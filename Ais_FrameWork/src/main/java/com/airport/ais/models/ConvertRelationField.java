package com.airport.ais.models;

/**
 * 
 * 
 * FileName      ConvertRelationField.java
 * @Description  TODO  ת���Ĺ����ֶΣ�
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��9��20��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��9��20��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */


public class ConvertRelationField {
  
	/**
	 * �����ֶζ�Ӧ��Code�ֶ�����ֵ�ǹ����ֶε�Id����
	 */
	private String codeFieldName;
	
	/**
	 * �����ֶ���
	 */
	private String relationFieldName;
	
	/**
	 * �����ֶε���
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
