package com.example.jara_dreamfairy;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Locale;

public class Time_Running_Activity extends AppCompatActivity {

    private static final long START_TIME_IN_MILLIS = 600000;
    private TextView mTextViewCountDown;
    private Button mButtonStart, mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.time_running_activity);

        mTextViewCountDown = (TextView) findViewById(R.id.timer_text);
        mButtonStart = (Button) findViewById(R.id.start_bnt_time_running);
        mButtonReset = (Button) findViewById(R.id.reset_bnt_time_running);

        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });


        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });
        updateCountDownText();
    }
        private void startTimer(){
            mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    mTimeLeftInMillis = millisUntilFinished;
                    updateCountDownText();
                }

                @Override
                public void onFinish() {
                    mTimerRunning=false;
                    mButtonStart.setText("start");
                    mButtonReset.setVisibility(View.INVISIBLE);
                    mButtonReset.setVisibility(View.VISIBLE);
                }
            }.start();
            mTimerRunning =true;
            mButtonStart.setText("pause");
            mButtonReset.setVisibility(View.INVISIBLE);
        }
        private void pauseTimer(){
            mCountDownTimer.cancel();
            mTimerRunning= false;
            mButtonStart.setText("Start");
            mButtonReset.setVisibility(View.VISIBLE);
        }
        private void resetTimer(){
            mTimeLeftInMillis=START_TIME_IN_MILLIS;
            updateCountDownText();
            mButtonReset.setVisibility(View.INVISIBLE);
            mButtonReset.setVisibility(View.VISIBLE);
        }
        private void updateCountDownText(){
            int minutes=(int)(mTimeLeftInMillis/1000)/60;
            int seconds=(int)(mTimeLeftInMillis/1000)%60;

            String timeLeftFormatted=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
            mTextViewCountDown.setText(timeLeftFormatted);
        }




}
