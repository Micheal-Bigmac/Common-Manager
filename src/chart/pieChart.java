package chart;

import java.awt.Font;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class pieChart {
	static ChartPanel frame = null;
	pieChartModel piechar=null;
	public pieChart(){
		
	}
	public void query(String sql,String paras[],int type) {
		piechar=new pieChartModel();
		DefaultPieDataset date = piechar.getDataSet(sql, paras,type);
		JFreeChart chart = ChartFactory.createPieChart3D("", date, true,	false, false);
		chart.setTitle(new TextTitle("每月销售比例", new Font("黑体", Font.BOLD, 20)));
		PiePlot pieplot = (PiePlot) chart.getPlot();
		DecimalFormat df = new DecimalFormat(" 0.00");
		NumberFormat nf = NumberFormat.getNumberInstance();
		StandardPieSectionLabelGenerator spg = new StandardPieSectionLabelGenerator(
				"{0}{2}", nf, df);
		pieplot.setLabelGenerator(spg);

		pieplot.setNoDataMessage("无数据显示");
		pieplot.setCircular(false);
		pieplot.setLabelGap(0.02D);
		pieplot.setIgnoreNullValues(true);
		pieplot.setIgnoreZeroValues(true);
		if(frame==null){
			frame = new ChartPanel(chart, true);
		}else{
			frame.setChart(chart);
		}
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 10));
		chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 10));
	}

	public ChartPanel getChartPanel(){
		return frame;
	}
}
