package com.our.archat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;


public class User extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}
}
