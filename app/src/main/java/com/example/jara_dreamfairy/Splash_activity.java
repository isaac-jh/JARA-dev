package com.example.jara_dreamfairy;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

public class Splash_activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash_activity);


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(Splash_activity.this, Start_Activity.class));
            }
        },3000);


        overridePendingTransition(R.anim.transition_activity_noting, R.anim.fade_out);
    }


}
