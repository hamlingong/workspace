package lmc.lonely.base;
import lmc.lonely.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;
public class BTouch extends Activity {
	private TextView touch_msg = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_touch);
        touch_msg = (TextView) super.findViewById(R.id.touch_msg);
    }
	@Override
    public boolean onTouchEvent(MotionEvent e) {
    	float screenX = e.getRawX();
    	float screenY = e.getRawY();
    	float vX = e.getX();
    	float vY = e.getY();
    	switch(e.getAction()){
	    	case MotionEvent.ACTION_DOWN:touch_msg.setText("������Ļ:("+screenX+","+screenY+") ("+vX+","+vY+")");break;
	    	case MotionEvent.ACTION_MOVE:touch_msg.setText("�����ƶ�:("+screenX+","+screenY+") ("+vX+","+vY+")");break;
	    	case MotionEvent.ACTION_UP:touch_msg.setText("ֹͣ����:("+screenX+","+screenY+") ("+vX+","+vY+")");break;
    	}
    	StringBuffer sb = new StringBuffer();
    	int count = e.getPointerCount();
    	for(int i=0;i<count;i++){
    		sb.append("��"+(i+1)+"�����ص�:"+e.getPointerId(i)+" ("+e.getX(i)+","+e.getY(i)+
    			")\n��ָѹ��:"+e.getPressure(i)+"\n�¼���ʼʱ��:"+e.getDownTime()+"\n�¼�����ʱ��:"+e.getEventTime()+
    			"\n�¼���ʱ:"+(e.getEventTime()-e.getDownTime())+"����");
    	}
    	sb.append("\n����"+count+"�����ص�");
    	Toast.makeText(this,sb.toString(),50).show();
    	return true;
    }
}