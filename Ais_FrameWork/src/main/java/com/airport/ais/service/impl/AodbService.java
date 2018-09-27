package com.airport.ais.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.airport.ais.dao.impl.AodbDaoImpl;
import com.airport.ais.service.IAodbService;

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
public class AodbService<K, E> extends Service<K, E> implements IAodbService<K, E>{
	
	@EJB
	public void setAodbDAO(AodbDaoImpl<K, E> daoImpl){
		setDao(daoImpl);
	}
	
}
