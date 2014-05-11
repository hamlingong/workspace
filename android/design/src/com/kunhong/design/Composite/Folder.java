package com.kunhong.design.Composite;

import java.util.Vector;

/**
 * Created by IntelliJ IDEA. 文件夹角色
 */
public class Folder implements IFile {
	private String name; // 文件名字
	private int deep; // 层级深度，根深度为0
	private Vector<IFile> componentVector = new Vector<IFile>();

	public Folder(String name) {
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

	/**
	 * 增加一个文件或文件夹
	 * 
	 * @param IFile
	 */
	public void add(IFile IFile) {
		componentVector.addElement(IFile);
		IFile.setDeep(this.deep + 1);

	}

	// 删除一个文件或文件夹
	public void remove(IFile IFile) {
		componentVector.removeElement(IFile);
	}

	/**
	 *  返回直接子文件（夹）集合
	 * @return
	 */
	public Vector getAllComponent() {
		return componentVector;
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
