package com.example.zombieruns;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import com.zombieruns.R;

@SuppressLint("NewApi")
public class AttackLaptop extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attack_laptop);
		
		ActionBar actionBar = getActionBar();
        actionBar.hide();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.attack_laptop, menu);
		return true;
	}
	public void ContinueHallway(View view)
    {	
    	Intent intent = new Intent(this, ContinueHallwayBat.class);
    	startActivity(intent);
    
    }
	public void CheckFriend(View view)
    {	
    	Intent intent = new Intent(this, CheckFriend.class);
    	startActivity(intent);
    
    }

}
