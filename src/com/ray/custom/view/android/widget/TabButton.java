package com.ray.custom.view.android.widget;



import com.ray.custom.view.android.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;

public class TabButton extends Button {
	private int normal_bg_res;
	private int selected_bg_res;

	public TabButton(Context context) {
		super(context);
	}

	public TabButton(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray typeArray = context.obtainStyledAttributes(attrs,
				R.styleable.TabButton);
		normal_bg_res = typeArray.getResourceId(
				R.styleable.TabButton_normal_background, 0);
		selected_bg_res = typeArray.getResourceId(
				R.styleable.TabButton_selected_background, 0);

		typeArray.recycle();
	}

	public void setSelected(boolean selected) {
		if (selected) {
			setBackgroundResource(selected_bg_res);
			setTextColor(Color.WHITE);
		} else {
			setBackgroundResource(normal_bg_res);
			setTextColor(Color.BLACK);
		}
	}

}
