package com.kunhong.design.Builder;

/**
 * 建造者模式 建造者模式的优点 封装性
 * 使用建造者模式可以使客户端不必知道产品内部组成的细节，如例子中我们就不需要关心每一个具体的模型内部是如何实现的，产生的对象类型就是CarModel。
 * 
 * 建造者独立，容易扩展 Builder之间是相互独立的，与其它的Builder无关，对系统的扩展非常有利。
 * 
 * 便于控制细节风险 模式所建造的最终产品更易于控制：由于具体的建造者是独立的，因此可以对建造过程逐步细化，而不对其他的模块产生任何影响。
 * 
 * @author lyq
 * 
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Builder shandongCuisineChef = new ShandongCuisineChefBuilder();
		Builder siChuanChef = new SiChuanChefBuilder();

		Director director = new Director(shandongCuisineChef);
		Food food = director.construct("糖醋里脊", "色淡黄,形光润饱满.外松脆酥香,里软嫩鲜美", "又甜又香",
				"无", "适量", "加糖");

		System.out.println("经典鲁菜： " + "\r\n" + food);

		Director director2 = new Director();
		director2.setDirector(siChuanChef);
		Food food2 = director2.construct("水煮肉片", "肉味香辣，软嫩，易嚼", "麻、辣、鲜、烫", "多",
				"适量", "无");
		System.out.println("经典川菜： " + "\r\n" + food2);

	}
}
