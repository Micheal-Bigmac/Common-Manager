package chart;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class reportview extends JPanel implements ActionListener {
	JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7;
	JButton jb1,jb2,jb3;
	JTabbedPane jtp;
	JComboBox jcb1,jcb2,jcb3,jcb5;
	JLabel jl;
	String month[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
	String years[] = {"2010","2011","2012","2013","2014","2015","2017","2018","2019","2020","2021","2022"};
	
//	 柱状图
	columnDiagram cd=null;
	//饼状图
	pieChart pie=null;
	// 折线
	lineChart line=null;
	
	CardLayout card;
	JButton jb4,jb5,jb6;
	public reportview(){
		jl=new JLabel("报表统计");
		card=new CardLayout();
		jp1=new JPanel();
		jp1.add(jl);
		
		jp2=new JPanel(card);
		cd=new columnDiagram();
		cd.query("select * from month_kind_sales where year(date)=year(curdate()) and month(date)=month(curdate())",null,0);
		pie=new pieChart();
		pie.query("select * from month_sales where year(date)=year(curdate()) and month(date)=month(curdate())",null,1);
		line=new lineChart();
		line.query("select * from year_sales",null,2);
		jp2.add(cd.getChartPanel(),"0");// 柱状图
		jp2.add(pie.getChartPanel(),"1");//饼状图
		jp2.add(line.getChartPanel(),"2");//折线图
		
		jp4=new JPanel(new GridLayout(1,2));
		jcb1=new JComboBox(month);
//		jcb1=new JComboBox();
		jcb2=new JComboBox(years);
		jcb3=new JComboBox(years);
		jcb5=new JComboBox(years);
		
		jp5=new JPanel();
		jb4=new JButton("确定");
		jb4.addActionListener(this);
		jp5.add(jcb2);
		jp5.add(jcb1);
		jp5.add(jb4);
		
		jp6=new JPanel();
		jb5=new JButton("确定");
		jb5.addActionListener(this);
		jp6.add(jcb3);
		jp6.add(jb5);
		
		jp3=new JPanel();
		jb6=new JButton("确定");
		jb6.addActionListener(this);
		jp3.add(new Label("自"));
		jp3.add(jcb5);
		jp3.add(new Label("以来"));
		jp3.add(jb6);
		
		jtp=new JTabbedPane(1);
		
		jtp.add("月份营业额",jp5);
		jtp.add("年份营业额", jp6);
		jtp.add("历年销售额",jp3);
		
		jb1=new JButton("柱状图");
		jb1.addActionListener(this);
		jb2=new JButton("饼状图");
		jb2.addActionListener(this);
		jb3=new JButton("折线图");
		jb3.addActionListener(this);
		
		jp7=new JPanel();
		jp7.add(jb1);
		jp7.add(jb2);
		jp7.add(jb3);
		
		jp4.add(jtp);
		jp4.add(jp7);
		
		this.setLayout(new BorderLayout());
		this.add(jp1,"North");
		this.add(jp2,"Center");
		this.add(jp4,"South");
		this.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		reportview rr=new reportview();
		JFrame jf=new JFrame();
		jf.add(rr);
		jf.show();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
			card.show(jp2, "0");
		}else if(e.getSource()==jb2){
			card.show(jp2, "1");
		}else if(e.getSource()==jb3){
			card.show(jp2, "2");
		}else if(e.getSource()==jb4){
			String jcb_2=(String) jcb2.getSelectedItem();
			String jcb_1=(String) jcb1.getSelectedItem();
			System.out.println(jcb_2+"  "+jcb_1);
			System.out.println(Integer.parseInt(jcb_1));
			String arg[]={jcb_2,jcb_1};
			
			String sql="select * from month_kind_sales where year(date)=? and month(date)=?";
			cd.query(sql, arg,0);
			pie.query(sql, arg,0);
			line.query(sql, arg, 0);
			jb1.setEnabled(true);
			jb2.setEnabled(true);
//			jb3.setEnabled(false);

		}else if(e.getSource()==jb5){
			String jcb_3=(String) jcb3.getSelectedItem();
			System.out.println(jcb_3);
			jb1.setEnabled(true);
			jb2.setEnabled(true);
			String arg[]={jcb_3};
			String sql="select * from month_sales where year(date)=?";
			pie.query(sql, arg,1);
			cd.query(sql, arg, 1);
			line.query(sql, arg, 1);
			card.show(jp2, "1");
			
		}else if(e.getSource()==jb6){
			String jcb_5 =(String) jcb5.getSelectedItem();
			System.out.println(jcb_5);
			jb1.setEnabled(false);
			jb2.setEnabled(false);
			jb3.setEnabled(true);
			card.show(jp2, "2");
			String sql="select * from year_sales where year between ? and year(now())";
			String arg[]={jcb_5};
			
			line.query(sql, arg,2);
		}
	}

}
