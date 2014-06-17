package com.view;
import java.awt.*;

import javax.swing.*;
import com.model.employeeModel;
public class detailEmp extends JDialog{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
	JPanel jp1,jp2;
	
	public detailEmp(Frame ower,String title,boolean modal,employeeModel model,int row){
		super(ower,title,modal);
		
		jl1=new JLabel("员工号",jl1.CENTER);
		jl2=new JLabel("姓名",jl2.CENTER);
		jl3=new JLabel("性别",jl3.CENTER);
		jl4=new JLabel("籍贯",jl4.CENTER);
		jl5=new JLabel("生日",jl5.CENTER);
		jl6=new JLabel("学历",jl6.CENTER);
		jl7=new JLabel("婚姻",jl7.CENTER);
		jl8=new JLabel("职位",jl8.CENTER);
		
		jtf1=new JTextField(20);
		jtf1.setText((String)model.getValueAt(row, 0));
		jtf1.setEditable(false);
		jtf2=new JTextField(20);
		jtf2.setText((String)model.getValueAt(row, 1));
		jtf2.setEditable(false);
		jtf3=new JTextField(20);
		jtf3.setText((String)model.getValueAt(row, 2));
		jtf3.setEditable(false);
		jtf4=new JTextField(20);
		jtf4.setText((String)model.getValueAt(row, 3));
		jtf4.setEditable(false);
		jtf5=new JTextField(20);
		jtf5.setText((String)model.getValueAt(row, 4));
		jtf5.setEditable(false);
		jtf6=new JTextField(20);
		jtf6.setText((String)model.getValueAt(row, 5));
		jtf6.setEditable(false);
		jtf7=new JTextField(20);
		jtf7.setText((String)model.getValueAt(row, 6));
		jtf7.setEditable(false);
		jtf8=new JTextField(20);
		jtf8.setText((String)model.getValueAt(row, 7));
		jtf8.setEditable(false);
		
		jp1=new JPanel(new GridLayout(8, 1));
		jp2=new JPanel(new GridLayout(8, 1));
		
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		jp1.add(jl7);
		jp1.add(jl8);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		jp2.add(jtf7);
		jp2.add(jtf8);
		
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.EAST);
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(w/2-150,h/2-150);
		this.setSize(400,300);
		this.setVisible(true);
	}
}
