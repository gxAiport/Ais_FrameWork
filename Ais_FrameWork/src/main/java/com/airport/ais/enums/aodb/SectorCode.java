package com.airport.ais.enums.aodb;

/**
 * FileName      SectorCode.java
 * @Description  TODO 领域代码
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月12日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月12日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

public enum SectorCode {
	/**
	 *   国内
	 */
    D,
    /**
     *   国际
     */
    I,
    /**
     *   混合
     */
    M,
    /**
     *   地区
     */
    R;
    public String value() {
        return name();
    }

    public static SectorCode fromValue(String v) {
        return valueOf(v);
    }
    
    /**
     * 根据CAAC规定的代码，返回对应的枚举值
     * @param code  CAAC代码
     * @return  对应的枚举值,如果没有对应值返回值为空
     */
    public static SectorCode fromCaacCode(String code){
    	switch (code.toUpperCase()) {
		case "DOM":
			 return D;
		case "INT":
			 return I;
		case "REG":
			 return R;	
		default:
			return  null;
    	}
    }
    
    public static String toCaacCode(SectorCode code){
    	switch (code) {
		case D:
			return "DOM";
		case I:
			return "INT";
		case R:
			return "REG";
		default:
		    return null;
		}
    }
    
    /**
     * 根据对应的枚举值，返回对应的中文含义
     * @param code  枚举值
     * @return 中文含义，如果没有对应枚举值，返回值为空
     */
    public static String getCn(SectorCode code){
    	switch (code) {
		case D:
			return "国内";
		case I:
			return "国际";
		case M:
			return "混合";
		case R:
			return "地区";
		default:
		    return null;
		}
    	
    }
    
    
    
    
    
    
}