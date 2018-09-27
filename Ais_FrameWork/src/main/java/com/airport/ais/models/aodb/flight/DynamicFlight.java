package com.airport.ais.models.aodb.flight;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * FileName      DynamicFlight.java
 * @Description  TODO 运营航班的动态实体类，主要是定义各中航班相关的实体表
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月20日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月20日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Entity
@Table(name="Dynamic_Flight")
public  class DynamicFlight extends Flight {

	private static final long serialVersionUID = 1L;
	
	
	public final  static String[] searchParams ={FLIGHTDIRECTION,SECTOR,LOCALAIRPOT,AIRLINE,FLIGHTNUMBER,FLIGHTCLASSIFICATION,
			FLIGHTCODE,FLIGHTSTATUS,DEPARTUREAIRPORT,ARRIVALAIRPORT};
	
	

	/**
	 * @Description  机场数据的静态类，与机场相关的数据集合
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */

	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
	@JoinColumn(name="dynamicFlight_id")
	protected  Set<DynamicFlight.BaggageReclaimCarousel> baggageReclaimCarousels;
	
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
	@JoinColumn(name="dynamicFlight_id")
	protected  Set<DynamicFlight.BaggageMakeupPosition> baggageMakeupPositions;
	
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
	@JoinColumn(name="dynamicFlight_id")
	protected  Set<DynamicFlight.Checkin> checkins;
	
	@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
	@JoinColumn(name="dynamicFlight_id")
	protected  Set<DynamicFlight.Gate> gates;
	
	@Override
	public Set<DynamicFlight.Checkin> getCheckins() {
		if (checkins == null){
			checkins = new HashSet<DynamicFlight.Checkin>();
		}
		
		return checkins;
	}

	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setCheckins(Set checkins) {
		this.checkins = checkins;
	}



