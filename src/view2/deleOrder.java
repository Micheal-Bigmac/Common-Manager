package view2;
import java.awt.*;
import javax.swing.*;

import com.model.orderModel;
import com.tools.myfont;

import java.awt.event.*;
public class deleOrder extends JDialog implements ActionListener{
	JPanel p1,p2,p3;
	JLabel jl1;
	JTextField jtf1;
	JButton jb1,jb2;
	
	public deleOrder()
	{
		super();
		p1=new JPanel(new GridLayout(1,1));
		
		jl1=new JLabel("deskid");
		p1.add(jl1);
		
		p2=new JPanel(new GridLayout(1,1));
		jtf1=new JTextField();
		
		
		p2.add(jtf1);
	
		
		p3=new JPanel(new FlowLayout(FlowLayout.CENTER));
		jb1=new JButton("ȷ��");
		jb1.setFont(myfont.f4);
		jb1.addActionListener(this);
		jb2=new JButton("ȡ��");
		jb2.setFont(myfont.f4);
		jb2.addActionListener(this);
		p3.add(jb1);
		p3.add(jb2);
		this.setLayout(new BorderLayout());
		this.add(p1,"West");
		this.add(p2,"Center");
		this.add(p3,"South");
		

		this.setSize(200,100);

		this.setTitle("�˶���λ");
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		if(arg0.getSource()==jb1)
		{
			
			orderModel om=new orderModel();
			
			String status=om.getStatusById(jtf1.getText().trim());
//			System.out.print(status);
			if(status.equals("0"))
			{
				JOptionPane.showMessageDialog(null, "�Բ��𣬸ò������ھͲͣ�");
			}
			else if(status.equals("1"))
			{
				String sql="delete from orderdesk where deskid=? ";
				String []params={jtf1.getText()};
				orderModel em=new orderModel();
				em.executeUpdate(sql, params);
				String sql2="update status set deskstatus=2 where deskid=?";
				em.executeUpdate(sql2, params);
				JOptionPane.showMessageDialog(null, "��ϲ���˶��ɹ���");
			}
			else if(status.equals("2"))
			{
				JOptionPane.showMessageDialog(null , "�Բ��𣬸ò�����δԤ����");
			}
			
			this.dispose();
		}
		else if(arg0.getSource()==jb2)
		{
			this.dispose();
		}
	}
	
}
