package com.airport.ais.dao.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.FetchParent;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.Attribute.PersistentAttributeType;
import com.airport.ais.dao.IDao;
import com.airport.ais.dao.parameter.AggregationColumnField;
import com.airport.ais.dao.parameter.ColumnField;
import com.airport.ais.dao.parameter.ExpressionUtil;
import com.airport.ais.dao.parameter.GroupField;
import com.airport.ais.dao.parameter.QueryCondition;
import com.airport.ais.dao.parameter.QueryOrder;
import com.airport.ais.enums.QuerySortMode;
import com.airport.ais.models.DefaultEntity;
import com.airport.ais.utils.ObjectMethodUtil;


/**
 * 
 * 
 * FileName      DaoImpl.java
 * @Description  TODO ͨ�õ�DAO��ӿڳ����࣬ʵ�ָ���ͨ�õĲ������ݿ�ķ���
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��23��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��23��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Stateless
@SuppressWarnings("unchecked")
public abstract class DaoImpl<K,E> implements IDao<K, E> {
	

	/**
	 * ʵ������������ڲ���ʵ��
	 */
	protected EntityManager em;
	/**
	 *  Ԫģ����EM��ȡ
	 */
	protected Metamodel metamodel;
	/**
	 *  Criteria�����ߣ���EM��ȡ
	 */
	protected CriteriaBuilder cb;

	/**
	 *    ��ʼ��Criteria�ؼ��Ķ���
	 *    ��ֵEM,��ȡMetamodel��CriteriaBuilder��
	 *    
	 */	
	public abstract void initCriteriaVariable();

	
	
	/**
	 * ��Ԫģ�͵������滻�������ʽ�е�ʵ�����Եľ�̬�ַ���
	 * @param root       JPA�е�root�������ڽ���Ӧ�����Ա�ΪJPA��ʶ��ı��ʽ
	 * @param clazz      ��Ҫ������CLASS����      
	 * @param expression ��Ҫ�滻�ı��ʽ             
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	protected void replaceExpressionToMetamodel(Root root,Class clazz,Object[] expression) throws Exception{
		
		/*
		 *   ��ȡCLAZZ���е�Ԫģʽ����
		 */
		Set<Attribute> attributes = metamodel.managedType(clazz).getAttributes();
		for(Attribute attribute:attributes){
			
//			if (attribute.getPersistentAttributeType().equals(Attribute.PersistentAttributeType.EMBEDDED)){
//				/*
//				 * ���ֶε�JPA������EMBEDDED��˵�����ֶ�Ϊһ�����󣬵ݹ���÷�����������滻
//				 */
//				replaceExpressionToMetamodel(root, attribute.getJavaType(),expression);
//			}
			/*
			 * ����Expression���ʽ����������ͬ���ֶΣ��������滻
			 */
			for (int i=0;(expression != null)&&(i<expression.length);i++){
				if (attribute.getName().equals(expression[i])){
					expression[i] = root.get((SingularAttribute) attribute);
					/*
					 *   ���Value���ַ����ͣ�����Ӧ���ֶ���ö�٣�����ö�����͵�fromValue��������ת��
					 *   
					 */
					
					if (Enum.class.isAssignableFrom(attribute.getJavaType()) && i+2 <= expression.length && expression[i+2] instanceof String){
						Method method = attribute.getJavaType().getDeclaredMethod("fromValue", String.class);
						expression[i+2] = method.invoke(attribute.getJavaType(),expression[i+2]);
					}
					
					/*
					 * ����ֶ�ΪManyToOne���Ҵ����Value(expression[i+2])���ַ�������ö����
					 * ����в����滻
					 */
					if (attribute.getPersistentAttributeType().equals(Attribute.PersistentAttributeType.MANY_TO_ONE) 
							&& i+2 <= expression.length&&(expression[i+2] instanceof String || expression[i+2] instanceof Enum)){
						/*
						 *   ���Value���ַ����ͣ�����Ӧ��ʵ���ID��ö�٣�����ö�����͵�fromValue��������ת��
						 *   
						 */
						Class entityClass = attribute.getJavaType();
						CriteriaQuery cq = cb.createQuery(entityClass);
						Root entityRoot  =  cq.from(entityClass);
						Class<?> idType = entityRoot.getModel().getIdType().getJavaType();
						if (Enum.class.isAssignableFrom(idType) && expression[i+2] instanceof String){
							Method method = idType.getDeclaredMethod("fromValue", String.class);
							expression[i+2] = method.invoke(idType,expression[i+2]);
						}
						/*
						 *   ����findById���в��Ҷ�Ӧ��entity �����滻expression�ж�Ӧ����ֵ
						 */
						expression[i+2] = findById(expression[i+2], attribute.getJavaType());

					}
				}
			}
		}
	}
	
	
	
	/**
	 * ��Ԫģ�͵������滻������ʽ�е�ʵ�����Եľ�̬�ַ���
	 * @param root          JPA�е�root�������ڽ���Ӧ�����Ա�ΪJPA��ʶ��ı��ʽ
	 * @param clazz         ��Ҫ������CLASS����      
	 * @param queryOrders   ��Ҫ�滻�ı��ʽ  
	 */
	@SuppressWarnings("rawtypes")
	protected List<Order>  replaceOrderToMetamodel(Root<E> root,Class clazz,QueryOrder[] queryOrders){
		/*
		 *   ��ȡCLAZZ���е�Ԫģʽ����
		 */
		List<Order> orders = new ArrayList<Order>();
		Set<Attribute> attributes = metamodel.managedType(clazz).getAttributes();
		for(Attribute attribute:attributes){
			if (attribute.getPersistentAttributeType().equals(Attribute.PersistentAttributeType.EMBEDDED)){
				/*
				 * ���ֶε�JPA������EMBEDDED��˵�����ֶ�Ϊһ�����󣬵ݹ���÷�����������滻
				 */
				orders.addAll(replaceOrderToMetamodel(root, attribute.getJavaType(), queryOrders));
			}
			/*
			 * ����Expression���ʽ����������ͬ���ֶΣ��������滻
			 */
			for (int i=0;(queryOrders != null)&&(i< queryOrders.length);i++){

				if (attribute.getName().equals(queryOrders[i].getName())){
					if (queryOrders[i].getQuerySortMode().equals(QuerySortMode.ASC)) {
						orders.add(cb.asc(root.get((SingularAttribute) attribute)));
					}else{
						orders.add(cb.desc(root.get((SingularAttribute) attribute)));
					}

				}
			}
		}
		return orders;
	}
	
	
	
	/**
	 * ��ʵ������һ�Զ�Ͷ��һ������LeftJion�ķ�ʽ����
	 * @param fetchParent Fetch�ĸ������
	 * @param clazz ��Ҫ����ʵ����������
	 */
	
	@SuppressWarnings("rawtypes")
	private void fetchEntity(FetchParent fetchParent,Class clazz,String manyToOne,String ontToMany){
		
		Set<Attribute> attributes = metamodel.managedType(clazz).getAttributes();
		 
		 for (Attribute attribute:attributes){
			 
			switch (attribute.getPersistentAttributeType()) {
			 	
				case MANY_TO_ONE:
					if (manyToOne.equals("ALL")||manyToOne.indexOf(attribute.getName())!=-1){
						
						fetchParent.fetch((SingularAttribute)attribute,JoinType.LEFT);
					}
					break;
				case ONE_TO_MANY:
					if  (ontToMany.equals("ALL")||ontToMany.indexOf(attribute.getName())!= -1){
						fetchParent.fetch((SetAttribute)attribute,JoinType.LEFT);
					}
					break;
			default:
				break;
			}
		 }

	}	
	
	
	/**
	 * ����ѯ�ֶ�ת����JPA��ʽ��Selection����
	 * @param root
	 * @param clazz
	 * @param fields
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private List<Selection<?>> convertSelect(Root root,Class clazz ,String[] fields){
		List<Selection<?>> selections   = new ArrayList<Selection<?>>() ;
		Set<Attribute> attributes = metamodel.managedType(clazz).getAttributes();
		for (String field:fields){
			 for (Attribute attribute:attributes){
				 if (attribute.getName().equals(field)){
					 switch (attribute.getPersistentAttributeType()) {
					 	
						case MANY_TO_ONE:
						case ONE_TO_MANY:
							selections.add(root.join(field,JoinType.LEFT));
							break;
						default:
							selections.add(root.get(field));
							break;
					 }
				 }				 
			 }
		
		}
		return selections;
  }
	
		
	/**
	 * ��Object����ת���ɶ�Ӧ��ʵ����
	 * @param tq
	 * @param clazz
	 * @param fields
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	private List<E>  convertEntity(TypedQuery tq,Class<E> clazz,String[] fields) throws Exception{
		List<E> entityList = new ArrayList<E>();
		Set<Attribute<? super E, ?>> attributes = metamodel.managedType(clazz).getAttributes();
		List<Object[]> objsList = tq.getResultList();
		for (Object[] objs:objsList){
			E entity = null;
			for (E iterator:entityList){
				DefaultEntity defaultEntity = (DefaultEntity) iterator;
				if (defaultEntity.getIdValue().equals(objs[0])){
					entity = iterator;
					break;
				}
			}
			if (entity == null){
				entity =  clazz.newInstance();
				entityList.add(entity);
			}
			for(int i =0;i<fields.length;i++){
				for (Attribute attribute:attributes){
					 if (attribute.getName().equals(fields[i]) && (objs[i] != null)){
						 if  (PersistentAttributeType.ONE_TO_MANY.equals(attribute.getPersistentAttributeType())){
							 /**
							  * �����һ�Զ������,ȡ�ü��Ϻ����add���
							  */
							 Object set = ObjectMethodUtil.getFieldObject(entity, fields[i],false);
							 ObjectMethodUtil.setFieldObject(set, "add", objs[i], Object.class,true);
						 }else {
							ObjectMethodUtil.setFieldObject(entity, fields[i], objs[i], objs[i].getClass(),false);
						}
					 }
				}
			}
		
		}
		return entityList;
		
	}
	
	
	
	
	
	/**
	 * �Ը�����������ѯ����TypedQuery�Ķ����ṩ�����������Ի�ȡ���Ľ��
	 * @param condition ���������� 
	 * @return TypedQuery����
	 * @throws Exception 
	 */
	
	@SuppressWarnings("rawtypes")
	private TypedQuery<E> findByCondition(QueryCondition condition,Class<E> clazz) throws Exception{
		/*
		 * �ж��Ƿ��ѡ�ֶα�־
		 */
		boolean isMultiselect = false;
		if (condition.getSelectFields() != null && condition.getSelectFields().length > 0){
			isMultiselect = true;
		}
		CriteriaQuery cq = null;
		
		
		
		if (isMultiselect){
			/*
			 * �����ָ���ֶΣ����������Ƕ�������
			 */
			cq = cb.createQuery(Object[].class);
		}else{
			/*
			 * ���򷵻�������ʵ����
			 */
			cq = cb.createQuery(clazz);
		}
		
		
		
		Root<E> root=  cq.from(clazz);
		List<Order> orders = replaceOrderToMetamodel(root, clazz, condition.getOrders());
		
		cq.orderBy(orders);
		cq.distinct(true);
		if (isMultiselect){
			cq.multiselect(convertSelect(root, clazz, condition.getSelectFields()));
		}else{
			fetchEntity(root, clazz,condition.getFetchManyToOne(),condition.getFetchOneToMany());
		}
		
		/*
		 *   �ϳ�Where���ʽ 
		 */
		if (condition.getExpression() != null){
			replaceExpressionToMetamodel(root, clazz, condition.getExpression());
			try {
				Predicate predicate = new ExpressionUtil(cb).composeExpression(condition.getExpression());
				cq.where(predicate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (condition.getFirst() != null && condition.getMax() != null  && condition.getMax() != 0){
			return  em.createQuery(cq).
					setMaxResults(condition.getMax()).
					setFirstResult(condition.getFirst());
		}else{
			return em.createQuery(cq);
		}
	}
	

	/**
	 * 
	 * @Description: ���ط��������ļ�¼����
	 * @param conditions ����
	 * @return ���ϵ�ʵ������
	 * @throws Exception 
	 */
	private int CountByCondition(QueryCondition condition,Class<E> clazz) throws Exception{
		
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<E> root=  cq.from(clazz);
		
		replaceExpressionToMetamodel(root, clazz, condition.getExpression());
		
		if (condition.getExpression() != null){
			try {
				Predicate predicate = new ExpressionUtil(cb).composeExpression(condition.getExpression());
				cq.where(predicate);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		cq.select(cb.countDistinct(root));
		return  em.createQuery(cq).getSingleResult().intValue();
		
	}
	

	/**
	 * 
	 * @Description: TODO(������һ�仰�����������������)
	 * @param cb
	 * @param javaType
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Expression getsubExpression(CriteriaBuilder cb,Class javaType,Root root,Object attributeName,SetAttribute setAttribute,List<Join> joins){

		try {
			CriteriaQuery cq = cb.createQuery(javaType);
			Root subroot;			
			subroot = cq.from(javaType);
			boolean foundJoin =false;
			Join setJoin = null;
			//��ȡԪģ�ͼ�ȡ��Ԫģ������Ӧ����������
			EntityType entityType = subroot.getModel();
			Set<Attribute> attributes = entityType.getAttributes();
			for(Attribute attribute:attributes){
				if (attribute.getName().equals(attributeName)){
					for (Join join:joins){
						if (javaType.equals(join.getModel().getBindableJavaType())){
							foundJoin = true;
							setJoin = join;
						}
					}
					if (!foundJoin){ 
						setJoin =root.join(setAttribute,JoinType.INNER);
						joins.add(setJoin);
					}
					return setJoin.get((SingularAttribute) attribute);
				}
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			/**
			 *  ������Ͳ���ʵ���࣬���ؿ�
			 */
			return null;
		}

		return null;
		
	}
	
	
	
	/**
	 * 
	 * @Description: ��������������ʹ���
	 * @param condition ����
	 * @return ���ղ�ѯ��TypedQuery�Ķ���
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	private TypedQuery<Tuple> AggregationByCondition(QueryCondition condition,Class<E> clazz) throws Exception{
		
		List<Order> orders = new ArrayList<Order>();
		CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);
		Root<E> root=  cq.from(clazz);
		
		
		
		
		EntityType<E> entityType = root.getModel();
		ExpressionUtil expresstionUtil = new ExpressionUtil(cb);
		List<Join> joins = new ArrayList<Join>();
		
		Set<Attribute<? super E, ?>> attributes=entityType.getAttributes();
		for(Attribute attribute:attributes){
		//��Ԫģ�͵������滻�������ʽ�е�ʵ�����Եľ�̬�ַ���
			for (int i=0;(condition.getExpression() != null)&&(i<condition.getExpression().length);i++){
				if (attribute.getName().equals(condition.getExpression()[i])){
					condition.getExpression()[i] = root.get((SingularAttribute) attribute);
				}else if (attribute instanceof SetAttribute){
					Class javaType = ((SetAttribute)attribute).getBindableJavaType();
					Expression expression = getsubExpression(cb, javaType,root,condition.getExpression()[i],(SetAttribute) attribute,joins);
					if (expression != null){
						condition.getExpression()[i] = expression;
					}					
				}
			}
			
			
			//��Ԫģ�͵������������ֶεľ�̬�ַ���
			for (AggregationColumnField field:condition.getAggregationFields()){
				for(int i=0;(field.getExpression() != null)&&(i<field.getExpression().length);i++){
					if (attribute.getName().equals(field.getExpression()[i])){
						field.getExpression()[i] = root.get((SingularAttribute) attribute);
					}else if (attribute instanceof SetAttribute){
						Class javaType = ((SetAttribute)attribute).getBindableJavaType();
						Expression expression = getsubExpression(cb, javaType,root,field.getExpression()[i],(SetAttribute) attribute,joins);
						if (expression != null){
							field.getExpression()[i] = expression;
						}
					}
			}
				
			for(int i=0;(field.getWhenCondition() != null)&&(i<field.getWhenCondition().length);i++){
					if (attribute.getName().equals(field.getWhenCondition()[i])){
						field.getWhenCondition()[i] = root.get((SingularAttribute) attribute);
					}else if (attribute instanceof SetAttribute){
						Class javaType = ((SetAttribute)attribute).getBindableJavaType();
						Expression expression = getsubExpression(cb, javaType,root,field.getWhenCondition()[i],(SetAttribute) attribute,joins);
						if (expression != null){
							field.getWhenCondition()[i] = expression;
						}
					}
				}
			}
			//��Ԫģ��������������ֶεľ�̬�ַ���
			if (condition.getGroupFields() != null){
				for (GroupField field:condition.getGroupFields()){
					if (attribute.getName().equals(field.getExpression())){

						field.setExpression( root.get((SingularAttribute) attribute));
					}else if (attribute instanceof SetAttribute){
						Class javaType = ((SetAttribute)attribute).getBindableJavaType();
						Expression expression = getsubExpression(cb, javaType,root,field.getExpression(),(SetAttribute) attribute,joins);
						if (expression != null){
							field.setExpression(expression);
						}						
					}
				}
			}
			
			for (int i=0;(condition.getOrders() != null)&&(i< condition.getOrders().length);i++){

				if (attribute.getName().equals(condition.getOrders()[i].getName())){
					if (condition.getOrders()[i].getQuerySortMode().equals(QuerySortMode.ASC)) {
						orders.add(cb.asc(root.get((SingularAttribute<? super E, ?>) attribute)));
					}else{
						orders.add(cb.desc(root.get((SingularAttribute<? super E, ?>) attribute)));
					}

				}
			}
			

		}
		
		
		
		if (condition.getExpression() != null){
			try {
				Predicate predicate = expresstionUtil.composeExpression(condition.getExpression());
				cq.where(predicate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		List<Selection<?>> selections = new ArrayList<Selection<?>>();
		
		for (AggregationColumnField field:condition.getAggregationFields()){
			
			Expression expression = expresstionUtil.composeExpression(field.getExpression());
			
			if (field.getWhenCondition() != null){
				Predicate predicate = expresstionUtil.composeExpression(field.getWhenCondition());
				expression = cb.selectCase().when(predicate, expression).otherwise(0);
			}
			
			switch (field.getAggregationType()) {
			case Sum:
				selections.add(cb.sum(expression).alias(field.getAlias()));
				break;
			case Avg:
				selections.add(cb.avg(expression).alias(field.getAlias()));
				break;
			case Count:
				selections.add(cb.count(expression).alias(field.getAlias()));
				break;
			case None:
				selections.add(expression.alias(field.getAlias()));
				break;
			}
		}
		
		
		
		List<Expression<?>>  expressions = new ArrayList<Expression<?>>() ;
		if (condition.getGroupFields() != null){
			for (GroupField field:condition.getGroupFields()){

				Expression expression=  (Expression) field.getExpression();
			
				if (field.getQueryGroupDate() != null){
					expression = expresstionUtil.getYMDExpression(field.getQueryGroupDate(), expression);
				}
				expressions.add(expression);
				selections.add(expression.alias(field.getAlias()));
			}
		}
		//�����ֶη���cq��
		cq.groupBy(expressions);
		cq.orderBy(orders);
		
		
		cq.multiselect(selections);
		return em.createQuery(cq);
		
	}
		
	
	

	/** 
	* ͨ�����췽��ָ��DAO�ľ���ʵ���� 
	*/

	public DaoImpl() {
	     
		
	}
	


	
	/**
	 * ����ʵ��
	 */
	@Override
	public E save(E entity) {
		entity = em.merge(entity);
		em.persist(entity);
		return (E) entity;
	
	}

	
	@Override
	public void remove(E entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	
	@Override
	public E update(E entity) {
		return em.merge(entity);
	}

	
	@Override
	public E findById(Object id,Class<E> clazz) throws Exception {
		// TODO Auto-generated method stub
		
		
		return em.find(clazz, id);
		
	}

	
	@Override
	public List<E> getAll(Class<E> clazz) throws Exception {
		// TODO Auto-generated method stub
		QueryCondition conditions = new QueryCondition();
		return findByCondition(conditions,clazz).getResultList();
	}



	@Override
	public List<E> findByFieldAll(String field, Object value,Class<E> clazz) throws Exception {
		
		QueryCondition conditions = new QueryCondition();
		conditions.setExpression(new Object[]{field,"=",value});
		return findByCondition(conditions,clazz).getResultList();
	}

	@Override
	public E findByFieldSingle(String field, Object value,Class<E> clazz) {
		QueryCondition conditions = new QueryCondition();
		conditions.setExpression(new Object[]{field,"=",value});
		try {
			return findByCondition(conditions,clazz).setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public E findByConditionSingle(QueryCondition conditions,Class<E> clazz) {

		try {
			return findByCondition(conditions,clazz).setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			/*
			 * ���û���ҵ���Ӧ��ʵ�壬���ؿ�ֵ
			 */
//			e.printStackTrace();
			return null;
		}
		
	}


	@Override
	public List<E> findByConditionAll(QueryCondition condition,Class<E> clazz) throws Exception {
		
		if (condition.getSelectFields() != null && condition.getSelectFields().length >0){
			return convertEntity(findByCondition(condition, clazz), clazz, condition.getSelectFields());
		}else{
			return findByCondition(condition, clazz).getResultList();
		}
		
	}

	@Override
	public int findCountByCondition(QueryCondition conditions,Class<E> clazz) throws Exception {
		return CountByCondition(conditions,clazz);
	}
	
	
	@Override
	public List<Map<String,Object>> findAggregationByCondition(QueryCondition conditions,Class<E> clazz) throws Exception{
		List<Tuple> tuples = AggregationByCondition(conditions,clazz).getResultList();
		List<Map<String,Object>> records = new ArrayList<Map<String,Object>>();
		Map<String, Object> record = null;
		for (Integer i=0; i < tuples.size();i++){
			
			record = new HashMap<String, Object>();
			record.put("id", i);
			for(ColumnField field:conditions.getAggregationFields()){
				record.put(field.getAlias(),tuples.get(i).get(field.getAlias()));
			}
			if (conditions.getGroupFields()!=null){
				for(GroupField field:conditions.getGroupFields()){
					
					if (tuples.get(i).get(field.getAlias()) != null){
						record.put(field.getAlias(),tuples.get(i).get(field.getAlias()).toString());	
					}else{
						record.put(field.getAlias(),null);	
					}
				}
			}
			if (conditions.getGroupFields() != null&&conditions.getGroupFields().size()>0){
				GroupField field = conditions.getGroupFields().get(0);
				Object rowValue = tuples.get(i).get(field.getAlias());
				if (rowValue != null&&!"".equals(rowValue)){
					records.add(record);
				}
			}else{
				records.add(record);
			}
		}
		return records;
	}



	@Override
	public int removeByCondition(QueryCondition condition, Class<E> clazz) throws Exception {
		    String   alias       = " "+clazz.getSimpleName().toLowerCase();
			String   jpql      = "delete from "+clazz.getSimpleName()+alias; 
			String[] fdNames   = new String[condition.getExpression().length/2];
			Object[] values    = new Object[condition.getExpression().length/2];  
			int      pamsCount = 0;
			/*
			 * ����������{flightNumber,=,CA1980,And,execDate,=,1979/09/06}
			 * ת��ΪJPQL�ַ���"flight.flightNumber=:flightNumber And flight.execDate=:execDate"
			 */
		    if (condition.getExpression() != null && condition.getExpression().length >=3){
		    	jpql += " where";
		    	int pos =1;
		    	for (Object pam:condition.getExpression()){
		    		if (pos > 3){
		    			pos = 0;
		    		}
		    		switch (pos % 4) {
					case 0:  /* AND OR */
					    jpql = jpql+" "+pam;
						break;
					case 1:/* �ֶ���*/
						jpql               = jpql+alias+"."+pam.toString();
						fdNames[pamsCount] = pam.toString()+pamsCount;
						break;
					case 2:  /* >= <= <> = */
 						jpql += pam;
						break;
					case 3:/* ���� */
						jpql              = jpql+":"+fdNames[pamsCount];
						values[pamsCount] = pam;
						pamsCount         = pamsCount+1;
						break;
					}
		    		pos++;
		    	}
		    }
		    Query query = em.createQuery(jpql);
		    /*
		     * ����ֵ����Query�Ĳ�����
		     */
		    for(int i=0;i<pamsCount;i++){
		    	if (values[i] instanceof Date) {
				    query.setParameter(fdNames[i], values[i]);
				}else{
			    	query.setParameter(fdNames[i], values[i]);
				}
		    }
		   return query.executeUpdate();
		    
	}



	
	
	
	
}
