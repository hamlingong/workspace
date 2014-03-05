package lmc.entity;
import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.content.Intent;
public class TreeEle {
	private String id = null;
	private String title = null;
	private boolean hasChild = false;
	private List<TreeEle>childs = null;
	private Intent it = null;
	private boolean isOpen = true;
	private int level = 0;
	/**
	 * ������ת��/���ӽڵ�Ľڵ�
	 * @param id:�ڵ�ID
	 * @param title:�ڵ����
	 * @param hasChild:�Ƿ����ӽڵ�
	 * */
	public TreeEle(String id, String title, boolean hasChild) {
		this.id = id;
		this.title = title;
		this.hasChild = hasChild;
		if(hasChild){
			this.childs = new ArrayList<TreeEle>();
		}else{
			this.childs = null;
		}
		this.it = null;
		this.isOpen = false;
	}
	/**
	 * ����ת��Ҷ�ӽڵ�
	 * @param id:�ڵ�ID
	 * @param title:�ڵ����
	 * @param it:��ת·��
	 * */
	public TreeEle(String id, String title, Intent it) {
		this.id = id;
		this.title = title;
		this.hasChild = false;
		this.childs = null;
		this.it = it;
		this.isOpen = false;
	}
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public boolean isHasChild() {
		return hasChild;
	}
	public List<TreeEle> getChilds() {
		return childs;
	}
	public void addChild(TreeEle ele){
		if(hasChild){
			childs.add(ele);
		}	
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public void forward(Context con){
		if(it!=null&&con!=null){
			con.startActivity(it);
		}
	}
}