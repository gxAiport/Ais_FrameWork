/**
 * 
 */
package com.airport.ais.report.generater;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

import com.airport.ais.dao.parameter.SummaryField;
import com.airport.ais.enums.SummaryType;



/**
 * 
 * 
 * FileName      SummaryGenerater.java
 * @Description  TODO �ֶεĻ��ܴ����� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��10��8��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��10��8��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Component
public class SummaryGenerater {
	
	
	
	private Double calcExpression(Map<String,Double> calcMap,SummaryField field){
		
		return calcMap.get(field.getExpression()[0])/calcMap.get(field.getExpression()[1])*100;
		
	}
	
	
	
	/**
	 * 
	 * @Description: ����reportList��fields�����ֶε�С��
	 * @param reportList  ��������
	 * @param fields ��Ҫ������ֶ�
	 * @return ���ظ��ֶε�С��
	 */
	public Map<String,Object> calcSummary(List<Map<String,Object>> reportList,SummaryField[] fields){

		Map<String,Object> result = new HashMap<String, Object>();
		Map<String,Double> calcMap = new HashMap<String, Double>();
		
		if (fields == null){
			/**
			 * ����ֶ�Ϊ�գ����ؿ�����
			 */
			return result;
		}
		/**
		 *   ��ʼ����С���ֶ� 
		 */
		for(SummaryField field:fields){
			if (!SummaryType.None.equals(field.getSummaryType())){
				calcMap.put(field.getDataIndex(), 0.0);
			}
		}
		
		
		/**
		 * �ۼӸ��ֶ�����
		 */
		for(Map<String,Object> map:reportList){
			for(SummaryField field:fields){
				if (!SummaryType.None.equals(field.getSummaryType())){
					if (map.get(field.getDataIndex()) != null){
						Double calcNum= calcMap.get(field.getDataIndex()) +
								Double.parseDouble(map.get(field.getDataIndex()).toString());
						calcMap.put(field.getDataIndex(), calcNum);
					}
				}
			}
		}
		
		
		/**
		 * ���ݸ��ֶ�С�����͵��������Map��
		 */
		for(SummaryField field:fields){
			Double calcNum = null;
			if (SummaryType.Avg.equals(field.getSummaryType())){
				calcNum = calcMap.get(field.getDataIndex()) / reportList.size();
			}else if (SummaryType.Sum.equals(field.getSummaryType())){
				calcNum = calcMap.get(field.getDataIndex());
			}else if (SummaryType.Calc.equals(field.getSummaryType())){
				calcNum = calcExpression(calcMap,field);
			}
			result.put(field.getDataIndex(), new DecimalFormat("#.00").format(calcNum));
		}
		
		return  result;
	}

}
