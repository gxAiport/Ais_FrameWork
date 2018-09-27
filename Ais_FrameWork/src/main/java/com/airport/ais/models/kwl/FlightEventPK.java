package com.airport.ais.models.kwl;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the FlightEvent database table.
 * 
 */
@Embeddable
public class FlightEventPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ID")
	private int id;

	@Column(name="FlightNo")
	private String flightNo;

	@Column(name="Airways_3Code")
	private String airways_3Code;

	@Column(name="Flag_InOut")
	private String flag_InOut;

	public FlightEventPK() {
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlightNo() {
		return this.flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getAirways_3Code() {
		return this.airways_3Code;
	}
	public void setAirways_3Code(String airways_3Code) {
		this.airways_3Code = airways_3Code;
	}
	public String getFlag_InOut() {
		return this.flag_InOut;
	}
	public void setFlag_InOut(String flag_InOut) {
		this.flag_InOut = flag_InOut;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FlightEventPK)) {
			return false;
		}
		FlightEventPK castOther = (FlightEventPK)other;
		return 
			(this.id == castOther.id)
			&& this.flightNo.equals(castOther.flightNo)
			&& this.airways_3Code.equals(castOther.airways_3Code)
			&& this.flag_InOut.equals(castOther.flag_InOut);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.flightNo.hashCode();
		hash = hash * prime + this.airways_3Code.hashCode();
		hash = hash * prime + this.flag_InOut.hashCode();
		
		return hash;
	}
}