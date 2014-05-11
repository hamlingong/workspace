package com.kunhong.design.Prototype;

/**
 * 原始模型
 * @author lyq
 *
 */
public class Test {
	private static PandaToClone thisPanda, thatPanda;

	public static void main(String[] args){
	  thisPanda = new PandaToClone(15,25);
	  thisPanda.setAge(13);

	  thatPanda = (PandaToClone)thisPanda.clone();

	  System.out.println("Age of this panda:"+thisPanda.getAge());
	  System.out.println("  height:"+thisPanda.getHeight());
	  System.out.println("  weight:"+thisPanda.getWeight());
	  System.out.println("Age of this panda:"+thatPanda.getAge());
	  System.out.println("  height:"+thatPanda.getHeight());
	  System.out.println("  weight:"+thatPanda.getWeight());
	  //结果
	  //Age of this panda:3
      //height:15
      //weight:25
	 }
}
