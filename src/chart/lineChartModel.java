package chart;

import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;

import com.db.sqlHander;
import com.tools.FoodName;

public class lineChartModel {
	//结果集ResultSet
	ResultSet resultSet = null;
	//
	sqlHander sqlHelper = null;
	FoodName food=null;
	
	public XYDataset getDataSet(String sql,String[] paras,int type){
        //设置数据集
		TimeSeries timeseries = new TimeSeries("");
		TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        //初始化sqlhelper
		Map<String, TimeSeries> a=new HashMap<String,TimeSeries>();
		sqlHelper = new sqlHander();
		//返回结果集
		resultSet=sqlHelper.query(sql, paras);
		if(type==0){
			food=new FoodName("select distinct foodname from month_kind_sales where year(date)=? and month(date)=?", paras);
			for(int i=0;i<food.foodname.size();i++){
				TimeSeries temp=new TimeSeries(food.foodname.get(i).toString());
				a.put((String) food.foodname.get(i), temp);
			}
		}
        //设置数据
		try {
			while(resultSet.next()){
				int year=0;
				double income=resultSet.getDouble("totally");
				if(type==2){
					 year = resultSet.getInt("year");
					 timeseries.add(new Year(year), income);
				}else if(type==1){
					Date date=resultSet.getDate("date");
					timeseries.add(new Day(date), income);
				}else if(type==0){
					System.out.println(food.foodname.size());
			
					Date date=resultSet.getDate("date");
					String foodid=resultSet.getString("foodname");
						for(int i=0;i<food.foodname.size();i++){
							if(a.containsKey(foodid)){
								TimeSeries b=a.get(foodid);
								b.addOrUpdate(new Day(date), income);
							}
						}
				}
			}
			if(type==0){
				for(int i=0;i<a.size();i++){
					TimeSeries temp=a.get(food.foodname.get(i));
					timeseriescollection.addSeries(temp);
				}
			}else {
				timeseriescollection.addSeries(timeseries);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlHelper.close();
		}
		//返回数据集
        return timeseriescollection;
		
	}
}
