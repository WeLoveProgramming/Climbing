package com.example.testandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	GameActivity game;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		menu.add("Playgame");
		menu.add("Credits");
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}
	public boolean onButtonClick(MenuItem item){
			
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if(id==0){
			playgame();
		}else if(id==1){
			showcredits();
		}
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	private void playgame(){
		//playgame 
		if(!GameActivity.isGameRunning()){
			game= new GameActivity();
			game.gameStart();
		}
		else {
			game.gameRun();
		}
	}
	private void showcredits(){
		//display credits
	}
	
	
}
