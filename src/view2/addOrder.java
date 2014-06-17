package view2;

import javax.swing.*;

import com.model.orderModel;
import com.tools.myfont;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

public class addOrder extends JDialog implements ActionListener{
	JPanel p1,p2,p3;
	JLabel jl1,jl2,jl3,jl4;
	JTextField jtf1,jtf2,jtf3,jtf4;
	JButton jb1,jb2;
	public addOrder(){
		super();
		p1=new JPanel(new GridLayout(4,1));
		jl1=new JLabel("deskid");
		jl2=new JLabel("customname");
		jl3=new JLabel("tel");
		jl4=new JLabel("number");
	
		p1.add(jl1);
		p1.add(jl2);
		p1.add(jl3);
		p1.add(jl4);
	
		p2=new JPanel(new GridLayout(4,1));
		jtf1=new JTextField();
		jtf2=new JTextField();
		jtf3=new JTextField();
		jtf4=new JTextField();
		
		p2.add(jtf1);
		p2.add(jtf2);
		p2.add(jtf3);
		p2.add(jtf4);
		
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
		

		this.setSize(400,250);

		this.setTitle("预订座位");
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1){
			orderModel order=new orderModel();
			String status=order.getStatusById(jtf1.getText().trim());
			if(status.equals("0")){
				JOptionPane.showMessageDialog(null, "添加失败，该餐桌正在就餐！");
			}else if(status.equals("1")){
				JOptionPane.showMessageDialog(null, "添加失败，该餐桌已被预订！");
			}else if(status.equals("2")){
				String sql="insert into orderdesk values(?,?,?,?,?)";
				String []params={jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),Calendar.getInstance().getTime().toLocaleString()};
				orderModel em=new orderModel();
				em.executeUpdate(sql, params);
				String params2[]={jtf1.getText()};
				String sql2="update status set deskstatus=1 where deskid=?";
				em.executeUpdate(sql2, params2);
				JOptionPane.showMessageDialog(null, "恭喜！添加成功！");
			}
			this.dispose();
		}else if(e.getSource()==jb2){
			this.dispose();
		}
	}
}
