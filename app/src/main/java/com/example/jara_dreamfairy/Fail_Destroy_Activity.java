package com.example.jara_dreamfairy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class Fail_Destroy_Activity extends AppCompatActivity {

    TextView Fail_text;
    Button BackMain_Btn;
    ImageView Boss;

    protected void onCreate(Bundle  savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fail_destroy_activity);

        Fail_text=(TextView)findViewById(R.id.fail_text);
        Boss=(ImageView)findViewById(R.id.boss);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(Boss);
        Glide.with(this).load(R.drawable.realboss).into(gifImage);
        BackMain_Btn=(Button)findViewById(R.id.BackMain_Btn);
        BackMain_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fail_Destroy_Activity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.transition_activity_bottom_to_center, R.anim.transition_activity_noting);
            }
        });


    }

}
