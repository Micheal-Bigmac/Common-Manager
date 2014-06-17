package view2;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.tools.Tool;

import com.model.statusModel;
import com.tools.imagepanel;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

public class window2 extends JFrame implements MouseListener ,ActionListener,Runnable{
	Image titleIcon, timebg, p1_bg, p2_bg, p3_bg;
	JMenuBar jmb;
	JSplitPane jsp;
	JMenu jm1, jm2, jm3;
	JMenuItem jmi1, jmi2, jmi3, jmi4, jmi5, jmi6;
	ImageIcon jmi1_icon, jmi2_icon, jmi3_icon, jmi4_icon, jmi5_icon, jmi6_icon;
	JToolBar jtb;
	JButton jb1, jb2, jb3, jb4, jb5;
	JPanel jp1, jp2, jp3, jp4, jp5;
	JLabel showtime;
	JLabel p2_jl1, p2_jl2, p2_jl3, p2_jl4, p2_jl5, p2_jl11;
	JLabel p1_jl1, p1_jl2, p1_jl3, p1_jl4, p1_jl5, p1_jl6, p1_jl7, p1_jl8,
			p1_jl9, p1_jl10, p1_jl11, p1_jl12, p1_jl13, p1_jl14, p1_jl15,
			p1_jl16, p1_jl17, p1_jl18, p1_jl19, p1_jl20, p1_jl21, p1_jl22,
			p1_jl23, p1_jl24, p1_jl25;

	CardLayout card = null;
	static String name = null;
	static String job = null;
	imagepanel p1_bgimage, p2_bgimage, p3_bgimage;
	Timer t = null;

	JPanel p2_jp1,p2_jp2;
	GridLayout gri=null;
	boolean view[];
	public void initMenu() {
		jmi1_icon = new ImageIcon("iamge/menu/jmm1_icon1.jpg");
		jmi2_icon = new ImageIcon("iamge/menu/jmm1_icon2.jpg");
		jmi3_icon = new ImageIcon("iamge/menu/jmm1_icon3.jpg");
		jm1 = new JMenu("系统");
		jmi1 = new JMenuItem("切换用户", jmi1_icon);
		jmi2 = new JMenuItem("切换到收款界面", jmi3_icon);
		jmi3 = new JMenuItem("退出", jmi3_icon);

		jm1.add(jmi1);
		jm1.add(jmi2);
		jm1.add(jmi3);

		jmi4_icon = new ImageIcon("iamge/tootbar/jb4.jpg");
		jm2 = new JMenu("服务");
		jmi4 = new JMenuItem("客房服务", jmi4_icon);
		jm2.add(jmi4);

		jmi6_icon = new ImageIcon("image/toolbar/jb6.jpg");
		jm3 = new JMenu("帮助");
		jmi5 = new JMenuItem("系统简介", jmi6_icon);
		jm3.add(jmi5);

		jmb = new JMenuBar();
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		this.setJMenuBar(jmb);
	}

	public void initToolbar() {
		jtb = new JToolBar();
		jtb.setFloatable(false);
		jb1 = new JButton(new ImageIcon("images/toolbar/jb1.jpg"));
		
		jb2 = new JButton(new ImageIcon("images/toolbar/jb2.jpg"));
		jb3 = new JButton(new ImageIcon("images/toolbar/jb3.jpg"));
		jb4 = new JButton(new ImageIcon("images/toolbar/jb4.jpg"));
		jb5 = new JButton(new ImageIcon("images/toolbar/jb5.jpg"));
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5);

