package salsa.monitor.ui;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Millisecond;
import org.jfree.chart.plot.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.LegendItem;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.annotations.XYTitleAnnotation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.ui.*;

import javax.swing.*;
import java.awt.*;

/**
 * @author Saliya Ekanayake (esaliya at gmail dot com OR sekanaya at cs dot indiana dot edu)
 */

public class GenericGraph {
    // Color settings
    private Color bkgColor = Color.black;
    private Color borderColor = bkgColor;
    private Color titleColor = Color.white;
    private Color rangeColor = Color.white;
    private Color domainColor = Color.white;
    private Color labelColor = Color.white;
    private Color waterMarkColor = Color.white;

    private TimeSeries cpuTime, memTime;
    private JFreeChart chart;
    private ChartPanel panel;
    private CombinedDomainXYPlot plot;
    private XYPlot xyCpuTime, xyMemTime;

    public GenericGraph(Color color1, Color color2, boolean showWaterMark) {
        // define the two time series
        cpuTime = new TimeSeries("Average CPU Usage");
        memTime = new TimeSeries("Average Memory Usage");

        plot = new CombinedDomainXYPlot();

        xyCpuTime = getXYPlot(cpuTime, color1, "Avg. CPU Usage (%)", false);
        plot.add(xyCpuTime);

        xyMemTime = getXYPlot(memTime, color2, "Avg. Memory Usage (%)", showWaterMark);
        plot.add(xyMemTime);

        plot = customizeCombinedDomainPlot(plot);

        // create new chart
        chart = getChart(plot);

        // customize chart panel
        panel = new ChartPanel(chart,false, true, true, false, false);
        panel.setMouseZoomable(false);
        panel.setPreferredSize(new java.awt.Dimension(300, 600));
    }

    public void setMaxItemAge(long age) {
        cpuTime.setMaximumItemAge(age);
        memTime.setMaximumItemAge(age);
    }

    public void setDomainFixedAutoRange(double range) {
        plot.getDomainAxis().setFixedAutoRange(range);        
    }

    public void setCpuTimeColor(Color color) {
        xyCpuTime.getRenderer().setSeriesPaint(0, color);
    }

    public void setMemTimeColor(Color color) {
        xyMemTime.getRenderer().setSeriesPaint(0, color);
    }

    private CombinedDomainXYPlot customizeCombinedDomainPlot(CombinedDomainXYPlot plot) {
        DateAxis domainAxis = new DateAxis("Time");
        domainAxis.setAutoRange(true);
        domainAxis.setFixedAutoRange(30000.0);
        domainAxis.setAxisLinePaint(domainColor);
        domainAxis.setLabelPaint(domainColor);
        domainAxis.setTickLabelPaint(domainColor);

        // customize combined plot
        plot.setDomainAxis(domainAxis);
        plot.setGap(20.0);

        return plot;
    }

    private XYPlot getXYPlot(TimeSeries ts, Color color, String title, boolean showWaterMark) {
        ts.setMaximumItemAge(60000); // the user may change the default value
        TimeSeriesCollection tsc = new TimeSeriesCollection(ts);

        // customized renderer
        XYAreaRenderer renderer = new XYAreaRenderer();
        renderer.setSeriesPaint(0, color);

        // define range axis
//        NumberAxis rangeAxis = new NumberAxis("Percentage (%)");
        NumberAxis rangeAxis = new NumberAxis();
        rangeAxis.setLabelPaint(rangeColor);
        rangeAxis.setAxisLinePaint(rangeColor);
        rangeAxis.setTickLabelPaint(rangeColor);
        rangeAxis.setRange(0.0, 100.0);

        XYPlot xyPlot = new XYPlot(tsc, null, rangeAxis, renderer);
        xyPlot.setBackgroundPaint(bkgColor);
        xyPlot.setDomainGridlinePaint(domainColor);
        xyPlot.setRangeGridlinePaint(rangeColor);
        xyPlot.setForegroundAlpha(0.5f);

        // add annotation -- I am done with annoations, since it changes alpha with foreground alpha
//        TextTitle tt = new TextTitle(title);
//        tt.setFont(new Font("Arial", Font.BOLD, 14));
//        tt.setPaint(labelColor);
//        XYTitleAnnotation ta = new XYTitleAnnotation(0.98, 0.8, tt,
//                RectangleAnchor.BOTTOM_RIGHT);
//        ta.setMaxWidth(0.60);
//        renderer.addAnnotation(ta, Layer.BACKGROUND);
//        xyPlot.addAnnotation(ta);

        // a dirty workaround for the alpha issue with annotations
        ValueMarker titleMarker = new ValueMarker(86.0);
        titleMarker.setLabel(title);
        titleMarker.setLabelFont(new Font("Calibri", Font.BOLD, 12));
        titleMarker.setLabelAnchor(RectangleAnchor.RIGHT);
        titleMarker.setLabelTextAnchor(TextAnchor.CENTER_RIGHT);
        titleMarker.setLabelPaint(titleColor);
        titleMarker.setPaint(bkgColor);
        titleMarker.setAlpha(1.0f);
        xyPlot.addRangeMarker(titleMarker, Layer.BACKGROUND);


        if (showWaterMark) {
            // add SALSA watermark
            ValueMarker salsaWaterMark = new ValueMarker(31.0);
            salsaWaterMark.setLabel("S   A   L   S   A        H   P   C");
            salsaWaterMark.setLabelFont(new Font("Calibri", Font.BOLD, 25));
            salsaWaterMark.setLabelAnchor(RectangleAnchor.CENTER);
            salsaWaterMark.setLabelTextAnchor(TextAnchor.CENTER);
            salsaWaterMark.setLabelPaint(waterMarkColor);
            salsaWaterMark.setPaint(bkgColor);
            salsaWaterMark.setAlpha(0.3f);
            xyPlot.addRangeMarker(salsaWaterMark, Layer.BACKGROUND);
        }

        return xyPlot;
    }

    private JFreeChart getChart(Plot plot) {
        JFreeChart chart = new JFreeChart("",plot); // dummy title
        TextTitle tt = new TextTitle();
        tt.setFont(new Font("Calibri", Font.PLAIN, 20));
        chart.setTitle(tt);
        chart.setBorderPaint(borderColor);
        chart.setBackgroundPaint(bkgColor);
        chart.getTitle().setPaint(titleColor);
        chart.removeLegend();

        return chart;
    }

    public JPanel getPanel () {
        return panel;
    }

    public void update (String title, double val1, double val2) {
        update(val1, val2);
        setTitle(title);
    }

    public void setTitle(String title) {
        if (title != null && !"".equals(title)){
            chart.setTitle(title);
        }
    }
    public void update (double val1, double val2) {
        cpuTime.addOrUpdate(new Millisecond(), val1);
        memTime.addOrUpdate(new Millisecond(), val2);
    }
}
