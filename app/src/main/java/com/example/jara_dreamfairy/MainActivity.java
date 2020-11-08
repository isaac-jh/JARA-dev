package com.example.jara_dreamfairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView gold;
    ImageButton setting;
    ImageButton social;
    ImageButton equipment;
    ImageButton marketplace;
    ImageButton achievement;
    ImageButton door;
    ImageButton character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        gold = (TextView)findViewById(R.id.text_gold_main);
        setting = (ImageButton)findViewById(R.id.button_setting_main);
        social = (ImageButton)findViewById(R.id.button_social_main);
        equipment = (ImageButton)findViewById(R.id.equipment_main);
        marketplace = (ImageButton)findViewById(R.id.marketplace_main);
        achievement = (ImageButton)findViewById(R.id.achieve_main);
        door = (ImageButton)findViewById(R.id.button_door_main);
        character = (ImageButton)findViewById(R.id.image_button_charactor_main);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setting();

            }
        });

        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        equipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                equipment();

            }
        });

        marketplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                marketplace();

            }
        });

        achievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Achieve();

            }
        });

        door.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        character.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                select();

            }
        });

    }

    public void equipment(){
        Intent intent = new Intent(MainActivity.this, Character_equipment_Activity.class);
        startActivity(intent);
    }
    public void marketplace(){
        Intent intent = new Intent(MainActivity.this, Marketplace_Activity.class);
        startActivity(intent);
    }
    public void Achieve(){
        Intent intent = new Intent(MainActivity.this, select_boss_activity.class);
        startActivity(intent);
    }
    public void setting(){
        Intent intent = new Intent(MainActivity.this, Setting_Activity.class);
        startActivity(intent);
    }
    public void select(){
        Intent intent = new Intent(MainActivity.this, Character_selection_Activity.class);
        startActivity(intent);
    }

}