		this.add(jtb, "North");
	}

	public void initcenter() {
		jp1 = new JPanel(new BorderLayout());
		try {
			p1_bg = ImageIO.read(new File("images/orderindex.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p1_bgimage = new imagepanel(p1_bg);
		p1_bgimage.setLayout(new BorderLayout());
		try {
			p3_bg = ImageIO.read(new File("images/desk.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		p3_bgimage = new imagepanel(p3_bg);
		p3_bgimage.setLayout(new GridLayout(5, 5));
		p1_jl1 = new JLabel(new ImageIcon("images/desk/1.jpg"));
		p1_jl2 = new JLabel(new ImageIcon("images/desk/2.jpg"));
		p1_jl3 = new JLabel(new ImageIcon("images/desk/3.jpg"));
		p1_jl4 = new JLabel(new ImageIcon("images/desk/4.jpg"));
		p1_jl5 = new JLabel(new ImageIcon("images/desk/5.jpg"));
		p1_jl6 = new JLabel(new ImageIcon("images/desk/16.jpg"));
		p1_jl7 = new JLabel(new ImageIcon("images/desk/17.jpg"));
		p1_jl8 = new JLabel(new ImageIcon("images/desk/18.jpg"));
		p1_jl9 = new JLabel(new ImageIcon("images/desk/19.jpg"));
		p1_jl10 = new JLabel(new ImageIcon("images/desk/6.jpg"));
		p1_jl11 = new JLabel(new ImageIcon("images/desk/15.jpg"));
		p1_jl12 = new JLabel(new ImageIcon("images/desk/24.jpg"));
		p1_jl13 = new JLabel(new ImageIcon("images/desk/25.jpg"));
		p1_jl14 = new JLabel(new ImageIcon("images/desk/20.jpg"));
		p1_jl15 = new JLabel(new ImageIcon("images/desk/7.jpg"));
		p1_jl16 = new JLabel(new ImageIcon("images/desk/14.jpg"));
		p1_jl17 = new JLabel(new ImageIcon("images/desk/23.jpg"));
		p1_jl18 = new JLabel(new ImageIcon("images/desk/22.jpg"));
		p1_jl19 = new JLabel(new ImageIcon("images/desk/21.jpg"));
		p1_jl20 = new JLabel(new ImageIcon("images/desk/8.jpg"));
		p1_jl21 = new JLabel(new ImageIcon("images/desk/13.jpg"));
		p1_jl22 = new JLabel(new ImageIcon("images/desk/12.jpg"));
		p1_jl23 = new JLabel(new ImageIcon("images/desk/11.jpg"));
		p1_jl24 = new JLabel(new ImageIcon("images/desk/10.jpg"));
		p1_jl25 = new JLabel(new ImageIcon("images/desk/9.jpg"));
		JLabel[] jlables = { p1_jl1, p1_jl2, p1_jl3, p1_jl4, p1_jl5, p1_jl6,
				p1_jl7, p1_jl8, p1_jl9, p1_jl10, p1_jl11, p1_jl12, p1_jl13,
				p1_jl14, p1_jl15, p1_jl16, p1_jl17, p1_jl18, p1_jl19, p1_jl20,
				p1_jl21, p1_jl22, p1_jl23, p1_jl24, p1_jl25 };

		String status[] = new String[25];
		statusModel model = new statusModel();
		view= new boolean[25];
		for (int i = 0; i < 25; i++) {
			status[i] = model.getStatusById((i + 1) + "");
			if (status[i] == "0") {
				view[i] = false;
			} else {
				view[i] = true;
			}
			System.out.println(view[i]);
			jlables[i].setEnabled(view[i]);
			jlables[i].addMouseListener(this);
			p3_bgimage.add(jlables[i],i);
		}
			// addActionListener()
			int width = Toolkit.getDefaultToolkit().getScreenSize().width;
			int height = Toolkit.getDefaultToolkit().getScreenSize().height;
			p3_bgimage.setLocation(width / 4, height / 4);
			 p1_bgimage.add(p3_bgimage,"Center");
			jp1.add(p1_bgimage, "Center");
//			jp1.add(p3_bgimage, "East");// 有点疑问

			jp2 = new JPanel(new BorderLayout());
			try {
				p2_bg = ImageIO.read(new File("images/manage.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			p2_bgimage = new imagepanel(p2_bg);
			gri=new GridLayout(5, 2);
			gri.setHgap(100);
			gri.setVgap(50);
			p2_bgimage.setLayout(gri);

			p2_jl1 = new JLabel(new ImageIcon("images/main/label_1.gif"));
			p2_jl11 = new JLabel();
			p2_jl2 = new JLabel("当前用户");
			p2_jl3 = new JLabel(name);
			p2_jl4 = new JLabel("职位");
			p2_jl5 = new JLabel(job);

			jb1 = new JButton("预定");
			jb1.addActionListener(this);
//			jb1.setBounds(r)
			jb2 = new JButton("退订");
			jb2.addActionListener(this);
			jb3 = new JButton("点菜");
			jb3.addActionListener(this);
			jb4 = new JButton("结账");
			jb4.addActionListener(this);

			p2_bgimage.add(p2_jl1, "0");
			p2_bgimage.add(p2_jl11, "1");
			p2_bgimage.add(p2_jl2, "2");
			p2_bgimage.add(p2_jl3, "3");
			p2_bgimage.add(p2_jl4, "4");
			p2_bgimage.add(p2_jl5, "5");

			
			p2_bgimage.add(jb1, "6");
			p2_bgimage.add(jb2, "7");
			p2_bgimage.add(jb3, "8");
			p2_bgimage.add(jb4, "9");
			
			jp2.add(p2_bgimage, "Center");

			jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, jp1, jp2);
			jsp.setDividerLocation(Toolkit.getDefaultToolkit().getScreenSize().width *3/4);
			jsp.setDividerSize(0);

			this.add(jsp, "Center");
	}

	public void initStatus() {
		jp3 = new JPanel(new BorderLayout());
		t = new Timer(1000, (ActionListener) this);
		showtime = new JLabel("当前时间为 :"
				+ Calendar.getInstance().getTime().toLocaleString());
		t.start();
		try {
			timebg = ImageIO.read(new File("images/status/time_bg.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		imagepanel sta = new imagepanel(timebg);
		sta.setLayout(new BorderLayout());
		sta.add(showtime, "East");
		jp3.add(sta);
		this.add(jp3, "South");
	}

	public window2() {// String empname,String zhiwei
		try {
			titleIcon = ImageIO.read(new File("images/title.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		name = "songxupeng";
		job = "jingli";
		this.initMenu();
		this.initToolbar();
		this.initcenter();
		this.initStatus();
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(width, height - 40);
		this.setIconImage(titleIcon);
		this.setTitle("餐饮前台管理系统");
		this.setVisible(true);

	}

	public static void main(String args[]) {
		window2 wi = new window2();
		Thread th=new Thread(wi);
		th.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.showtime.setText("当前时间： "+Calendar.getInstance().getTime().toLocaleString()+" ");
		if(e.getSource()==jb1){
			//add order;
			new addOrder();
		}else if(e.getSource()==jb2){
			//delorder
			new deleOrder();
		}else if(e.getSource()==jb3){
			//bookdish
			new bookdish();
		}else if(e.getSource()==jb4){
			// account;
			new Accounts();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(arg0.getSource()==p1_jl1)
		{
			this.p1_jl2.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl2)
		{
			this.p1_jl2.setEnabled(true);
		}else if(arg0.getSource()==p1_jl3)
		{
			this.p1_jl3.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl4)
		{
			this.p1_jl4.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl5)
		{
			this.p1_jl5.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl6)
		{
			this.p1_jl6.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl7)
		{
			this.p1_jl7.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl8)
		{
			this.p1_jl8.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl9)
		{
			this.p1_jl9.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl10)
		{
			this.p1_jl10.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl1)
		{
			this.p1_jl11.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl12)
		{
			this.p1_jl12.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl13)
		{
			this.p1_jl13.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl14)
		{
			this.p1_jl14.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl15)
		{
			this.p1_jl15.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl16)
		{
			this.p1_jl16.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl17)
		{
			this.p1_jl17.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl18)
		{
			this.p1_jl18.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl19)
		{
			this.p1_jl19.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl20)
		{
			this.p1_jl20.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl21)
		{
			this.p1_jl21.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl22)
		{
			this.p1_jl22.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl23)
		{
			this.p1_jl23.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl24)
		{
			this.p1_jl24.setEnabled(true);
		}
		else if(arg0.getSource()==p1_jl25)
		{
			this.p1_jl25.setEnabled(true);
		}

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if(arg0.getSource()==p1_jl1)
		{
			this.p1_jl1.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl2)
		{
			this.p1_jl2.setEnabled(false);
		}else if(arg0.getSource()==p1_jl3)
		{
			this.p1_jl3.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl4)
		{
			this.p1_jl4.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl5)
		{
			this.p1_jl5.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl6)
		{
			this.p1_jl6.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl7)
		{
			this.p1_jl7.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl8)
		{
			this.p1_jl8.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl9)
		{
			this.p1_jl9.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl10)
		{
			this.p1_jl10.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl1)
		{
			this.p1_jl11.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl12)
		{
			this.p1_jl12.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl13)
		{
			this.p1_jl13.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl14)
		{
			this.p1_jl14.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl15)
		{
			this.p1_jl15.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl16)
		{
			this.p1_jl16.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl17)
		{
			this.p1_jl17.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl18)
		{
			this.p1_jl18.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl19)
		{
			this.p1_jl19.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl20)
		{
			this.p1_jl20.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl21)
		{
			this.p1_jl21.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl22)
		{
			this.p1_jl22.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl23)
		{
			this.p1_jl23.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl24)
		{
			this.p1_jl24.setEnabled(false);
		}
		else if(arg0.getSource()==p1_jl25)
		{
			this.p1_jl25.setEnabled(false);
		}
	}
	public void run() {
		JLabel []jlables={p1_jl1,p1_jl2,p1_jl3,p1_jl4,p1_jl5,p1_jl6,p1_jl7,p1_jl8,p1_jl9,p1_jl10,p1_jl11,p1_jl12,p1_jl13,p1_jl14,p1_jl15,p1_jl16,p1_jl17,p1_jl18,p1_jl19,p1_jl20,p1_jl21,p1_jl22,p1_jl23,p1_jl24,p1_jl25};
		for(int i=0;i<jlables.length;i++)
		{
			try
			{
			Thread.sleep(500);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
//			p3_bgimage.add(jlables[i]);
//			jlables[i].setCursor(Cursor.TEXT_CURSOR);
			jlables[i].setBackground(Color.gray);
		}
		while(true)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			break;
		}
	}
	
}
