package com.example.jara_dreamfairy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Achiev_Activity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout[] linearLayout = new LinearLayout[7];
    private ImageButton[] imageButton = new ImageButton[7];
    private ProgressBar[] progressBar = new ProgressBar[7];
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achiev_);

        linearLayout[0] = (LinearLayout) findViewById(R.id.achiev_1);
        linearLayout[1] = (LinearLayout) findViewById(R.id.achiev_2);
        linearLayout[2] = (LinearLayout) findViewById(R.id.achiev_3);
        linearLayout[3] = (LinearLayout) findViewById(R.id.achiev_4);
        linearLayout[4] = (LinearLayout) findViewById(R.id.achiev_5);
        linearLayout[5] = (LinearLayout) findViewById(R.id.achiev_6);
        linearLayout[6] = (LinearLayout) findViewById(R.id.achiev_7);

        progressBar[0] = (ProgressBar) findViewById(R.id.achiev_1_progressbar);
        progressBar[1] = (ProgressBar) findViewById(R.id.achiev_2_progressbar);
        progressBar[2] = (ProgressBar) findViewById(R.id.achiev_3_progressbar);
        progressBar[3] = (ProgressBar) findViewById(R.id.achiev_4_progressbar);
        progressBar[4] = (ProgressBar) findViewById(R.id.achiev_5_progressbar);
        progressBar[5] = (ProgressBar) findViewById(R.id.achiev_6_progressbar);
        progressBar[6] = (ProgressBar) findViewById(R.id.achiev_7_progressbar);

        imageButton[0] = (ImageButton) findViewById(R.id.achiev_1_imagebutton);
        imageButton[1] = (ImageButton) findViewById(R.id.achiev_2_imagebutton);
        imageButton[2] = (ImageButton) findViewById(R.id.achiev_3_imagebutton);
        imageButton[3] = (ImageButton) findViewById(R.id.achiev_4_imagebutton);
        imageButton[4] = (ImageButton) findViewById(R.id.achiev_5_imagebutton);
        imageButton[5] = (ImageButton) findViewById(R.id.achiev_6_imagebutton);
        imageButton[6] = (ImageButton) findViewById(R.id.achiev_7_imagebutton);
        ArrayList arrayList_linearlayout = new ArrayList();

        LinearLayout temp;
        for (int i = 0; i < linearLayout.length; i++) {
            if(progressBar[i].isIndeterminate())
            {
                imageButton[i].setEnabled(false);
            }
            else
            {
                temp=linearLayout[i];
                linearLayout[i]=linearLayout[linearLayout.length-1];
                linearLayout[i];
            }
        }
    }

    @Override
    public void onClick(View v) {
        //보상을 수령하는 이벤트
    }

    //현재진행률/최종목표,표시 및 갱신
    //미완료 업적은 클릭할수없게
    //보상을 모두 수령받은 업적은 맨밑으로
}