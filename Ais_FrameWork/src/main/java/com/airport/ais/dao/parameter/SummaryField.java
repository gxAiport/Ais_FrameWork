package com.airport.ais.dao.parameter;

import com.airport.ais.enums.SummaryType;

/**
 * 
 * 
 * FileName      SummaryField.java
 * @Description  TODO 用于显示汇总的字段 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年10月11日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月11日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
public class SummaryField {
	
	/**
	 * 数据Key值
	 */
	private String  dataIndex;
	
	private Object[] expression;
	/**
	 * 数据的标题
	 */
	private String  text;
	
	
	/**
	 * 合计的类型
	 */
	private SummaryType summaryType;

	/**
	 * @return the dataIndex
	 */
	public String getDataIndex() {
		return dataIndex;
	}

	/**
	 * @param dataIndex the dataIndex to set
	 */
	public void setDataIndex(String dataIndex) {
		this.dataIndex = dataIndex;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the summaryType
	 */
	public SummaryType getSummaryType() {
		return summaryType;
	}

	/**
	 * @param summaryType the summaryType to set
	 */
	public void setSummaryType(SummaryType summaryType) {
		this.summaryType = summaryType;
	}

	public Object[] getExpression() {
		return expression;
	}

	public void setExpression(Object[] expression) {
		this.expression = expression;
	}
	
	

}
