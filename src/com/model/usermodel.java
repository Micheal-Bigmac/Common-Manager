package com.model;
import java.sql.*;

import com.db.sqlHander;
public class usermodel {
	ResultSet rs=null;
	sqlHander hander=new sqlHander();
	public String check(String id,String password){
		String zhiwei="";
		String arg[]={id,password};
		String sql="select zhiwei from login,rszl where login.empid=rszl.empid and login.empid=? and login.passwd=?";
		rs=hander.query(sql, arg);
		try {
			if(rs.next()) {
				zhiwei=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			hander.close();
		}
		return zhiwei;
	}
}
