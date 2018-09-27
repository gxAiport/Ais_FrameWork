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
 * @Description  �ۼ��£����ֶδ�������Ҫ��ۺϲ�ѯ�����ֶα���ΪGrpDate.day����
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2016��2��24�� 
 * @ModificationHistory
 * Date         Author     Version   Discription
 * <p>---------------------------------------------
 * <p>2016��2��24��      Yu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */




public class CumulativeColumnGenerater<K> implements IColumnGenerater {

	/**
	 *  �����List
	 */
	private List<Map<String,Object>> reportList;
	
	/**
	 *  �������ֶε�Aials
	 */
	private String rowKey;
	
	
	private ICumulativeService<K> cumulativeService;
	
	/**
	 * 
	 * @Description: ��ʼ���࣬������Ľ�������ֶζ�Ӧ��Ailas��ֵ��������
	 * @param reportList �����List
	 * @param rowKey ������Ӧ���ֶε�Ailas
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
			 * ������ۼ��ֶ�
			 */
			CumulativeColumnField cumulativeColumnField = (CumulativeColumnField) field;
			String year = cumulativeColumnField.getYear();
			CumulativeType type = cumulativeColumnField.getCumulativeType();
			for(Map<String,Object> map:reportList){
				/**
				 * ȡ�����ڣ�����02-01
				 */
				String day = map.get(rowKey).toString();
				/**
				 * ������Ҫ�ۼƵ����ڵ�����һ��
				 */
				Date date = DateTimeUtil.strToDate(year+"-"+day);
				if (CumulativeType.month.equals(type)){
					/**
					 * ��������ۼƣ��������ۼƷ���
					 */
					map.put(field.getAlias(), cumulativeService.cumulativeMonth(date, cumulativeColumnField));
				}else if (CumulativeType.year.equals(type)){
					/**
					 * ��������ۼƣ��������ۼƷ���
					 */
					map.put(field.getAlias(), cumulativeService.cumulativeYear(date, cumulativeColumnField));
				}
			}			
		}else{
			throw new Exception("��������ۼ��ֶδ��������ܴ������������ֶ�");
		}
		
		
	}

}
