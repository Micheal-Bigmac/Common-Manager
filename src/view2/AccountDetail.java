package view2;

import java.awt.*;

import javax.swing.*;
import javax.swing.JDialog;

import com.model.Model;
import com.model.orderModel;
import com.tools.myfont;

import java.awt.event.*;

//添加界面
public class AccountDetail extends JDialog implements ActionListener {

	JPanel p1, p2, p3;
	JLabel jl1, jl2;
	JTable table;
	JScrollPane jsp;
	JButton jb1, jb2;
	String deskid, bookid;
	Model em;

	public AccountDetail(Accounts a) {
		deskid = a.jtf1.getText().trim();
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jl1 = new JLabel("您的消费情况如下：");
		p1.add(jl1);
		p2 = new JPanel(new BorderLayout());

		String sql = "select * from view_accounts where deskid=? ";
		String arg[] = { deskid };
		em = new Model();
		em.query(sql, arg);
		table = new JTable(em);
		jsp = new JScrollPane(table);
		p2.add(jsp);
		p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jb1 = new JButton("结账");
		jb1.setFont(myfont.f4);
		jb1.addActionListener(this);
		jb2 = new JButton("取消");
		jb2.setFont(myfont.f4);
		jb2.addActionListener(this);
		p3.add(jb1);
		p3.add(jb2);
		this.setLayout(new BorderLayout());
		this.add(p1, "North");
		this.add(p2, "Center");
		this.add(p3, "South");

		this.setSize(600, 400);

		this.setTitle("结账");
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == jb1) {
//			String sql = "select * from view_money where deskid=?";
			double sum;
			String arg[] = {deskid};
			String sql="{call procedure_clear_deskid_status(?,?)}";
//			String sql="{ call procedure1(?,?) }";
			sum=em.callprocedure(sql, arg);
			if(sum==0)
			{
				JOptionPane.showMessageDialog(this, " 操作失败");
			}
			JOptionPane.showMessageDialog(this, "消费总金额为：" + sum + "元");
			this.dispose();
		} else if (arg0.getSource() == jb2) {
			this.dispose();
		}
	}

}
