package com.airport.ais.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.airport.ais.dao.impl.NNGAommsDaoImpl;
import com.airport.ais.service.INNGAommsService;

/**
 * 
 * 
 * FileName      NNGAommsService.java
 * @Description  TODO 南宁机场地服系统的Service
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年10月19日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年10月19日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Stateless
public class NNGAommsService<K, E> extends Service<K, E> implements INNGAommsService<K, E> {

	@EJB
	public void setNNGAommsDAO(NNGAommsDaoImpl<K, E> daoImpl){
		setDao(daoImpl);
	}
	
}
