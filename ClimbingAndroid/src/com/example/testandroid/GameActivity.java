package com.example.testandroid;

public class GameActivity {
	protected int tickClock;// how many milsecound per tick
	protected boolean tickOn;// if clock is on
	private Clock cClock;
	private Thread timmer;
	private static boolean gamerunning= false;
	public GameActivity(){
		gamerunning= true;
	}
	public static boolean isGameRunning(){
		return gamerunning;
	}
	public boolean gameStart(){
		if(init()==false)
		{
			return false; //In case of failed init
		}
		gameRun();
		return true;
	}
	protected void gameRun(){
		if(cClock.isActive())// checks if it is active if not start clock
			timmer.run();
		//starts or resume the game
	}
	protected void gamePause(){
		//pause the game
		cClock.pause();
	}
	protected void gameStop(){
		//used if game is over
		gamePause();
		DisplayResults();
		gamerunning= false;		
	}
	private void DisplayResults(){
	// display rank and score and maybe a sendscore	
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
