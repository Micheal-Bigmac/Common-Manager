package com.view;
import java.awt.*;

import javax.swing.*;

import com.model.loginModel;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class loginmanage extends JPanel implements ActionListener{
	JPanel p1,p2,p3,p4,p5;
	JLabel p1_label,p3_label;
	JTextField p1_jtf;
	JButton p1_jb1,p1_jb2,p1_jb3,p1_jb4,p1_jb5;
	JTable jtb;
	JScrollPane jsp;
	loginModel log=null;
	public loginmanage(){
		p1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_label=new JLabel("请输入员工号(姓名或职位)");
		p1_jtf=new JTextField(20);
		p1_jb1=new JButton("查找员工");
		p1_jb1.addActionListener(this);
		p1.add(p1_label);
		p1.add(p1_jtf);
		p1.add(p1_jb1);
		
		p2=new JPanel(new BorderLayout());
		log=new loginModel();
		jtb=new JTable(log);
		jsp=new JScrollPane(jtb);
		p2.add(jsp);
		
		p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		p3_label=new JLabel("共*** 条数据");
		p3.add(p3_label);
		
		p4=new JPanel(new FlowLayout(FlowLayout.RIGHT));
//		p1_jb2=new JButton("详细信息");
		p1_jb3=new JButton("详细记录");
		p1_jb3.addActionListener(this);
		p1_jb4=new JButton("添加密码");
		p1_jb4.addActionListener(this);
		p1_jb5=new JButton("修改密码");
		p1_jb5.addActionListener(this);
		
//		p4.add(p1_jb2);
		p4.add(p1_jb3);
		p4.add(p1_jb4);
		p4.add(p1_jb5);
		
		p5=new JPanel(new BorderLayout());
		p5.add(p3,"West");
		p5.add(p4,"East");
		
		this.setLayout(new BorderLayout());
		this.add(p1,"North");
		this.add(p2,"Center");
		this.add(p5,"South");
		this.setSize(400,300);
		
		this.setVisible(true);
		
	}
	public static void main(String args[]){
		loginmanage log=new loginmanage();
		JFrame jf=new JFrame();
		jf.add(log);
		jf.show();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==p1_jb1){
			String jb1=p1_jtf.getText().trim();
			String arg[]={jb1,jb1,jb1};
			String sql ="select * from loginMana where empname=? or empid=? or zhiwei=? ";
			
			log=new loginModel();
			log.query(sql, arg);
			this.jtb.setModel(log);
		}else if(e.getSource()==p1_jb3){
			int row=this.jtb.getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(this, "请选中行");
			}
			detailLogin lo=new detailLogin(window.m, "详细信息", true, log, row);
		}else if(e.getSource()==p1_jb4){
			addlogin add =new addlogin(window.m,"详细信息",true);
			log=new loginModel();
			this.jtb.setModel(log);
		}else if(e.getSource()==p1_jb5){
			int row=this.jtb.getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(this, "请选中行");
			}
			modifyLogin mo=new modifyLogin(window.m,"修改密码",true,this.log,row);
			log=new loginModel();
			this.jtb.setModel(log);
		}
	}
}
