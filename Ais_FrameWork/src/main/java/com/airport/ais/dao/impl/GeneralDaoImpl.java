package com.airport.ais.dao.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * 
 * 
 * FileName      GeneralDaoImpl.java
 * @Description  TODO  
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��26��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��26��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Stateless
public class GeneralDaoImpl<K, E> extends DaoImpl<K, E> {
	
	@PersistenceContext(unitName="AisGeneralDS",type=PersistenceContextType.TRANSACTION)
	private EntityManager generalEm;

	@PostConstruct 
	@Override
	public void initCriteriaVariable() {
		em = this.generalEm;
		metamodel = em.getMetamodel();
		cb        = em.getCriteriaBuilder();
	}

}
