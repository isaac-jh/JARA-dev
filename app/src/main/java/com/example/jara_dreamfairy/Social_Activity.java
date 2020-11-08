package com.example.jara_dreamfairy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Social_Activity extends AppCompatActivity {

    private ImageButton close;
    private EditText searchFriend;
    private ImageButton addFriend;
    private ScrollView friendList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_social);

        close = (ImageButton)findViewById(R.id.setting_close);
        searchFriend = (EditText)findViewById(R.id.search_social);
        addFriend = (ImageButton)findViewById(R.id.add_social);
        friendList = (ScrollView)findViewById(R.id.friend_list_social);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Social_Activity.this, MainActivity.class));
                overridePendingTransition(R.anim.transition_activity_noting, R.anim.setting_and_social_out);
            }
        });

        //친구 목록 및 추가는 추후 개발
    }
}
