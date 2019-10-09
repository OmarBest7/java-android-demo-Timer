package com.ceibalabs.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1st option
        /*
        final Handler handler = new Handler(); //allows chunks of code to be processed in a delayed way possibly every 5 seconds, 1 minute,etc
        //these chunks are runnables
        Runnable run = new Runnable() {
            @Override
            public void run() {
                //insert code to be run every second
                Log.i("Runnable has run!", "a second has passed...");

                handler.postDelayed(this, 1000);//this refers to the run method in this context
                //and will indicate the program to run the run method every 1 second
            }
        };

        handler.post(run); //this will initialize for the first time the run method
        handler is not destroyed even when has finished
        */

        //2nd option
        new CountDownTimer(10000, 1000) {
            public void onTick(long millisecondsUntilDone){
                //counter is counting down every period specified in our case every second
                Log.i("Seconds left", String.valueOf(millisecondsUntilDone / 1000));
            }

            public void onFinish(){
                //counter is finished
                Log.i("Done", "Counter has finished.");
            }
        }.start(); //counter is the destroyed once its finished
    }
}
