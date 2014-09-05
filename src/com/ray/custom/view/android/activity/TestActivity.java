package com.ray.custom.view.android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.ray.custom.view.android.R;
import com.ray.custom.view.android.widget.TabButton;
import com.ray.custom.view.android.widget.TabButtonGroup;
import com.ray.custom.view.android.widget.TabButtonGroup.OnCheckedChangeListener;

public class TestActivity extends Activity implements OnClickListener{
	
	private TabButtonGroup g;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		g = (TabButtonGroup) this.findViewById(R.id.tabGroup);

		g.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(int checkedId) {
				switch (checkedId) {
				case R.id.btn_left:
					
					Toast.makeText(TestActivity.this, "Left", Toast.LENGTH_SHORT).show();
					break;
				case R.id.btn_center:
					Toast.makeText(TestActivity.this, "Center", Toast.LENGTH_SHORT).show();
					break;
				case R.id.btn_right:
					Toast.makeText(TestActivity.this, "Right", Toast.LENGTH_SHORT).show();
					break;
				}

			}

		});
		
		Button left = (Button)findViewById(R.id.left);
		left.setOnClickListener(this);
		
		Button center = (Button)findViewById(R.id.center);
		center.setOnClickListener(this);
		
		Button right = (Button)findViewById(R.id.right);
		right.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.left:
			((TabButton)this.findViewById(R.id.btn_left)).setChecked(true);
			break;
			
		case R.id.center:
			((TabButton)this.findViewById(R.id.btn_center)).setChecked(true);
			break;
			
		case R.id.right:
			((TabButton)this.findViewById(R.id.btn_right)).setChecked(true);
			break;
		}
		
	}

}