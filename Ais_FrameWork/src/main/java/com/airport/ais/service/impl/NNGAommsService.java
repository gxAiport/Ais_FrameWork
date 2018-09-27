package com.airport.ais.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.airport.ais.dao.impl.NNGAommsDaoImpl;
import com.airport.ais.service.INNGAommsService;

/**
 * 
 * 
 * FileName      NNGAommsService.java
 * @Description  TODO ���������ط�ϵͳ��Service
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��10��19��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��10��19��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Stateless
public class NNGAommsService<K, E> extends Service<K, E> implements INNGAommsService<K, E> {

	@EJB
	public void setNNGAommsDAO(NNGAommsDaoImpl<K, E> daoImpl){
		setDao(daoImpl);
	}
	
}
