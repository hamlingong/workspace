package lmc.adater;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
public class BListView3Adapter extends BaseExpandableListAdapter {
	private Context con = null;
	private String[]groups = new String[]{"�ҵĺ���","У��","����ѧԺ","����","����"};
	private String[][]children = new String[][]{{"л����","�޷�"},{"����","���","���","������"},
		{"�»�","�촫��","����","�轭��"},{"֣ݶ","����","��־��"},{"��ε","����"}};
	public BListView3Adapter(Context con) {
		this.con = con;
	}
	@Override
	public Object getChild(int gId, int cId) {
		return this.children[gId][cId];
	}
	@Override
	public long getChildId(int gId, int cId) {
		return cId;
	}
	@Override
	public View getChildView(int gId, int cId, boolean isLastChild, View v, ViewGroup par) {
		TextView tv = this.creatTxt(10);
		tv.setText(this.getChild(gId,cId).toString());
		return tv;
	}
	@Override
	public int getChildrenCount(int gId) {
		return this.children[gId].length;
	}
	@Override
	public Object getGroup(int gId) {
		return this.groups[gId];
	}
	@Override
	public int getGroupCount() {
		return this.groups.length;
	}
	@Override
	public long getGroupId(int gId) {
		return gId;
	}
	@Override
	public View getGroupView(int gId, boolean isExpanded, View v, ViewGroup par) {
		TextView tv = this.creatTxt(15);
		tv.setText(this.getGroup(gId).toString());
		return tv;
	}
	@Override
	public boolean hasStableIds() {
		return true;
	}
	@Override
	public boolean isChildSelectable(int gId, int cId) {
		return true;
	}
	private TextView creatTxt(int size){
		TextView tv = new TextView(con);
		tv.setTextColor(0xFF000000);
		tv.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.FILL_PARENT));
		tv.setTextSize(size);
		tv.setGravity(Gravity.LEFT);
		tv.setPadding(45,0,0,0);
		return tv;
	}
}