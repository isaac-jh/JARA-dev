package com.example.jara_dreamfairy;

import android.os.Bundle;
import android.support.v4.app.*;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

public class select_boss_activity extends AppCompatActivity implements View.OnClickListener{

    ImageButton prev,next,select;
    ViewFlipper flipper;
    String[] boss = {"boss_monitor","boss_mosquito","boss_amp"};
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_boss_activity);

        flipper = (ViewFlipper) findViewById(R.id.flipper);
        prev = (ImageButton) findViewById(R.id.ibtn_prev);
        select = (ImageButton) findViewById(R.id.ibtn_select);
        next = (ImageButton) findViewById(R.id.ibtn_next);
        next.setOnClickListener(this);
        prev.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v==prev)
            flipper.showPrevious();
        else if(v==next)
            flipper.showNext();
        else if(v==select)
        {
            //스토리지에서 해당 플리퍼의 보스의 정보를 가져와서 텍스트뷰에 표기함
            //한번더 누를 시 러닝타임으로 화면 전환
        }

    }
}
