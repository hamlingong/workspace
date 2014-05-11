package com.kunhong.design.Interpreter;

import java.util.HashMap;

/**
 * 减法解析器
 * 
 * @author lyq
 * 
 */
public class SubExpression extends SymbolExpression{
	public SubExpression(Expression _left, Expression _right) {

		super(_left, _right);

	}

	// 左右两个表达式相减

	public int interpreter(HashMap<String, Integer> var) {

		return super.left.interpreter(var) - super.right.interpreter(var);

	}
}
