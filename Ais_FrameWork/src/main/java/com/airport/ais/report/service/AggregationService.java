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
 * @Description  TODO �ۺϱ��ʽ�������ĳ������ 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��10��8��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��10��8��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public abstract class AggregationService implements IAggregationService {
	
	/**
	 *    ���ַ����Ŀ�ʼλ��
	 */
	private static int YearStartPos =0;
	
	/**
	 *    ���ַ����Ľ���λ��
	 */
	private static int Yearlen=4;

	/**
	 * 
	 * @Description: TODO ���ػ��ܵ�Where����
	 * @return
	 */
	protected abstract Object[] getPredicate(Date startDate,Date endDate);
	
	
	@Override
	public QueryCondition interpreter(List<ReportField> fields, Date startDate, Date endDate, int diffYear,
			Object[] expresstion, String order) {
		QueryCondition conditions = new QueryCondition();

		/**
		 * ����
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
			 * ���diffYear�����㣬˵����Ҫ�Ƚ����ݣ���ӱ��ʽ
			 * ����diffYear=1 startDate=2016-01-01 endDate=2016-01-21
			 * ���һ���������ʽ execDate >2015-01-01 and endDate <=2015-01-21
			 */
			Date startDiffDate = DateTimeUtil.getDiffYearDate(startDate, diffYear);
			Date endDiffDate = DateTimeUtil.getDiffYearDate(endDate, diffYear);
			comparePredicate = getPredicate(startDiffDate,endDiffDate);
		}

		
		for(ReportField field:fields){
			if (field.getClass().equals(GroupField.class)){
				/**
				 * �����Group�����conditions.getGroupFields()��
				 */
				conditions.getGroupFields().add((GroupField) field);
			}else if (field.getClass().equals(AggregationColumnField.class)){
				/**
				 * ����ۺ��У���ӽ�conditions.getAggregationFields()�У�������������ʽSelect Case
				 * ���������������������ֶβ��ǱȽ��ֶΣ�����Ϊ
				 *  execDate >2016-01-01 and endDate <=2016-01-21
				 *  ����ǣ�����Ϊ
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
				 * ������ۼ��ֶΣ������ֶ�����Year������
				 * �������������������ǱȽ��ֶ�
				 * Year����Ϊ2015 ����Ϊ2016
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
				 * ����Ǽƻ��ܴμ����ֶΣ����뿪ʼ�ͽ�����ʱ��
				 */
				PlanCountColumnField plnCountColumnField = (PlanCountColumnField) field;
				plnCountColumnField.setRowField(conditions.getGroupFields().get(0));
				plnCountColumnField.setStartDate(startDate);
				plnCountColumnField.setEndDate(endDate);
			}
			
		}		
		
		if (diffYear >0) {
			/**
			 * ���������Ҫ�ȶԣ���ԭ��ʱ���������ʽ�ͱȽ��������ʽ����ԭ�������ʽ��
			 * �������
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
			 * ���û�жԱ� ��ʱ����ʽ����ԭ���ʽ
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
