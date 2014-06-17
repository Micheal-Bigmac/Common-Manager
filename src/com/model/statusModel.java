package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.sqlHander;

public class statusModel {
	sqlHander hander=null;
	ResultSet rs=null;
	public String getStatusById(String deskid){
		String deskstatus=null;
		hander=new sqlHander();
		String arg[]={deskid};
		String sql="select * from status where deskid=?";
		rs=hander.query(sql, arg);
		try {
			if(rs.next()){
				deskstatus=rs.getString("deskstatus");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			hander.close();
		}
		return deskstatus;
	}
	public boolean executeUpdate(String sql,String arg[]){
		sqlHander handler=new sqlHander();
		boolean b=handler.executeUpdate(sql, arg);
		return b;
	}
}
