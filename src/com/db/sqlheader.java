package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlheader {
	public static String Driver="com.mysql.jdbc.Driver";
	public static String url="jdbc:mysql://localhost:3306/student";
	public static String user="root";
	public static String password="mysql";
	
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	public sqlheader(){
		try {
			Class.forName(Driver);
			ct=DriverManager.getConnection(url, user, password);
			if(!ct.isClosed()){
				System.out.println("open database success");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean update(String sql,String arg[]){
		boolean b=true;
		try {
			ps=ct.prepareStatement(sql);
			
			for(int i=0;i<arg.length;i++){
				ps.setString(i+1, arg[i]);
			}
			if(ps.executeUpdate()!=1){
				b=false;
			}
			
		} catch (SQLException e) {
			b=false;
			e.printStackTrace();
		}
		return b;
	}
	public ResultSet query(String sql,String arg[]){
		try {
			ps=ct.prepareStatement(sql);
			for(int i=0;i<arg.length;i++){
				ps.setString(i+1, arg[i]);
			}
			rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public ResultSet query(String sql){
		try {
			System.out.println("68");
			ps=ct.prepareStatement(sql);
			System.out.println("70");
			rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	void close(){
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
