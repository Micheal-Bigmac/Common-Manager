package chart;

import java.awt.Font;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;

public class columnDiagram {
	static ChartPanel frame;
	columnDiagramModel barchar=null;
	public columnDiagram(){
	}
	public void query(String sql,String paras[],int type){
		barchar=new columnDiagramModel();
		CategoryDataset dateset=barchar.getDataSet(sql, paras,type);
	
		JFreeChart chart=ChartFactory.createBarChart3D("", "", "", dateset, PlotOrientation.VERTICAL,true ,false, false);
//		chart.setTitle("����ÿ��ʳ����������");
		chart.setTitle(new TextTitle("ʳ����������", new Font("����", Font.BOLD, 20)));
		CategoryPlot plot=chart.getCategoryPlot();
		CategoryAxis domainAxis=plot.getDomainAxis();
		domainAxis.setLabelFont(new Font("����", Font.BOLD, 14));
		domainAxis.setLabel("����");//x ��
		domainAxis.setTickLabelFont(new Font("����", Font.BOLD, 12));
		ValueAxis rangeAxis=plot.getRangeAxis();
		rangeAxis.setLabel("Ԫ");
		rangeAxis.setLabelFont(new Font("����", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("����", Font.BOLD, 20));
		if(frame==null){
			frame=new ChartPanel(chart, true);
		}else {
			frame.setChart(chart);
		}
		frame.setMouseWheelEnabled(true);
		
	}
	
	public ChartPanel getChartPanel(){
		return frame;
	}
}
