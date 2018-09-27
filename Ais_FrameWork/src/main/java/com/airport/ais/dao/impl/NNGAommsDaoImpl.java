package com.airport.ais.dao.impl;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * 
 * 
 * FileName      NNGAommsDaoImpl.java
 * @Description  TODO ���������ط�ϵͳ��DAO��ӿ�ʵ�ֻ��࣬ �����ݿ�DAO������ʵ���඼�̳���
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��10��19��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��10��19��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */


@Stateless
public class NNGAommsDaoImpl<K,E> extends DaoImpl<K, E> {
	@PersistenceContext(unitName="nngAommsDS",type=PersistenceContextType.TRANSACTION)
	private EntityManager nngAodbEm;

	@PostConstruct 
	@Override
	public void initCriteriaVariable() {
		em        = nngAodbEm;
		metamodel = em.getMetamodel();
		cb        = em.getCriteriaBuilder();
	}

}
