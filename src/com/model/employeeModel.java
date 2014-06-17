package com.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.db.sqlHander;

public class employeeModel extends AbstractTableModel{

	ResultSet rs=null;
	Vector row,column;
	
	public employeeModel(){
		String sql="select * from empMana";
		this.query(sql, null);
	}
	public boolean executeUpdate(String sql,String arg[]){
		sqlHander handler=new sqlHander();
		boolean b=handler.executeUpdate(sql, arg);
		return b;
	}
	public void query(String sql,String arg[]){
		sqlHander handler=new sqlHander();
		row=new Vector();
		column=new Vector();
		
		rs=handler.query(sql, arg);
		ResultSetMetaData rsmd=null;
		try {
			rsmd=rs.getMetaData();
			for(int i=0;i<rsmd.getColumnCount();i++){
				column.add(rsmd.getColumnName(i+1));
			}
			while(rs.next()){
				Vector tem=new Vector();
				for(int i=0;i<rsmd.getColumnCount();i++){
					tem.add(rs.getString(i+1));
				}
				row.add(tem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			handler.close();
		}
	}
	
	@Override
	public int getRowCount() {
		return row.size();
	}

	@Override
	public int getColumnCount() {
		return column.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ((Vector)row.get(rowIndex)).get(columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return this.column.get(column).toString(); 
	}

}
