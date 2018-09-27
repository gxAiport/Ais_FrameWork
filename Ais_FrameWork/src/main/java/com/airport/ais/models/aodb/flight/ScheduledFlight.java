package com.airport.ais.models.aodb.flight;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 
 * FileName      ScheduledFlight.java
 * @Description  TODO 运营航班的航班计划实体类
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月20日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月20日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Entity
@Table(name="Scheduled_Flight")
public class ScheduledFlight extends Flight {

	private static final long serialVersionUID = 1L;

	/**
	 * @Description  机场数据的静态类，与机场相关的数据集合
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */

	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
	@JoinColumn(name="scheduled_Flight_id")
	protected Set<ScheduledFlight.BaggageMakeupPosition> baggageMakeupPositions;
	
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
	@JoinColumn(name="scheduled_Flight_id")
	protected Set<ScheduledFlight.BaggageReclaimCarousel> baggageReclaimCarousels;
	
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
	@JoinColumn(name="scheduled_Flight_id")
	protected Set<ScheduledFlight.Checkin> checkins;
	
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
	@JoinColumn(name="scheduled_Flight_id")
	protected Set<ScheduledFlight.Gate> gates;
	
	@Override
	public Set<com.airport.ais.models.aodb.flight.ScheduledFlight.BaggageMakeupPosition> getBaggageMakeupPositions() {
		if (baggageMakeupPositions == null){
			baggageMakeupPositions = new HashSet<ScheduledFlight.BaggageMakeupPosition>();
		}
		return this.baggageMakeupPositions;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setBaggageMakeupPositions(Set baggageMakeupPositions) {
		this.baggageMakeupPositions = baggageMakeupPositions;
	}	
	
	@Override
	public Set<com.airport.ais.models.aodb.flight.ScheduledFlight.BaggageReclaimCarousel> getBaggageReclaimCarousels() {
		if (baggageReclaimCarousels == null){
			baggageReclaimCarousels = new HashSet<ScheduledFlight.BaggageReclaimCarousel>();
		}
		return this.baggageReclaimCarousels;
	}

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setBaggageReclaimCarousels(Set baggageReclaimCarousels) {
		this.baggageReclaimCarousels = baggageReclaimCarousels;
	}	
	
	
	
	@Override
	public Set<com.airport.ais.models.aodb.flight.ScheduledFlight.Checkin> getCheckins() {
		if (checkins == null){
			checkins = new HashSet<ScheduledFlight.Checkin>();
		}
		return this.checkins;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setCheckins(Set checkins) {
		this.checkins = checkins;
	}	
	
	@Override
	public Set<com.airport.ais.models.aodb.flight.ScheduledFlight.Gate> getGates() {
		if (gates == null){
			gates = new HashSet<ScheduledFlight.Gate>();
		}
		return this.gates;
	}		
		
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setGates(Set gates) {
		this.gates = gates;
	}		
		@Entity
		@Table(name="Scheduled_BaggageMakeupPosition")
		public class BaggageMakeupPosition extends Flight.BaggageMakeupPosition{

			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="Scheduled_BaggageReclaimCarousel")
		public class BaggageReclaimCarousel extends Flight.BaggageReclaimCarousel{
			
			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="Scheduled_Checkin")
		public class Checkin extends Flight.Checkin{

			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="Scheduled_Gate")
		public class Gate extends Flight.Gate{

			private static final long serialVersionUID = 1L;
			
		}

		/**
		 * @Description  航班数据的静态类，与航班相关的数据
		 *---------------------------------------------------------------------------------------------------------------------------------------------------------------
		 */
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="scheduled_Flight_id")
		protected Set<ScheduledFlight.ShareFlight> shareFlights;
		
		@Override
		public Set<com.airport.ais.models.aodb.flight.ScheduledFlight.ShareFlight> getShareFlights() {
			if (shareFlights == null){
				shareFlights = new HashSet<ScheduledFlight.ShareFlight>();
			}
			return this.shareFlights;
		}
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void setShareFlights(Set shareFlights) {
			this.shareFlights = shareFlights;
		}					
		
		@Entity
		@Table(name="Scheduled_ShareFlight")
		public class ShareFlight extends  BasicFlight.ShareFlight{

			private static final long serialVersionUID = 1L;
			
		}
		
		


	
	/**
	 * @Description  航线数据的静态类，与航线数据相关的数据集合
	 * ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="scheduled_Flight_id")
		protected Set<ScheduledFlight.StopFlight> stopFlights;
				
		
		@Override
		public Set<com.airport.ais.models.aodb.flight.ScheduledFlight.StopFlight> getStopFlights() {
			if (stopFlights == null){
				stopFlights = new HashSet<ScheduledFlight.StopFlight>();
			}
			return this.stopFlights;
		}		
		

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void setStopFlights(Set stops) {
			this.stopFlights = stops;
		}		
		
		@Entity
		@Table(name="Scheduled_StopFlight")
		public  class StopFlight extends BasicFlight.StopFlight{
			
			private static final long serialVersionUID = 1L;
			
		}

	/**
	 * @Description  航班载量的静态类，与载量相关的所有数据的集合
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
	 */

		
		/**
		 * @Description  航班载量的静态类，与载量相关的所有数据的集合
		 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
		 */

			@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
			@JoinColumn(name="scheduled_Flight_id")
			protected Set<ScheduledFlight.LoadFlight> loads;
			
			@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
			@JoinColumn(name="scheduled_Flight_id")
			protected Set<ScheduledFlight.Passenger>  passengers;
			
			@Override
			public Set<com.airport.ais.models.aodb.flight.ScheduledFlight.LoadFlight> getLoads() {
				if (loads == null){
					loads = new HashSet<ScheduledFlight.LoadFlight>();
				}
				return this.loads;
			}

			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void setLoads(Set loads) {
				this.loads = loads;
			}		

			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public void setPassengers(Set passengers) {
				this.passengers = passengers;
			}		
					
			@Override
			public Set<com.airport.ais.models.aodb.flight.ScheduledFlight.Passenger> getPassengers() {
				if (passengers == null){
					passengers = new HashSet<ScheduledFlight.Passenger>();
				}
				return this.passengers;
			}
			
			@SuppressWarnings("serial")
			@Entity
			@Table(name="Scheduled_LoadFlight")
			public class LoadFlight extends Flight.LoadFlight{

				@ManyToOne
				@JoinColumn(name="scheduled_Flight_id")
				private ScheduledFlight flight;
				
				@Override
				public Flight getFlight() {
					return flight;
				}

				@Override
				public void setFlight(Flight flight) {
					this.flight = (ScheduledFlight) flight;
				}							
				
			}
			
			@SuppressWarnings("serial")
			@Entity
			@Table(name="Scheduled_Passenger")
			public class Passenger extends Flight.Passenger{
				
	}		
		

	
		
		
		
	
}
