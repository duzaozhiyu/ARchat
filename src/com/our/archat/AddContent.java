package com.our.archat;

import com.our.archat.PopMenu.OnItemClickListener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class AddContent extends Activity {

	private Button text=null,auth=null,ok=null;
	private EditText et=null;
	
	private PopMenu popMenu1,popMenu2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);	//���ر���
		setContentView(R.layout.aty_addcontent);
		
		text=(Button) findViewById(R.id.btntext);
		auth=(Button) findViewById(R.id.btnauth);
		ok=(Button) findViewById(R.id.btnok);
		et=(EditText) findViewById(R.id.et);
		
		popMenu1 = new PopMenu(this);
		popMenu1.addItems(new String[]{"ͼƬ", "����", "��Ƶ"});
		popMenu1.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(int index) {
				// TODO Auto-generated method stub
				switch (index) {
				case 0://ͼƬ
					
					break;
				case 1://����
					break;
				case 2://��Ƶ
					break;
				default:
					break;
				}
			}
		});
		
		popMenu2 = new PopMenu(this);
		popMenu2.addItems(new String[]{"˽��"});
		popMenu2.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(int index) {
				// TODO Auto-generated method stub
				//˽��
			}
		});
		
		//����ѡ�ť���
		text.setOnClickListener(new View.OnClickListener() {
					
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popMenu1.showAsDropDown(v);
			}
		});
		
		//����ѡ�ť���
		auth.setOnClickListener(new View.OnClickListener() {
							
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popMenu2.showAsDropDown(v);
			}
		});
	}
	
	
}
