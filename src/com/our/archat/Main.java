package com.our.archat;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main extends Activity {

	private ImageView me=null,msg=null,ivuser=null;
	private Button add=null,find=null;
	private ListView lvl=null,lvr=null;
	private RelativeLayout rll=null;
	private LinearLayout llr=null;
	private DrawerLayout dl=null;
	private TextView tvuser=null;
	
	private ArrayAdapter<String> lAdapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);	//隐藏标题
        setContentView(R.layout.aty_main);

        me=(ImageView) findViewById(R.id.btnme);
        msg=(ImageView) findViewById(R.id.btnmsg);
        ivuser=(ImageView) findViewById(R.id.ivuser);
        add=(Button) findViewById(R.id.btnadd);
        find=(Button) findViewById(R.id.btnfind);
        lvl=(ListView) findViewById(R.id.left);
        lvr=(ListView) findViewById(R.id.right);
        rll=(RelativeLayout) findViewById(R.id.rll);
        llr=(LinearLayout) findViewById(R.id.llr);
        dl=(DrawerLayout) findViewById(R.id.drawer_layout);
        tvuser=(TextView) findViewById(R.id.tvuser);
        
        lAdapter=new ArrayAdapter<String>(this, R.layout.cell_left, R.id.tv);
        lvl.setAdapter(lAdapter);
        lAdapter.add("历史记录");
        lAdapter.add("新手引导");
        lAdapter.add("分享软件");
        lAdapter.add("退出应用");
        
        //点击添加按钮
        add.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(Main.this, AddContent.class);
				startActivity(intent);
			}
		});
        
        find.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(Main.this, LocationFilter.class);
				startActivity(intent);
			}
		});
        
        //点击头像打开修改个人主页
        ivuser.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(Main.this, User.class);
				startActivity(intent);
			}
		});
        
        //点击左侧按钮右滑（个人主页界面）
        me.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!dl.isDrawerOpen(rll)){
					dl.openDrawer(rll);
				}
			}
		});
        
        //点击右侧按钮左滑（消息界面）
        msg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!dl.isDrawerOpen(llr)){
					dl.openDrawer(llr);
				}
			}
		});
        
        //左侧列表监听
        lvl.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				switch (arg2) {
				case 0://历史记录
					
					break;
				case 1://新手引导
					new AlertDialog.Builder(Main.this).setTitle("新手引导").
					setMessage("这个到时候随便写写就行吧").setPositiveButton("知道了", null).show();
					break;
				case 2://分享软件
					File file=new File(getApplicationContext().getPackageResourcePath());
					Intent intent=new Intent(Intent.ACTION_SEND);
					intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
					intent.setType("text/plain");
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(Intent.createChooser(intent, "分享到"));
					break;
				case 3://退出
					finish();
					break;
				default:
					break;
				}
			}
		});
        }
    
    @Override
    public void onBackPressed() {
    	// TODO Auto-generated method stub
    	super.onBackPressed();
    	finish();
    }
}
