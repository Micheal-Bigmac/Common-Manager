package com.view;
import java.awt.*;

import javax.swing.*;

import com.model.employeeModel;
import com.model.menuModel;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class menuManage extends JPanel implements ActionListener{
	JPanel p1,p2,p3,p4,p5;
	JLabel p1_label,p3_label;
	JTextField p1_jtf;
	JButton p1_jb1,p1_jb2,p1_jb3,p1_jb4,p1_jb5;
	JTable jtb;
	JScrollPane jsp;
	JComboBox jcb;
	menuModel menu=null;
	private modifyMenu modifymenu;
	
	public menuManage(){
		p1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_label=new JLabel("�������ѯ����(foodid,foodname.chief)");
		p1_jtf=new JTextField(20);
		jcb=new JComboBox();
		jcb.addItem("��ʳ��");
		jcb.addItem("�Ȳ���");
		jcb.addItem("������");
		jcb.addItem("�����");
		jcb.addItem("������");
		jcb.addItem("����");
		jcb.setSelectedIndex(-1);
		
		p1_jb1=new JButton("��ѯ");
		p1_jb1.addActionListener(this);
		p1.add(p1_label);
		p1.add(p1_jtf);
		p1.add(jcb);
		p1.add(p1_jb1);
		
		p2=new JPanel(new BorderLayout());
		menu=new menuModel();
		jtb=new JTable(menu);
		jsp=new JScrollPane(jtb);
		p2.add(jsp);
		
		p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		p3_label=new JLabel("��*** ������");
		p3.add(p3_label);
		
		p4=new JPanel(new FlowLayout(FlowLayout.RIGHT));
//		p1_jb2=new JButton("ˢ��");
//		p1_jb2.addActionListener(this);
		p1_jb3=new JButton("���");
		p1_jb3.addActionListener(this);
		p1_jb4=new JButton("ɾ��");
		p1_jb4.addActionListener(this);
		p1_jb5=new JButton("�޸�");
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
		menuManage em=new menuManage();
		JFrame jf=new JFrame();
		jf.add(em);
		jf.show();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==p1_jb1){
			String select=this.p1_jtf.getText().trim();
			String combox=(String) this.jcb.getSelectedItem();
			String arg[]={select,select,select,combox};
			
			System.out.println(combox);
			String sql ="select * from view_menu where foodid=? or foodname=? or chief=? or type=? ";
			menu=new menuModel();
			menu.query(sql, arg);
			this.jtb.setModel(menu);
		}else if(e.getSource()==p1_jb3){
			addmenu add=new addmenu(window.m, "��Ӳ���", true);
			menu=new menuModel();
			this.jtb.setModel(menu);
		}else if(e.getSource()==p1_jb4){
			int row=jtb.getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(this, "��ѡ����");
			}
			String foodid=(String) jtb.getValueAt(row, 0);
			String arg[]={foodid};
			String sql="delete from menu where foodid=?";
			if(!menu.executeUpdate(sql, arg)){
				JOptionPane.showMessageDialog(this, "ɾ��ʧ��");
			}
			menu=new menuModel();
			this.jtb.setModel(menu);
		}else if(e.getSource()==p1_jb5){
			int row=jtb.getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(this, "��ѡ����");
			}
			modifymenu = new modifyMenu(window.m, "�޸Ĳ˵�", true, menu, row);
			menu=new menuModel();
			this.jtb.setModel(menu);
		}
	}

}
