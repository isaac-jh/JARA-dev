package com.example.jara_dreamfairy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView2;
    ImageView imageView;
    ImageButton ImageButton2;
    ImageButton ImageButton3;
    ImageButton ImageButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void equipment(View v){
        Intent intent = new Intent(MainActivity.this, Character_equipment_Activity.class);
        startActivity(intent);
    }
    public void marketplace(View v){
        Intent intent = new Intent(MainActivity.this, Marketplace_Activity.class);
        startActivity(intent);
    }
    public void Achiev(View v){
        Intent intent = new Intent(MainActivity.this, Achiev_Activity.class);
        startActivity(intent);
    }
    public void setting(View v){
        Intent intent = new Intent(MainActivity.this, Setting_Activity.class);
        startActivity(intent);
    }
    public void status(View v){
        Intent intent = new Intent(MainActivity.this, Character_status_Activity.class);
        startActivity(intent);
    }

}