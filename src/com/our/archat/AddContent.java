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
		requestWindowFeature(Window.FEATURE_NO_TITLE);	//隐藏标题
		setContentView(R.layout.aty_addcontent);
		
		text=(Button) findViewById(R.id.btntext);
		auth=(Button) findViewById(R.id.btnauth);
		ok=(Button) findViewById(R.id.btnok);
		et=(EditText) findViewById(R.id.et);
		
		popMenu1 = new PopMenu(this);
		popMenu1.addItems(new String[]{"图片", "声音", "视频"});
		popMenu1.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(int index) {
				// TODO Auto-generated method stub
				switch (index) {
				case 0://图片
					
					break;
				case 1://声音
					break;
				case 2://视频
					break;
				default:
					break;
				}
			}
		});
		
		popMenu2 = new PopMenu(this);
		popMenu2.addItems(new String[]{"私密"});
		popMenu2.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(int index) {
				// TODO Auto-generated method stub
				//私密
			}
		});
		
		//文字选项按钮点击
		text.setOnClickListener(new View.OnClickListener() {
					
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popMenu1.showAsDropDown(v);
			}
		});
		
		//公开选项按钮点击
		auth.setOnClickListener(new View.OnClickListener() {
							
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				popMenu2.showAsDropDown(v);
			}
		});
	}
	
	
}
