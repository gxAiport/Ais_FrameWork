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
 * @Description  TODO 用来处理计算的工具类
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2016年2月23日 
 * @ModificationHistory
 * Date         Author     Version   Discription
 * <p>---------------------------------------------
 * <p>2016年2月23日      Yu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Component
public class CalcExpression {
	
	/**
	 *  操作符对比动作
	 */
	private static String CALC = "calc";
	
	private static String POP = "pop";
	
	private static String PUSH = "push";
	
	private static String ERROR ="err";
	
	private Map<String,Object> map;
	
	private String suffix;
	
	private List<String> opts = Arrays.asList("+","-","*","/","(",")","#");
	
	/**
	 * 存放条件表达式的栈
	 */
	private Stack<Double> dataStack = new Stack<Double>();
	
	/**
	 * 存放操作符的栈
	 */
	private Stack<String> optStack = new Stack<String>();
	
	
	
	/**
	 *   优先级定义表
	 */
	private Map<String, Map<String, String>> priorityMap = new HashMap<String, Map<String, String>>();
	
	
	
	private  boolean fractionDigits; 
	
	
	
	/**
	 * 
	 * @Description: 初始化优先级定义表
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
		  //) 不可能被放入栈中，一定会被丢弃，因为前面的数据一定会被计算
		  subMap = new HashMap<String, String>();
		  subMap.put("+", ERROR);
		  subMap.put("-", ERROR);
		  subMap.put("*", ERROR);
		  subMap.put("/", ERROR);
		  subMap.put("(", ERROR);
		  subMap.put(")", ERROR);
		  subMap.put("#", ERROR);
		  priorityMap.put(")", subMap);
		  //# 结束和开始字符
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
	 * @Description: TODO(这里用一句话描述这个方法的作用)
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
		 throw new RuntimeException("不支持的操作" + opt);
		}
	}
	
	private void process(Object token) throws Exception{
		while (!optStack.peek().equals("#")||!"#".equals(token)){
			//如果操作符栈顶为#，表达式传入对象为#，说明已经处理完表达式，跳出循环
			if (!isOpt(token)){
				//表达式不是操作符，入栈，跳出循环，进行下一个表达式的处理
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
					//如果操作符的等级比栈内的操作符的等级高，将此操作符入栈，并跳出循环
					optStack.push(opt);
					break;
				} else if (POP.equals(priority)){
					//说明是一对括号，中间的数据已经处理完毕，跳出循环，丢弃括号
					optStack.pop();
					break;
				}else if (CALC.equals(priority)){
					//说明操作符等级比栈内的低，处理栈内的数据运算，直到跳出循环
					if (dataStack.size() >=2){
						Double res = calc(dataStack.pop(), dataStack.pop(), optStack.pop());
						dataStack.push(res);
					}else{
						throw new Exception("数据栈内数据不足，请检查表达式");	
					}
				}else{
			
					throw new Exception("表达式出错，请检查表达式");	
				}
			}else {
				throw new Exception("操作符栈内数据不足，请检查表达式");	
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
