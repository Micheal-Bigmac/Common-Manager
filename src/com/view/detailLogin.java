package com.view;
import java.awt.*;

import javax.swing.*;

import com.model.employeeModel;
import com.model.loginModel;

import java.awt.event.*;
public class detailLogin extends JDialog{
	JLabel jl1,jl2,jl3,jl4;
	JTextField jtf1,jtf2,jtf3,jtf4;
	JPanel jp1,jp2;
	public detailLogin(Frame ower,String title,boolean modal,loginModel log,int row){
		super(ower,title,modal);
		
		jl1=new JLabel("员工号",jl1.CENTER);
		jl2=new JLabel("姓名",jl2.CENTER);
		jl3=new JLabel("性别",jl3.CENTER);
		jl4=new JLabel("籍贯",jl4.CENTER);
	
		
		jtf1=new JTextField(20);
		jtf1.setText((String)log.getValueAt(row, 0));
		jtf1.setEditable(false);
		jtf2=new JTextField(20);
		jtf2.setText((String)log.getValueAt(row, 1));
		jtf2.setEditable(false);
		jtf3=new JTextField(20);
		jtf3.setText((String)log.getValueAt(row, 2));
		jtf3.setEditable(false);
		jtf4=new JTextField(20);
		jtf4.setText((String)log.getValueAt(row, 3));
		jtf4.setEditable(false);
		
		jp1=new JPanel(new GridLayout(4, 1));
		jp2=new JPanel(new GridLayout(4, 1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);

		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);

		
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.EAST);
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(w/2-150,h/2-150);
		this.setSize(400,300);
		this.setVisible(true);
	}
}
