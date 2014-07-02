package com.example.handlerpostrunnable;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	static Context context;
	Button b1,b2;
	TextView t1;
	ProgressBar pb1;
	static Handler miHandler;
	static Runnable actualizaUI;
	PostRunnableThread miThread;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//vistas
		context=getApplicationContext();
		miHandler=new Handler();
		actualizaUI=new Runnable(){

			@Override
			public void run() {
				// TODO 
				  //incrementa la barra en 10
				  if(pb1.getProgress()<90)
				  {  
				    pb1.setProgress(pb1.getProgress()+10);
				    t1.setText(t1.getText()+"\nbarra incrementada a "+pb1.getProgress());
				    pb1.invalidate();
				  }else{
					      miThread.setRunning(false);
					      t1.setText(t1.getText()+"\nFinalizando Thread...");
				       }
			}
			
		};
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		t1=(TextView)findViewById(R.id.textView2);
		pb1=(ProgressBar)findViewById(R.id.progressBar1);
		//listeners
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 
				//Arrancamos Thread en Background para incrementar la barra
				miThread=new PostRunnableThread();
				miThread.setRunning(true);
				miThread.start();
				
			}
		});
	    b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 
				finish();
				
			}
		});
	}
  
	

	
}
