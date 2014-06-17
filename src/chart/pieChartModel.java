package chart;

import java.sql.ResultSet;

import org.jfree.data.general.DefaultPieDataset;

import com.db.sqlHander;


public class pieChartModel {
	//�����ResultSet
	ResultSet resultSet = null;
	//
	sqlHander sqlHelper = null;
	
	public DefaultPieDataset getDataSet(String sql,String[] paras,int type){
        //�������ݼ�
		DefaultPieDataset dataset = new DefaultPieDataset();
        //��ʼ��sqlhelper
		sqlHelper = new sqlHander();
		//���ؽ����
		resultSet=sqlHelper.query(sql, paras);
        //��������
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
		//�������ݼ�
        return dataset;
		
	}
}
