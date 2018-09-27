/**
 * 
 */
package com.airport.ais.report.parameter;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.springframework.stereotype.Component;

import com.airport.ais.utils.Ais_String_Util;


/**
 * FileName      CalcExpression.java
 * @Description  TODO �����������Ĺ�����
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2016��2��23�� 
 * @ModificationHistory
 * Date         Author     Version   Discription
 * <p>---------------------------------------------
 * <p>2016��2��23��      Yu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Component
public class CalcExpression {
	
	/**
	 *  �������Աȶ���
	 */
	private static String CALC = "calc";
	
	private static String POP = "pop";
	
	private static String PUSH = "push";
	
	private static String ERROR ="err";
	
	private Map<String,Object> map;
	
	private String suffix;
	
	private List<String> opts = Arrays.asList("+","-","*","/","(",")","#");
	
	/**
	 * ����������ʽ��ջ
	 */
	private Stack<Double> dataStack = new Stack<Double>();
	
	/**
	 * ��Ų�������ջ
	 */
	private Stack<String> optStack = new Stack<String>();
	
	
	
	/**
	 *   ���ȼ������
	 */
	private Map<String, Map<String, String>> priorityMap = new HashMap<String, Map<String, String>>();
	
	
	
	private  boolean fractionDigits; 
	
	
	
	/**
	 * 
	 * @Description: ��ʼ�����ȼ������
	 * (OR)<(AND)<(>,<,>=,<=,<>,LIKE)<(())
	 */
	private void initPriorityMap(){
      	  //>
		  Map<String, String> subMap = new HashMap<String, String>();
		  //+
		  subMap = new HashMap<String, String>();
		  subMap.put("+", CALC);
		  subMap.put("-", CALC);
		  subMap.put("*", PUSH);
		  subMap.put("/", PUSH);
		  subMap.put("(", PUSH);
		  subMap.put(")", CALC);
		  subMap.put("#", CALC);
		  priorityMap.put("+", subMap);
		  
		  //-
		  subMap = new HashMap<String, String>();
		  subMap.put("+", CALC);
		  subMap.put("-", CALC);
		  subMap.put("*", PUSH);
		  subMap.put("/", PUSH);
		  subMap.put("(", PUSH);
		  subMap.put(")", CALC);
		  subMap.put("#", CALC);
		  priorityMap.put("-", subMap);		 
		  
		  //*
		  subMap = new HashMap<String, String>();
		  subMap.put("+", CALC);
		  subMap.put("-", CALC);
		  subMap.put("*", CALC);
		  subMap.put("/", CALC);
		  subMap.put("(", PUSH);
		  subMap.put(")", CALC);
		  subMap.put("#", CALC);
		  priorityMap.put("*", subMap);
		  
		  ///
		  subMap = new HashMap<String, String>();
		  subMap.put("+", CALC);
		  subMap.put("-", CALC);
		  subMap.put("*", CALC);
		  subMap.put("/", CALC);
		  subMap.put("(", PUSH);
		  subMap.put(")", CALC);
		  subMap.put("#", CALC);
		  priorityMap.put("/", subMap);
		  //(
		  subMap = new HashMap<String, String>();
		  subMap.put("+", PUSH);
		  subMap.put("-", PUSH);
		  subMap.put("*", PUSH);
		  subMap.put("/", PUSH);
		  subMap.put("(", PUSH);
		  subMap.put(")", POP);
		  subMap.put("#", ERROR);
		  priorityMap.put("(", subMap);
		  //) �����ܱ�����ջ�У�һ���ᱻ��������Ϊǰ�������һ���ᱻ����
		  subMap = new HashMap<String, String>();
		  subMap.put("+", ERROR);
		  subMap.put("-", ERROR);
		  subMap.put("*", ERROR);
		  subMap.put("/", ERROR);
		  subMap.put("(", ERROR);
		  subMap.put(")", ERROR);
		  subMap.put("#", ERROR);
		  priorityMap.put(")", subMap);
		  //# �����Ϳ�ʼ�ַ�
		  subMap = new HashMap<String, String>();
		  subMap.put("+", PUSH);
		  subMap.put("-", PUSH);
		  subMap.put("*", PUSH);
		  subMap.put("/", PUSH);
		  subMap.put("(", PUSH);
		  subMap.put(")", ERROR);
		  subMap.put("#", POP);
		  priorityMap.put("#", subMap);
		 
	}	
	
	
	
	
	public CalcExpression() {
		super();
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
	 * @param n1
	 * @param n2
	 * @param opt
	 * @return
	 */
	private Double calc(Double n1, Double n2, String opt) {

		if ("+".equals(opt)) {
		   return n2 + n1;
		} else if ("-".equals(opt)) {
		   return n2 - n1;
		} else if ("*".equals(opt)) {
		  return n2 * n1;
		} else if ("/".equals(opt)) {
			fractionDigits = true;
			if (n1 ==0){
				return n2/1;
			}else{
 			    return n2 / n1;
			}
		} else {
		 throw new RuntimeException("��֧�ֵĲ���" + opt);
		}
	}
	
	private void process(Object token) throws Exception{
		while (!optStack.peek().equals("#")||!"#".equals(token)){
			//���������ջ��Ϊ#�����ʽ�������Ϊ#��˵���Ѿ���������ʽ������ѭ��
			if (!isOpt(token)){
				//���ʽ���ǲ���������ջ������ѭ����������һ�����ʽ�Ĵ���
				if (Ais_String_Util.isNumeric(token.toString())){
					dataStack.push(Double.parseDouble(token.toString()));
				} else{
					
					if (map.get(token+suffix) != null){
						dataStack.push(Double.parseDouble(map.get(token+suffix).toString()));
					}else{
						dataStack.push(0.0);
					}
				}
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
						Double res = calc(dataStack.pop(), dataStack.pop(), optStack.pop());
						dataStack.push(res);
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

	public  Number calcExpression(Object[] expressions,String suffix,Map<String, Object> map) throws Exception{
		fractionDigits = false;
		this.map = map;
		this.suffix = suffix;
		optStack.push("#");
		for (Object token:expressions){
			process(token);
		}
		process("#");
		if (fractionDigits) {
			
			return Double.parseDouble(new DecimalFormat("#.00").format(dataStack.pop()));
		}else {
			return dataStack.pop().intValue();
		}
		
	}
	

}
