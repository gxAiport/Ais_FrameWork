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
 * @Description  AODB��Ӫ���ݿ�DAO��ӿ�ʵ�ֻ��࣬ �����ݿ�DAO������ʵ���඼�̳���
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��22��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��22��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Stateless
public class AodbDaoImpl<K, E> extends DaoImpl<K, E> {
	
	@PersistenceContext(unitName="AisAodbDS",type=PersistenceContextType.TRANSACTION)
	private EntityManager aodbEm;

	@PostConstruct 
	@Override
	public void initCriteriaVariable() {
		em        = aodbEm;
		metamodel = em.getMetamodel();
		cb        = em.getCriteriaBuilder();
	}





}
