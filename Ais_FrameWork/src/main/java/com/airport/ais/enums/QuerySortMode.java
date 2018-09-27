package com.airport.ais.enums;

/**
 * 
 * FileName      QuerySortMode.java
 * @Description  TODO �����ö����
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��22��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��22��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public enum QuerySortMode {
	
	 ASC,
	 DESC;

    public String value() {
        return name();
    }

    public static QuerySortMode fromValue(String v) {
        return valueOf(v);
    }
}
