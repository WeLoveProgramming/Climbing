package com.example.testandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.example.testandroid.R;
import com.example.framework.implementation.AndroidGame;

public class MainActivity extends AndroidGame  {
	GameActivity game;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Assets.load(this);
		
		new SplashLoadingScreen(this);
	          
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

	@Override
	public Screen getInitScreen() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
