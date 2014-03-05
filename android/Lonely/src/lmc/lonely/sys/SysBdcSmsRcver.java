package lmc.lonely.sys;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;
public class SysBdcSmsRcver extends BroadcastReceiver {
	@Override
	public void onReceive(Context con, Intent it) {
		Bundle data = it.getExtras();
		Object[]objs = (Object[])data.get("pdus");
		SmsMessage[]smses = new SmsMessage[objs.length];
		StringBuffer sb = new StringBuffer("���յ�lmc.lonely.sys.SysBdc�Ĺ㲥\n");
		for(int i=0;i<objs.length;i++){
			smses[i] = SmsMessage.createFromPdu((byte[])objs[i]);
			sb.append("����"+i+":"+smses[i].getDisplayMessageBody());
		}
		sb.append("����"+objs.length+"������");
		Toast.makeText(con,sb.toString(),Toast.LENGTH_SHORT).show();
		Log.i("lmc","------------------->ok");
	}
}