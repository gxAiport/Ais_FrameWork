package com.airport.ais.report.generater;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.airport.ais.dao.parameter.ColumnField;
import com.airport.ais.dao.parameter.GroupField;
import com.airport.ais.dao.parameter.QueryCondition;
import com.airport.ais.dao.parameter.ReportField;
import com.airport.ais.enums.ChartType;
import com.airport.ais.report.Report;
import com.airport.ais.report.generater.column.IColumnGenerater;
import com.airport.ais.report.generater.column.IColumnGeneraterFactory;
import com.airport.ais.report.service.IAggregationService;
import com.airport.ais.service.IService;


/**
 * 
 * 
 * FileName      ReportGenerater.java
 * @Description  TODO  报表处理的类，用于产生报表的各种结果
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年10月8日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月8日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */


public class ReportGenerater<K,E> {
	
	public final  String RECORDS ="records";
	
	public final  String TOTALCOUNT ="totalCount";
	
	public final  String SUMMARY = "summary";
	
	public final  String MERGE   = "merge";
	
	/**
	 * 需要处理的报表
	 */
	private Report report;
	
	/**
	 *  聚合查询的结果
	 */
	private  List<Map<String, Object>> aggregationResult;
	
	/**
	 *   Group的字段列表
	 */
	private List<GroupField> gFields;
	
	/**
	 *  组生成器
	 */
	private GroupGenerater groupGenerater;
	
	/**
	 *  列的生产工厂
	 */
	private IColumnGeneraterFactory factory;
	
	/**
	 *   数据的Service
	 */
	private IService<K,E> service;
	
	/**
	 *   生成聚合表达式的Service
	 */
	private IAggregationService aggregationService;
	
	/**
	 *  汇总生成器
	 */
	private SummaryGenerater summaryGenerater;



	/**
	 * 
	 * @Description: 获取有可能的行分组的所有可能值
	 * @return 获取有可能的行分组的所有可能值
	 */
	public Map<String, List<Object>> getLabels(List<Map<String, Object>> rList,String gKey,String vKey,ChartType chartType){
		groupGenerater.setInitVars(aggregationResult, gFields,report.getColNum());
		Map<String, List<Object>> groupValues = groupGenerater.getAvailableGroupValues();
		if (rList != null && !chartType.equals(ChartType.Lines)){
			groupValues.get(gKey).add(MERGE);
			List<Object> dList = new ArrayList<Object>();
			for (Object group:groupValues.get(gKey)){
				String key = vKey+"."+group;
				boolean found =false;
				for(int i=0;i<rList.size();i++){
					 if (rList.get(i).keySet().contains(key)){
						 found = true;
						 break;
					 }
				}
				if (!found){
					dList.add(group);
				}
			}
			groupValues.get(gKey).removeAll(dList);
		}
		return groupValues;
	}
	
	
	
	
	/**
	 * 
	 * @Description: TODO 创建聚合List集合结果
	 * @param report  需要生成的报表
	 * @param startDate 开始时间
	 * @param endDate   结束时间
	 * @return   聚合List集合的结果
	 * @throws Exception
	 */
	
	public  List<Map<String, Object>> CreateAggregationList(Report report,Date startDate,Date endDate,Class<E> clazz) throws Exception{
		/*报表字段赋值*/
		this.report = report;
		/*生成聚合查询所需的条件*/
		QueryCondition condition = aggregationService.interpreter(report.getFields(),
				startDate, endDate, report.getDiffYear(), report.getCondistion(),report.getOrder());
		/*组字段*/
		this.gFields = condition.getGroupFields();
		/*赋值各相关数据*/
		return service.findAggregationByCondition(condition,clazz);
	}
	

	/**
	 * 
	 * @Description: TODO 生成报表数据List集合，以Map<Key,Object>存放方式
	 * @param report 需要生成报表
	 * @param startDate 开始时间
	 * @param endDate   结束时间
	 * @return 报表数据List集合
	 * @throws Exception
	 */
	public  List<Map<String,Object>> createListReport(Report report,Date startDate,Date endDate,Class<E> clazz) throws Exception{
		this.aggregationResult = CreateAggregationList(report,startDate,endDate,clazz);
		if (gFields.size() >0){
			/*建立报表的List，确立行，所有有可能的Group的值 */
			groupGenerater.setInitVars(aggregationResult, gFields,report.getColNum());
			Map<String, List<Object>> groupValues =groupGenerater.getAvailableGroupValues();
			List<Map<String,Object>> rList =groupGenerater.getReportList();

			/*根据对应的Column产生对应的处理 */
			for (ReportField field:report.getFields()){
				if (field instanceof ColumnField) {
					IColumnGenerater columnGenerater = factory.getcolumnGenerater(field, aggregationResult, groupValues, rList, gFields);
					columnGenerater.writeReportList(field);
				}
			}
			return rList;
		}else{
			throw new Exception("Group字段不足，无法产生报表，因为无法产生行");
		}
		
	}
	
	
	/**
	 * 
	 * @Description: TODO 根据条件生成报表，包括数据记录的List、记录数、合计
	 * @param startDate 开始时间 
	 * @param endDate   结束时间
	 * @param start     开始记录数
	 * @param limit     记录数量
	 * @param isPaging  是否分页
	 * @return  Map
	 * records 记录的List
	 * totalCount 总记录数
	 * summary 汇总小结
	 * @throws Exception
	 */
	public Map<String, Object> createMapReport(Report report,Date startDate,Date endDate,
			Integer start,Integer limit,boolean isPaging,Class<E> clazz) throws Exception{
		

		List<Map<String, Object>> reportList   =  createListReport(report,startDate,endDate,clazz);
		/*需返回的数据记录集合*/
		List<Map<String, Object>> reportResult =  new ArrayList<Map<String,Object>>();
		/*需返回的汇总记录集合*/
		Map<String, Object> reportSummary = summaryGenerater.calcSummary(reportList,report.getSummaryFields());
		if(isPaging){
			/*如果是分页，根据Start,limit返回分页数据 */
			for(int i=start;i<reportList.size()&&i<limit+start;i++){
				reportResult.add(reportList.get(i));
			}
		}else{
			reportResult = reportList;
		}
		/*返回数据集合*/
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(RECORDS, reportResult);
		result.put(TOTALCOUNT,reportList.size());
		result.put(SUMMARY, reportSummary);
		return result;
	}

	/**
	 * @param groupGenerater the groupGenerater to set
	 */
	public void setGroupGenerater(GroupGenerater groupGenerater) {
		this.groupGenerater = groupGenerater;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(IService<K, E> service) {
		this.service = service;
	}

	/**
	 * @param aggregationService the aggregationService to set
	 */
	public void setAggregationService(IAggregationService aggregationService) {
		this.aggregationService = aggregationService;
	}

	/**
	 * @param summaryGenerater the summaryGenerater to set
	 */
	public void setSummaryGenerater(SummaryGenerater summaryGenerater) {
		this.summaryGenerater = summaryGenerater;
	}

	/**
	 * @param factory the factory to set
	 */
	public void setFactory(IColumnGeneraterFactory factory) {
		this.factory = factory;
	}

	







	
	
	

}
