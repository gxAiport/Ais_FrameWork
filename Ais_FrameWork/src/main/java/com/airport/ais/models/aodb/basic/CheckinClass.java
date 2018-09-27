package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.airport.ais.models.DefaultEntity;

/**
 * 
 * FileName      CheckinClass.java
 * @Description  TODO ֵ���ȼ���ʵ���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��13��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��13��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Entity
@Table(name="CheckinClass")
public class CheckinClass extends DefaultEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String  CLASSCODE            = "classCode";
	public static final String  ENGLISHDESCRIPTION   = "englishDescription";
	public static final String  CHINESEDESCRIPTION   = "chineseDescription";
	
	/**
	 * ֵ���ȼ�����
	 */
	@Id
	@Column(length=1)
	private String classCode;
	/**
	 *  Ӣ������
	 */
	@Column(length=128)
	private String englishDescription;
	/**
	 * ��������
	 */
	@Column(length=128)
	private String chineseDescription;
	
	public String getClassCode() {
		return classCode;
	}
	
	public void setClassCode(String classCode) {
		this.classCode = classCode;
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
		return this.classCode;
	}
	
}
