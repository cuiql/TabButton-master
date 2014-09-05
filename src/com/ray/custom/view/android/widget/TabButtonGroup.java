package com.ray.custom.view.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class TabButtonGroup extends LinearLayout {

	private OnChildCheckChangedListener mInnerListener = new OnChildCheckChangedListener() {

		@Override
		public void onChanged(TabButton tab,boolean isChecked,boolean isFromUser) {
			doChildChanged(tab,isChecked,isFromUser);
		}

	};

	private OnCheckedChangeListener mCheckedChangeListener;

	public TabButtonGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public TabButtonGroup(Context context) {
		super(context);
	}

	public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
		mCheckedChangeListener = listener;
	}

	@Override
	public void addView(View child, int index,
			android.view.ViewGroup.LayoutParams params) {

		if (child instanceof TabButton) {

			((TabButton) child).update(((TabButton) child).isChecked());
			((TabButton) child).setOnChildCheckChangedListener(mInnerListener);
		}

		super.addView(child, index, params);
	}

	private void doChildChanged(TabButton tab,boolean isChecked,boolean isFromUser) {
		int childCount = super.getChildCount();
		for (int i = 0; i < childCount; i++) {

			TabButton t = (TabButton) super.getChildAt(i);

			if (t.getId() == tab.getId()) {
				t.update(isChecked);
				if (mCheckedChangeListener != null&& isFromUser) {
					mCheckedChangeListener.onCheckedChanged(t.getId());
				}
			} else {
				t.update(false);
			}
		}
	}

	interface OnChildCheckChangedListener {
		public void onChanged(TabButton tab,boolean isChecked,boolean isFromUser);
	}

	public interface OnCheckedChangeListener {
		public void onCheckedChanged(int id);
	}

}
