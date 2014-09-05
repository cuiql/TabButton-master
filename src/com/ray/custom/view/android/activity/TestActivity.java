package com.ray.custom.view.android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.ray.custom.view.android.R;
import com.ray.custom.view.android.widget.TabButton;

public class TestActivity extends Activity implements OnClickListener {
	private TabButton left;
	private TabButton center;
	private TabButton right;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		left = (TabButton) findViewById(R.id.btn_left);
		left.setOnClickListener(this);

		center = (TabButton) findViewById(R.id.btn_center);
		center.setOnClickListener(this);

		right = (TabButton) findViewById(R.id.btn_right);
		right.setOnClickListener(this);

		resetState(R.id.btn_left);
	}

	public void onClick(View v) {
		resetState(v.getId());
	}

	private void resetState(int id) {
		// ｽｫﾈ�ｴﾅ･ｱｳｾｰﾉ靹ﾃﾎｪﾎｴﾑ｡ﾖﾐ
		left.setSelected(false);
		center.setSelected(false);
		right.setSelected(false);
		
		// ｽｫｵ羹ﾄｰｴﾅ･ｱｳｾｰﾉ靹ﾃﾎｪﾒﾑﾑ｡ﾖﾐ
		switch (id) {
		case R.id.btn_left:
			left.setSelected(true);
			break;
		case R.id.btn_center:
			center.setSelected(true);
			break;
		case R.id.btn_right:
			right.setSelected(true);
			break;
		}
	}
}