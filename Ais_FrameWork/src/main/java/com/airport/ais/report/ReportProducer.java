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
 * @Description  ���ɱ�����࣬�������ɱ���
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2016��4��10�� 
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2016��4��10��      Yu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */


public class ReportProducer {
	

	private AggregationColumnField[] columnFields;
	

	private SummaryField[] displayFields;
	

	private GroupField[] groupFields;
	

	private IChartService chartUtils;
	
	
	/**
	 * 
	 * @Description: TODO���ݲ�������һ������ı���
	 * @param statisticsType ͳ����Ŀ����
	 * @param groups �����ֶ�����
	 * @param strCondistion �޶�����
	 * @return һ������õı���
	 */
	public Report getReport(String statisticsType,String[] groups,List<LimitCondistion> limitCondistions,boolean compare){
		Report report = new Report();
		List<ReportField> reportFields = new ArrayList<ReportField>();
		List<SummaryField> summaryFields = new ArrayList<SummaryField>();
		/**
		 * ���÷����ֶ�
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
		 * ���þۺ��ֶ�
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
