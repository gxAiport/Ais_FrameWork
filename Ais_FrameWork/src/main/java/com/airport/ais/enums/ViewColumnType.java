package com.airport.ais.enums;

/**
 * 
 * 
 * FileName      ViewColumnType.java
 * @Description  TODO ��ͼ�ж������������ 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��27��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��27��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public enum ViewColumnType {
	/**
	 *  ��̬�ֶ� 
	 */
	_static,
	/**
	 * ö���ֶ�
	 */
	_Enum,
	/**
	 * ��̬�ֶ�
	 */
	_Dyniamic,
	/**
	 *  ���������ֶ� 
	 */
	_Number;
	
	public String value() {
        return name();
    }

    public static ViewColumnType fromValue(String v) {
        return valueOf(v);
    }
	
	

}
