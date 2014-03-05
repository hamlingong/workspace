package lmc.lonely.base;
import lmc.lonely.R;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;
public class BWidget2 extends AppWidgetProvider {
	private static String Update = "lmc.lonely.base.WIDGET_UPDATE";
	@Override
	public void onUpdate(Context con, AppWidgetManager mgr, int[]ids) {
		super.onUpdate(con, mgr, ids);
		Toast.makeText(con,"ִ�и���B",Toast.LENGTH_SHORT).show();
		Intent it = new Intent();
		it.setAction(Update);
		RemoteViews rViews = new RemoteViews(con.getPackageName(),R.layout.base_widg);
		PendingIntent pIt = PendingIntent.getBroadcast(con,0,it,0);
		rViews.setOnClickPendingIntent(R.id.widg_call,pIt);
		mgr.updateAppWidget(ids,rViews);
	}
	@Override
	public void onDeleted(Context con, int[]ids) {
		super.onDeleted(con, ids);
		Toast.makeText(con,"�Ƴ�����Ӧ��B",Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onEnabled(Context con) {
		super.onEnabled(con);
		Toast.makeText(con,"ִ������B",Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onDisabled(Context con) {
		super.onDisabled(con);
		Toast.makeText(con,"ִ�н���B",Toast.LENGTH_SHORT).show();
	}
	@Override
	public void onReceive(Context con, Intent it) {
		Toast.makeText(con,"���ܹ㲥�¼�B",Toast.LENGTH_SHORT).show();
		if(it.getAction().equals(Update)){
			RemoteViews rViews = new RemoteViews(con.getPackageName(),R.layout.base_widg);
			rViews.setTextViewText(R.id.widg_hello,"�϶�����");
			AppWidgetManager mgr = AppWidgetManager.getInstance(con);
			ComponentName com = new ComponentName(con,BWidget2.class);
			mgr.updateAppWidget(com,rViews);
			Toast.makeText(con,"���ܵ��˹㲥",Toast.LENGTH_SHORT).show();
		}else{
			super.onReceive(con, it);
		}
	}
}