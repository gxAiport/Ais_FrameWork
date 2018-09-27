package com.airport.ais.dao.parameter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

import com.airport.ais.enums.QueryGroupDate;




/**
 * 
 * FileName      ExpressionUtil.java
 * @Description  TODO JPA ��ȫ���ʽ������
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��22��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��22��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */


@SuppressWarnings("rawtypes")
public class ExpressionUtil {
	
private static int StartYearPos = 1;
	
	/**
	 *  ���������ַ�λ�õĳ��� 
	 */
	private static int StartMonthPos = 6;
	
	private static int StartDayPos = 6;
	
	private static int Yearlen = 4;
	
	private static int MonthLen = 2;
	
	private static int DayLen = 5;
	
	private CriteriaBuilder cb;
	
	/**
	 *  �������Աȶ���
	 */
	private static String CALC = "calc";
	
	private static String POP = "pop";
	
	private static String PUSH = "push";
	
	private static String ERROR ="err";

	
	/**
	 *   ���ȼ������
	 */
	private Map<String, Map<String, String>> priorityMap = new HashMap<String, Map<String, String>>();
	
	private List<String> opts = Arrays.asList(">","<",">=","<=","<>","=","LIKE","IS","+","-","OR","AND","(",")","#");
	
	/**
	 * ����������ʽ��ջ
	 */
	private Stack<Object> dataStack = new Stack<Object>();
	
