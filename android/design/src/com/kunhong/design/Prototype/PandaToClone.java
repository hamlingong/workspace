package com.kunhong.design.Prototype;

/**
 * 原始模式实质就是对象的复制！JAVA语言提供的Cloneable接口只起一个作用，就是在运行的时期通知JAVA虚拟机可以安全地在这个类上使用clone()
 * 方法。通过调用这个clone()方法可以得到一个对象的复制。由于Object类本身并不实现Cloneable接口，
 * 因此如果所考虑的类没有实现Cloneable接口时，调用clone()方法会抛出CloneNotSupportedException异常。
 * 系统可以在PandaToClone里面置换掉java
 * .lang.Object提供的clone()方法，以便控制复制的过程。在下面的例子里，PandaToClone是一个带有几个性质的类
 * ，它将java.lang.Object类的克隆方法置换掉了，由一个新的clone()方法提供复制自己实例的任务。
 * 
 * @author lyq
 * 
 */
class PandaToClone implements Cloneable {

	private int height, weight, age;

	public PandaToClone(int height, int weight) {
		this.age = 0;
		this.weight = weight;
		this.height = height;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	public Object clone() {
		// 创建一个本类的对象
		// 并返还给调用者
		PandaToClone temp = new PandaToClone(height, weight);
		temp.setAge(age);
		// 注意返还值的类型必须是Object
		return (Object) temp;
	}
}
