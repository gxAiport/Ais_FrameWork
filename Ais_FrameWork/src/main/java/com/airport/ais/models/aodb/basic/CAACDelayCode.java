package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.airport.ais.models.DefaultEntity;


/**
 * 
 * 
 * FileName      CAACDelayCode.java
 * @Description  TODO 延误代码 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月13日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Entity
@Table(name="CAACDelayCode")
public class CAACDelayCode extends DefaultEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final String  DELAYCODE            = "delayCode";
	public static final String  ENGLISHDESCRIPTION   = "englishDescription";
	public static final String  CHINESEDESCRIPTION   = "chineseDescription";
	
	/**
	 * 延误代码
	 */
	@Id
	@Column(length=4)
	private String delayCode;
	/**
	 *  英文描述
	 */
	@Column(length=128)
	private String englishDescription;
	/**
	 * 中文描述
	 */
	@Column(length=128)
	private String chineseDescription;
	
	@ManyToOne
	private CAACDelayCategory caacDelayCategory;
	
	public String getDelayCode() {
		return delayCode;
	}
	
	public void setDelayCode(String delayCode) {
		this.delayCode = delayCode;
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

	public CAACDelayCategory getCaacDelayCategory() {
		return caacDelayCategory;
	}

	public void setCaacDelayCategory(CAACDelayCategory caacDelayCategory) {
		this.caacDelayCategory = caacDelayCategory;
	}
	
	

	@Override
	public Object getIdValue() {
		return this.delayCode;
	}
	

}
