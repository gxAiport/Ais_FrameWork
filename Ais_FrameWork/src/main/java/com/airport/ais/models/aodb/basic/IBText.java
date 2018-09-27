package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.airport.ais.models.IntIdEntity;

/**
 * 
 * 
 * FileName      IBText.java
 * @Description  TODO  IB信息对照表
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年7月11日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年7月11日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Entity
public class IBText extends IntIdEntity {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final String  TEXTCATEGORYCODE    = "textCategoryCode";
	public static final String  TEXTCODE            = "textCode"; 
	public static final String  CHINESELANGUAGETEXT = "chineseLanguageText";
	public static final String  ENGLISHLANGUAGETEXT = "englishLanguageText";
	
	
	/**
	 *   代码种类
	 */
	@Column(length=10)
	private String textCategoryCode;
	/**
	 *  代码
	 */
	@Column(length=10)
	private String textCode;
	/**
	 * 中文描述
	 */
	@Column(length=128)
	private String chineseLanguageText;
	/**
	 * 英文描述
	 */
	@Column(length=128)
	private String englishLanguageText;
	public String getTextCategoryCode() {
		return textCategoryCode;
	}
	public void setTextCategoryCode(String textCategoryCode) {
		this.textCategoryCode = textCategoryCode;
	}
	public String getTextCode() {
		return textCode;
	}
	public void setTextCode(String textCode) {
		this.textCode = textCode;
	}
	public String getChineseLanguageText() {
		return chineseLanguageText;
	}
	public void setChineseLanguageText(String chineseLanguageText) {
		this.chineseLanguageText = chineseLanguageText;
	}
	public String getEnglishLanguageText() {
		return englishLanguageText;
	}
	public void setEnglishLanguageText(String englishLanguageText) {
		this.englishLanguageText = englishLanguageText;
	}
	
	
	
	
}
