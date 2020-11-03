package com.example.jara_dreamfairy;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_activity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        startSplash();

        Intent intent = new Intent(Splash_activity.this, Start_Activity.class);
        startActivity(intent);

    }

    private void startSplash() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },3000); //영상 만드는거 길이 맞춰서 delay 수정
    }


}
