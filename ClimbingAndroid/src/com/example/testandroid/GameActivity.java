package com.example.testandroid;

public class GameActivity {
	protected int tickClock;// how many milsecound per tick
	protected boolean tickOn;// if clock is on
	private Clock cClock;
	private Thread timmer;
	public GameActivity(){}
	public boolean gameStart(){
		if(init()==false)
		{
			return false; //In case of failed init
		}
		gameRun();
		return true;
	}
	private void gameRun(){
		if(cClock.isActive())// checks if it is active if not start clock
			timmer.run();
		//starts or resume the game
	}
	private void gamePause(){
		//pause the game
		cClock.pause();
	}
	private void gameStop(){
		gamePause();
		//uses if game is over
	}
	private boolean init(){
		//the initialization of the game
		cClock= new Clock();
		timmer= new Thread(cClock);
		return true;
	}
	public void tick(){
		//action of each tick
	}
	public class Clock extends Thread {
		public Clock(){
			//empty constructor
			
		}
		private boolean stop;
		public boolean isActive(){
			return stop;
		}
		public void pause(){
			stop= true;
		}
		public void run(){
			stop= false;
			while (stop!=true){
				try{
					if(System.currentTimeMillis()%tickClock==0){
						tick();
						Thread.sleep(tickClock-System.currentTimeMillis()%tickClock-1);
					}
				}catch(InterruptedException e){
					
				}
				
			}
		}
	}
}
