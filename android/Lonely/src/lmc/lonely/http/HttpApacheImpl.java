package lmc.lonely.http;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.util.InetAddressUtils;
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
public class HttpApacheImpl extends Activity implements OnClickListener {
	private Button apache_simp = null;
	private Button apache_comx = null;
	private Button apache_entity = null;
	private Button apache_json = null;
	private Button apache_ja = null;
	private Button apache_cookie = null;
	private Button apache_ip = null;
	private Button apache_simpsv = null;
	private Button apache_jasv = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.http_apache);
        Toast.makeText(this,"�Ȱ�װ����"+SysConts.appName+"����˲��޸� ����->���Ӻ�̨ ����ַ",Toast.LENGTH_SHORT).show();
        apache_simp = (Button) super.findViewById(R.id.apache_simp);
        apache_comx = (Button) super.findViewById(R.id.apache_comx);
        apache_entity = (Button) super.findViewById(R.id.apache_entity);
        apache_json = (Button) super.findViewById(R.id.apache_json);
        apache_ja = (Button) super.findViewById(R.id.apache_ja);
        apache_cookie = (Button) super.findViewById(R.id.apache_cookie);
        apache_ip = (Button) super.findViewById(R.id.apache_ip);
        apache_simpsv = (Button) super.findViewById(R.id.apache_simpsv);
        apache_jasv = (Button) super.findViewById(R.id.apache_jasv);
        apache_simp.setOnClickListener(this);
        apache_comx.setOnClickListener(this);
        apache_entity.setOnClickListener(this);
        apache_json.setOnClickListener(this);
        apache_ja.setOnClickListener(this);
        apache_cookie.setOnClickListener(this);
        apache_ip.setOnClickListener(this);
        apache_simpsv.setOnClickListener(this);
        apache_jasv.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.apache_simp){
			try{
				HttpPost post = new HttpPost(SysArgs.getUrlLogin()+"?username=lmc&password=123456");
				HttpResponse resp = HttpApacheFac.getHttpClient().execute(post);
				if(resp.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
					StringBuffer sb = new StringBuffer();
					BufferedReader br = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
					for(String line=br.readLine();line!=null;line=br.readLine()){
	    				sb.append(line);
	    			}
					Toast.makeText(this,sb.toString(),Toast.LENGTH_SHORT).show();
	            }else{
	            	post.abort();
	            }
			}catch(Exception e){
				Toast.makeText(this,"�����쳣",Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}
		}else if(v.getId()==R.id.apache_comx){
			HashMap<String,Object>args = new HashMap<String,Object>();
			args.put("username","lmc");
			args.put("password","123456");
			Toast.makeText(this,HttpApacheFac.doPost(SysArgs.getUrlLogin(),args),Toast.LENGTH_SHORT).show();
		}else if(v.getId()==R.id.apache_entity){
			HashMap<String,Object>args = new HashMap<String,Object>();
			args.put("book.bkid",100);
			args.put("book.bkname","��ƽ�������硷");
			args.put("book.bkprice",99.9f);
			Toast.makeText(this,HttpApacheFac.doPost(SysArgs.getUrlEntity(),args),Toast.LENGTH_SHORT).show();
		}else if(v.getId()==R.id.apache_json){
			try{
				HashMap<String,Object>args = new HashMap<String,Object>();
				args.put("type","json");
				JSONObject jobj = new JSONObject(HttpApacheFac.doPost(SysArgs.getUrlJson(),args));
				StringBuffer sb = new StringBuffer("����JSON\n");
				sb.append("������:"+jobj.getString("name")+"\n");
				sb.append("��ϵ�绰:"+jobj.getString("phone")+"\n");
				sb.append("QQ:"+jobj.getString("qq"));
				Toast.makeText(this,sb.toString(),Toast.LENGTH_SHORT).show();
			}catch(Exception e){
				Toast.makeText(this,"�����쳣",Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}
		}else if(v.getId()==R.id.apache_ja){
			try{
				HashMap<String,Object>args = new HashMap<String,Object>();
				args.put("type","jarray");
				JSONArray ja = new JSONArray(HttpApacheFac.doPost(SysArgs.getUrlJarray(),args));
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
		}else if(v.getId()==R.id.apache_cookie){
			Toast.makeText(this,HttpApacheFac.getCookies(SysArgs.getUrlLogin()+"?username=lmc&password=123456"),Toast.LENGTH_SHORT).show();
		}else if(v.getId()==R.id.apache_ip){
			try{
				StringBuffer sb = new StringBuffer();
				int count = 0;
				for(Enumeration<NetworkInterface>niEn = NetworkInterface.getNetworkInterfaces();niEn.hasMoreElements();){
					NetworkInterface net = niEn.nextElement();
					for(Enumeration<InetAddress>iaEn = net.getInetAddresses();iaEn.hasMoreElements();){
						InetAddress addr = iaEn.nextElement();
						if(!addr.isLoopbackAddress()){
							sb.append((InetAddressUtils.isIPv4Address(addr.getHostAddress())?"IPv4��ַ:":"IPv6��ַ:")+addr.getHostAddress()+"\n");
							count++;
						}
					}
				}
				sb.append("����"+count+"��");
				Toast.makeText(this,sb.toString(),Toast.LENGTH_SHORT).show();
			}catch(Exception e){
				Toast.makeText(this,"��ȡ�ֻ�IPʧ��",Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}
		}else if(v.getId()==R.id.apache_simpsv){
			HashMap<String,Object>args = new HashMap<String,Object>();
			args.put("type","login");
			args.put("username","lmc");
			args.put("password","123456");
			Toast.makeText(this,HttpApacheFac.doPost(SysArgs.getUrlServlet(),args),Toast.LENGTH_SHORT).show();
		}else if(v.getId()==R.id.apache_jasv){
			HashMap<String,Object>args = new HashMap<String,Object>();
			args.put("type","jarray");
			try{
				JSONArray ja = new JSONArray(HttpApacheFac.doPost(SysArgs.getUrlServlet(),args));
				if(ja!=null&&ja.length()>0){
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
				}else{
					Toast.makeText(this,"û������",Toast.LENGTH_SHORT).show();
				}
			}catch(Exception e){
				Toast.makeText(this,"�����쳣",Toast.LENGTH_SHORT).show();
				e.printStackTrace();
			}
		}
	}
}