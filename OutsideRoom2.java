package com.example.zombieruns;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import com.zombieruns.R;

public class OutsideRoom2 extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_outside_room2);
		
		ActionBar actionBar = getActionBar();
        actionBar.hide();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.outside_room2, menu);
		return true;
	}
	public void DeathScene(View view)
    {	
    	Intent intent = new Intent(this, DeadScene.class);
    	startActivity(intent);
    
    }


}
