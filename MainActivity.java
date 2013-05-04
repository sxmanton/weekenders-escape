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
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();
        actionBar.hide();

      
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public void Aspirin(View view)
    {
    	Intent intent = new Intent(this, Aspirin.class);
    	startActivity(intent);
    	
    }
    public void checkPhone(View view)
    {
    	Intent intent = new Intent(this, Phone.class);
    	startActivity(intent);
    	
    }
    public void checkTV(View view)
    {
    	Intent intent = new Intent(this, TV.class);
    	startActivity(intent);
    	
    }
}
