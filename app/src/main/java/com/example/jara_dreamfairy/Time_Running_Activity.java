package com.example.jara_dreamfairy;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;


public class Time_Running_Activity extends Activity {
    TextView Time_text;
    Button Gift_Btn, Start_Btn;
    ImageView Character, Boss;
    int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.time_running_activity);

        Intent intent = getIntent();
        time = intent.getIntExtra("Time",0);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                | WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);

        Time_text=(TextView)findViewById(R.id.Timer_text);
        Gift_Btn=(Button)findViewById(R.id.Gift_Btn);
        Gift_Btn.setVisibility(View.INVISIBLE);

        Start_Btn=(Button)findViewById(R.id.screenlock_start);

        Character=(ImageView)findViewById(R.id.character);
        Boss=(ImageView)findViewById(R.id.boss);

        Start_Btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ScreenService.class);
                startService(intent);
            }
        });



        Time_Running(time);
    }
    public void Time_Running(int Time ){

        new CountDownTimer(Time+1000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                int times = (int)(millisUntilFinished / 1000);

                int hours = times/(60*60);
                int tempMint = (times - (hours*60*60));
                int minutes = tempMint / 60;
                times = tempMint - (minutes*60);

                Time_text.setText("보스토벌중 : "+String.format("%02d",hours)
                        +":"+String.format("%02d",minutes)
                        +":"+String.format("%02d",times));


            }

            @Override
            public void onFinish() {
                Gift_Btn.setVisibility(View.VISIBLE);

                Gift_Btn.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
//                        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
//                        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

                        //String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
                        AlertDialog.Builder dig = new AlertDialog.Builder(Time_Running_Activity.this);
                        dig.setTitle("추가보상수령");
                        dig.setMessage("추가보상수령까지 1분 남았습니다.");
                        // startTimer();
                        dig.setPositiveButton("수령하기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(Time_Running_Activity.this, "보상을 수령하셨습니다", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Time_Running_Activity.this, MainActivity.class);
                                startActivity(intent);
                                overridePendingTransition(R.anim.transition_activity_bottom_to_center, R.anim.transition_activity_noting);

                            }
                        });
                        dig.show();
                    }
                });
            }
        }.start();
    }

    public void onBackPressed(){
        Toast.makeText(this, "back키 금지", Toast.LENGTH_SHORT).show();
        return;
    }
    protected void onPause(){
        super.onPause();
        ActivityManager activityManager = (ActivityManager)getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        activityManager.moveTaskToFront(getTaskId(), 0);
        Toast.makeText(this, "메뉴키 사용불가",Toast.LENGTH_SHORT).show();
    }
    public void onStop(){
        super.onStop();
        startActivity(new Intent(this, Time_Running_Activity.class));
        Toast.makeText(this,"재실행", Toast.LENGTH_SHORT).show();
    }

}
