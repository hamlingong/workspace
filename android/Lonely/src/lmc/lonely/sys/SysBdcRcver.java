package lmc.lonely.sys;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
public class SysBdcRcver extends BroadcastReceiver {
	@Override
	public void onReceive(Context con, Intent it) {
		Toast.makeText(con,this.getClass().getName()+"->����ʵ�ֽ��յ�"+SysBdc.class.getName()+"�Ĺ㲥",Toast.LENGTH_SHORT).show();
	}
}