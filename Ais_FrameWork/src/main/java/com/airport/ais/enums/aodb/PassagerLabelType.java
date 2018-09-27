package com.airport.ais.enums.aodb;


/**
 * 
 * FileName      PassagerLabelType.java
 * @Description  TODO 旅客标签类型的枚举类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2018年9月4日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2018年9月4日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

public enum PassagerLabelType {
	/**
	 * 年龄：30岁
	 */
	Age("Age"),
	/**
	 * 性别：男，女
	 */
	Sex("Sex"),
	/**
	 * 座位等级：头等，商务，经济
	 */
	SeatClass("SeatClass"),
	/**
	 *  区域:国内、国外  
	 */
	Sector("Sector"),
	/**
	 * 省份：湖南
	 */
	Provinces("Provinces"),
	/**
	 * 城市：北京
	 */
	City("City");
	
	private final String value;
	
	PassagerLabelType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PassagerLabelType fromValue(String v) {
        for (PassagerLabelType c: PassagerLabelType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	
}
