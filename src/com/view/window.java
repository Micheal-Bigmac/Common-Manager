package com.view;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import chart.reportview;

import com.tools.imagepanel;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
public class window extends JFrame implements ActionListener,MouseListener{
	public static Frame m;
	JMenuBar jmb;
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	JMenuItem jmm1,jmm2,jmm3,jmm4,jmm5,jm2_1,jm3_1,jm4_1,jm5_1,jm6_1,jm6_2,jm6_3;
	
	ImageIcon jmm1_icon1,jmm1_icon2,jmm1_icon3,jmm1_icon4,jmm1_icon5,jm2_icon1,jm3_icon1,jm4_icon1,
	jm5_icon1,jm6_icon1,jm6_icon2,jm6_icon3;
	
	JToolBar jtb;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	
	JPanel p1,p2,p3,p4,p5;
	
	JLabel p1_lab1,p1_lab2,p1_lab3,p1_lab4,p1_lab5,p1_lab6,p1_lab7,p1_lab8;
	
	JLabel p2_lab1,p2_lab2;
	JLabel timelabel;
	Image im=null;
	Timer timer=null;
	imagepanel p1_panel1=null;
	CardLayout p2_card,p3_card;
	JSplitPane jsp;
	public void initmenu(){
		jmm1_icon1=new ImageIcon("images/menu/jmm1_icon1.jpg");
		jmm1_icon2=new ImageIcon("images/menu/jmm1_icon2.jpg");
		jmm1_icon3=new ImageIcon("images/menu/jmm1_icon3.jpg");
		jmm1_icon4=new ImageIcon("images/menu/jmm1_icon4.jpg");
		jmm1_icon5=new ImageIcon("images/menu/jmm1_icon5.jpg");
		
		jm2_icon1=new ImageIcon("images/menu/jm2_icon1.jpg");
		jm3_icon1=new ImageIcon("images/menu/jm3_icon1.jpg");
		jm4_icon1=new ImageIcon("images/menu/jm4_icon1.jpg");
		jm5_icon1=new ImageIcon("images/menu/jm5_icon1.jpg");
		jm6_icon1=new ImageIcon("images/menu/jm6_icon1.jpg");
		jm6_icon2=new ImageIcon("images/menu/jm6_icon2.jpg");
		jm6_icon3=new ImageIcon("images/menu/jm6_icon3.jpg");
		
		jm1=new JMenu("系统管理");
		jmm1=new JMenuItem("切换用户",jmm1_icon1);
		jmm2=new JMenuItem("切换到收款界面",jmm1_icon2);
		jmm3=new JMenuItem("登陆管理",jmm1_icon3);
		jmm4=new JMenuItem("万年历",jmm1_icon4);
		jmm5=new JMenuItem("退出",jmm1_icon5);
		jm1.add(jmm1);
		jm1.add(jmm2);
		jm1.add(jmm3);
		jm1.add(jmm4);
		jm1.add(jmm5);
		
		jm2=new JMenu("人事管理");
		jm2_1=new JMenuItem("人士登记",jm2_icon1);
		jm2.add(jm2_1);
		
		jm3=new JMenu("菜单服务");
		jm3_1=new JMenuItem("菜谱及价格录入",jm3_icon1);
		jm3.add(jm3_1);
		
		jm4 =new JMenu("报表统计");
		jm4_1=new JMenuItem("报表统计",jm4_icon1);
		jm4.add(jm4_1);
		
		jm5=new JMenu("成本及库房");
		jm5_1=new JMenuItem("成本控制",jm5_icon1);
		jm5.add(jm5_1);
		
		jm6=new JMenu("帮助");
		jm6_1=new JMenuItem("动画帮助",jm6_icon1);
		jm6_2=new JMenuItem("文本帮助",jm6_icon2);
		jm6_3=new JMenuItem("关于",jm6_icon3);
		jm6.add(jm6_1);
		jm6.add(jm6_2);
		jm6.add(jm6_3);
		
		jmb=new JMenuBar();
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
		this.setJMenuBar(jmb);
		
	}
	public void initToolbar(){
		jb1=new JButton(new ImageIcon("images/toolbar/jb1.jpg"));
		jb2=new JButton(new ImageIcon("images/toolbar/jb2.jpg"));
		jb3=new JButton(new ImageIcon("images/toolbar/jb3.jpg"));
		jb4=new JButton(new ImageIcon("images/toolbar/jb4.jpg"));
		jb5=new JButton(new ImageIcon("images/toolbar/jb5.jpg"));
		jb6=new JButton(new ImageIcon("images/toolbar/jb6.jpg"));
		jb7=new JButton(new ImageIcon("images/toolbar/jb7.jpg"));
		jb8=new JButton(new ImageIcon("images/toolbar/jb8.jpg"));
		jb9=new JButton(new ImageIcon("images/toolbar/jb9.jpg"));
		jb10=new JButton(new ImageIcon("images/toolbar/jb10.jpg"));
		
		jtb=new JToolBar();
		jtb.setFloatable(false);
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5);
		jtb.add(jb6);
		jtb.add(jb7);
		jtb.add(jb8);
		jtb.add(jb9);
		jtb.add(jb10);
		this.add(jtb,"North");
		
	}
	public void initstatus(){
		p5=new JPanel(new BorderLayout());
		timer=new Timer(1000, this);
		timer.start();
		timelabel=new JLabel("当前时间为 :"+Calendar.getInstance().getTime().toLocaleString());
//		p5.add(timelabel);
		im=Toolkit.getDefaultToolkit().getImage("images/status/time_bg.jpg");
//		status=new imagepanel(im);
//		status.add(timelabel);
//		status.setLayout(new BorderLayout());
//		status.add(timelabel);
		JPanel sta=new JPanel(new BorderLayout());
		sta.setBackground(Color.cyan);
		sta.add(timelabel,"East");
		p5.add(sta);
		this.add(p5,"South");
	}
	public void initcenter(){
		p1=new JPanel(new BorderLayout());
		try {
			im=ImageIO.read(new File("images/main/jp1_bg.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p1_panel1=new imagepanel(im);
		p1_panel1.setLayout(new GridLayout(8,1));
		p1_lab1=new JLabel(new ImageIcon("images/main/label_1.gif"));
		p1_lab2=new JLabel("人事登记",new ImageIcon("images/main/label_2.jpg"), 0);
		p1_lab2.addMouseListener(this);
		p1_lab2.setEnabled(false);
		p1_lab3=new JLabel("登陆管理",new ImageIcon("images/main/label_3.jpg"), 0);
		p1_lab3.addMouseListener(this);
		p1_lab3.setEnabled(false);
		p1_lab4=new JLabel("菜谱价格",new ImageIcon("images/main/label_4.jpg"), 0);
		p1_lab4.addMouseListener(this);
		p1_lab4.setEnabled(false);
		p1_lab5=new JLabel("报表统计",new ImageIcon("images/main/label_5.jpg"), 0);
		p1_lab5.addMouseListener(this);
		p1_lab5.setEnabled(false);
		p1_lab6=new JLabel("成本及库房",new ImageIcon("images/main/label_6.jpg"), 0);
		p1_lab6.addMouseListener(this);
		p1_lab6.setEnabled(false);
		p1_lab7=new JLabel("系统设置",new ImageIcon("images/main/label_7.jpg"), 0);
		p1_lab7.addMouseListener(this);
		p1_lab7.setEnabled(false);
		p1_lab8=new JLabel("动画帮助",new ImageIcon("images/main/label_8.jpg"), 0);
		p1_lab8.addMouseListener(this);
		p1_lab8.setEnabled(false);
		
		
		p1_panel1.add(p1_lab1);
		p1_panel1.add(p1_lab2);
		p1_panel1.add(p1_lab3);
		p1_panel1.add(p1_lab4);
		p1_panel1.add(p1_lab5);
		p1_panel1.add(p1_lab6);
		p1_panel1.add(p1_lab7);
		p1_panel1.add(p1_lab8);
		
		p1.add(p1_panel1);
		this.add(p1,"Center");
		
		
		p4=new JPanel();
		p2_card=new CardLayout();
		p2=new JPanel(p2_card);
		p2_lab1=new JLabel(new ImageIcon("images/main/jp2_left.jpg"));
		p2_lab1.addMouseListener(this);
		p2_lab2=new JLabel(new ImageIcon("images/main/jp2_right.jpg"));
		p2_lab2.addMouseListener(this);
		p2.add(p2_lab1,"0");
		p2.add(p2_lab2,"1");
		
		p3_card=new CardLayout();
		p3=new JPanel(p3_card);
	
		Image p3_bg=null;
		try {
			p3_bg=ImageIO.read(new File("images/main/00.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		imagepanel p3_panel=new imagepanel(p3_bg);
		p3.add(p3_panel,"0");
		employee em =new employee();
		p3.add(em,"1");
		loginmanage login=new loginmanage();
		p3.add(login,"2");
		menuManage menu=new menuManage();
		p3.add(menu,"3");
		reportview report =new reportview();
		p3.add(report,"4");
		//成本及库房
		//p3.add(,"5");
		SystemSettings sys=new SystemSettings();
		p3.add(sys,"6");
		//帮助
		//p3.add(,"7");
		p4=new JPanel(new BorderLayout());
		p4.add(p2,"West");
		p4.add(p3,"Center");
		
		jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,p1,p4);
		jsp.setDividerLocation(150);
		jsp.setDividerSize(0);
		this.add(jsp,"Center");
	}
	public window(){
		this.m=this;
		initmenu();
		initToolbar();
		initstatus();
		initcenter();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(width,height);
		this.setTitle("****管理系统");
		this.setIconImage(new ImageIcon("images/title.gif").getImage());
		this.setVisible(true);
	}
	public static void main(String args[]){
		new window();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.timelabel.setText("当前时间为 :"+Calendar.getInstance().getTime().toLocaleString());
//		if(e.getSource()==)
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==p2_lab1){
			this.jsp.setDividerLocation(0);
			this.p2_card.show(p2, "1");
		}else if(e.getSource()==p2_lab2){
			
			this.p2_card.show(p2, "0");
			this.jsp.setDividerLocation(150);
		}else if(e.getSource()==p1_lab2){
			System.out.println(p1_lab2.getText());
			this.p3_card.show(p3, "1");
		}else if(e.getSource()==p1_lab3){
			System.out.println(p1_lab3.getText());
			this.p3_card.show(p3, "2");
		}else if(e.getSource()==p1_lab4){
			this.p3_card.show(p3, "3");
			System.out.println(p1_lab4.getText());
		}else if(e.getSource()==p1_lab5){
			this.p3_card.show(p3, "4");
			System.out.println(p1_lab5.getText());
		}else if(e.getSource()==p1_lab6){
			System.out.println("p1_lab6"+p1_lab6.getText());
		}else if(e.getSource()==p1_lab7){
			System.out.println("p1_lab7"+p1_lab7.getText());
			this.p3_card.show(p3, "6");
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()==this.p1_lab2){
			p1_lab2.setEnabled(true);
		}else if(e.getSource()==this.p1_lab3){
			this.p1_lab3.setEnabled(true);
		}else if(e.getSource()==this.p1_lab4){
			this.p1_lab4.setEnabled(true);
		}else if(e.getSource()==this.p1_lab5){
			this.p1_lab5.setEnabled(true);
		}else if(e.getSource()==this.p1_lab6){
			this.p1_lab6.setEnabled(true);
		}else if(e.getSource()==this.p1_lab7){
			this.p1_lab7.setEnabled(true);
		}else if(e.getSource()==this.p1_lab8){
			this.p1_lab8.setEnabled(true);
		}		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if(e.getSource()==this.p1_lab2){
			p1_lab2.setEnabled(false);
		}else if(e.getSource()==this.p1_lab3){
			this.p1_lab3.setEnabled(false);
		}else if(e.getSource()==this.p1_lab4){
			this.p1_lab4.setEnabled(false);
		}else if(e.getSource()==this.p1_lab5){
			this.p1_lab5.setEnabled(false);
		}else if(e.getSource()==this.p1_lab6){
			this.p1_lab6.setEnabled(false);
		}else if(e.getSource()==this.p1_lab7){
			this.p1_lab7.setEnabled(false);
		}else if(e.getSource()==this.p1_lab8){
			this.p1_lab8.setEnabled(false);
		}		
	}

}
