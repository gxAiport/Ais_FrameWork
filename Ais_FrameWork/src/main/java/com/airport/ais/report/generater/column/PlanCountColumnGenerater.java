/**
 * 
 */
package com.airport.ais.report.generater.column;

import java.util.List;
import java.util.Map;

import com.airport.ais.dao.parameter.GroupField;
import com.airport.ais.dao.parameter.PlanCountColumnField;
import com.airport.ais.dao.parameter.ReportField;
import com.airport.ais.report.service.IPlanCountService;




/**
 * 
 * 
 * FileName      PlanCountColumnGenerater.java
 * @Description  TODO �����ֶδ�������
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��10��8��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��10��8��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public class PlanCountColumnGenerater<K> implements IColumnGenerater {

	/**
	 *  �����List
	 */
	private List<Map<String,Object>> reportList;
	
	
	private IPlanCountService<K> planCountService;


	/**
	 * 
	 * @Description: �����࣬����Ҫ����ı�����ֵ����
	 * @param reportList�����List
	 */
	public void setInitVars(List<Map<String, Object>> reportList) {
		this.reportList = reportList;
		
	}

	@Override
	public void writeReportList(ReportField field) throws Exception {
		if (field instanceof PlanCountColumnField) {
			/**
			 * ����Ǽƻ��ܴ��ֶΣ���ֵ����ѯ�ı���
			 */
			PlanCountColumnField planCountColumnField = (PlanCountColumnField) field;
			GroupField  routeField = planCountColumnField.getRowField();
			String rowKey = routeField.getAlias();
			for (Map<String, Object> map:reportList){
				Object kind= map.get(rowKey);
				/**
				 * �����ֶεı��ʽ��ֵ��Ϊ��ѯ����������ROUTEHX ='SHA-LZH-SHA'
				 */
				map.put(planCountColumnField.getAlias(), planCountService.count(kind,planCountColumnField));
			}			
		}else{
			throw new Exception("��������ƻ��ܴ�ͳ���ֶδ��������ܴ������������ֶ�");
		}
		
		
		
	}

}