	/**
	 * ��Ų�������ջ
	 */
	private Stack<String> optStack = new Stack<String>();
	
	
	

	
	/**
	 * 
	 * @Description: ��ʼ�����ȼ������
	 * (OR)<(AND)<(>,<,>=,<=,<>,LIKE)<(())
	 */
	private void initPriorityMap(){
      	  //>
		Map<String, String> subMap = new HashMap<String, String>();
		  subMap.put(">", CALC);
		  subMap.put("<", CALC);
		  subMap.put(">=", CALC);
		  subMap.put("<=", CALC);
		  subMap.put("<>", CALC);
		  subMap.put("=", CALC);
		  subMap.put("LIKE", CALC);
		  subMap.put("IS", CALC);
		  subMap.put("+", PUSH);
		  subMap.put("-", PUSH);
		  subMap.put("OR", CALC);
		  subMap.put("AND", CALC);
		  subMap.put("(", PUSH);
		  subMap.put(")", CALC);
		  subMap.put("#", CALC);
		  priorityMap.put(">", subMap);
		  //<
		  subMap = new HashMap<String, String>();
		  subMap.put(">", CALC);
		  subMap.put("<", CALC);
		  subMap.put(">=", CALC);
		  subMap.put("<=", CALC);
		  subMap.put("=", CALC);
		  subMap.put("<>", CALC);
		  subMap.put("LIKE", CALC);
		  subMap.put("IS", CALC);
		  subMap.put("+", PUSH);
		  subMap.put("-", PUSH);
		  subMap.put("OR", CALC);
		  subMap.put("AND", CALC);
		  subMap.put("(", PUSH);
		  subMap.put(")", CALC);
		  subMap.put("#", CALC);
		  priorityMap.put("<", subMap);
		  
		  //>=
		  subMap = new HashMap<String, String>();
		  subMap.put(">", CALC);
		  subMap.put("<", CALC);
		  subMap.put(">=", CALC);
		  subMap.put("<=", CALC);
		  subMap.put("=", CALC);
		  subMap.put("<>", CALC);
		  subMap.put("LIKE", CALC);
		  subMap.put("IS", CALC);
		  subMap.put("+", PUSH);
		  subMap.put("-", PUSH);
		  subMap.put("OR", CALC);
		  subMap.put("AND", CALC);
		  subMap.put("(", PUSH);
		  subMap.put(")", CALC);
		  subMap.put("#", CALC);
		  priorityMap.put(">=", subMap);
		  
		  //<=
		  subMap = new HashMap<String, String>();
		  subMap.put(">", CALC);
		  subMap.put("<", CALC);
		  subMap.put(">=", CALC);
		  subMap.put("<=", CALC);
		  subMap.put("=", CALC);
		  subMap.put("<>", CALC);
		  subMap.put("LIKE", CALC);
		  subMap.put("IS", CALC);
		  subMap.put("+", PUSH);
		  subMap.put("-", PUSH);
		  subMap.put("OR", CALC);
		  subMap.put("AND", CALC);
		  subMap.put("(", PUSH);
		  subMap.put(")", CALC);
		  subMap.put("#", CALC);
		  priorityMap.put("<=", subMap);
		  //<>
		  subMap = new HashMap<String, String>();
		  subMap.put(">", CALC);
		  subMap.put("<", CALC);
		  subMap.put(">=", CALC);
		  subMap.put("<=", CALC);
		  subMap.put("=", CALC);
		  subMap.put("<>", CALC);
		  subMap.put("LIKE", CALC);
		  subMap.put("IS", CALC);
		  subMap.put("+", PUSH);
		  subMap.put("-", PUSH);
		  subMap.put("OR", CALC);
		  subMap.put("AND", CALC);
		  subMap.put("(", PUSH);
		  subMap.put(")", CALC);
		  subMap.put("#", CALC);
		  priorityMap.put("<>", subMap);
		  
		  //=
		  subMap = new HashMap<String, String>();
		  subMap.put(">", CALC);
		  subMap.put("<", CALC);
		  subMap.put(">=", CALC);
		  subMap.put("<=", CALC);
		  subMap.put("=", CALC);
		  subMap.put("<>", CALC);
		  subMap.put("LIKE", CALC);
		  subMap.put("IS", CALC);
		  subMap.put("+", PUSH);
		  subMap.put("-", PUSH);
		  subMap.put("OR", CALC);
		  subMap.put("AND", CALC);
		  subMap.put("(", PUSH);
		  subMap.put(")", CALC);
		  subMap.put("#", CALC);
		  priorityMap.put("=", subMap);
		  		  
		  //LIKE
		  subMap = new HashMap<String, String>();
		  subMap.put(">", CALC);
		  subMap.put("<", CALC);
		  subMap.put(">=", CALC);
		  subMap.put("<=", CALC);
		  subMap.put("=", CALC);
		  subMap.put("<>", CALC);
		  subMap.put("LIKE", CALC);
		  subMap.put("IS", CALC);
		  subMap.put("+", PUSH);
		  subMap.put("-", PUSH);
		  subMap.put("OR", CALC);
		  subMap.put("AND", CALC);
		  subMap.put("(", PUSH);
		  subMap.put(")", CALC);
		  subMap.put("#", CALC);
		  priorityMap.put("LIKE", subMap);

		  //IS
		  subMap = new HashMap<String, String>();
		  subMap.put(">", CALC);
		  subMap.put("<", CALC);
		  subMap.put(">=", CALC);
		  subMap.put("<=", CALC);
		  subMap.put("=", CALC);
		  subMap.put("<>", CALC);
		  subMap.put("LIKE", CALC);
		  subMap.put("IS", CALC);
		  subMap.put("+", PUSH);
		  subMap.put("-", PUSH);
		  subMap.put("OR", CALC);
		  subMap.put("AND", CALC);
		  subMap.put("(", PUSH);
		  subMap.put(")", CALC);
		  subMap.put("#", CALC);
		  priorityMap.put("IS", subMap);
		  
		  //+
		  subMap = new HashMap<String, String>();
		  subMap.put(">", CALC);
		  subMap.put("<", CALC);
		  subMap.put(">=", CALC);
		  subMap.put("<=", CALC);
		  subMap.put("=", CALC);
		  subMap.put("<>", CALC);
		  subMap.put("LIKE", CALC);
		  subMap.put("IS", CALC);
		  subMap.put("+", CALC);
		  subMap.put("-", CALC);
		  subMap.put("OR", CALC);
		  subMap.put("AND", CALC);
		  subMap.put("(", PUSH);
		  subMap.put(")", CALC);
		  subMap.put("#", CALC);
		  priorityMap.put("+", subMap);
		  
		  //-
		  subMap = new HashMap<String, String>();
		  subMap.put(">", CALC);
		  subMap.put("<", CALC);
		  subMap.put(">=", CALC);
		  subMap.put("<=", CALC);
		  subMap.put("=", CALC);
		  subMap.put("<>", CALC);
		  subMap.put("LIKE", CALC);
		  subMap.put("IS", CALC);
		  subMap.put("+", CALC);
		  subMap.put("-", CALC);
		  subMap.put("OR", CALC);
		  subMap.put("AND", CALC);
		  subMap.put("(", PUSH);
		  subMap.put(")", CALC);
		  subMap.put("#", CALC);
		  priorityMap.put("-", subMap);		 
		  
		  //OR
		  subMap = new HashMap<String, String>();
		  subMap.put(">", PUSH);
		  subMap.put("<", PUSH);
		  subMap.put(">=", PUSH);
		  subMap.put("<=", PUSH);
		  subMap.put("=", PUSH);
		  subMap.put("<>", PUSH);
		  subMap.put("LIKE", PUSH);
		  subMap.put("IS", PUSH);
		  subMap.put("+", PUSH);
		  subMap.put("-", PUSH);
		  subMap.put("OR", CALC);
		  subMap.put("AND", PUSH);
		  subMap.put("(", PUSH);
		  subMap.put(")", CALC);
		  subMap.put("#", CALC);
		  priorityMap.put("OR", subMap);
		  
		  //AND
		  subMap = new HashMap<String, String>();
		  subMap.put(">", PUSH);
		  subMap.put("<", PUSH);
		  subMap.put(">=", PUSH);
		  subMap.put("<=", PUSH);
		  subMap.put("=", PUSH);
		  subMap.put("<>", PUSH);
		  subMap.put("LIKE", PUSH);
		  subMap.put("IS", PUSH);
		  subMap.put("+", PUSH);
		  subMap.put("-", PUSH);
		  subMap.put("OR", CALC);
		  subMap.put("AND", CALC);
		  subMap.put("(", PUSH);
		  subMap.put(")", CALC);
		  subMap.put("#", CALC);
		  priorityMap.put("AND", subMap);
		  //(
		  subMap = new HashMap<String, String>();
		  subMap.put(">", PUSH);
		  subMap.put("<", PUSH);
		  subMap.put(">=", PUSH);
		  subMap.put("<=", PUSH);
		  subMap.put("=", PUSH);
		  subMap.put("<>", PUSH);
		  subMap.put("LIKE", PUSH);
		  subMap.put("IS", PUSH);
		  subMap.put("+", PUSH);
		  subMap.put("-", PUSH);
		  subMap.put("OR", PUSH);
		  subMap.put("AND", PUSH);
		  subMap.put("(", PUSH);
		  subMap.put(")", POP);
		  subMap.put("#", ERROR);
		  priorityMap.put("(", subMap);
		  
		  //) �����ܱ�����ջ�У�һ���ᱻ��������Ϊǰ�������һ���ᱻ����
		  subMap = new HashMap<String, String>();
		  subMap.put(">", ERROR);
		  subMap.put("<", ERROR);
		  subMap.put(">=", ERROR);
		  subMap.put("<=", ERROR);
		  subMap.put("<>", ERROR);
		  subMap.put("=", ERROR);
		  subMap.put("LIKE",ERROR);
		  subMap.put("IS", ERROR);
		  subMap.put("+", ERROR);
		  subMap.put("-", ERROR);
		  subMap.put("OR", ERROR);
		  subMap.put("AND", ERROR);
		  subMap.put("(", ERROR);
		  subMap.put(")", ERROR);
		  subMap.put("#", ERROR);
		  priorityMap.put(")", subMap);
		  //# �����Ϳ�ʼ�ַ�
		  subMap = new HashMap<String, String>();
		  subMap.put(">", PUSH);
		  subMap.put("<", PUSH);
		  subMap.put(">=", PUSH);
		  subMap.put("<=", PUSH);
		  subMap.put("=", PUSH);
		  subMap.put("<>", PUSH);
		  subMap.put("LIKE", PUSH);
		  subMap.put("IS", PUSH);
		  subMap.put("+", PUSH);
		  subMap.put("-", PUSH);
		  subMap.put("OR", PUSH);
		  subMap.put("AND", PUSH);
		  subMap.put("(", PUSH);
		  subMap.put(")", ERROR);
		  subMap.put("#", POP);
		  priorityMap.put("#", subMap);
		 
	}
	
