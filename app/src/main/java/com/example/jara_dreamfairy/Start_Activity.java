package com.example.jara_dreamfairy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;
import java.util.TimerTask;

public class Start_Activity extends AppCompatActivity {

    private ImageButton tts;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Timer timer = new Timer();

        firebaseAuth = FirebaseAuth.getInstance();
        tts = (ImageButton)findViewById(R.id.TTS);
        tts.setVisibility(View.GONE);

        if(firebaseAuth.getCurrentUser() == null){
            //로그인 안되어있다면 로그인 액티비티로 이동
            startActivity(new Intent(Start_Activity.this, Login_Activity.class));

            overridePendingTransition(R.anim.transition_activity_bottom_to_center, R.anim.transition_activity_noting);
        }



        tts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tts.setImageDrawable(getDrawable(R.drawable.TouchToStart)); //TouchToStart 이미지 후에 만들어서 수정 (반짝하는 모션)
                startActivity(new Intent(Start_Activity.this, MainActivity.class));

                overridePendingTransition(R.anim.transition_activity_right_to_center, R.anim.transition_activity_noting);
            }
        });

//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                Animation blink = AnimationUtils.loadAnimation(Start_Activity.this, R.anim.blink);
//                tts.startAnimation(blink);
//                tts.setVisibility(View.VISIBLE);
//            }
//        },2000);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Animation blink = AnimationUtils.loadAnimation(Start_Activity.this, R.anim.blink);
                tts.startAnimation(blink);
                tts.setVisibility(View.VISIBLE);

            }
        });


    }

}
