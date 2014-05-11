package com.kunhong.design.Composite;

/**
 * Created by IntelliJ IDEA. 文件
 */
public class File implements IFile {
	private String name; // 文件名字
	private int deep; // 层级深度

	public File(String name) {
		this.name = name;
	}

	/**
	 * 返回自己的实例
	 */
	public IFile getComposite() {
		return this;
	}

	/**
	 * 某个商业方法
	 */
	public void sampleOperation() {
		System.out.println("执行了某个商业方法！");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDeep() {
		return deep;
	}

	public void setDeep(int deep) {
		this.deep = deep;
	}
}