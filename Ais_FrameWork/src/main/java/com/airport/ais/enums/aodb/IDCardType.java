package com.airport.ais.enums.aodb;

/**
 * 
 * 
 * FileName      IDType.java
 * @Description  TODO ֤������ ��ö����
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2018��9��4��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2018��9��4��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public enum IDCardType {
	/**
	 * ���֤
	 */
	National("National"),
	/**
	 * ����
	 */
	Passport("Passport"),
	/**
	 * ����֤
	 */
	Military("Military"),
	/**
	 * ����֤
	 */
	Employee("Employee"),
	/**
	 * ��ʻ֤
	 */
	Driver("Driver"),
	/**
	 * ѧ��֤
	 */
	Student("Student");
	
    private final String value;
	
	private IDCardType(String value) {
		this.value = value;
	}
	
	public static  IDCardType fromValue(String v) {
        for ( IDCardType u:  IDCardType.values()) {
            if (u.value.equals(v)) {
                return u;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