	public ExpressionUtil(CriteriaBuilder cb) {
		super();
		this.cb = cb;
		initPriorityMap();
	}
	
	private boolean isOpt(Object Token){
		if (opts.indexOf(Token) == -1){
			return false;
		}else{
			return true;
		}
	}
	
	


	/**
	 * 
	 * @Description: TODO(������һ�仰�����������������)
	 * @param data1
	 * @param data2
	 * @param opt
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings({ "unchecked",  })
	private Object compose(Object data1,Object data2,String opt) throws Exception{
		
		
		Object result = null;
		Object value = null;
		Predicate predicate1=null;
		Predicate predicate2=null;
		Expression expression1 = null;
		Expression expression2 = null;
			
		if (data1 instanceof Predicate && data2 instanceof Predicate){
			predicate1 = (Predicate) data1;
			predicate2 = (Predicate) data2;
		}else if (data1 instanceof Expression && data2 instanceof Expression){
			expression1 = (Expression) data1;
			expression2 = (Expression) data2;
		}else if (data2 instanceof Expression){
			expression1 = (Expression) data2;
			value = data1;
		}else {
			
			throw new Exception("ջ�ڲ��������޷����кϳ�");
		}
		
		if (opt.equals(">") && value instanceof Comparable && expression1!= null){
			//���ڴ���ʽ
			result = cb.greaterThan(expression1, (Comparable)value);
		}else if (opt.equals(">=")&&value instanceof Comparable && expression1!= null){
			//����ڴ���ʽ
			result = cb.greaterThanOrEqualTo(expression1, (Comparable)value);
		}else if (opt.equals("<") && value instanceof Comparable && expression1!= null){
			//С�ڴ���ʽ
			result = cb.lessThan(expression1, (Comparable)value);
		}else if (opt.equals("<=")&&value instanceof Comparable && expression1!= null){
			//С�ڵ��ڴ���ʽ
			result = cb.lessThanOrEqualTo(expression1, (Comparable)value);
			//���ڴ���ʽ
		}else if (opt.equals("=") && expression1!= null){
			result = cb.equal(expression1, value);
		}else if (opt.equals("<>") && expression1!= null){
			//�����ڴ���ʽ
			result = cb.notEqual(expression1, value);
		}else if (opt.equals("LIKE") && expression1!= null){
			//LIKE����ʽ
			result = cb.like(expression1, value.toString());
		}else if (opt.equals("IS") && expression1!= null){
			//IS����ʽ
			result = cb.isNull(expression1);
			
		}else if (opt.equals("AND")&&predicate1 != null&&predicate2 != null){
			//And����
			result = cb.and(predicate1, predicate2);
		}else if (opt.equals("OR")&&predicate1 != null&&predicate2 != null){
			//OR����
			result = cb.or(predicate1, predicate2);
		}else if (opt.equals("+")&&expression1 != null&&expression2 != null){
			//�Ӵ���ʽ
			result = cb.sum(expression1, expression2);
		}else if (opt.equals("-")&&expression1 != null&&expression2 != null){
			//������ʽ
			result = cb.diff(expression1,expression2);
		}else{
			throw new Exception("�ֶκϳɱ��ʽ���ִ���");			
		}
		
		return result;
		
		
		
	}
	
	/**
	 * 
	 * @Description: TODO(������һ�仰�����������������)
	 * @param expresstion
	 * @throws Exception 
	 */
	private void process(Object token) throws Exception{
		while (!optStack.peek().equals("#")||!"#".equals(token)){
			//���������ջ��Ϊ#�����ʽ�������Ϊ#��˵���Ѿ���������ʽ������ѭ��
			if (!isOpt(token)){
				//���ʽ���ǲ���������ջ������ѭ����������һ�����ʽ�Ĵ���
				dataStack.push(token);
				break;
			}else if (optStack.size() > 0){
				String opt = (String) token; 
				String priority = priorityMap.get(optStack.peek()).get(opt);
				if (PUSH.equals(priority)){
					//����������ĵȼ���ջ�ڵĲ������ĵȼ��ߣ����˲�������ջ��������ѭ��
					optStack.push(opt);
					break;
				} else if (POP.equals(priority)){
					//˵����һ�����ţ��м�������Ѿ�������ϣ�����ѭ������������
					optStack.pop();
					break;
				}else if (CALC.equals(priority)){
					//˵���������ȼ���ջ�ڵĵͣ�����ջ�ڵ��������㣬ֱ������ѭ��
					if (dataStack.size() >=2){
						Object obj = compose(dataStack.pop(), dataStack.pop(), optStack.pop());
						dataStack.push(obj);
					}else{
						throw new Exception("����ջ�����ݲ��㣬������ʽ");	
					}
				}else{
					
					throw new Exception("���ʽ����������ʽ");	
				}
			}else {
				throw new Exception("������ջ�����ݲ��㣬������ʽ");	
			}
			
		}
	}
	
	/**
	 * 
	 * @Description: TODO(������һ�仰�����������������)
	 * @param expresstions
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public <T>T composeExpression(Object[] expresstions) throws Exception{
		optStack.push("#");
		for (Object token:expresstions){
			process(token);
		}
		process("#");
		return (T) dataStack.pop();
		
	}
	
	
	/**
	 * 
	 * @Description: TODO(������һ�仰�����������������)
	 * @param ymd
	 * @param attrib
	 * @return
	 */
	@SuppressWarnings({ "unchecked" })
	public Expression getYMDExpression(QueryGroupDate ymd,Expression expression){
		switch (ymd) {
		case year:
			return 	cb.substring(expression,StartYearPos, Yearlen);
		case month:
			return  cb.substring(expression,StartMonthPos,MonthLen);
		case day:
			return  cb.substring(expression,StartDayPos,DayLen);
		default:
			return null;
		}
	}

}
