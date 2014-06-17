package view2;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JDialog;

import com.model.orderModel;
import com.tools.myfont;

import java.util.Calendar;
import java.util.Vector;


import java.awt.event.*;
//添加界面
public class Accounts extends JDialog implements ActionListener{

	JPanel p1,p2,p3;
	JLabel jl1;
	JTextField jtf1;
	JButton jb1,jb2;
	
	public Accounts()
	{
		super();
		p1=new JPanel(new GridLayout(1,1));
		
		jl1=new JLabel("deskid");
		
		p1.add(jl1);
		
		p2=new JPanel(new GridLayout(1,1));
		jtf1=new JTextField();
		
		
		p2.add(jtf1);
		
		
		p3=new JPanel(new FlowLayout(FlowLayout.CENTER));
		jb1=new JButton("确定");
		jb1.setFont(myfont.f4);
		jb1.addActionListener(this);
		jb2=new JButton("取消");
		jb2.setFont(myfont.f4);
		jb2.addActionListener(this);
		p3.add(jb1);
		p3.add(jb2);
		this.setLayout(new BorderLayout());
		this.add(p1,"West");
		this.add(p2,"Center");
		this.add(p3,"South");
		

		this.setSize(250,100);

		this.setTitle("选择餐桌结账");
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb1)
		{
			orderModel om=new orderModel();
			
			String status=om.getStatusById(jtf1.getText());
//			System.out.print(status);
			if(status.equals("0"))
			{
				new AccountDetail(this);
				this.dispose();
			}
			else 
			{
			
				JOptionPane.showMessageDialog(null, "对不起，该餐桌无人用餐！");
				
			}

			this.dispose();
		}
		else if(arg0.getSource()==jb2)
		{
			this.dispose();
		}
	}
	
	
	
	
}
