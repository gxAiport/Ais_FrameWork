/**
 * 
 */
package com.airport.ais.report.generater.column;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.airport.ais.dao.parameter.CumulativeColumnField;
import com.airport.ais.dao.parameter.ReportField;
import com.airport.ais.enums.CumulativeType;
import com.airport.ais.report.service.ICumulativeService;
import com.airport.ais.utils.DateTimeUtil;



/**
 * FileName      CumulativeColumnGenerater.java
 * @Description  累计月，年字段处理器。要求聚合查询的行字段必须为GrpDate.day类型
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2016年2月24日 
 * @ModificationHistory
 * Date         Author     Version   Discription
 * <p>---------------------------------------------
 * <p>2016年2月24日      Yu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */




public class CumulativeColumnGenerater<K> implements IColumnGenerater {

	/**
	 *  报表的List
	 */
	private List<Map<String,Object>> reportList;
	
	/**
	 *  代表行字段的Aials
	 */
	private String rowKey;
	
	
	private ICumulativeService<K> cumulativeService;
	
	/**
	 * 
	 * @Description: 初始化类，将报表的结果，行字段对应的Ailas赋值给处理器
	 * @param reportList 报表的List
	 * @param rowKey 行所对应的字段的Ailas
	 */
	public void setInitVars(List<Map<String, Object>> reportList,String rowKey,ICumulativeService<K> cumulativeService) {
		this.cumulativeService = cumulativeService;
		this.reportList = reportList;
		this.rowKey = rowKey;
	}


	@Override
	public void writeReportList(ReportField field) throws Exception {
		
		if (field instanceof CumulativeColumnField) {
			/**
			 * 如果是累计字段
			 */
			CumulativeColumnField cumulativeColumnField = (CumulativeColumnField) field;
			String year = cumulativeColumnField.getYear();
			CumulativeType type = cumulativeColumnField.getCumulativeType();
			for(Map<String,Object> map:reportList){
				/**
				 * 取得日期，比如02-01
				 */
				String day = map.get(rowKey).toString();
				/**
				 * 生成需要累计的日期的数据一天
				 */
				Date date = DateTimeUtil.strToDate(year+"-"+day);
				if (CumulativeType.month.equals(type)){
					/**
					 * 如果是月累计，调用月累计方法
					 */
					map.put(field.getAlias(), cumulativeService.cumulativeMonth(date, cumulativeColumnField));
				}else if (CumulativeType.year.equals(type)){
					/**
					 * 如果是年累计，调用年累计方法
					 */
					map.put(field.getAlias(), cumulativeService.cumulativeYear(date, cumulativeColumnField));
				}
			}			
		}else{
			throw new Exception("处理出错，累计字段处理器不能处理其他的列字段");
		}
		
		
	}

}
