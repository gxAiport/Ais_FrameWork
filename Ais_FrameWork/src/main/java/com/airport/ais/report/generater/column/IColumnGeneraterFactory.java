package com.airport.ais.report.generater.column;

import java.util.List;
import java.util.Map;

import com.airport.ais.dao.parameter.GroupField;
import com.airport.ais.dao.parameter.ReportField;

public interface IColumnGeneraterFactory {

	/**
	 * 
	 * @Description: ����field���ض�Ӧ��Column�Ĵ�����������ʼ���ֶδ�����
	 * @param field �ֶ�
	 * @param aggregationResult  �ۺϴ���Ľ��
	 * @param groupMap ������Group�ֶ�ֵ�ü���
	 * @param reportList ������ɵı���
	 * @param groupFields Group�ֶμ���
	 * @return ���ֶδ�����
	 */
	IColumnGenerater getcolumnGenerater(ReportField field, List<Map<String, Object>> aggregationResult,
			Map<String, List<Object>> groupMap, List<Map<String, Object>> reportList, List<GroupField> groupFields);

}