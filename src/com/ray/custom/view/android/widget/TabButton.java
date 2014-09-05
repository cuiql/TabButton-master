package com.ray.custom.view.android.widget;



import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

import com.ray.custom.view.android.R;
import com.ray.custom.view.android.widget.TabButtonGroup.OnChildCheckChangedListener;

public class TabButton extends Button {
	private int mNormalBackground;
	private int mSelectBackgroud;
	private boolean mChecked = false;
	
	private OnChildCheckChangedListener mListener;

	public TabButton(Context context) {
		super(context);
		
	}
	
	public boolean isChecked(){
		return mChecked;
	}
	
	public void setChecked(boolean checked){
		mListener.onChanged(this,checked,false);
	}

	public TabButton(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray typeArray = context.obtainStyledAttributes(attrs,
				R.styleable.TabButton);
		mNormalBackground = typeArray.getResourceId(
				R.styleable.TabButton_normal_background, 0);
		mSelectBackgroud = typeArray.getResourceId(
				R.styleable.TabButton_selected_background, 0);
		
		
		

		typeArray.recycle();
	}
	
	public void setOnChildCheckChangedListener(OnChildCheckChangedListener listener){
		mListener = listener;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		if(event.getAction() == MotionEvent.ACTION_UP){
			mListener.onChanged(this,true,true);
		}
		return super.onTouchEvent(event);
	}
	
	public void update(boolean checked){
		if (checked) {
			setBackgroundResource(mSelectBackgroud);
			setTextColor(Color.WHITE);
		} else {
			setBackgroundResource(mNormalBackground);
			setTextColor(Color.BLACK);
		}
	}

}
