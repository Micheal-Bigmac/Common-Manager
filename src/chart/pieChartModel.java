package chart;

import java.sql.ResultSet;

import org.jfree.data.general.DefaultPieDataset;

import com.db.sqlHander;


public class pieChartModel {
	//结果集ResultSet
	ResultSet resultSet = null;
	//
	sqlHander sqlHelper = null;
	
	public DefaultPieDataset getDataSet(String sql,String[] paras,int type){
        //设置数据集
		DefaultPieDataset dataset = new DefaultPieDataset();
        //初始化sqlhelper
		sqlHelper = new sqlHander();
		//返回结果集
		resultSet=sqlHelper.query(sql, paras);
        //设置数据
		try {
			while(resultSet.next()){
				double income=resultSet.getDouble("totally");
				String month = resultSet.getString("date");
				dataset.setValue(month, income);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlHelper.close();
		}
		//返回数据集
        return dataset;
		
	}
}
