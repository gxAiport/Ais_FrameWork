package com.airport.ais.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.airport.ais.dao.impl.KwlAodbDaoImpl;
import com.airport.ais.service.IKwlAodbService;

/**
 * 
 * 
 * FileName      AODBService.java
 * @Description  TODO 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��24��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��24��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Stateless
public class KwlAodbService<K, E> extends Service<K, E> implements IKwlAodbService<K, E>{
	
	@EJB
	public void setAodbDAO(KwlAodbDaoImpl<K, E> daoImpl){
		setDao(daoImpl);
	}
	
}
