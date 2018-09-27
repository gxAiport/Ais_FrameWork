package com.airport.ais.report.generater.column;

import java.util.List;
import java.util.Map;

import com.airport.ais.dao.parameter.GroupField;
import com.airport.ais.dao.parameter.ReportField;

public interface IColumnGeneraterFactory {

	/**
	 * 
	 * @Description: 根据field返回对应的Column的处理器，并初始化字段处理器
	 * @param field 字段
	 * @param aggregationResult  聚合处理的结果
	 * @param groupMap 产生的Group字段值得集合
	 * @param reportList 最后生成的报表
	 * @param groupFields Group字段集合
	 * @return 列字段处理器
	 */
	IColumnGenerater getcolumnGenerater(ReportField field, List<Map<String, Object>> aggregationResult,
			Map<String, List<Object>> groupMap, List<Map<String, Object>> reportList, List<GroupField> groupFields);

}