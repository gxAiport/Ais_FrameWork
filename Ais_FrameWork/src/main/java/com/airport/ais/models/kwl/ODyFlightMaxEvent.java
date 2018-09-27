package com.airport.ais.models.kwl;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the ODyFlightMaxEvent database table.
 * 
 */
@Entity
@NamedQuery(name="ODyFlightMaxEvent.findAll", query="SELECT o FROM ODyFlightMaxEvent o")
public class ODyFlightMaxEvent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static final String OPERATIONDATE = "operationDate";

	
	@EmbeddedId
	private EventId eventId;

	@Column(name="EVENT_CODE")
	private BigDecimal eventCode;

	

	public ODyFlightMaxEvent() {
	}

	

	public EventId getEventId() {
		return eventId;
	}



	public void setEventId(EventId eventId) {
		this.eventId = eventId;
	}



	public BigDecimal getEventCode() {
		return this.eventCode;
	}

	public void setEventCode(BigDecimal eventCode) {
		this.eventCode = eventCode;
	}


	
	
	public  static class EventId implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Column(name="AorD")
		private String aorD;
		
		@Column(name="FLIGHT_NO")
		private String flightNo;

		@Column(name="OPERATION_DATE")
		private Timestamp operationDate;
		
		public String getAorD() {
			return this.aorD;
		}

		public void setAorD(String aorD) {
			this.aorD = aorD;
		}
		public String getFlightNo() {
			return this.flightNo;
		}

		public void setFlightNo(String flightNo) {
			this.flightNo = flightNo;
		}

		public Timestamp getOperationDate() {
			return this.operationDate;
		}

		public void setOperationDate(Timestamp operationDate) {
			this.operationDate = operationDate;
		}
	}

}