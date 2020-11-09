package com.example.jara_dreamfairy;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
    Button start, finish;
    int start_hour, start_minute, finish_hour, finish_minute;
    String[] boss = {"amp,monitor,mosquito"};
    int Parallax, hour, minute;
    Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_boss_activity);

        flipper = (ViewFlipper) findViewById(R.id.flipper);
        prev = (ImageButton) findViewById(R.id.ibtn_prev);
        select = (ImageButton) findViewById(R.id.ibtn_select);
        next = (ImageButton) findViewById(R.id.ibtn_next);

        prev.setOnClickListener(this);
        select.setOnClickListener(this);
        next.setOnClickListener(this);


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

    void time_calc() {
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

        Parallax = hour * 3600000 + minute * 60000;
    }

    @Override
    public void onClick(View v) {

        if (v == prev)
            flipper.showPrevious();
        else if (v == next)
            flipper.showNext();
        else if (v == select) {
            {
                time_calc();
                if (Parallax > 3600000 * 4
                ) {
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
<<<<<<< HEAD
                            //타임러닝으로 데이터값을 넘기고 실행.(Parallax값,보스 정보)
=======
                            //타임러닝으로 데이터값을 넘기고 실행.
                            Intent intent = new Intent(select_boss_activity.this, Time_Running_Activity.class);
                            intent.putExtra("Time", Parallax);
                            startActivity(intent);



>>>>>>> origin/Jinsan
                        }
                    });
                    dlg.show();
                } else {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(select_boss_activity.this);
                    dlg.setTitle("최소 수면시간 부족!");
                    dlg.setMessage("보스 격파를 위한 시간이 부족합니다.(최소 4시간)");
                    dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "다시 시간을 설정해주세요.", Toast.LENGTH_SHORT);
                        }
                    });
                    dlg.show();
                }
                }
            }
        }

    }

