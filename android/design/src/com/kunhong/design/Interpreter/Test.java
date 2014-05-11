package com.kunhong.design.Interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 解释器模式 解释器模式的优点
 * 解释器是一个简单语法分析工具，它最显著的优点就是扩展性，修改语法规则只要修改相应的非终结符表达式就可以了，若扩展语法，则只要增加非终结符类就可以了。
 * 
 * 27.3.2 解释器模式的缺点 解释器模式会引起类膨胀
 * 每个语法都要产生一个非终结符表达式，语法规则比较复杂时，就可能产生大量的类文件，为维护带来了非常多的麻烦。
 * 
 * 解释器模式采用递归调用方法
 * 每个非终结符表达式只关心与自己有关的表达式，每个表达式需要知道最终的结果，必须一层一层地剥茧，无论是面向过程的语言还是面向对象的语言
 * ，递归都是在必要条件下使用的，它导致调试非常复杂。想想看，如果要排查一个语法错误，我们是不是要一个一个断点的调试下去，直到最小的语法单元。
 * 
 * 效率问题 解释器模式由于使用了大量的循环和递归，效率是个不容忽视的问题，特别是用于解析复杂、冗长的语法时，效率是难以忍受的。
 * 
 * @author lyq
 * 
 */
public class Test {
	/**
	 * 运行四则运算
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		String expStr = getExpStr();

		// 赋值

		HashMap<String, Integer> var = getValue(expStr);

		Calculator cal = new Calculator(expStr);

		System.out.println("运算结果为：" + expStr + "=" + cal.run(var));

	}

	/**
	 * 获得表达式
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String getExpStr() throws IOException {

		System.out.print("请输入表达式：");

		return (new BufferedReader(new InputStreamReader(System.in)))
				.readLine();

	}

	/**
	 * 获得值映射
	 * 
	 * @param exprStr
	 * @return
	 * @throws IOException
	 */
	public static HashMap<String, Integer> getValue(String exprStr)
			throws IOException {

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		// 解析有几个参数要传递

		for (char ch : exprStr.toCharArray()) {

			if (ch != '+' && ch != '-') {

				// 解决重复参数的问题

				if (!map.containsKey(String.valueOf(ch))) {
					System.out.print("请输入" + ch + "的值:");

					String in = (new BufferedReader(new InputStreamReader(
							System.in))).readLine();

					map.put(String.valueOf(ch), Integer.valueOf(in));

				}

			}

		}
		return map;
	}
}
