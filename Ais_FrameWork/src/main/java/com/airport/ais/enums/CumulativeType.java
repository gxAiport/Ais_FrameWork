package com.airport.ais.enums;


/**
 * 
 * FileName      CumulativeType.java
 * @Description  TODO 累计类型的枚举类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年10月8日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月8日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
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
