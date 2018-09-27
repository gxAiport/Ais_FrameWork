package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.airport.ais.models.DefaultEntity;

/**
 * 
 * 
 * FileName      FlightStatus.java
 * @Description  TODO 航班状态 的实体类
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月16日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月16日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Entity
@Table(name="FlightStatus")
public class FlightStatus extends DefaultEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String CODE                  = "code";
	public static final String ENGLISHDESCRIPTION    = "englishDescription";	
	public static final String CHINESEDESCRIPTION    = "chineseDescription";	
	
	/**
	 * 航班性质
	 */
	@Id
	@Column(length=3)
	private String code;
	/**
	 *  英文描述
	 */
	@Column(length=32)
	private String englishDescription;
	/**
	 * 中文描述
	 */
	@Column(length=32)
	private String chineseDescription;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getEnglishDescription() {
		return englishDescription;
	}
	
	public void setEnglishDescription(String englishDescription) {
		this.englishDescription = englishDescription;
	}
	
	public String getChineseDescription() {
		return chineseDescription;
	}
	
	public void setChineseDescription(String chineseDescription) {
		this.chineseDescription = chineseDescription;
	}
	
	
	@Override
	public Object getIdValue() {
		// TODO Auto-generated method stub
		return this.code;
	}

}
