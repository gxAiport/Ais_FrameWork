package com.airport.ais.dao.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;


/**
 * 
 * 
 * FileName      AodbDaoImpl.java
 * @Description  桂林AODB运营数据库DAO层接口实现基类， 该数据库DAO层所有实现类都继承它
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月22日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Stateless
public class KwlFidsDaoImpl<K, E> extends DaoImpl<K, E> {
	
	@PersistenceContext(unitName="kwlFidsDS",type=PersistenceContextType.TRANSACTION)
	private EntityManager kwlFidsEm;

	@PostConstruct 
	@Override
	public void initCriteriaVariable() {
		em        = kwlFidsEm;
		metamodel = em.getMetamodel();
		cb        = em.getCriteriaBuilder();
	}





}
