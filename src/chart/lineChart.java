package chart;

import java.awt.Font;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

public class lineChart {
	static ChartPanel frame = null;
	lineChartModel linechar = null;

	public lineChart() {

	}

	public void query(String sql, String paras[], int type) {
		linechar = new lineChartModel();
		XYDataset data = linechar.getDataSet(sql, paras, type);

		JFreeChart chart = ChartFactory.createTimeSeriesChart("", "日期", "元",
				data, true, true, true);
		chart.setTitle(new TextTitle("销售收入情况", new Font("黑体", Font.BOLD, 20)));
		// XYPlot plot=(XYPlot) chart.getPlot();
		XYPlot plot = chart.getXYPlot();
		//
		DateAxis dateAxis = (DateAxis) plot.getDomainAxis();
		dateAxis.setDateFormatOverride(new SimpleDateFormat("yyyy-MM-dd"));
		if (frame == null) {
			frame = new ChartPanel(chart, true);
		} else {
			frame.setChart(chart);
		}
		frame.setMouseWheelEnabled(true);
		frame.setMouseZoomable(true);
		dateAxis.setLabelFont(new Font("黑体", Font.BOLD, 14));
		dateAxis.setTickLabelFont(new Font("宋体", Font.BOLD, 12));

		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setLabelFont(new Font("黑体", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 20));

		// 设置曲线显示各数据点的值
		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) plot
				.getRenderer();
		plot.setAxisOffset(new RectangleInsets(0D, 0D, 0D, 10D));
		xylineandshaperenderer.setBaseShapesVisible(true);
	}

	// private XYDataset createDataset(){
	// TimeSeries timeseries = new TimeSeries("legal & general欧洲指数信任",
	// org.jfree.data.time.Month.class);
	// timeseries.add(new Month(2, 2001), 181.80000000000001D);
	// timeseries.add(new Month(3, 2001), 167.30000000000001D);
	// timeseries.add(new Month(5, 2002), 139.80000000000001D);
	// timeseries.add(new Month(6, 2002), 137D);
	// timeseries.add(new Month(7, 2002), 132.80000000000001D);
	// TimeSeries timeseries1 = new TimeSeries("legal & general英国指数信任",
	// org.jfree.data.time.Month.class);
	// timeseries1.add(new Month(2, 2001), 129.59999999999999D);
	// timeseries1.add(new Month(3, 2001), 123.2D);
	// timeseries1.add(new Month(4, 2001), 117.2D);
	// timeseries1.add(new Month(5, 2001), 124.09999999999999D);
	// timeseries1.add(new Month(6, 2001), 122.59999999999999D);

	// timeseries1.add(new Month(5, 2002), 111.59999999999999D);
	// timeseries1.add(new Month(6, 2002), 108.8D);
	// timeseries1.add(new Month(7, 2002), 101.59999999999999D);
	// TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
	// timeseriescollection.addSeries(timeseries);
	// timeseriescollection.addSeries(timeseries1);
	// return timeseriescollection;
	//
	// }
	public ChartPanel getChartPanel() {
		return frame;
	}
}
