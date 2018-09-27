package com.airport.ais.enums.aodb;

/**
 * FileName      SectorCode.java
 * @Description  TODO �������
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��12��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��12��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public enum SectorCode {
	/**
	 *   ����
	 */
    D,
    /**
     *   ����
     */
    I,
    /**
     *   ���
     */
    M,
    /**
     *   ����
     */
    R;
    public String value() {
        return name();
    }

    public static SectorCode fromValue(String v) {
        return valueOf(v);
    }
    
    /**
     * ����CAAC�涨�Ĵ��룬���ض�Ӧ��ö��ֵ
     * @param code  CAAC����
     * @return  ��Ӧ��ö��ֵ,���û�ж�Ӧֵ����ֵΪ��
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
     * ���ݶ�Ӧ��ö��ֵ�����ض�Ӧ�����ĺ���
     * @param code  ö��ֵ
     * @return ���ĺ��壬���û�ж�Ӧö��ֵ������ֵΪ��
     */
    public static String getCn(SectorCode code){
    	switch (code) {
		case D:
			return "����";
		case I:
			return "����";
		case M:
			return "���";
		case R:
			return "����";
		default:
		    return null;
		}
    	
    }
    
    
    
    
    
    
}