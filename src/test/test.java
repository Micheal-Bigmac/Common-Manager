package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.Border;
public class test extends JFrame{
	JButton jb1,jb2,jb3,jb4;
	JPanel jp1,jp2,jp3;
	BoxLayout box=null;
	public test(){
		jp1=new JPanel();
		BoxLayout box1=new BoxLayout(jp1, BoxLayout.Y_AXIS);
		
		jb1=new JButton("1");
		jb2=new JButton("2");
		jb3=new JButton("3");
		jb4=new JButton("4");
//		jp1.setAlignmentY(Component.TOP_ALIGNMENT);
		
		
		jp2=new JPanel();
		BoxLayout box2=new BoxLayout(jp2, BoxLayout.Y_AXIS);
		
		jp1.add(jb1);
		//������ť֮�����һ�����ɼ��� rigidArea	
//		jp1.add(Box.createRigidArea(new Dimension(15, 15)));
		jp1.add(jb2);
//		jp2.add(Box.createRigidArea(new Dimension(15, 15)));
		
		
		jp2.add(jb3);
		jp2.add(Box.createRigidArea(new Dimension(15, 15)));
		jp2.add(jb4);
		
//		jp3=new JPanel(new GridBagLayout());
	
//		jp3.add(jp1);
		
//		jp3.add(jp2);
//		this.add(jp3);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		jp3.setOpaque(true);
//		this.setContentPane(jp3);
//		BoxLayout box3=new BoxLayout(null, BoxLayout.X_AXIS);
//		this.setLayout(box3);
//		this.setOpacity(true);
		
		
		
		this.setLayout(new BorderLayout());
		this.add(jp1,"West");
		this.add(jp2,"East");
		
//		JButton toTargetButton=new JButton(">>");
//		JButton toSourceButton=new JButton("<<");
//		JPanel buttonPanel = new JPanel(); 
//		 // �м�� Panel ����ˮƽ����
//		 buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS )); 
//		 // ����ť >> ���뵽�м�� Panel 
//		 buttonPanel.add(toTargetButton); 
//		//������ť֮�����һ�����ɼ��� rigidArea			
//		 buttonPanel.add(Box.createRigidArea (new Dimension(15, 15))); 
//		 // ����ť << ���뵽�м�� Panel 
//		 buttonPanel.add(toSourceButton); 
//		 buttonPanel.setAlignmentY(Component.TOP_ALIGNMENT ); 
//		 buttonPanel.setBorder(BorderFactory.createEmptyBorder (15, 5, 15, 5)); 
//		 // ���м�� Panel ���뵽 middlePanel 
////		 middlePanel .add(buttonPanel); 
//		 this.add(buttonPanel);

		
		this.setSize(400, 300);
		this.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test te=new test();
	}

}
