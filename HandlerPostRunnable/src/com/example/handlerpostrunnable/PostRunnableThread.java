package com.example.handlerpostrunnable;

public class PostRunnableThread extends Thread {
	boolean running=false;

	public PostRunnableThread() {
		// TODO Auto-generated constructor stub
	}

	public void run()
	{
		while(running)
		{
			//cuenta 3 segundos...
					try {
						this.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			//incrementa la barra y la repinta con postRunnable
					MainActivity.miHandler.post(MainActivity.actualizaUI);
					
		}
	}
	public void setRunning(boolean r)
	{
		this.running=r;
	}
}
