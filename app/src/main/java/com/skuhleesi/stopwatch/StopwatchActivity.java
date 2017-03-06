package com.skuhleesi.stopwatch;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StopwatchActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running;        //Record if stop watch is running

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);
        runTimer();
    }

    //Start the stopwatch running when the Start button is clicked.
    public void onClickStart(View view){
        running = true;         //Start stopwatch
    }

    //Stop teh stopwatch when the Stop button is clicked
    public void onClickStop(View view){
        running = false;
    }

    //Reset the stopwatch when the Reset button is clicked
    public void onClickReset(View view){
        running = false;
        seconds = 0;        //Stop the stopwatch and set seconds to 0
    }

    //Sets the number of seconds on the timer
    private void runTimer() {
        final TextView timeView = (TextView)findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable(){
            @Override
            public void run(){
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);         //Set textview text
                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);     //Post code again after 1 second delay
            }
        });
    }
}
