package com.airport.ais.enums.aodb;

/**
 * 
 * 
 * FileName      IDType.java
 * @Description  TODO 证件类型 的枚举类
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2018年9月4日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2018年9月4日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

public enum IDCardType {
	/**
	 * 身份证
	 */
	National("National"),
	/**
	 * 护照
	 */
	Passport("Passport"),
	/**
	 * 军官证
	 */
	Military("Military"),
	/**
	 * 工作证
	 */
	Employee("Employee"),
	/**
	 * 驾驶证
	 */
	Driver("Driver"),
	/**
	 * 学生证
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
