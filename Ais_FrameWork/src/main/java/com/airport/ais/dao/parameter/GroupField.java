package com.airport.ais.dao.parameter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;

import com.airport.ais.enums.QueryGroupDate;

/**
 * 
 * FileName      GroupField.java
 * @Description  TODO �����ֶΣ����ڱ����ֶε��У�����GroupBy��ͳ�ƣ����ʽ�Ĳ���ֻ����һ���ֶ�
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��22��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��22��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 * 
 */


public class GroupField extends ReportField {

	
	private static final long serialVersionUID = 1L;

	public static String EXPRESSION     = "expression";
	public static String QUERYGROUPDATE = "queryGroupDate";
	
	/**
	 * ���ʽ
	 */
	@Transient
	private Object expression;
	
	
	/**
	 * ��������
	 */
	@Column(length=10)
	@Enumerated(EnumType.STRING)
	private QueryGroupDate queryGroupDate;


	/**
	 * @return the expression
	 */
	public Object getExpression() {
		return expression;
	}


	/**
	 * @param expression the expression to set
	 */
	public void setExpression(Object expression) {
		this.expression = expression;
	}


	/**
	 * @return the queryGroupDate
	 */
	public QueryGroupDate getQueryGroupDate() {
		return queryGroupDate;
	}


	/**
	 * @param queryGroupDate the queryGroupDate to set
	 */
	public void setQueryGroupDate(QueryGroupDate queryGroupDate) {
		this.queryGroupDate = queryGroupDate;
	}




}
