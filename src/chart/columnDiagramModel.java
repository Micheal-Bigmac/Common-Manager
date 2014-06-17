package chart;

import java.sql.ResultSet;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.db.sqlHander;


public class columnDiagramModel {
	//�����ResultSet
	ResultSet resultSet = null;
	//
	sqlHander sqlHelper = null;
	
	public CategoryDataset getDataSet(String sql,String[] paras,int type){
        //�������ݼ�
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        //��ʼ��sqlhelper
		sqlHelper = new sqlHander();
		
		//���ؽ����
		resultSet=sqlHelper.query(sql, paras);
		System.out.println(sql);
	
        //��������
		try {
//			System.out.println();
			while(resultSet.next()){
				
				double income=resultSet.getDouble("totally");
				String month = resultSet.getString("date");
				if(type==0){
					String	foodname=resultSet.getString("foodname");//foodid->foodname
//					System.out.println(income+" "+foodname+" "+month);
					dataset.addValue(income,foodname, month);
				}else if(type==1){
					dataset.addValue(income,month , month);
				}
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
