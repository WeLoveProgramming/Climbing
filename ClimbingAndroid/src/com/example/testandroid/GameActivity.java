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
	// display rank and score and maybe a send score	
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
	public class Clock extends Thread {// the Clock
		public Clock(){
			//empty constructor
			
		}
		private boolean stop;// boolean sets to true when the clock stop
		public boolean isActive(){//return if it clock is ticking
			return stop;
		}
		public void pause(){// sets the stop to true
			stop= true;
		}
		public void run(){// run the clock
			stop= false;// sets stop to true
			while (stop!=true){// loop exits when sets to true
				try{
					
						tick();// calls a tick
						Thread.sleep(System.currentTimeMillis()%tickClock);// sleeps the tick interval 
					
				}catch(InterruptedException e){// in case of an interrupt exception
					
				}
				
			}
		}
	}
}
