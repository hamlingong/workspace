package lmc.lonely.base;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import lmc.lonely.R;
import lmc.lonely.SysConts;
public class BDialog extends Activity implements OnClickListener {
	private Button dia_yuan = null;
	private Button dia_tiao = null;
	private Button dia_toastset = null;
	private Button dia_toastcus = null;
	private TextView dia_chgres = null;
	private Button dia_chg = null;
	private Button dia_mstd = null;
	private String[]fruits = new String[]{"��֦","����","����","����"};
	private Button dia_schs1 = null;
	private Button dia_schs2 = null;
	private int seleted = 0;
	private String[]homes = new String[]{"���","�Ϻ�","�人","����"};
	private String[]descs = new String[]{"�����ž黨������","�Ϻ����й����ĳ���֮һ",
			"�人�������в�����","���ڵ�����ҵ�ܷ���"};
	private Button dia_schs3 = null;
	private TextView dia_schsres = null;
	private String[]classes = new String[]{"��Ϣ","����","����","Ӣ��","��ó"};
	private boolean[]isChkeds = new boolean[]{false,false,false,false,false};
	private Button dia_mchs = null;
	private TextView dia_mchsres = null;
	private Button dia_cus = null;
	private Button dia_date = null;
	private Button dia_time = null;
	private TextView dia_dtres = null;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_dia);
        dia_yuan = (Button) super.findViewById(R.id.dia_yuan);
        dia_tiao = (Button) super.findViewById(R.id.dia_tiao);
        dia_toastset = (Button) super.findViewById(R.id.dia_toastset);
        dia_toastcus = (Button) super.findViewById(R.id.dia_toastcus);
        dia_chgres = (TextView) super.findViewById(R.id.dia_chgres);
        dia_chg = (Button) super.findViewById(R.id.dia_chg);
        dia_mstd = (Button) super.findViewById(R.id.dia_mstd);
        dia_schs1 = (Button) super.findViewById(R.id.dia_schs1);
        dia_schs2 = (Button) super.findViewById(R.id.dia_schs2);
        dia_schs3 = (Button) super.findViewById(R.id.dia_schs3);
        dia_schsres = (TextView) super.findViewById(R.id.dia_schsres);
        dia_mchs = (Button) super.findViewById(R.id.dia_mchs);
        dia_mchsres = (TextView) super.findViewById(R.id.dia_mchsres);
        dia_cus = (Button) super.findViewById(R.id.dia_cus);
        dia_date = (Button) super.findViewById(R.id.dia_date);
        dia_time = (Button) super.findViewById(R.id.dia_time);
        dia_dtres = (TextView) super.findViewById(R.id.dia_dtres);
        dia_yuan.setOnClickListener(this);
        dia_tiao.setOnClickListener(this);
        dia_toastset.setOnClickListener(this);
        dia_toastcus.setOnClickListener(this);
        dia_chg.setOnClickListener(this);
        dia_mstd.setOnClickListener(this);
        dia_schs1.setOnClickListener(this);
        dia_schs2.setOnClickListener(this);
        dia_schs3.setOnClickListener(this);
        dia_mchs.setOnClickListener(this);
        dia_cus.setOnClickListener(this);
        dia_date.setOnClickListener(this);
        dia_time.setOnClickListener(this);
    }
	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.dia_yuan){
			final ProgressDialog yuan = ProgressDialog.show(this,"��������","������...");
			//�ȼ�����һ��
			/*final ProgressDialog yuan = new ProgressDialog(this);
			yuan.setTitle("��������");
			yuan.setMessage("������...");
			yuan.onStart();*/
			new Thread(){
				@Override
				public void run() {
					try{
						Thread.sleep(3000);
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						yuan.dismiss();
					}
				}
			}.start();
			yuan.show();
		}else if(v.getId()==R.id.dia_tiao){
			final ProgressDialog tiao = new ProgressDialog(this);
			tiao.setTitle("��������");
			tiao.setMessage("������...");
			tiao.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			tiao.setMax(100);
			tiao.setProgress(10);
			tiao.setButton("��̨",new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dia, int which) {
					dia.dismiss();
				}
			});
			tiao.setButton2("����",new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dia, int which) {
					dia.dismiss();
				}
			});
			tiao.onStart();
			new Thread(){
				@Override
				public void run() {
					try{
						for(int i=10;i<100;i++){
							Thread.sleep(100);
							tiao.incrementProgressBy(1);
						}
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						tiao.dismiss();
					}
				}
			}.start();
			tiao.show();
		}else if(v.getId()==R.id.dia_toastset){
			Toast toast = Toast.makeText(this,"�ײ�����",Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
			toast.show();
		}else if(v.getId()==R.id.dia_toastcus){
			Toast toast = Toast.makeText(this,SysConts.appName+"��ӭ��",Toast.LENGTH_SHORT);
			toast.setGravity(Gravity.CENTER,60,60);
			ImageView iv = new ImageView(this);
			iv.setImageResource(R.drawable.icob_dia);
			LinearLayout lay = (LinearLayout) toast.getView();
			lay.addView(iv,0);
			toast.show();
		}else if(v.getId()==R.id.dia_chg){
			final View view = LayoutInflater.from(this).inflate(R.layout.base_diapopup,null);
			final PopupWindow win = new PopupWindow(view,240,300,true);
			win.showAtLocation(dia_chg,Gravity.CENTER,0,0);
			RadioGroup dia_choose = (RadioGroup)view.findViewById(R.id.dia_choose);
			dia_choose.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					RadioButton rbt = (RadioButton)view.findViewById(checkedId);
					dia_chgres.setText("��ǰ״̬:"+rbt.getText());
					win.dismiss();
				}
			});
			Button dia_cancel = (Button)view.findViewById(R.id.dia_cancel);
			dia_cancel.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					win.dismiss();
				}
			});
		}else if(v.getId()==R.id.dia_mstd){
			Dialog delDia = new AlertDialog.Builder(this).setIcon(R.drawable.ico_logo).setTitle("ɾ��").
				setMessage("��ȷ��ɾ����").setPositiveButton("ɾ��",new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dia, int which) {
						Toast.makeText(BDialog.this,"ѡ����ɾ��",Toast.LENGTH_SHORT).show();
					}
				}).setNeutralButton("�鿴",new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dia, int which) {
						Toast.makeText(BDialog.this,"ѡ���˲鿴",Toast.LENGTH_SHORT).show();
				}
				}).setNegativeButton("ȡ��",new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dia, int which) {
						Toast.makeText(BDialog.this,"ѡ����ȡ��",Toast.LENGTH_SHORT).show();
						dia.dismiss();
					}
				}).create();
			delDia.show();
		}else if(v.getId()==R.id.dia_schs1){
			Dialog schDia = new AlertDialog.Builder(this).setIcon(R.drawable.ico_logo).setTitle("��ѡ��").
				setItems(fruits,new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dia, int which) {
						dia_schsres.setText(fruits[which]);
					}
				}).setNegativeButton("ȡ��",new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dia, int which) {
						dia.dismiss();
					}
				}).create();
			schDia.show();
		}else if(v.getId()==R.id.dia_schs2){
			Dialog arrDia = new AlertDialog.Builder(this).setIcon(R.drawable.ico_logo).setTitle("��ѡ��").
				setItems(R.array.dia_stu,new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dia, int which) {
						dia_schsres.setText(BDialog.this.getResources().getStringArray(R.array.dia_stu)[which]);
					}
				}).setNegativeButton("ȡ��",new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dia, int which) {
						dia.dismiss();
					}
				}).create();
			arrDia.show();
		}else if(v.getId()==R.id.dia_schs3){
			Dialog radDia = new AlertDialog.Builder(this).setIcon(R.drawable.ico_logo).setTitle("��ѡ��").
				setSingleChoiceItems(homes,0,new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dia, int which) {
						seleted = which;
					}
				}).setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dia, int which) {
						dia_schsres.setText(descs[seleted]);
					}
				}).setNegativeButton("ȡ��",new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dia, int which) {
						dia.dismiss();
					}
				}).create();
			radDia.show();
		}else if(v.getId()==R.id.dia_mchs){
			Dialog mchDia = new AlertDialog.Builder(this).setIcon(R.drawable.ico_logo).setTitle("��ѡ��")
				.setMultiChoiceItems(classes,isChkeds,new DialogInterface.OnMultiChoiceClickListener() {
					@Override
					public void onClick(DialogInterface dia, int which, boolean isChecked) {
						isChkeds[which] = isChecked;
					}
				}).setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dia, int which) {
						StringBuffer cont = new StringBuffer();
						for(int i=0;i<isChkeds.length;i++){
							if(isChkeds[i]){
								cont.append(classes[i]+" ");
								isChkeds[i] = false;
							}
						}
						if(cont.length()>0){
							dia_mchsres.setText(cont.toString());
						}
					}
				}).setNegativeButton("ȡ��",new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dia, int which) {
						dia.dismiss();
					}
				}).create();
			mchDia.show();
		}else if(v.getId()==R.id.dia_cus){
			View login = LayoutInflater.from(this).inflate(R.layout.base_dialogin,null);
			Dialog cusDia = new AlertDialog.Builder(this).setIcon(R.drawable.ico_logo).setTitle("���¼").
		        setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {
		        	@Override
					public void onClick(DialogInterface dia, int which) {
						dia.dismiss();
					}
				}).setNegativeButton("ȡ��",new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dia, int which) {
						dia.dismiss();
					}
				}).setView(login).create();
	        cusDia.show();
		}else if(v.getId()==R.id.dia_date){
			Dialog date = new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener() {
				@Override
				public void onDateSet(DatePicker v, int year, int month, int day) {
					dia_dtres.setText("��������:"+year+"-"+(month+1)+"-"+day);
				}
			},1988,11,26);
			date.show();
		}else if(v.getId()==R.id.dia_time){
			Dialog time = new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener() {
				@Override
				public void onTimeSet(TimePicker v, int hour, int minute) {
					dia_dtres.setText("����ʱ��:"+hour+":"+minute);
				}
			},23,20,true);
			time.show();
		}
	}
}