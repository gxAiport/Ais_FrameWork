package com.airport.ais.dao.parameter;

/**
 * 
 * 
 * FileName      ColumnField.java
 * @Description  TODO  ���ֶεĳ����࣬����ʵ�ʵ����ֶζ��̳��� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��22��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��22��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public  class ColumnField extends ReportField {

	private static final long serialVersionUID = 1L;
	
	public static String EXPRESSION = "expression";
	
	/**
	 * �ۺϱ��ʽ��ֻ����+,-���ߵ���
	 */
	protected Object[] expression;
	/**
	 * @return the expression
	 */
	public Object[] getExpression() {
		return expression;
	}
	/**
	 * @param expression the expression to set
	 */
	public void setExpression(Object[] expression) {
		this.expression = expression;
	}
	
	


}