package com.airport.ais.models.aodb.basic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.airport.ais.enums.aodb.ResourceStatusCode;
import com.airport.ais.models.DefaultEntity;

/**
 * 
 * FileName      BoardingBridge.java
 * @Description  TODO ���ŵ�ʵ���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��13��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��13��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Entity
@Table(name="BoardingBridge")
public class BoardingBridge extends DefaultEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String BRIDGEID                       = "bridgeID";	
	public static final String DESCRIPTION                          = "description";
	public static final String TERMINAL                             = "terminal";
	public static final String STATUSGENERAL                        = "statusGeneral";
	public static final String STATUSGENERALSTARTDATETIME           = "statusGeneralStartDateTime";
	public static final String STATUSGENERALENDDATETIME             = "statusGeneralEndDateTime";
	public static final String STATUSPCA                            = "statusPCA;";
	public static final String STATUSPCASTARTDATETIME               = "statusPCAStartDateTime";
	public static final String STATUSPCAENDDATETIME                 = "statusPCAEndDateTime";
	public static final String STATUSPOWER                          = "statusPower";
	public static final String STATUSPOWERSTARTDATETIME             = "statusPowerStartDateTime";
	public static final String STATUSPOWERENDDATETIME               = "statusPowerEndDateTime";
	
	/**
	 * ����ID
	 */
	@Id
	@Column(length=15)
	private String bridgeID;
	/**
	 * ��������
	 */
	@Column(length=64)
	private String description;
	/**
	 * ������վ¥
	 */
	@ManyToOne
	private Terminal terminal;
	/**
	 * ����״̬
	 */
	@Column(length=1)
	@Enumerated(EnumType.STRING)
	private ResourceStatusCode statusGeneral;
	/**
	 * ����״̬��ʼʱ��
	 */
	private Date statusGeneralStartDateTime;
	/**
	 * ����״̬����ʱ��
	 */
	private Date statusGeneralEndDateTime;
	/**
	 * ����PCA״̬
	 */
	@Column(length=1)
	@Enumerated(EnumType.STRING)
	private ResourceStatusCode statusPCA;
	/**
	 * ����PCA״̬��ʼʱ��
	 */
	private Date statusPCAStartDateTime;
	/**
	 * ����PCA״̬����ʱ��
	 */
	private Date statusPCAEndDateTime;
	/**
	 * ����Power״̬
	 */
	@Column(length=1)
	@Enumerated(EnumType.STRING)
	private ResourceStatusCode statusPower;
	/**
	 * ����Power״̬��ʼʱ��
	 */
	private Date statusPowerStartDateTime;
	/**
	 * ����Power״̬����ʱ��
	 */
	private Date statusPowerEndDateTime;
	
	public String getBridgeID() {
		return bridgeID;
	}
	
	public void setBridgeID(String bridgeID) {
		this.bridgeID = bridgeID;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Terminal getTerminal() {
		return terminal;
	}
	
	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	
	public ResourceStatusCode getStatusGeneral() {
		return statusGeneral;
	}
	
	public void setStatusGeneral(ResourceStatusCode statusGeneral) {
		this.statusGeneral = statusGeneral;
	}
	
	public Date getStatusGeneralStartDateTime() {
		return statusGeneralStartDateTime;
	}
	
	public void setStatusGeneralStartDateTime(Date statusGeneralStartDateTime) {
		this.statusGeneralStartDateTime = statusGeneralStartDateTime;
	}
	
	public Date getStatusGeneralEndDateTime() {
		return statusGeneralEndDateTime;
	}
	
	public void setStatusGeneralEndDateTime(Date statusGeneralEndDateTime) {
		this.statusGeneralEndDateTime = statusGeneralEndDateTime;
	}
	
	public ResourceStatusCode getStatusPCA() {
		return statusPCA;
	}
	
	public void setStatusPCA(ResourceStatusCode statusPCA) {
		this.statusPCA = statusPCA;
	}
	
	public Date getStatusPCAStartDateTime() {
		return statusPCAStartDateTime;
	}
	
	public void setStatusPCAStartDateTime(Date statusPCAStartDateTime) {
		this.statusPCAStartDateTime = statusPCAStartDateTime;
	}
	
	public Date getStatusPCAEndDateTime() {
		return statusPCAEndDateTime;
	}
	
	public void setStatusPCAEndDateTime(Date statusPCAEndDateTime) {
		this.statusPCAEndDateTime = statusPCAEndDateTime;
	}
	
	public ResourceStatusCode getStatusPower() {
		return statusPower;
	}
	
	public void setStatusPower(ResourceStatusCode statusPower) {
		this.statusPower = statusPower;
	}
	
	public Date getStatusPowerStartDateTime() {
		return statusPowerStartDateTime;
	}
	
	public void setStatusPowerStartDateTime(Date statusPowerStartDateTime) {
		this.statusPowerStartDateTime = statusPowerStartDateTime;
	}
	
	public Date getStatusPowerEndDateTime() {
		return statusPowerEndDateTime;
	}
	
	public void setStatusPowerEndDateTime(Date statusPowerEndDateTime) {
		this.statusPowerEndDateTime = statusPowerEndDateTime;
	}

	@Override
	public Object getIdValue() {
		// TODO Auto-generated method stub
		return this.bridgeID;
	}
	
	
	

}
