package com.view;
import java.awt.*;

import javax.swing.*;

import com.model.employeeModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class employee extends JPanel implements ActionListener{
	JPanel p1,p2,p3,p4,p5;
	JLabel p1_label,p3_label;
	JTextField p1_jtf;
	JButton p1_jb1,p1_jb2,p1_jb3,p1_jb4,p1_jb5;
	JTable jtb;
	JScrollPane jsp;
	employeeModel em=null;
	public employee(){
		p1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_label=new JLabel("������Ա��������idְλ");
		p1_jtf=new JTextField(20);
		p1_jb1=new JButton("search");
		p1_jb1.addActionListener(this);
		p1.add(p1_label);
		p1.add(p1_jtf);
		p1.add(p1_jb1);
		
		p2=new JPanel(new BorderLayout());
		em=new employeeModel();
		jtb=new JTable();
		jtb.setModel(em);
		jsp=new JScrollPane(jtb);
		p2.add(jsp);
		
		p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		p3_label=new JLabel("��*** ������");
		p3.add(p3_label);
		
		p4=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p1_jb2=new JButton("��ϸ��Ϣ");
		p1_jb2.addActionListener(this);
		
		p1_jb3=new JButton("���");
		p1_jb3.addActionListener(this);
		p1_jb4=new JButton("ɾ��");
		p1_jb4.addActionListener(this);
		p1_jb5=new JButton("�޸�");
		p1_jb5.addActionListener(this);
		
		p4.add(p1_jb2);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==p1_jb1){
			String str=p1_jtf.getText().trim();
			String arg[]={str,str,str};
			String sql ="select * from empMana where empid =? or empname=? or bz=?";
			em=new employeeModel();
			em.query(sql, arg);
			this.jtb.setModel(em);
		}else if(e.getSource()==p1_jb3){
			System.out.println("sfsd");
			addEmp add=new addEmp(window.m, "����Ա��", true);
			em=new employeeModel();
			this.jtb.setModel(em);
		}else if(e.getSource()==p1_jb4){
			int row=jtb.getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(this, "��ѡ����");
			}
			String empid=(String) jtb.getValueAt(row, 0);
			String arg[]={empid};
			String sql="delete from rszl where empid=?";
			if(!em.executeUpdate(sql, arg)){
				JOptionPane.showMessageDialog(this, "ɾ��ʧ��");
			}
			em=new employeeModel();
			this.jtb.setModel(em);
		}else if(e.getSource()==p1_jb5){
			int row=jtb.getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(this, "��ѡ����");
			}
			modifyEmp modify=new modifyEmp(window.m,"�޸���Ϣ",true,em,row);
			em=new employeeModel();
			this.jtb.setModel(em);
		}else if(e.getSource()==p1_jb2){
			int row=jtb.getSelectedRow();
			if(row==-1){
				JOptionPane.showMessageDialog(this, "��ѡ����");
			}
			detailEmp emp=new detailEmp(window.m, "��ϸ��Ϣ", true, em, row);
		}
	}
}
