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
 * @Description  TODO  ��������࣬���ڲ�������ĸ��ֽ��
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��10��8��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��10��8��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */


public class ReportGenerater<K,E> {
	
	public final  String RECORDS ="records";
	
	public final  String TOTALCOUNT ="totalCount";
	
	public final  String SUMMARY = "summary";
	
	public final  String MERGE   = "merge";
	
	/**
	 * ��Ҫ����ı���
	 */
	private Report report;
	
	/**
	 *  �ۺϲ�ѯ�Ľ��
	 */
	private  List<Map<String, Object>> aggregationResult;
	
	/**
	 *   Group���ֶ��б�
	 */
	private List<GroupField> gFields;
	
	/**
	 *  ��������
	 */
	private GroupGenerater groupGenerater;
	
	/**
	 *  �е���������
	 */
	private IColumnGeneraterFactory factory;
	
	/**
	 *   ���ݵ�Service
	 */
	private IService<K,E> service;
	
	/**
	 *   ���ɾۺϱ��ʽ��Service
	 */
	private IAggregationService aggregationService;
	
	/**
	 *  ����������
	 */
	private SummaryGenerater summaryGenerater;



	/**
	 * 
	 * @Description: ��ȡ�п��ܵ��з�������п���ֵ
	 * @return ��ȡ�п��ܵ��з�������п���ֵ
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
	 * @Description: TODO �����ۺ�List���Ͻ��
	 * @param report  ��Ҫ���ɵı���
	 * @param startDate ��ʼʱ��
	 * @param endDate   ����ʱ��
	 * @return   �ۺ�List���ϵĽ��
	 * @throws Exception
	 */
	
	public  List<Map<String, Object>> CreateAggregationList(Report report,Date startDate,Date endDate,Class<E> clazz) throws Exception{
		/*�����ֶθ�ֵ*/
		this.report = report;
		/*���ɾۺϲ�ѯ���������*/
		QueryCondition condition = aggregationService.interpreter(report.getFields(),
				startDate, endDate, report.getDiffYear(), report.getCondistion(),report.getOrder());
		/*���ֶ�*/
		this.gFields = condition.getGroupFields();
		/*��ֵ���������*/
		return service.findAggregationByCondition(condition,clazz);
	}
	

	/**
	 * 
	 * @Description: TODO ���ɱ�������List���ϣ���Map<Key,Object>��ŷ�ʽ
	 * @param report ��Ҫ���ɱ���
	 * @param startDate ��ʼʱ��
	 * @param endDate   ����ʱ��
	 * @return ��������List����
	 * @throws Exception
	 */
	public  List<Map<String,Object>> createListReport(Report report,Date startDate,Date endDate,Class<E> clazz) throws Exception{
		this.aggregationResult = CreateAggregationList(report,startDate,endDate,clazz);
		if (gFields.size() >0){
			/*���������List��ȷ���У������п��ܵ�Group��ֵ */
			groupGenerater.setInitVars(aggregationResult, gFields,report.getColNum());
			Map<String, List<Object>> groupValues =groupGenerater.getAvailableGroupValues();
			List<Map<String,Object>> rList =groupGenerater.getReportList();

			/*���ݶ�Ӧ��Column������Ӧ�Ĵ��� */
			for (ReportField field:report.getFields()){
				if (field instanceof ColumnField) {
					IColumnGenerater columnGenerater = factory.getcolumnGenerater(field, aggregationResult, groupValues, rList, gFields);
					columnGenerater.writeReportList(field);
				}
			}
			return rList;
		}else{
			throw new Exception("Group�ֶβ��㣬�޷�����������Ϊ�޷�������");
		}
		
	}
	
	
	/**
	 * 
	 * @Description: TODO �����������ɱ����������ݼ�¼��List����¼�����ϼ�
	 * @param startDate ��ʼʱ�� 
	 * @param endDate   ����ʱ��
	 * @param start     ��ʼ��¼��
	 * @param limit     ��¼����
	 * @param isPaging  �Ƿ��ҳ
	 * @return  Map
	 * records ��¼��List
	 * totalCount �ܼ�¼��
	 * summary ����С��
	 * @throws Exception
	 */
	public Map<String, Object> createMapReport(Report report,Date startDate,Date endDate,
			Integer start,Integer limit,boolean isPaging,Class<E> clazz) throws Exception{
		

		List<Map<String, Object>> reportList   =  createListReport(report,startDate,endDate,clazz);
		/*�践�ص����ݼ�¼����*/
		List<Map<String, Object>> reportResult =  new ArrayList<Map<String,Object>>();
		/*�践�صĻ��ܼ�¼����*/
		Map<String, Object> reportSummary = summaryGenerater.calcSummary(reportList,report.getSummaryFields());
		if(isPaging){
			/*����Ƿ�ҳ������Start,limit���ط�ҳ���� */
			for(int i=start;i<reportList.size()&&i<limit+start;i++){
				reportResult.add(reportList.get(i));
			}
		}else{
			reportResult = reportList;
		}
		/*�������ݼ���*/
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
