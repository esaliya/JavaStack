package salsa.monitor;

import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

import salsa.monitor.ui.GenericGraph;
import salsa.monitor.thread.GraphUpdater;
import salsa.monitor.client.StatClient;
import cgl.perfmon.MonitorExecption;

public class Monitor extends ApplicationFrame{
    public static final Color CPU_COLOR = Color.blue;
    public static final Color MEM_COLOR = Color.green;
    public static final int MIN_REFRESH = 1000;
    public static final int NUM_OF_GRAPHS = 4;
    public static final int DOMAIN_RANGE = 200000;
    public static final int SWITCH_DOMAIN_RANGE = 500000;
    public static final int ITEMAGE_PERCENT = 10;

    private GenericGraph[] graphs;
    private StatClient client;
    private GraphUpdater updater;
    private int refresh;
    private boolean started = false;

    public Monitor(String frameTitle) {
        super(frameTitle);

        graphs = new GenericGraph[NUM_OF_GRAPHS];
        int i;
        for (i = 0; i < NUM_OF_GRAPHS - 1; i++) {
            graphs[i] = new GenericGraph(CPU_COLOR, MEM_COLOR);
            graphs[i].setDomainFixedAutoRange(DOMAIN_RANGE);
            graphs[i].setMaxItemAge(DOMAIN_RANGE * 100 / ITEMAGE_PERCENT);
        }
        //only show the legend of the switching graph
        graphs[i] = new GenericGraph(CPU_COLOR, MEM_COLOR);
        //set different max item age and domain range for the switching graph
        graphs[i].setDomainFixedAutoRange(SWITCH_DOMAIN_RANGE);
        graphs[i].setMaxItemAge(SWITCH_DOMAIN_RANGE * 100 / ITEMAGE_PERCENT);
        initUI();
    }

    private void initUI() {
        setContentPane(createContentPane());
        pack();
        RefineryUtilities.centerFrameOnScreen(this);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
//        setUndecorated(true);
    }

    private JPanel createContentPane() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JPanel topPane = new JPanel(new GridLayout());
        contentPane.add(topPane);

        JPanel gridPane;
        int i;
        for (i = 0; i < NUM_OF_GRAPHS - 1; i++) {
            topPane.add(graphs[i].getPanel());
        }
        contentPane.add(graphs[i].getPanel());
        return contentPane;
    }

    public void stopMonitor() throws MonitorExecption {
        if (started) {
            updater.exit();
            client.stop();
            started = false;
        }
    }

    /**
     * Starts the monitor with the instant's refresh value
     * @throws MonitorExecption
     */
    public void startMonitor() throws MonitorExecption {
        startMonitor(refresh);
    }

    /**
     * Starts the monitor with the given refresh value. If the given value
     * is less than the minimum allowable refresh time then the monitor is
     * started with the default minimum refresh time.
     *
     * Note. This has a side effect of setting the instant's refresh value
     *       to either the given value or the default minimum value
     * @param refresh
     * @throws MonitorExecption
     */
    public void startMonitor(int refresh) throws MonitorExecption {
        if (refresh < MIN_REFRESH) {
            refresh = MIN_REFRESH;
        } else {
            this.refresh = refresh;
        }
        start();
    }

    public GenericGraph[] getGraphs() {
        return graphs;
    }

    public int getRefresh() {
        return refresh;
    }

    public void setRefresh(int refresh) {
        this.refresh = refresh;
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        try {
            this.stopMonitor();
        } catch (MonitorExecption monitorExecption) {
            monitorExecption.printStackTrace();  //later log this
        } finally {
            super.windowClosing(windowEvent);
        }
    }

    private void start() throws MonitorExecption {
        if (!started) {
            client = new StatClient();
            client.start();
            updater = new GraphUpdater(graphs, client, refresh);
            Thread t = new Thread(updater, "Graph Updater");
            t.start();
            started = true;
        }
    }


    public static void main(String[] args) {

        String frameTitle = "Cluster Monitor";
        String [] graphTitles = new String[] {"Linux VM", "Linux BM", "Windows BM", "Waiting for name..."};
        final Monitor monitor = new Monitor(frameTitle);
        try {
            if (args != null) {
                if (args[0] != null && !"".equals(args[0])) {
                    monitor.startMonitor(Integer.parseInt(args[0]));
                } else  {
                    monitor.startMonitor(1000);
                }
            }
        } catch (MonitorExecption monitorExecption) {
            monitorExecption.printStackTrace();
        }
    }
}
