package com.airport.ais.enums;

/**
 * 
 * 
 * FileName      UploadType.java
 * @Description  TODO  上传类型的枚举类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年8月6日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年8月6日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */


public enum UploadType {
	/**
	 *   季度航班 
	 */
	SeansonFlight("SeansonFlight"),
	/**
	 *   结算飞机
	 */
	CAAC_Settlement_Aircraft("CAAC_Settlement_Aircraft"),
	/**
	 *  结算收入数据
	 */
	CAAC_Settlement_Income("CAAC_Settlement_Income"),
	/**
	 *   民航统计系统飞机数据
	 */
	CAAC_Statistics_Aircraft("CAAC_Statistics_Aircraft"),
	/**
	 *  民航统计系统载量数据
	 */
	CAAC_Statistics_Load("CAAC_Statistics_Load"),
	
	/**
	 *  航信旅客数据
	 */
	CAAC_Passenger("CAAC_Passenger");
	
    private final String value;

	private UploadType(String value) {
		this.value = value;
	}
	
	public static  UploadType fromValue(String v) {
        for ( UploadType u:  UploadType.values()) {
            if (u.value.equals(v)) {
                return u;
            }
        }
        throw new IllegalArgumentException(v);
    }

	 
	 

}
