package com.view;
import javax.swing.*;
import java.awt.*;

import javax.swing.JDialog;

import com.model.employeeModel;
import com.tools.myfont;

import java.awt.event.*;

public class addSoundDialog extends JDialog implements ActionListener{
	JPanel p1,p2,p3;
	JLabel jl1,jl2,jl3;
	JTextField jtf1,jtf2,jtf3;
	JButton jb1,jb2;
	
	public addSoundDialog(Frame empInfo,String title,boolean model)
	{
		super(empInfo,title,model);
		p1=new JPanel(new GridLayout(3,1));
		jl1=new JLabel("soundid");
		jl2=new JLabel("soundpath");
		jl3=new JLabel("description");
		
		p1.add(jl1);
		p1.add(jl2);
		p1.add(jl3);
		
	
		p2=new JPanel(new GridLayout(3,1));
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
	

		p2.add(jtf1);
		p2.add(jtf2);
		p2.add(jtf3);
	
		
		p3=new JPanel(new FlowLayout(FlowLayout.CENTER));
		jb1=new JButton("添加");
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
		

		this.setSize(400,200);
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(w/2-150,h/2-150);
		this.setTitle("添加音乐");
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==jb1)
		{
			String sql="insert into sound values(?,?,?)";
			String []params={jtf1.getText(),jtf2.getText(),jtf3.getText()};
			employeeModel em=new employeeModel();
		
			if(!em.executeUpdate(sql, params))
			{
				JOptionPane.showMessageDialog(null, "添加失败，请输入正确数据类型!");
			}
//			em.query("select * from sound", null);
//			this.repaint();
			JOptionPane.showMessageDialog(null, "恭喜！添加成功！");
			this.dispose();
			
		}
		else if(arg0.getSource()==jb2)
		{
			this.dispose();
		}
	}

}
