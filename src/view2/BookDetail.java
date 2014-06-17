package view2;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JDialog;

import com.model.orderModel;
import com.tools.myfont;

import java.awt.event.*;
//添加界面
public class BookDetail extends JDialog implements ActionListener{

	JPanel p1,p2,p3;
	//JLabel jl0,jl1,jl2,jl3,jl4,jl5,jl6;
	JTextField jtf0,jtf1,jtf2,jtf3,jtf4,jtf5,jtf6,jtf7,jtf8,jtf9;
	JTextField tf0,tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
	JButton jb1,jb2;
	String deskid,bookid;
	public BookDetail(bookdish bd)
	{
		super();
		deskid=bd.jtf1.getText().trim();
		bookid=bd.jtf2.getText().trim();
		System.out.print(bookid);
		p1=new JPanel(new GridLayout(9,1));
		p2=new JPanel(new GridLayout(9,1));
		jtf1=new JTextField("foodid",20);
		jtf1.setEditable(false);
		jtf2=new JTextField(20);
		jtf3=new JTextField(20);
		jtf4=new JTextField(20);
		jtf5=new JTextField(20);
		jtf6=new JTextField(20);
		jtf7=new JTextField(20);
		jtf8=new JTextField(20);
		jtf9=new JTextField(20);
		tf1=new JTextField("foodnum",20);
		tf1.setEditable(false);
		tf2=new JTextField(20);
		tf3=new JTextField(20);
		tf4=new JTextField(20);
		tf5=new JTextField(20);
		tf6=new JTextField(20);
		tf7=new JTextField(20);
		tf8=new JTextField(20);
		tf9=new JTextField(20);
		p1.add(jtf1);
		p1.add(jtf2);
		p1.add(jtf3);
		p1.add(jtf4);
		p1.add(jtf5);
		p1.add(jtf6);
		p1.add(jtf7);
		p1.add(jtf8);
		p1.add(jtf9);
		p2.add(tf1);
		p2.add(tf2);
		p2.add(tf3);
		p2.add(tf4);
		p2.add(tf5);
		p2.add(tf6);
		p2.add(tf7);
		p2.add(tf8);
		p2.add(tf9);
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
		this.add(p2,"East");
		this.add(p3,"South");
		

		this.setSize(450,300);

		this.setTitle("添加菜单");
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb1)
		{
			String sql="insert into bookdetail values(?,?,?)";
			String []params1={bookid,jtf2.getText(),tf2.getText()};
			String []params2={bookid,jtf3.getText(),tf3.getText()};
			String []params3={bookid,jtf4.getText(),tf4.getText()};
			String []params4={bookid,jtf5.getText(),tf5.getText()};
			String []params5={bookid,jtf6.getText(),tf6.getText()};
			String []params6={bookid,jtf7.getText(),tf7.getText()};
			String []params7={bookid,jtf8.getText(),tf8.getText()};
			String []params8={bookid,jtf9.getText(),tf9.getText()};
			String[][]params={params1,params2,params3,params4,params5,params6,params7,params8};
			orderModel om=new orderModel();
			
			for(int i=0;i<params.length;i++)
			{
				om.executeUpdate(sql, params[i]);
			}
			String sql2="insert into bookdish values(?,?)";
			String []params9={deskid,bookid};
			orderModel om2=new orderModel();
			om2.executeUpdate(sql2, params9);
			String[]params10={deskid};
			String sql3="update status set deskstatus=0 where deskid=?";
			om2.executeUpdate(sql3, params10);
			JOptionPane.showMessageDialog(null, "恭喜！添加成功！");
			this.dispose();
		
		}
		else if(arg0.getSource()==jb2)
		{
			this.dispose();
		}
	}
	
	
	
	
}

