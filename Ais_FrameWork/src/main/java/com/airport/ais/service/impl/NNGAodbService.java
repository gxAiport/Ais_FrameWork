package com.airport.ais.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.airport.ais.dao.impl.NNGAodbDaoImpl;
import com.airport.ais.service.INNGAodbService;

/**
 * 
 * 
 * FileName      AODBService.java
 * @Description  TODO 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月24日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月24日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Stateless
public class NNGAodbService<K, E> extends Service<K, E> implements INNGAodbService<K, E>{
	
	@EJB
	public void setAodbDAO(NNGAodbDaoImpl<K, E> daoImpl){
		setDao(daoImpl);
	}
	
}
