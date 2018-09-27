package com.airport.ais.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import com.airport.ais.dao.impl.GeneralDaoImpl;
import com.airport.ais.service.IGeneralService;

/**
 * 
 * FileName      GeneralService.java
 * @Description  TODO 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月26日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月26日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Stateless
public class GeneralService<K, E> extends Service<K, E> implements IGeneralService<K, E> {

	
	
	@EJB
	public void setGeneralDao(GeneralDaoImpl<K, E> daoImpl) {
		// TODO Auto-generated method stub
		setDao(daoImpl);
	}

	

}
