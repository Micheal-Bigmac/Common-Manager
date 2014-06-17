package view2;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import com.model.orderModel;
import com.tools.myfont;

public class bookdish extends JDialog implements ActionListener{
	JPanel p1,p2,p3;
	JLabel jl1,jl2;
	JTextField jtf1,jtf2;
	JButton jb1,jb2;
	
	public bookdish()
	{
		super();
		p1=new JPanel(new GridLayout(2,1));
		
		jl1=new JLabel("deskid");
		jl2=new JLabel("bookid");
		p1.add(jl1);
		p1.add(jl2);
		p2=new JPanel(new GridLayout(2,1));
		jtf1=new JTextField();
		jtf2=new JTextField();
		
		p2.add(jtf1);
		p2.add(jtf2);
		
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
		

		this.setSize(300,150);

		this.setTitle("选择餐桌点菜");
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
				JOptionPane.showMessageDialog(null, "对不起，该餐桌正在就餐！");
			}
			else 
			{
//				String deskId=jtf1.getText().trim();
				new BookDetail(this);
				this.dispose();
			}

			this.dispose();
		}
		else if(arg0.getSource()==jb2)
		{
			this.dispose();
		}
	}

}
