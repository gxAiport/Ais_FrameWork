package com.airport.ais.dao.parameter;

import java.io.Serializable;


/**
 * 
 * 
 * FileName      ReportField.java
 * @Description  TODO用于统计分组报表字段的基类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月22日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */


@SuppressWarnings("serial")
public class ReportField   implements  Serializable {


	public static String EXPRESSIONSTRING  = "expressionString";
	public static String ALIAS             = "alias";
		
	/**
	 *  表达式的字符串
	 */
	protected String expressionString;

	/**
	 *  别名
	 */
	protected String alias;

	/**
	 * @return the expressionString
	 */
	public String getExpressionString() {
		return expressionString;
	}

	/**
	 * @param expressionString the expressionString to set
	 */
	public void setExpressionString(String expressionString) {
		this.expressionString = expressionString;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
}
