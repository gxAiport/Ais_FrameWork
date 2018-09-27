/**
 * 
 */
package com.airport.ais.report.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.airport.ais.dao.parameter.AggregationColumnField;
import com.airport.ais.dao.parameter.CumulativeColumnField;
import com.airport.ais.dao.parameter.GroupField;
import com.airport.ais.dao.parameter.PlanCountColumnField;
import com.airport.ais.dao.parameter.QueryCondition;
import com.airport.ais.dao.parameter.QueryOrder;
import com.airport.ais.dao.parameter.ReportField;
import com.airport.ais.enums.QuerySortMode;
import com.airport.ais.utils.DateTimeUtil;



/**
 * 
 * FileName      AggregationService.java
 * @Description  TODO 聚合表达式解析器的抽象基类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年10月8日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月8日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

public abstract class AggregationService implements IAggregationService {
	
	/**
	 *    年字符串的开始位置
	 */
	private static int YearStartPos =0;
	
	/**
	 *    年字符串的结束位置
	 */
	private static int Yearlen=4;

	/**
	 * 
	 * @Description: TODO 返回汇总的Where条件
	 * @return
	 */
	protected abstract Object[] getPredicate(Date startDate,Date endDate);
	
	
	@Override
	public QueryCondition interpreter(List<ReportField> fields, Date startDate, Date endDate, int diffYear,
			Object[] expresstion, String order) {
		QueryCondition conditions = new QueryCondition();

		/**
		 * 排序
		 */
		if (order != null){
			QueryOrder aisOrder = new QueryOrder();
			aisOrder.setName(order);
			aisOrder.setQuerySortMode(QuerySortMode.ASC);
			conditions.setOrders(new QueryOrder[]{aisOrder});
		}
		
		Object[] comparePredicate = null ;
		Object[] predicate = getPredicate(startDate,endDate);
		conditions.setGroupFields(new ArrayList<GroupField>());
		conditions.setAggregationFields(new ArrayList<AggregationColumnField>());
		
		if (diffYear > 0){
			/**
			 * 如果diffYear大于零，说明需要比较数据，添加表达式
			 * 例如diffYear=1 startDate=2016-01-01 endDate=2016-01-21
			 * 添加一个条件表达式 execDate >2015-01-01 and endDate <=2015-01-21
			 */
			Date startDiffDate = DateTimeUtil.getDiffYearDate(startDate, diffYear);
			Date endDiffDate = DateTimeUtil.getDiffYearDate(endDate, diffYear);
			comparePredicate = getPredicate(startDiffDate,endDiffDate);
		}

		
		for(ReportField field:fields){
			if (field.getClass().equals(GroupField.class)){
				/**
				 * 如果是Group，添加conditions.getGroupFields()中
				 */
				conditions.getGroupFields().add((GroupField) field);
			}else if (field.getClass().equals(AggregationColumnField.class)){
				/**
				 * 如果聚合列，添加进conditions.getAggregationFields()中，并添加条件表达式Select Case
				 * 分以下两种情况，如果此字段不是比较字段，条件为
				 *  execDate >2016-01-01 and endDate <=2016-01-21
				 *  如果是，条件为
				 *   execDate >2015-01-01 and endDate <=2015-01-21
				 * 
				 */
				AggregationColumnField aggregationColumnField = (AggregationColumnField) field;
				if (aggregationColumnField.getCompare()) {
					aggregationColumnField.setWhenCondition(comparePredicate);
				}else{
					aggregationColumnField.setWhenCondition(predicate);
				}
				conditions.getAggregationFields().add(aggregationColumnField);
			}else if (field.getClass().equals(CumulativeColumnField.class)){
				/**
				 * 如果是累计字段，计算字段属性Year并存入
				 * 分以下两种情况，如果是比较字段
				 * Year属性为2015 否则为2016
				 * 
				 */
				CumulativeColumnField cumulativeColumnField = (CumulativeColumnField) field;
				Date date = startDate;
				if (cumulativeColumnField.getCompare()){
					date = DateTimeUtil.getDiffYearDate(startDate, diffYear);
				}
				String dateStr = DateTimeUtil.dateToYYYYMMDD(date);
				cumulativeColumnField.setYear(dateStr.substring(YearStartPos, Yearlen));
			}else if (field.getClass().equals(PlanCountColumnField.class)){
				/**
				 * 如果是计划架次计算字段，存入开始和结束的时间
				 */
				PlanCountColumnField plnCountColumnField = (PlanCountColumnField) field;
				plnCountColumnField.setRowField(conditions.getGroupFields().get(0));
				plnCountColumnField.setStartDate(startDate);
				plnCountColumnField.setEndDate(endDate);
			}
			
		}		
		
		if (diffYear >0) {
			/**
			 * 如果数据需要比对，将原先时间条件表达式和比较条件表达式加入原条件表达式中
			 * 结合上面
			 * expresstion+And (execDate >2016-01-01 and endDate <=2016-01-21 or execDate >2015-01-01 and endDate <=2015-01-21
			 * 
			 */
			if (expresstion != null && expresstion.length >0){
				predicate = ArrayUtils.addAll(new Object[]{"AND","("}, predicate);
				comparePredicate = ArrayUtils.addAll(new Object[]{"OR"}, comparePredicate);
				expresstion = ArrayUtils.addAll(expresstion, predicate);
				expresstion = ArrayUtils.addAll(expresstion, comparePredicate);
				expresstion = ArrayUtils.addAll(expresstion, ")");
			}else{
				expresstion = ArrayUtils.addAll(predicate,"OR");
				expresstion = ArrayUtils.addAll(expresstion, comparePredicate);
			}
			
		}else {
			/**
			 * 如果没有对比 将时间表达式加入原表达式
			 * expresstion+And execDate >2016-01-01 and endDate <=2016-01-21
			 * 
			 */
			if (expresstion != null && expresstion.length >0){
				expresstion = ArrayUtils.addAll(expresstion,"AND");
				expresstion = ArrayUtils.addAll(expresstion,predicate);
				
			}else{
				expresstion = predicate;
			}
		}
		
		
		conditions.setExpression(expresstion);
		return conditions;
	}

}
