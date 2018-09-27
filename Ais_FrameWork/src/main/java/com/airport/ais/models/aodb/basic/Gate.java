package com.airport.ais.models.aodb.basic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * 
 * FileName Gate.java
 * 
 * @Description TODO �ǻ��ڵ�ʵ����
 * @author ZhangYu Company: LZAirport
 * @version V0.9a CreateDate: 2017��6��13��
 * @ModificationHistory Date Author Version Description
 *                      <p>
 *                      ---------------------------------------------
 *                      <p>
 *                      2017��6��13�� ZhangYu 1.0 1.0
 *                      <p>
 *                      Why & What is modified: <�޸�ԭ������>
 */

@Entity
@Table(name="Gate")
public class Gate extends FlightResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String GATENUMBER ="gateNumber";
	public static final String BOARDINGBRIDGES = "boardingBridges";
	/**
	 * �ǻ��ڱ��
	 */
	@Id
	@Column(length = 15)
	private String gateNumber;
	/**
	 * ��Ӧ�ĵǻ���
	 */
	@OneToMany
	@JoinColumn(name="gate_id")
	private List<BoardingBridge> boardingBridges;
	
	public String getGateNumber() {
		return gateNumber;
	}
	
	public void setGateNumber(String gateNumber) {
		this.gateNumber = gateNumber;
	}
	
	public List<BoardingBridge> getBoardingBridges() {
		if (boardingBridges == null){
			boardingBridges = new ArrayList<BoardingBridge>();
		}
		return this.boardingBridges;
	}
	
	
	

	@Override
	public Object getIdValue() {
		// TODO Auto-generated method stub
		return this.gateNumber;
	}
	

}
