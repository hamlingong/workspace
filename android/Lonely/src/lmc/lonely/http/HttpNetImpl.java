package lmc.lonely.http;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import lmc.lonely.R;
import lmc.lonely.SysArgs;
import lmc.lonely.SysConts;
public class HttpNetImpl extends Activity implements OnClickListener {
	private Button net_login = null;
	private Button net_ja = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.http_net);
        Toast.makeText(this,"�Ȱ�װ����"+SysConts.appName+"����˲��޸� ����->���Ӻ�̨ ����ַ",Toast.LENGTH_SHORT).show();
        net_login = (Button) super.findViewById(R.id.net_simp);
        net_ja = (Button) super.findViewById(R.id.net_ja);
        net_login.setOnClickListener(this);
        net_ja.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.net_simp){
			HashMap<String,Object>args = new HashMap<String,Object>();
			args.put("type","login");
			args.put("username","lmc");
			args.put("password","123456");
			Toast.makeText(this,HttpNetFac.doPost(SysArgs.getUrlServlet(),args),Toast.LENGTH_SHORT).show();
		}else if(v.getId()==R.id.net_ja){
			try{
				HashMap<String,Object>args = new HashMap<String,Object>();
				args.put("type","jarray");
				JSONArray ja = new JSONArray(HttpNetFac.doPost(SysArgs.getUrlJarray(),args));
				StringBuffer sb = new StringBuffer("JSON����\n");
				JSONObject jobj = null;
				for(int i=0;i<ja.length();i++){
					jobj = (JSONObject) ja.get(i);
					sb.append("������("+i+"):"+jobj.get("name")+"\n");
					sb.append("��ϵ�绰("+i+"):"+jobj.get("phone")+"\n");
					sb.append("QQ("+i+"):"+jobj.get("qq")+"\n");
				}
				sb.append("��"+ja.length()+"������");
				Toast.makeText(this,sb.toString(),Toast.LENGTH_SHORT).show();
			}catch(Exception e){
				Toast.makeText(this,"�����쳣",Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}
		}
	}
}