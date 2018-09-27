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
 * @Description  TODO 通用的DAO层接口抽象类，实现各种通用的操作数据库的方法
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月23日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月23日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Stateless
@SuppressWarnings("unchecked")
public abstract class DaoImpl<K,E> implements IDao<K, E> {
	

	/**
	 * 实体管理器，用于操作实体
	 */
	protected EntityManager em;
	/**
	 *  元模型由EM获取
	 */
	protected Metamodel metamodel;
	/**
	 *  Criteria建造者，由EM获取
	 */
	protected CriteriaBuilder cb;

	/**
	 *    初始化Criteria关键的对象，
	 *    赋值EM,获取Metamodel，CriteriaBuilder；
	 *    
	 */	
	public abstract void initCriteriaVariable();

	
	
	/**
	 * 用元模型的属性替换条件表达式中的实体属性的静态字符串
	 * @param root       JPA中的root对象，用于将对应的属性变为JPA可识别的表达式
	 * @param clazz      需要操作的CLASS对象      
	 * @param expression 需要替换的表达式             
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	protected void replaceExpressionToMetamodel(Root root,Class clazz,Object[] expression) throws Exception{
		
		/*
		 *   获取CLAZZ所有的元模式属性
		 */
		Set<Attribute> attributes = metamodel.managedType(clazz).getAttributes();
		for(Attribute attribute:attributes){
			
//			if (attribute.getPersistentAttributeType().equals(Attribute.PersistentAttributeType.EMBEDDED)){
//				/*
//				 * 该字段的JPA属性是EMBEDDED，说明该字段为一个对象，递归调用方法本身进行替换
//				 */
//				replaceExpressionToMetamodel(root, attribute.getJavaType(),expression);
//			}
			/*
			 * 查找Expression表达式中与属性相同的字段，并进行替换
			 */
			for (int i=0;(expression != null)&&(i<expression.length);i++){
				if (attribute.getName().equals(expression[i])){
					expression[i] = root.get((SingularAttribute) attribute);
					/*
					 *   如果Value是字符串型，而对应的字段是枚举，调用枚举类型的fromValue方法进行转换
					 *   
					 */
					
					if (Enum.class.isAssignableFrom(attribute.getJavaType()) && i+2 <= expression.length && expression[i+2] instanceof String){
						Method method = attribute.getJavaType().getDeclaredMethod("fromValue", String.class);
						expression[i+2] = method.invoke(attribute.getJavaType(),expression[i+2]);
					}
					
					/*
					 * 如果字段为ManyToOne，且传入的Value(expression[i+2])是字符串或者枚举型
					 * 则进行查找替换
					 */
					if (attribute.getPersistentAttributeType().equals(Attribute.PersistentAttributeType.MANY_TO_ONE) 
							&& i+2 <= expression.length&&(expression[i+2] instanceof String || expression[i+2] instanceof Enum)){
						/*
						 *   如果Value是字符串型，而对应的实体的ID是枚举，调用枚举类型的fromValue方法进行转换
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
						 *   利用findById进行查找对应的entity 进行替换expression中对应的数值
						 */
						expression[i+2] = findById(expression[i+2], attribute.getJavaType());

					}
				}
			}
		}
	}
	
	
	
	/**
	 * 用元模型的属性替换排序表达式中的实体属性的静态字符串
	 * @param root          JPA中的root对象，用于将对应的属性变为JPA可识别的表达式
	 * @param clazz         需要操作的CLASS对象      
	 * @param queryOrders   需要替换的表达式  
	 */
	@SuppressWarnings("rawtypes")
	protected List<Order>  replaceOrderToMetamodel(Root<E> root,Class clazz,QueryOrder[] queryOrders){
		/*
		 *   获取CLAZZ所有的元模式属性
		 */
		List<Order> orders = new ArrayList<Order>();
		Set<Attribute> attributes = metamodel.managedType(clazz).getAttributes();
		for(Attribute attribute:attributes){
			if (attribute.getPersistentAttributeType().equals(Attribute.PersistentAttributeType.EMBEDDED)){
				/*
				 * 该字段的JPA属性是EMBEDDED，说明该字段为一个对象，递归调用方法本身进行替换
				 */
				orders.addAll(replaceOrderToMetamodel(root, attribute.getJavaType(), queryOrders));
			}
			/*
			 * 查找Expression表达式中与属性相同的字段，并进行替换
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
	 * 将实体对象的一对多和多对一对象以LeftJion的方式链接
	 * @param fetchParent Fetch的父类对象
	 * @param clazz 需要链接实体对象的类型
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
	 * 将查询字段转换成JPA样式的Selection集合
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
	 * 将Object数组转换成对应的实体类
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
							  * 如果是一对多的属性,取得集合后调用add添加
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
	 * 以给定的条件查询返回TypedQuery的对象，提供给其他方法以获取最后的结果
	 * @param condition 给定的条件 
	 * @return TypedQuery对象
	 * @throws Exception 
	 */
	
	@SuppressWarnings("rawtypes")
	private TypedQuery<E> findByCondition(QueryCondition condition,Class<E> clazz) throws Exception{
		/*
		 * 判断是否多选字段标志
		 */
		boolean isMultiselect = false;
		if (condition.getSelectFields() != null && condition.getSelectFields().length > 0){
			isMultiselect = true;
		}
		CriteriaQuery cq = null;
		
		
		
		if (isMultiselect){
			/*
			 * 如果是指定字段，返回类型是对象数组
			 */
			cq = cb.createQuery(Object[].class);
		}else{
			/*
			 * 否则返回类型是实体类
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
		 *   合成Where表达式 
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
	 * @Description: 返回符合条件的记录数量
	 * @param conditions 条件
	 * @return 符合的实体数量
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
	 * @Description: TODO(这里用一句话描述这个方法的作用)
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
			//获取元模型及取得元模型所对应的所有属性
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
			 *  如果类型不是实体类，返回空
			 */
			return null;
		}

		return null;
		
	}
	
	
	
	/**
	 * 
	 * @Description: 根据条件进行求和处理
	 * @param condition 条件
	 * @return 最终查询的TypedQuery的对象
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
		//用元模型的属性替换条件表达式中的实体属性的静态字符串
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
			
			
			//用元模型的属性替代求和字段的静态字符串
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
			//用元模型属性替代分组字段的静态字符串
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
		//分组字段放入cq中
		cq.groupBy(expressions);
		cq.orderBy(orders);
		
		
		cq.multiselect(selections);
		return em.createQuery(cq);
		
	}
		
	
	

	/** 
	* 通过构造方法指定DAO的具体实现类 
	*/

	public DaoImpl() {
	     
		
	}
	


	
	/**
	 * 新增实体
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
			 * 如果没有找到对应的实体，返回空值
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
			 * 将条件数组{flightNumber,=,CA1980,And,execDate,=,1979/09/06}
			 * 转换为JPQL字符串"flight.flightNumber=:flightNumber And flight.execDate=:execDate"
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
					case 1:/* 字段名*/
						jpql               = jpql+alias+"."+pam.toString();
						fdNames[pamsCount] = pam.toString()+pamsCount;
						break;
					case 2:  /* >= <= <> = */
 						jpql += pam;
						break;
					case 3:/* 参数 */
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
		     * 将数值传入Query的参数中
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