	@Override
	public Set<DynamicFlight.Gate> getGates() {
		if (gates == null){
			gates = new HashSet<DynamicFlight.Gate>();
		}
		return gates;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setGates(Set gates) {
		this.gates = gates;
	}	
	
	@Override
	public Set<DynamicFlight.BaggageReclaimCarousel> getBaggageReclaimCarousels() {
		if (baggageReclaimCarousels == null){
			baggageReclaimCarousels = new HashSet<DynamicFlight.BaggageReclaimCarousel>();
		}
		return baggageReclaimCarousels;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setBaggageReclaimCarousels(Set baggageReclaimCarousels) {
		this.baggageReclaimCarousels = baggageReclaimCarousels;
	}	
	
	@Override
	public Set<DynamicFlight.BaggageMakeupPosition> getBaggageMakeupPositions() {
		if (baggageMakeupPositions == null){
			baggageMakeupPositions = new HashSet<DynamicFlight.BaggageMakeupPosition>();
		}
		return baggageMakeupPositions;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void setBaggageMakeupPositions(Set baggageMakeupPositions) {
		this.baggageMakeupPositions = baggageMakeupPositions;
	}	
	
		@Entity
		@Table(name="Dynamic_BaggageMakeupPosition")
		public static class BaggageMakeupPosition extends Flight.BaggageMakeupPosition{

			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="Dynamic_BaggageReclaimCarousel")
		public static class BaggageReclaimCarousel extends Flight.BaggageReclaimCarousel{
			
			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="Dynamic_Checkin")
		public static class Checkin extends Flight.Checkin{

			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="Dynamic_Gate")
		public static class Gate extends Flight.Gate{

			private static final long serialVersionUID = 1L;
		}

		

		

	/**
	 * @Description  航班数据的静态类，与航班相关的数据
	 *---------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */
	
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="dynamicFlight_id")
		protected   Set<DynamicFlight.ShareFlight> shareFlights;

		@Override
		public Set<DynamicFlight.ShareFlight> getShareFlights() {
			if (shareFlights == null){
				shareFlights = new HashSet<DynamicFlight.ShareFlight>();
			}
			return shareFlights;
		}
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void setShareFlights(Set shareFlights) {
			this.shareFlights = shareFlights;
		}	
		
		@Entity
		@Table(name="Dynamic_ShareFlight")
		public static class ShareFlight extends  BasicFlight.ShareFlight{

			private static final long serialVersionUID = 1L;
			
		}

		
	
	
	/**
	 * @Description  航线数据的静态类，与航线数据相关的数据集合
	 * ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 */

		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="dynamicFlight_id")
		protected  Set<DynamicFlight.StopFlight> stopFlights;
		
		@Override
		public Set<DynamicFlight.StopFlight> getStopFlights() {
			if (stopFlights == null){
				stopFlights = new LinkedHashSet<DynamicFlight.StopFlight>();
			}else{
				/*
				 * 进行排序，用冒泡排序法
				 */
				
				StopFlight[] sortStopFlights = stopFlights.toArray(new StopFlight[stopFlights.size()]);
				for(int i =0;i<sortStopFlights.length-1;i++) {
		            for(int j=0;j<sortStopFlights.length-i-1;j++) {//-1为了防止溢出
		                if(sortStopFlights[j].getOrderCode()>sortStopFlights[j+1].getOrderCode()) {
		                	StopFlight temp = sortStopFlights[j];
		                    sortStopFlights[j]=sortStopFlights[j+1];
		                    sortStopFlights[j+1]=temp;
		                }
		            }    
		        }
				stopFlights = new LinkedHashSet<DynamicFlight.StopFlight>();
				for(StopFlight stopFlight:sortStopFlights){
					stopFlights.add(stopFlight);
				}
			}
			return stopFlights;
		}

		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void setStopFlights(Set stops) {
			this.stopFlights = stops;
		}		
		
		@Entity
		@Table(name="Dynamic_StopFlight")
		public static class StopFlight extends BasicFlight.StopFlight{
			
			private static final long serialVersionUID = 1L;
			
		}

	/**
	 * @Description  航班载量的静态类，与载量相关的所有数据的集合
	 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
	 */

		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="dynamicFlight_id")
		protected  Set<DynamicFlight.LoadFlight> loads;
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="dynamicFlight_id")
		protected  Set<DynamicFlight.Passenger>  passengers;
		
		
		@Override
		public Set<DynamicFlight.LoadFlight> getLoads() {
			if (loads == null){
				loads = new HashSet<DynamicFlight.LoadFlight>();
			}
			return loads;
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void setLoads(Set loads) {
			this.loads = loads;
		}		
		
		@Override
		public Set<DynamicFlight.Passenger> getPassengers() {
			if (passengers == null){
				passengers = new HashSet<DynamicFlight.Passenger>();
			}
			return passengers;
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void setPassengers(Set passengers) {
			this.passengers = passengers;
		}		
		
		@SuppressWarnings("serial")
		@Entity
		@Table(name="Dynamic_LoadFlight")
		public static class LoadFlight extends Flight.LoadFlight{

			@ManyToOne
			@JoinColumn(name="dynamicFlight_id")
			private DynamicFlight flight;
			
			@Override
			public Flight getFlight() {
				return flight;
			}

			@Override
			public void setFlight(Flight flight) {
				this.flight = (DynamicFlight) flight;
			}			
			
		}
		
		@Entity
		@SuppressWarnings("serial")
		@Table(name="Dynamic_EnsureService")
		public static class EnsureService  extends Flight.EnsureService {
			@ManyToOne
			@JoinColumn(name="dynamicFlight_id")
			private DynamicFlight flight;
			
			@Override
			public Flight getFlight() {
				return flight;
			}

			@Override
			public void setFlight(Flight flight) {
				this.flight = (DynamicFlight) flight;
			}			
		}
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="dynamicFlight_id")
		protected Set<Charge> charges;
		
		
		@Entity
		@SuppressWarnings("serial")
		@Table(name="Dynamic_Charge")
		public static class Charge  extends Flight.Charge {
			@ManyToOne
			@JoinColumn(name="dynamicFlight_id")
			private DynamicFlight flight;

			public DynamicFlight getFlight() {
				return flight;
			}

			public void setFlight(DynamicFlight flight) {
				this.flight = flight;
			}
			
		}		
		
		
		
		
		public Set<Charge> getCharges() {
			if (charges == null){
				charges = new HashSet<Charge>();
			}
			return charges;
		}



		public void setCharges(Set<Charge> charges) {
			this.charges = charges;
		}

		@Entity
		@Table(name="Dynamic_Passager")
		public static class Passenger extends Flight.Passenger{
			private static final long serialVersionUID = 1L;
			
		}
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="dynamicFlight_id")
		protected Set<EnsureService> ensuerServces;
		
		
		

		public Set<EnsureService> getEnsuerServces() {
			if (ensuerServces == null){
				ensuerServces = new HashSet<EnsureService>();
			}
			return ensuerServces;
		}



		public void setEnsuerServces(Set<EnsureService> ensuerServces) {
			this.ensuerServces = ensuerServces;
		}

		
		
		
		
		
		
}
