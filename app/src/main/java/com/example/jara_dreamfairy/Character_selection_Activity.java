package com.example.jara_dreamfairy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Character_selection_Activity extends AppCompatActivity {

    ImageButton Fly_flap, Sleep_eye_mask, Neck_pillow, Ear_plug, character_select;
    TextView Fly_flap_text, Sleep_eye_mask_text, Neck_pillow_text, Ear_plug_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_selection_activity);

        Fly_flap_text = (TextView)findViewById(R.id.fly_flap_text);
        Sleep_eye_mask_text = (TextView)findViewById(R.id.Sleep_eye_mask_text);
        Neck_pillow_text = (TextView)findViewById(R.id.Neck_pillow_text);
        Ear_plug_text = (TextView)findViewById(R.id.Ear_plug_text);
        Fly_flap = (ImageButton) findViewById(R.id.fly_flap);
        Sleep_eye_mask = (ImageButton) findViewById(R.id.Sleep_eye_mask);
        Neck_pillow = (ImageButton) findViewById(R.id.Neck_pillow);
        Ear_plug = (ImageButton) findViewById(R.id.Ear_plug);
        character_select = (ImageButton) findViewById(R.id.select_character);

        Fly_flap.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });
        Sleep_eye_mask.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });
        Neck_pillow.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });
        Ear_plug.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });
        character_select.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });
    }
}