package com.db;
import java.sql.*;
import java.util.*;
public class sqlHander {
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String Driver="com.mysql.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/restaurant?autoReconnect=true&UseUnicode=true&characterEncoding=GBK";
	String user="root";
	String password="mysql";
	
	public sqlHander(){
		try {
			Class.forName(Driver);
			ct=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean call_procedure(String sql,String arg[]){
		boolean b=true;
		 CallableStatement cs=null;
		 try {
			cs=ct.prepareCall(sql);
			for(int i=0;i<arg.length;i++){
				cs.setString(i+1, arg[i]);
			}
			if(!cs.execute()){
				System.out.println("cs.execute");
					b=false;
			}
		} catch (SQLException e) {
			System.out.println("here exception");
			b=false;
			e.printStackTrace();
		}
		 return b;
	}
	public double call_procedure2(String sql,String arg[]){
		double  b=0;
		CallableStatement cs=null;
		 try {
			 System.out.println(arg.length);
			 System.out.println(arg[0]);
			cs=ct.prepareCall(sql);
			for(int i=0;i<arg.length;i++){
				cs.setString(i+1, arg[i]);
			}
			cs.registerOutParameter(arg.length+1, Types.DOUBLE);
			cs.execute();
			b=cs.getDouble(arg.length+1);
//			System.out.println(b);
		} catch (SQLException e) {
			System.out.println("here exception");
			e.printStackTrace();
		}
		 return b;
	}
	public ResultSet query(String sql,String arg[]){
		try {
			ps=ct.prepareStatement(sql);
//			System.out.println(sql);
			if(arg!=null){
				for(int i=0;i<arg.length;i++){
					ps.setString(i+1, arg[i]);
				}
			}
			rs=ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public boolean executeUpdate(String sql ,String arg[]){
		boolean b=true;
		try {
			ps=ct.prepareStatement(sql);
			for(int i=0;i<arg.length;i++){
				ps.setString(i+1,arg[i]);
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
	public void close(){
		
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(ct!=null) ct.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
