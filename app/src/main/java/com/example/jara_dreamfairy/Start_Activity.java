package com.example.jara_dreamfairy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Start_Activity extends AppCompatActivity {

    private ImageButton tts;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        firebaseAuth = FirebaseAuth.getInstance();
        tts = (ImageButton)findViewById(R.id.TTS);
        tts.setVisibility(View.GONE);

        delay();

        if(firebaseAuth.getCurrentUser() == null){
            //로그인 안되어있다면 로그인 액티비티로 이동
            startActivity(new Intent(this, Login_Activity.class));

            overridePendingTransition(R.anim.transition_activity_bottom_to_center, R.anim.transition_activity_noting);
        }

        tts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tts.setImageDrawable(getDrawable(R.drawable.TouchToStart)); //TouchToStart 이미지 후에 만들어서 수정 (반짝하는 모션)
                delay();
                startActivity(new Intent(Start_Activity.this, MainActivity.class));

                overridePendingTransition(R.anim.transition_activity_noting, R.anim.transition_activity_center_to_bottom);
            }
        });

        tts.setVisibility(View.VISIBLE);

    }
    private void delay() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },2000); //영상 만드는거 길이 맞춰서 delay 수정
    }

}