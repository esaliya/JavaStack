package salsa.monitor;

import org.apache.commons.cli.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

import salsa.monitor.ui.GenericGraph;
import salsa.monitor.thread.GraphUpdater;
import salsa.monitor.client.StatClient;
import cgl.perfmon.MonitorExecption;

/**
 * @author Saliya Ekanayake (esaliya at gmail dot com OR sekanaya at cs dot indiana dot edu)
 */

public class Monitor extends ApplicationFrame{
    public static final Color CPU_COLOR = Color.blue;
    public static final Color MEM_COLOR = Color.green;
    public static final int MIN_REFRESH = 1000;
    public static final int NUM_OF_GRAPHS = 4;

    // domain range for switching graph 900000 ms)
    public int switchDomainRange;
    // domain range for normal graphs 300000 ms)
    public int domanRange;
    public static final int ITEMAGE_PERCENT = 10;

    private GenericGraph[] graphs;
    private StatClient client;
    private GraphUpdater updater;
    private int refresh;
    private boolean started = false;
    private String brokerHost = "127.0.0.1";
    private String brokerPort = "3045";


    public Monitor(String frameTitle, String brokerHost, String brokerPort, int refresh, int dr, int sdr) {
        super(frameTitle);
        this.brokerHost = brokerHost;
        this.brokerPort = brokerPort;
        this.refresh = refresh < MIN_REFRESH ? MIN_REFRESH : refresh;
        this.domanRange = dr;
        this.switchDomainRange = sdr;

        graphs = new GenericGraph[NUM_OF_GRAPHS];
        int i;
        for (i = 0; i < NUM_OF_GRAPHS - 1; i++) {
            graphs[i] = new GenericGraph(CPU_COLOR, MEM_COLOR, false);
            graphs[i].setDomainFixedAutoRange(domanRange);
            graphs[i].setMaxItemAge(domanRange * 100 / ITEMAGE_PERCENT);
        }
        graphs[i] = new GenericGraph(CPU_COLOR, MEM_COLOR, true);
        //set different max item age and domain range for the switching graph
        graphs[i].setDomainFixedAutoRange(switchDomainRange);
        graphs[i].setMaxItemAge(switchDomainRange * 100 / ITEMAGE_PERCENT);
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

        contentPane.add(createLabelPane());
        
        JPanel topPane = new JPanel(new GridLayout());
        contentPane.add(topPane);

        int i;
        for (i = 0; i < NUM_OF_GRAPHS - 1; i++) {
            topPane.add(graphs[i].getPanel());
        }
        contentPane.add(graphs[i].getPanel());
        return contentPane;
    }

    // todo - make this beautiful, either using an image
    private JPanel createLabelPane() {
        JPanel labelPane = new JPanel();
        labelPane.setBackground(Color.black);
        JLabel label = new JLabel("SALSA HPC - Science on Virtual Clusters");
        label.setForeground(Color.white);
        label.setFont(new Font("Calibri", Font.BOLD, 30));
        labelPane.add(label, BorderLayout.CENTER);

        return labelPane;
    }

    public void stopMonitor() throws MonitorExecption {
        if (started) {
            updater.exit();
            client.stop();
            started = false;
        }
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

    public void start() throws MonitorExecption {
        if (!started) {
            client = new StatClient(brokerHost, brokerPort);
            client.start();
            updater = new GraphUpdater(graphs, client, refresh);
            Thread t = new Thread(updater, "Graph Updater");
            t.start();
            started = true;
        }
    }


    public static void main(String[] args) {
        Options ops = buildCommandLineOptions();
        CommandLineParser parser = new GnuParser();
        try {
            CommandLine line = parser.parse(ops, args);

            if (line.hasOption("h")) {
                String brokerHost =line.getOptionValue("h");
                String frameTitle = line.hasOption("t")
                        ? line.getOptionValue("t")
                        : "SALSA HPC - Science on Virtual Clusters";

                String brokerPort = line.hasOption("p")
                        ? line.getOptionValue("p")
                        : "3045";
                int interval = line.hasOption("i")
                        ? Integer.parseInt(line.getOptionValue("i"))
                        : MIN_REFRESH;

                int dr = line.hasOption("dr")
                        ? Integer.parseInt(line.getOptionValue("dr"))
                        : 300000;
                int sdr = line.hasOption("i")
                        ? Integer.parseInt(line.getOptionValue("sdr"))
                        : 900000;

                Monitor monitor = new Monitor(frameTitle, brokerHost, brokerPort, interval, dr, sdr);
                monitor.start();
            } else {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("Monitor", ops);
            }
        } catch (ParseException e) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("Monitor", ops);
        } catch (MonitorExecption monitorExecption) {
            monitorExecption.printStackTrace();
        }
    }

    private static Options buildCommandLineOptions() {
        Options ops = new Options();
        ops.addOption("t","title", true, "(optional) frame title");
        ops.addOption("h", "host", true, "broker host");
        ops.addOption("p", "port", true, "(optional) broker port");
        ops.addOption("i", "interval", true, "(optional) refresh interval in ms");
        ops.addOption("dr", "domainrange", true, "(optional) domain range for normal graphs in ms");
        ops.addOption("sdr", "switchdomainrange", true, "(optional) domain range for switching graph in ms");

        return ops;
    }
}
