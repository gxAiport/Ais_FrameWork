package com.airport.ais.models.collection;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.airport.ais.models.IntIdEntity;


@Entity
@Table(name="IBMessage")
public class IBMessage extends IntIdEntity {

	private static final long serialVersionUID = 1L;

	
	public static final String  MESSAGESEQUENCENUMBER   = "messageSequenceNumber";
	public static final String  MESSAGETYPE             = "messageType";
	public static final String  SOURCESYSTEMID          = "sourceSystemID";
	public static final String  DESTINATIONSYSTEMID     = "destinationSystemID";
	public static final String  MESSAGEORIGINATORID     = "messageOriginatorID";
	public static final String  MESSAGESENTDATETIME     = "messageSentDateTime";
	public static final String  ORIGINATORDATETIME      = "originatorDateTime";
	public static final String  CONTENT                 = "content";
	public static final String  PROCESSED               = "processed";
 
	/**
	 * �������к�
	 */
	private int messageSequenceNumber;
	
	/**
	 * ��Ϣ����
	 */
	@Column(length=35)
	private String messageType;

	/**
	 *  ����ϵͳ
	 */
	@Column(length=35)
	private String sourceSystemID;

	/**
	 * Ŀ��ϵͳ
	 */
	@Column(length=35)
	private String destinationSystemID;
	
	
	/**
	 *  ��Ϣԭϵͳ
	 */
	@Column(length=35)
	private String messageOriginatorID;
	
	/**
	 * ����ʱ��
	 */
	private Date messageSentDateTime;
	
	
	/**
	 *  ԭϵͳʱ��
	 */
	private Date originatorDateTime;


	@Lob
	/**
	 *  ����
	 */
	private String content;
	
	/**
	 * �����־
	 */
	private boolean processed;
	
	/**
	 * @return the messageSequenceNumber
	 */
	public int getMessageSequenceNumber() {
		return messageSequenceNumber;
	}


	/**
	 * @param messageSequenceNumber the messageSequenceNumber to set
	 */
	public void setMessageSequenceNumber(int messageSequenceNumber) {
		this.messageSequenceNumber = messageSequenceNumber;
	}


	/**
	 * @return the messageType
	 */
	public String getMessageType() {
		return messageType;
	}


	/**
	 * @param messageType the messageType to set
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}


	/**
	 * @return the sourceSystemID
	 */
	public String getSourceSystemID() {
		return sourceSystemID;
	}


	/**
	 * @param sourceSystemID the sourceSystemID to set
	 */
	public void setSourceSystemID(String sourceSystemID) {
		this.sourceSystemID = sourceSystemID;
	}


	/**
	 * @return the destinationSystemID
	 */
	public String getDestinationSystemID() {
		return destinationSystemID;
	}


	/**
	 * @param destinationSystemID the destinationSystemID to set
	 */
	public void setDestinationSystemID(String destinationSystemID) {
		this.destinationSystemID = destinationSystemID;
	}


	/**
	 * @return the messageOriginatorID
	 */
	public String getMessageOriginatorID() {
		return messageOriginatorID;
	}


	/**
	 * @param messageOriginatorID the messageOriginatorID to set
	 */
	public void setMessageOriginatorID(String messageOriginatorID) {
		this.messageOriginatorID = messageOriginatorID;
	}


	/**
	 * @return the messageSentDateTime
	 */
	public Date getMessageSentDateTime() {
		return messageSentDateTime;
	}


	/**
	 * @param messageSentDateTime the messageSentDateTime to set
	 */
	public void setMessageSentDateTime(Date messageSentDateTime) {
		this.messageSentDateTime = messageSentDateTime;
	}


	/**
	 * @return the originatorDateTime
	 */
	public Date getOriginatorDateTime() {
		return originatorDateTime;
	}


	/**
	 * @param originatorDateTime the originatorDateTime to set
	 */
	public void setOriginatorDateTime(Date originatorDateTime) {
		this.originatorDateTime = originatorDateTime;
	}


	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}


	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}


	public boolean isProcessed() {
		return processed;
	}


	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	
	
	
}
