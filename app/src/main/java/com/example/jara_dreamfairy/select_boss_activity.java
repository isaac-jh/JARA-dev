package com.example.jara_dreamfairy;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.*;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import static java.security.AccessController.getContext;

public class select_boss_activity extends AppCompatActivity implements View.OnClickListener {

    ImageButton prev, next, select;
    ViewFlipper flipper;
    String[] boss = {"boss_monitor", "boss_mosquito", "boss_amp"};
    TimePicker start_timepicker, finish_timepicker;
    Button start, finish;
    int start_hour, start_minute, finish_hour, finish_minute;
    int Parallax,hour, minute;

    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_boss_activity);

        flipper = (ViewFlipper) findViewById(R.id.flipper);
        prev = (ImageButton) findViewById(R.id.ibtn_prev);
        select = (ImageButton) findViewById(R.id.ibtn_select);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        time_calc();
                        AlertDialog.Builder dlg = new AlertDialog.Builder(select_boss_activity.this);
                        dlg.setTitle("진행하시겠습니까?");
                        dlg.setMessage(Integer.toString(Parallax));
                        dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getApplicationContext(), "취소하셨습니다.", Toast.LENGTH_SHORT);
                            }
                        });
                        dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "해당 정보로 진행합니다.", Toast.LENGTH_SHORT);
                                //타임러닝으로 데이터값을 넘기고 실행.
                            }
                        });
                        dlg.show();
                    }
                });
            }
        });
        next = (ImageButton) findViewById(R.id.ibtn_next);
        next.setOnClickListener(this);
        prev.setOnClickListener(this);

        start = findViewById(R.id.start_timeset);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start_showTime();
                start.setText(start_hour + " : " + start_minute);
            }
        });

        finish = findViewById(R.id.finish_timeset);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish_showTime();
                finish.setText(finish_hour + " : " + finish_minute);
            }
        });
    }

    void start_showTime() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                start_hour = hourOfDay;
                start_minute = minute;

            }
        }, start_hour, start_minute, false);

        timePickerDialog.show();
    }

    void finish_showTime() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                finish_hour = hourOfDay;
                finish_minute = minute;
            }
        }, finish_hour, finish_minute, false);

        timePickerDialog.show();
    }

    void time_calc(){
        if (start_hour > finish_hour) {
            hour = finish_hour - start_hour + 24;
            if (start_minute > finish_minute) {
                minute = finish_minute - start_minute + 60;
                hour -= 1;
            } else
                minute = finish_minute - start_minute;
        } else if (start_hour < finish_hour) {
            hour = finish_hour - start_hour;
            if (start_minute > finish_minute) {
                minute = finish_minute - start_minute + 60;
                hour -= 1;
            } else
                minute = finish_minute - start_minute;
        } else
            minute = finish_minute - start_minute;

        Parallax = hour*3600000+minute*60000;
    }

    @Override
    public void onClick(View v) {
        if(v==prev)
            flipper.showPrevious();
        else if(v==next)
            flipper.showNext();

    }

}
