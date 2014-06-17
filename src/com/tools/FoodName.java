package com.tools;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.sqlHander;

public class FoodName {
	sqlHander hander=null;
	public List<String> foodname=null;
	ResultSet rs=null;
	public FoodName(String sql,String arg[]){
		foodname=new ArrayList<String>();
		hander=new sqlHander();
		rs=hander.query(sql, arg);
		try {
			while(rs.next()){
				foodname.add(rs.getString("foodname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			hander.close();
		}
	}
}
