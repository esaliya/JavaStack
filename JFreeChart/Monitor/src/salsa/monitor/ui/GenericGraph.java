package salsa.monitor.ui;

import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Millisecond;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.LegendItem;
import org.jfree.chart.annotations.XYTitleAnnotation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.ui.RectangleAnchor;

import javax.swing.*;
import java.awt.*;

public class GenericGraph {
    // Color settings
    private Color bkgColor = Color.black;
    private Color borderColor = bkgColor;
    private Color titleColor = Color.white;
    private Color rangeColor = Color.white;
    private Color domainColor = Color.white;
    private Color labelColor = Color.white;

    private TimeSeries cpuTime, memTime;
    private JFreeChart chart;
    private ChartPanel panel;
    private CombinedDomainXYPlot plot;
    private XYPlot xyCpuTime, xyMemTime;

    public GenericGraph(Color color1, Color color2) {
        // define the two time series
        cpuTime = new TimeSeries("Average CPU Usage");
        memTime = new TimeSeries("Average Memory Usage");

        plot = new CombinedDomainXYPlot();

        xyCpuTime = getXYPlot(cpuTime, color1, "Avg. CPU Usage");
        plot.add(xyCpuTime);

        xyMemTime = getXYPlot(memTime, color2, "Avg Memory Usage");
        plot.add(xyMemTime);

        plot = customizeCombinedDomainPlot(plot);

        // create new chart
        chart = getChart(plot);

        // customize chart panel
        panel = new ChartPanel(chart);
//        panel.setMouseWheelEnabled(true);
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

    private XYPlot getXYPlot(TimeSeries ts, Color color, String title) {
        ts.setMaximumItemAge(60000); // the user may change the default value
        TimeSeriesCollection tsc = new TimeSeriesCollection(ts);

        // customized renderer
        XYAreaRenderer renderer = new XYAreaRenderer();
        renderer.setSeriesPaint(0, color);

        // define range axis
        NumberAxis rangeAxis = new NumberAxis("Percentage (%)");
        rangeAxis.setLabelPaint(rangeColor);
        rangeAxis.setAxisLinePaint(rangeColor);
        rangeAxis.setTickLabelPaint(rangeColor);
        rangeAxis.setRange(0.0, 100.0);

        XYPlot xyPlot = new XYPlot(tsc, null, rangeAxis, renderer);
        xyPlot.setBackgroundPaint(bkgColor);
        xyPlot.setDomainGridlinePaint(domainColor);
        xyPlot.setRangeGridlinePaint(rangeColor);
        xyPlot.setForegroundAlpha(0.65f);

        // add annotation
        TextTitle tt = new TextTitle(title);
        tt.setFont(new Font("Arial", Font.BOLD, 14));
        tt.setPaint(labelColor);
//        LegendTitle lt = new LegendTitle(plot);
//        lt.setItemFont(new Font("Dialog", Font.PLAIN, 9));
//        lt.setBackgroundPaint(new Color(200, 200, 255, 100));
//        lt.setFrame(new BlockBorder(Color.white));
//        lt.setPosition(RectangleEdge.BOTTOM);
        XYTitleAnnotation ta = new XYTitleAnnotation(0.98, 0.8, tt,
                RectangleAnchor.BOTTOM_RIGHT);

        ta.setMaxWidth(0.60);
        xyPlot.addAnnotation(ta);

        return xyPlot;
    }

    private JFreeChart getChart(Plot plot) {
        JFreeChart chart = new JFreeChart("",plot); // dummy title
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
        cpuTime.add(new Millisecond(), val1);
        memTime.add(new Millisecond(), val2);
    }
}
