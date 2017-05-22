package com.our.archat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.EditText;

public class LineEditText extends EditText{

	private Rect mRect;
	private Paint mPaint;
	
	public LineEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mRect=new Rect();
		mPaint=new Paint();
		mPaint.setColor(Color.GRAY);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		int lineCount=getLineCount();
		Rect r=mRect;
		Paint p=mPaint;
		
		for(int i=0;i<lineCount;i++){
			int baseline=getLineBounds(i, r);
			canvas.drawLine(r.left, baseline+5, r.right, baseline+5, p);
		}
	}

}
