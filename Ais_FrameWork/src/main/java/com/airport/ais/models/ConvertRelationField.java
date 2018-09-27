package com.airport.ais.models;

/**
 * 
 * 
 * FileName      ConvertRelationField.java
 * @Description  TODO  转换的关联字段，
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年9月20日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年9月20日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */


public class ConvertRelationField {
  
	/**
	 * 关联字段对应的Code字段名，值是关联字段的Id数组
	 */
	private String codeFieldName;
	
	/**
	 * 关联字段名
	 */
	private String relationFieldName;
	
	/**
	 * 关联字段的类
	 */
	private Class<?> relationFieldClass;

	public String getCodeFieldName() {
		return codeFieldName;
	}

	public void setCodeFieldName(String codeFieldName) {
		this.codeFieldName = codeFieldName;
	}

	public String getRelationFieldName() {
		return relationFieldName;
	}

	public void setRelationFieldName(String relationFieldName) {
		this.relationFieldName = relationFieldName;
	}

	public Class<?> getRelationFieldClass() {
		return relationFieldClass;
	}

	public void setRelationFieldClass(Class<?> relationFieldClass) {
		this.relationFieldClass = relationFieldClass;
	}

	
	
	
}
