package com.airport.ais.enums;


/**
 * 
 * FileName      CumulativeType.java
 * @Description  TODO �ۼ����͵�ö���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��10��8��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��10��8��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public enum CumulativeType {
	
	year,
	month,
	day;
	
    public String value() {
        return name();
    }

    public static  CumulativeType fromValue(String v) {
        return valueOf(v);
    }
}
