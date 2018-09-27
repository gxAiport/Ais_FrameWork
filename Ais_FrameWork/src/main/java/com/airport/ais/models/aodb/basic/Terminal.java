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
 * FileName      Terminal.java
 * @Description  TODO ��վ¥��ʵ���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��13��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��13��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Entity
@Table(name="Terminal")
public class Terminal extends DefaultEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String TERMINALCODE = "terminalCode";
	public static final String DESCRIPTION  = "description";
	public static final String AIRPORT      = "airport";
	
	/**
	 * ��վ¥����
	 */
	@Id
	@Column(length=4)
	private String terminalCode;
	/**
	 * ����
	 */
	@Column(length=64)
	private String description;
	/**
	 * ��������
	 */
	@ManyToOne
	private Airport airport;
	
	public String getTerminalCode() {
		return terminalCode;
	}
	
	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Airport getAirport() {
		return airport;
	}
	
	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	@Override
	public Object getIdValue() {
		// TODO Auto-generated method stub
		return this.terminalCode;
	}
	

}
