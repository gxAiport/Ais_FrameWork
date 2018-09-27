package com.airport.ais.dao.parameter;

import com.airport.ais.enums.SummaryType;

/**
 * 
 * 
 * FileName      SummaryField.java
 * @Description  TODO ������ʾ���ܵ��ֶ� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��10��11��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��10��11��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
public class SummaryField {
	
	/**
	 * ����Keyֵ
	 */
	private String  dataIndex;
	
	private Object[] expression;
	/**
	 * ���ݵı���
	 */
	private String  text;
	
	
	/**
	 * �ϼƵ�����
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
