package com.airport.ais.enums.aodb;

/**
 * 
 * 
 * FileName      PassagerCardLevel.java
 * @Description  TODO  ���ÿͿ��ȼ�
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��18��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��18��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
public enum PassagerCardLevel {
	/**
	 * ��
	 */
	GOLD("Gold"),
	/**
	 * ����
	 */
	SILVER("Silver"),
	/**
	 * ͷ�Ȳ�
	 */
	FIRSTCLASS("FirstClass");
	
	private final String value;
	
	PassagerCardLevel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PassagerCardLevel fromValue(String v) {
        for (PassagerCardLevel c: PassagerCardLevel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
