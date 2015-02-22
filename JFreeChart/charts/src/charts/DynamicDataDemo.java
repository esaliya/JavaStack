package charts;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A demonstration application showing a time series chart where you can dynamically add
 * (random) data by clicking on a button.
 */
public class DynamicDataDemo extends ApplicationFrame implements ActionListener {

    /**
     * The time series data.
     */
    private TimeSeries series;

    /**
     * The most recent value added.
     */
    private double lastValue = 0.0;

    /**
     * Constructs a new demonstration application.
     *
     * @param title the frame title.
     */
    public DynamicDataDemo(final String title) {

        super(title);
        this.series = new TimeSeries("Random Data");
        series.setMaximumItemAge(30000);
        final TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);
        final JFreeChart chart = createChart(dataset);

        final ChartPanel chartPanel = new ChartPanel(chart);
        final JButton button = new JButton("Add New Data Item");
        button.setActionCommand("ADD_DATA");
        button.addActionListener(this);

        final JPanel content = new JPanel(new BorderLayout());
        content.add(chartPanel);
        content.add(button, BorderLayout.SOUTH);
//        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(content);

    }

    /**
     * Creates a sample chart.
     *
     * @param dataset the dataset.
     * @return A sample chart.
     */
    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
            "Dynamic Data Demo",
            "Time",
            "Value",
            dataset,
            true,
            true,
            false
        );

        result.setBackgroundPaint(Color.black);

//        result.setBorderVisible(true);



//        final JFreeChart result = ChartFactory.createXYAreaChart(
//                "Dynamic Data Demo",
//                "Time",
//                "Value",
//                dataset,
//                PlotOrientation.VERTICAL,
//                true,
//                true,
//                false
//
//        );
        
        final XYPlot plot = result.getXYPlot();
        XYAreaRenderer renderer = new XYAreaRenderer();
//        renderer.setBaseFillPaint(Color.blue);
        renderer.setSeriesPaint(0, Color.blue);
//        renderer.setOutline(true);
//        renderer.setSeriesOutlinePaint(0, Color.green);
//        BasicStroke s = new BasicStroke(1);
//        renderer.setSeriesOutlineStroke(0, s);
//        renderer.setAutoPopulateSeriesFillPaint(false);
//
        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.black);
        plot.setForegroundAlpha(0.65f);
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(30000.0);  // 60 seconds
        axis = plot.getRangeAxis();
        axis.setRange(0.0, 200.0);

        IntervalMarker marker = new IntervalMarker(50.0, 75.0, Color.red);
        plot.addRangeMarker(marker);
        marker = new IntervalMarker(25.0, 30.0, Color.yellow);
        plot.addRangeMarker(marker);

        
        return result;
    }

    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    *
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************

    /**
     * Handles a click on the button by adding new (random) data.
     *
     * @param e the action event.
     */
    public void actionPerformed(final ActionEvent e) {
        stop = true;
        if (e.getActionCommand().equals("ADD_DATA")) {
            final double factor = 0.90 + 0.2 * Math.random();
            this.lastValue = this.lastValue * factor;
            final Millisecond now = new Millisecond();
            System.out.println("Now = " + now.toString());
            this.series.add(new Millisecond(), this.lastValue);
            this.pack();
            this.setVisible(true);
        }
    }

public boolean stop = false;
    public void autoUpdate(int refreshTime) {
        while (! stop) {
            final double factor = Math.random();
            this.lastValue = 100* factor + 5;
            final Millisecond now = new Millisecond();
            System.out.println("Now = " + now.toString());
            this.series.add(new Millisecond(), this.lastValue);
            this.pack();
            this.invalidate();
            this.repaint();
            this.setVisible(true);
            try {
                Thread.sleep(refreshTime);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }


    /**
     * Starting point for the demonstration application.
     *
     * @param args ignored.
     */
    public static void main(final String[] args) {

        final DynamicDataDemo demo = new DynamicDataDemo("Dynamic Data Demo");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
        demo.autoUpdate(200);

    }

}
