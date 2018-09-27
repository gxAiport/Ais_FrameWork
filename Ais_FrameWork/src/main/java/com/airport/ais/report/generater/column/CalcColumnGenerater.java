/**
 * 
 */
package com.airport.ais.report.generater.column;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.airport.ais.dao.parameter.CalcColumnField;
import com.airport.ais.dao.parameter.GroupField;
import com.airport.ais.dao.parameter.ReportField;
import com.airport.ais.report.parameter.CalcExpression;



/**
 * FileName      CalcColumnGenerater.java
 * @Description  TODO  �������ֶεĴ�����
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��10��8��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��10��8��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Component
public class CalcColumnGenerater implements IColumnGenerater {
	
	/**
	 * ��������Group����ֵ��Map
	 */
	private  Map<String,List<Object>> groupMap;
	
	/**
	 *  ����List
	 */
	private List<Map<String,Object>> reportList;
	
	/**
	 * Group�ֶε��б�
	 */
	private List<GroupField> groupFields;
	
	/**
	 *  �����ֶ�
	 */
	private CalcColumnField calcField;
	
	/**
	 * ������ʽ����
	 */
	@Resource
	private CalcExpression calcExpression;
	
	public void setInitVars(Map<String, List<Object>> groupMap,List<Map<String, Object>> reportList, List<GroupField> groupFields) {
		this.groupMap = groupMap;
		this.reportList = reportList;
		this.groupFields = groupFields;
	}
	
	/**	
	 * @Description: ����Map�����ݼ���ֵ
	 * @param map �����б����
	 * @param key ��Ҫ�����Key ���� Pax
	 * @param suffix ��׺ ����.Dep.True
	 * @throws Exception 
	 */
	private void calcValue(Map<String, Object> map, String key, String suffix) throws Exception {
			Number value = calcExpression.calcExpression(calcField.getExpression(), suffix, map);
			/**
			 * �����ݷ���Map��
			 */
			map.put(key+suffix, value);
	}
	
	
	/**
	 * 
	 * @Description: �õѿ����˻��������ݽ��м���
	 * @param map  ����List����
	 * @param layer ����
	 * @param startlayer ��ʼ����
	 * @param key �ϳɵ�Key ����PAX
	 * @param suffix ��׺ ����.Dep.True
	 * @throws Exception
	 */
	private void descartesCalc(Map<String, Object> map,int layer,int startlayer ,String key,String suffix) throws Exception{
		if (layer < groupMap.size()-startlayer){
			/**
			 * �������1��,ȡ�ö�Ӧ��Group�е������п��ܵ����ݣ��ݹ����
			 */
			List<Object> keyList = groupMap.get(groupFields.get(layer).getAlias());
			for(Object obj:keyList){
				if (obj != null){
					descartesCalc(map, layer+1, startlayer,key,suffix+"."+obj);
				}
			}
		}else if (layer == groupMap.size()-startlayer){
			/**
			 * ��������һ�㣬ȡ�ö�Ӧ��Group�е������п��ܵ����ݣ��������ݼ���
			 */
			List<Object> keyList = groupMap.get(groupFields.get(layer).getAlias());
			for(Object obj:keyList){
				if (obj != null){
					calcValue(map, key,suffix+"."+obj);
				}
			}
		}else if (startlayer == groupMap.size()){
			/**
			 * �����ʼ���������һ�㣬ֱ�ӽ��м���
			 */
			calcValue(map, key,suffix);
		}
	}

	
	/**
	 *  �������
	 * ����       ������  �ܴ� ������.DEP �ܴ�.DEP ������.ARR �ܴ�.ARR  
	 * 02-01  500    10    250       5       250       5
	 * ����� 
	 * ����       ������  �ܴ� ������.DEP �ܴ�.DEP ������.ARR �ܴ�.ARR ƽ�������� ƽ��������.DEP ƽ��������.ARR   
	 * 02-01  500    10    250       5       250       5         0.5         0.5            0.5
	 */
	@Override
	public void writeReportList(ReportField field) throws Exception {
		this.calcField = (CalcColumnField)field;
		for (Map<String,Object>map:reportList){
			for (int i=1;i<=groupMap.size();i++){
				descartesCalc(map,1,i,field.getAlias(),"");
			}
		}
		

	}

}
