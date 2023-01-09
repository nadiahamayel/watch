package com.example.watch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int secaned;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkSaved(savedInstanceState);
        runTimer();
    }
    private void savedInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("SECANED",secaned);
        savedInstanceState.putBoolean("RUNNING",running);
    }
    public void checkSaved(Bundle savedInstance) {
        if (savedInstance != null) {
            secaned = savedInstance.getInt("SECANED");
            running = savedInstance.getBoolean("RUNNING");
        }
    }
        private void runTimer(){
            final TextView txtTime = findViewById(R.id.txtTime);
            final Handler handler = new Handler();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    int hours = secaned/3600;
                    int minutes = (secaned%3600) / 60;
                    int secs = secaned%60;
                    String time = hours +" : " + minutes + " : " + secs;
                    txtTime.setText(time);
                    if(running){
                        secaned++;
                    }
                    handler.postDelayed(this, 1000);

                }
            });
        }
                public void btnStartOnClick(View view) {
                  running = true;
                 }

                public void btnStopOnClick(View view) {
                   running = false;
                 }

                   public void btnResetOnClick(View view) {
                   running = false;
                        secaned= 0;
                    }




}