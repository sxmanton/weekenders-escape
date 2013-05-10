package com.undeadchoices;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @SuppressLint("NewApi") @Override
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
    
    public void Button1Down(View view){
    	if (button1_goesto == 10)
		{
			hasLaptop = true;
			hasFood = true;
		}
		UpdateScene(button1_goesto);	
	}
	public void Button2Down(View view){
		if (button2_goesto == 10)
		{
			hasLaptop = true;
			//hasFirstAid = true;
		}
		if (button2_goesto == 19)
		{
			hasBat = true;
		}
		UpdateScene(button2_goesto);		
	}
	public void Button3Down(View view){
		if (button3_goesto == 10)
		{
			hasFood = true;
			//hasFirstAid = true;
		}
		UpdateScene(button3_goesto);
		
	}
	
	
	
	public void UpdateScene(int goesto){		
		int newbg;
		switch (goesto){
			//Start Scene
			case 0: newbg = getResources().getIdentifier("@raw/start3", "drawable", this.getPackageName());
					setText(getString(R.string.Wakeup));
					setButton1(1,getString(R.string.Aspirin));
					setButton2(2,getString(R.string.Phone));
					setButton3(3,getString(R.string.TV));
					setVisibilities(true,true,true,true);
					hasLaptop = false;
					hasFood = false;
					//hasFirstAid = false;
					hasBat = false;
					deathToken = 0;
					break;
			//No Water Scene
			case 1: newbg = getResources().getIdentifier("@raw/aspirin2", "drawable", this.getPackageName());
					setText(getString(R.string.No_Water));
					setButton1(4,getString(R.string.Bathroom_Water));
					setVisibilities(true,true,false,false);				
					break;
			//Phone
			case 2: newbg = getResources().getIdentifier("@raw/checkphone2", "drawable", this.getPackageName());
					setButton1(5,getString(R.string.Check_Window));
					setText(getString(R.string.Sirens));
					setVisibilities(true,true,false,false);					
					break;
			//Check TV
			case 3: newbg = getResources().getIdentifier("@raw/checktv2", "drawable", this.getPackageName());
					setButton1(5,getString(R.string.No_Signal));
					setText(getString(R.string.Sirens));
					setVisibilities(true,true,false,false);
					break;
			//Go To Bathroom					
			case 4: newbg = getResources().getIdentifier("@raw/gotobathroomtogetwater", "drawable", this.getPackageName());
					setText(getString(R.string.Sick_Person));
					setButton1(6,getString(R.string.Closer_Look));
					setButton2(7,getString(R.string.Back_Room));
					setButton3(6,getString(R.string.Water_Important));
					setVisibilities(true,true,true,true);
					break;
			//Window
			case 5: newbg = getResources().getIdentifier("@raw/checkwindow", "drawable", this.getPackageName());
					setButton1(8,getString(R.string.Take_Peek_Should));
					setVisibilities(false,true,false,false);
					break;
			//First Death Scene
			case 6:	newbg = getResources().getIdentifier("@raw/deathscene", "drawable", this.getPackageName());
					switch (deathToken){
						case 0:	setText(getString(R.string.Zombie_Eats));
							break;
						case 1: setText(getString(R.string.That_Didnt_Work));
							break;
						case 2: setText(getString(R.string.Tom_Not_Happy));
							break;
						case 3: if (hasBat){setText(getString(R.string.Not_Fast_Enough));}
								else{setText(getString(R.string.buffet));}
							break;
						case 4: setText(getString(R.string.Need_Weapon));
							break;
						default: setText(getString(R.string.That_Didnt_Work));
							break;
					}
					setButton1(0,getString(R.string.Back_To_Start));
					setVisibilities(true,true,false,false);
					break;
			//Back Inside the Room
			case 7: newbg = getResources().getIdentifier("@raw/gobackintoroom", "drawable", this.getPackageName());
					setText(getString(R.string.Sirens));
					setButton1(5,getString(R.string.Check_Window));
					setVisibilities(true,true,false,false);
					break;
			//Outside the window
			case 8: newbg = getResources().getIdentifier("@raw/takeapeek", "drawable", this.getPackageName());
					setText(getString(R.string.Ambulance));
					setButton1(9,getString(R.string.Look_Around_Room));
					setVisibilities(true,true,false,false);
					break;
			//Choosing What to Take
			case 9: newbg = getResources().getIdentifier("@raw/gobackintoroom", "drawable", this.getPackageName());
					setText(getString(R.string.Something_Important));
					setButton1(10,getString(R.string.Laptop_Food));
					setButton2(10,getString(R.string.First_Aid_Laptop));
					setButton3(10,getString(R.string.Food_First_Aid));
					setVisibilities(true,true,true,true);
					break;
			//Choice Made
			case 10: newbg = getResources().getIdentifier("@raw/gobackintoroom", "drawable", this.getPackageName());
					setText(getString(R.string.Kick_Zombie_Butt));
					setButton1(11,getString(R.string.Go_Outside_Room));
					setVisibilities(true,true,false,false);
					break;
			//Outside Room
			case 11: newbg = getResources().getIdentifier("@raw/hallwayzombieattacks", "drawable", this.getPackageName());
					setText(getString(R.string.Zombies_Lunge));
					setButton1(12,getString(R.string.Attack_Laptop));
					setButton2(6,getString(R.string.Attack_Oranges));
					deathToken = 1;
					setVisibilities(true,hasLaptop,hasFood,false);
					break;
			//Survived First Zombie Attack
			case 12: newbg = getResources().getIdentifier("@raw/gotobathroomtogetwater", "drawable", this.getPackageName());
					setText(getString(R.string.Close_One));
					setButton1(13,getString(R.string.Continue_Hallway));
					setButton2(14,getString(R.string.Check_Tom));
					setVisibilities(true,true,true,false);
					break;
			//Continue Down the Hall
			case 13: newbg = getResources().getIdentifier("@raw/continuedownthehallway", "drawable", this.getPackageName());
					setText(getString(R.string.Better_Get_Going));
					setButton1(15,getString(R.string.Elevator));
					setButton2(16,getString(R.string.Stairs));
					setVisibilities(true,true,true,false);
					break;
			//Check On Tom
			case 14: newbg = getResources().getIdentifier("@raw/friendnextdoor", "drawable", this.getPackageName());
					setText(getString(R.string.Better_Get_Going));
					setButton1(17,getString(R.string.Check_It_Out));
					setVisibilities(true,true,false,false);
					break;
			//Elevator
			case 15: newbg = getResources().getIdentifier("@raw/elevator", "drawable", this.getPackageName());
					setText(getString(R.string.Zombies_Elevator));
					setButton1(6,getString(R.string.Run_Back_To_Room));
					if (hasBat)
						setButton2(18,getString(R.string.Kill_Undead));
					else
						setButton2(6,getString(R.string.Kill_Undead));
					setButton3(16,getString(R.string.Run_To_Stairs));
					deathToken = 3;
					setVisibilities(true,true,true,true);
					break;	
			//Stairs		
			case 16: newbg = getResources().getIdentifier("@raw/stairs", "drawable", this.getPackageName());
					setText(getString(R.string.Stairs_Master_Key));
					hasKey = true;
					setButton1(20,getString(R.string.To_Lobby));
					setVisibilities(true,true,false,false);
					break;
			//Tom Attacks
			case 17: newbg = getResources().getIdentifier("@raw/checkitout", "drawable", this.getPackageName());
					setText(getString(R.string.Tom_Zombie));
					setButton3(6,getString(R.string.Tom_Snap_Out));
					setButton2(19,getString(R.string.Kill_Tom_Bat));
					deathToken = 2;
					setVisibilities(true,false,true,true);
					break;
			//Successfully killed elevator undead		
			case 18: newbg = getResources().getIdentifier("@raw/lobby", "drawable", this.getPackageName());
					setText(getString(R.string.Unstoppable));
					setButton1(20,getString(R.string.To_Lobby));
					setVisibilities(true,true,false,false);
					break;
			//Killed Tom
			case 19: newbg = getResources().getIdentifier("@raw/friendnextdoor", "drawable", this.getPackageName());
					setText(getString(R.string.World_Come_To));
					setButton1(13,getString(R.string.Continue_Hallway));
					setVisibilities(true,true,false,false);
					break;
			//Hear Joyce Screaming Outside Study Lounge			
			case 20: newbg = getResources().getIdentifier("@raw/studylounge", "drawable", this.getPackageName());
					setText(getString(R.string.Joyce_Screams));
					if (hasKey){setButton1(21,getString(R.string.Use_Key));}
					else{setButton1(22,getString(R.string.Outside_Way_In));}
					setVisibilities(true,true,false,false);
					break;
			//Key works		
			case 21: newbg = getResources().getIdentifier("@raw/joyceintrouble", "drawable", this.getPackageName());
					setText(getString(R.string.Key_Fits));
					setButton1(22,getString(R.string.Ditch_Her));
					if (hasBat){setButton2(23,getString(R.string.Save_Her));}
					else{setButton2(6,getString(R.string.Save_Her));}
					deathToken = 4;
					setVisibilities(true,true,true,false);
					break;
			//Outside
			case 22: newbg = getResources().getIdentifier("@raw/panic", "drawable", this.getPackageName());
					setText(getString(R.string.Panic_Words));
					setButton1(6,getString(R.string.Not_A_Sissy));
					setButton2(6,getString(R.string.Run_For_Life));
					deathToken = 5;
					setVisibilities(true,true,true,false);					
					break;
			//Joyce Joins the Team
			case 23: newbg = getResources().getIdentifier("@raw/joycejoinstheteam", "drawable", this.getPackageName());
					setText(getString(R.string.Joyce_Joins));
					setButton1(24,getString(R.string.To_Dining_Hall));
					setVisibilities(true,true,false,false);
					break;
			//Radio Scene
			case 24: newbg = getResources().getIdentifier("@raw/radioroom", "drawable", this.getPackageName());
					setText(getString(R.string.Radio_Announce));
					setButton1(25,getString(R.string.Keep_Listening));
					setVisibilities(true,true,false,false);
					break;
			case 25: newbg = getResources().getIdentifier("@raw/radioroom", "drawable", this.getPackageName());
					setText(getString(R.string.Radio_More));
					setButton1(0,getString(R.string.Play_Again));
					setVisibilities(true,true,false,false);
					break;
			//Error Screen, placeholder if something points to an inexistent 		
			default:newbg = getResources().getIdentifier("@raw/jellyfish", "drawable", this.getPackageName());
					setText("There Was An Error, How Did you Get Here?");
					setButton1(0,"Return to Start");
					setVisibilities(true,true,false,false);
					break;
		}
		//Gets layout view and sets new background
		RelativeLayout main = (RelativeLayout) findViewById(R.id.relativeLayout1); 
		main.setBackgroundResource(newbg); 
	}
	
	//Points to scene (case) that buttons will trigger
	private int button1_goesto = 1;
	private int button2_goesto = 2;
	private int button3_goesto = 3;
	//Variables for items that are picked up
	private boolean hasLaptop = false;
	private boolean hasFood = false;
	//private boolean hasFirstAid = false;
	private boolean hasKey = false;
	boolean hasBat = false;
	//Death Token used to trigger different messages at same death scene.
	private int deathToken = 0;
	
	//Update buttons with new text and scene pointers
	public void setButton1(int goesto, String newtext){
		button1_goesto = goesto;
		Button p_button1 = (Button) findViewById(R.id.button1);		
		p_button1.setText(newtext);
	}
	public void setButton2(int goesto, String newtext){
		button2_goesto = goesto;
		Button p_button2 = (Button) findViewById(R.id.button2);		
		p_button2.setText(newtext);
	}
	public void setButton3(int goesto, String newtext){
		button3_goesto = goesto;
		Button p_button3 = (Button) findViewById(R.id.button3);		
		p_button3.setText(newtext);
	}
	//Change which elements are visible
	public void setVisibilities(boolean visibilitytext, boolean visibility1, boolean visibility2, boolean visibility3){
		Button p_button1 = (Button) findViewById(R.id.button1);
		Button p_button2 = (Button) findViewById(R.id.button2);
		Button p_button3 = (Button) findViewById(R.id.button3);
		TextView p_textview = (TextView) findViewById(R.id.textView1);
		if (visibilitytext)
			p_textview.setVisibility(View.VISIBLE);
		else
			p_textview.setVisibility(View.INVISIBLE);
		if (visibility1)
			p_button1.setVisibility(View.VISIBLE);
		else
			p_button1.setVisibility(View.INVISIBLE);
		if (visibility2)
			p_button2.setVisibility(View.VISIBLE);
		else
			p_button2.setVisibility(View.INVISIBLE);
		if (visibility3)
			p_button3.setVisibility(View.VISIBLE);
		else
			p_button3.setVisibility(View.INVISIBLE);
	}
	
	public void setText(String newtext){
		TextView p_textview = (TextView) findViewById(R.id.textView1);
		p_textview.setText(newtext);		
	}
    
}
