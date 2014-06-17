package com.view;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
public class index extends JWindow implements Runnable{

	JLabel top;
	JProgressBar jpb;
	public index(){
		top=new JLabel(new ImageIcon("images/index.gif"));
		jpb =new JProgressBar();

		this.setIconImage(Toolkit.getDefaultToolkit().getImage("images/title.gif"));
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(w/2-200, h/2-200);
		this.add(top,BorderLayout.NORTH);
		
		this.add(jpb,BorderLayout.SOUTH);
		
		this.setSize(400,300);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void run() {
		int value[]={0,4,8,16,20,25,28,31,35,42,48,53,58,62,68,72,79,83,89,95,100};
		for(int i=0;i<value.length;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			jpb.setValue(value[i]);
		}
		new login();
		this.dispose();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		index in=new index();
		Thread th=new Thread(in);
		th.start();
		
	}


}
