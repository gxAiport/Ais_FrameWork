package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.airport.ais.models.IntIdEntity;

/**
 * 
 * 
 * FileName      IBText.java
 * @Description  TODO  IB��Ϣ���ձ�
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��7��11��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��7��11��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Entity
public class IBText extends IntIdEntity {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String  TEXTCATEGORYCODE    = "textCategoryCode";
	public static final String  TEXTCODE            = "textCode"; 
	public static final String  CHINESELANGUAGETEXT = "chineseLanguageText";
	public static final String  ENGLISHLANGUAGETEXT = "englishLanguageText";
	
	
	/**
	 *   ��������
	 */
	@Column(length=10)
	private String textCategoryCode;
	/**
	 *  ����
	 */
	@Column(length=10)
	private String textCode;
	/**
	 * ��������
	 */
	@Column(length=128)
	private String chineseLanguageText;
	/**
	 * Ӣ������
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
