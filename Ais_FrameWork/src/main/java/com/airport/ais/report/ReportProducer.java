package com.airport.ais.report;

import java.util.ArrayList;
import java.util.List;

import com.airport.ais.dao.parameter.AggregationColumnField;
import com.airport.ais.dao.parameter.SummaryField;
import com.airport.ais.dao.parameter.GroupField;
import com.airport.ais.dao.parameter.ReportField;
import com.airport.ais.report.parameter.LimitCondistion;
import com.airport.ais.report.service.IChartService;

/**
 * FileName      ReportProducer.java
 * @Description  生成报表的类，用于生成报表
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2016年4月10日 
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2016年4月10日      Yu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */


public class ReportProducer {
	

	private AggregationColumnField[] columnFields;
	

	private SummaryField[] displayFields;
	

	private GroupField[] groupFields;
	

	private IChartService chartUtils;
	
	
	/**
	 * 
	 * @Description: TODO根据参数返回一个定义的报表
	 * @param statisticsType 统计项目类型
	 * @param groups 分组字段数组
	 * @param strCondistion 限定条件
	 * @return 一个定义好的报表
	 */
	public Report getReport(String statisticsType,String[] groups,List<LimitCondistion> limitCondistions,boolean compare){
		Report report = new Report();
		List<ReportField> reportFields = new ArrayList<ReportField>();
		List<SummaryField> summaryFields = new ArrayList<SummaryField>();
		/**
		 * 设置分组字段
		 */
		for (String group:groups){
			for(GroupField groupField:groupFields){
				if (group != null){
					
				}
				if (groupField.getAlias().equals(group)){
					reportFields.add(groupField);
				}
				
			}
		}
		
		/**
		 * 设置聚合字段
		 */
		for(AggregationColumnField columnField:columnFields){
			if (columnField.getAlias().equals(statisticsType)){
				reportFields.add(columnField);
					
			}
			if (compare){
				if(columnField.getAlias().equals(statisticsType+"COMPARE")){
					reportFields.add(columnField);
				}
			}
		}
		
		for(SummaryField displayField:displayFields){
			if (displayField.getDataIndex().equals(statisticsType)){
				summaryFields.add(displayField);
			}
		}
		
		
		
		
		if (compare){
			report.setDiffYear(1);
		}
		report.setFields(reportFields);
		report.setSummaryFields(summaryFields.toArray(new SummaryField[summaryFields.size()]));
		
		Object[] limitCondistion = chartUtils.convert(limitCondistions);
		report.setCondistion(limitCondistion);
		
		
		return report;
		
	}
	
}
