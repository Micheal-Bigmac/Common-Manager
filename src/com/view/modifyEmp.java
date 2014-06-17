package com.view;
import java.awt.*;

import javax.swing.*;

import com.model.employeeModel;

import java.awt.event.*;
public class modifyEmp extends JDialog implements ActionListener{
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8;
	JPanel jp1,jp2,jp3;
	employeeModel em=null;
	public modifyEmp(Frame ower,String title,boolean modal,employeeModel model,int row){
		super(ower,title,modal);
		
		em=new employeeModel();
		
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
		jtf3=new JTextField(20);
		jtf3.setText((String)model.getValueAt(row, 2));
		jtf4=new JTextField(20);
		jtf4.setText((String)model.getValueAt(row, 3));
		jtf5=new JTextField(20);
		jtf5.setText((String)model.getValueAt(row, 4));
		jtf6=new JTextField(20);
		jtf6.setText((String)model.getValueAt(row, 5));
		jtf7=new JTextField(20);
		jtf7.setText((String)model.getValueAt(row, 6));
		jtf8=new JTextField(20);
		jtf8.setText((String)model.getValueAt(row, 7));
		
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
		
		jp3=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jb1=new JButton("修改");
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.addActionListener(this);
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.EAST);
		this.add(jp3,BorderLayout.SOUTH);
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(w/2-150,h/2-150);
		this.setSize(400,300);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1){
			String id=jtf1.getText().trim();
			String name=jtf2.getText().trim();
			String sex=jtf3.getText().trim();
			String jiguan=jtf4.getText().trim();
			String bir=jtf5.getText().trim();
			if(bir.equals("")){
				System.out.println("kong");
				bir=null;
			}
			String xl=jtf6.getText().trim();
			String marriage=jtf7.getText().trim();
			String post=jtf8.getText().trim();
			String arg[]={name,sex,jiguan,bir,xl,marriage,post,id};
			
			String sql="update rszl set empname=?,sex=?,address=?,birthday=?,xl=?,hf=?,zhiwei=? where empid=?";
			if(em.executeUpdate(sql, arg)==true){
				JOptionPane.showMessageDialog(this, "修改成功");
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
				jtf4.setText("");
				jtf5.setText("");
				jtf6.setText("");
				jtf7.setText("");
				jtf8.setText("");
			}else{
				JOptionPane.showMessageDialog(this, "修改失败");
			}
		}else if(e.getSource()==jb2){
			this.dispose();
		}
	}
}
