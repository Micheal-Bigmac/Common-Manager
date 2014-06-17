package com.view;
//20102806
import javax.swing.*;

import com.model.usermodel;
import com.tools.myfont;

import java.awt.*;
import java.awt.event.*;

public class login extends JDialog implements ActionListener{
	private JLabel jl1,jl2;
	private JTextField jtf1;
	private JPasswordField jpw1;
	private JButton jb1,jb2;
	background bg=null;
	public login(){
		this.setLayout(null);
		bg=new background();
		
		jl1=new JLabel("user id");
		jl1.setFont(myfont.f1);
		jl2=new JLabel("password");
		jl2.setFont(myfont.f1);
		
		jb1=new JButton("go");
		jb1.addActionListener(this);
		jb2=new JButton("cancle");
		jb2.addActionListener(this);
		
		jtf1=new JTextField(10);
		jpw1=new JPasswordField(10);
		
		bg.setBounds(0,0,360,360);
		jl1.setBounds(40,200,100,30);
		jl2.setBounds(40,240,100,30);
		jtf1.setBounds(140,200,150,30);
		jpw1.setBounds(140,240,150,30);
		
		jb1.setBounds(90,280,80,30);
		jb2.setBounds(220,280,80,30);
		
		this.add(jl1);
		this.add(jl2);
		this.add(jtf1);
		this.add(jpw1);
		this.add(jb1);
		this.add(jb2);
		this.add(bg);
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		this.setUndecorated(true);
		this.setSize(360,360);
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(w/2-150, h/2-150);
		this.setVisible(true);
				
	}
	class background extends JPanel{
		private Image background =new ImageIcon("images/login.gif").getImage();
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(background,0,0,360,360,this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jb1){
			String id=jtf1.getText().trim();
			String password=new String(jpw1.getPassword());
			
			usermodel user=new usermodel();
			String post=user.check(id, password).trim();
			System.out.println(post);
			System.out.println(post.length());
			System.out.println(post.equals("经理"));
			if(post.equals("经理")||post.equals("主管")||post.equals("管理员"))
			{
//				new window();
				this.dispose();
			}
			if(post.equals("")){
				JOptionPane.showMessageDialog(this, "用户名或密码错误");
				jtf1.setText("");
				jpw1.setText("");
			}
		}else if(e.getSource()==jb2){
			this.dispose();
		}
	}
}
