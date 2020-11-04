package com.example.jara_dreamfairy;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class Splash_activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        startSplash();

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(Splash_activity.this, Login_Activity.class));
            }
        },5000);


    }

    private void startSplash() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },10000); //영상 만드는거 길이 맞춰서 delay 수정
    }


}
