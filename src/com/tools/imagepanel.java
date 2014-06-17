package com.tools;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class imagepanel extends JPanel {
	private Image img;
	public imagepanel(Image im){
		this.img=im; 
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(w,h);
	}
//	public void paint(Graphics g){
//		g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
//	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
	}
}
