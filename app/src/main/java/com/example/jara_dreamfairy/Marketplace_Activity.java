package com.example.jara_dreamfairy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Marketplace_Activity extends AppCompatActivity {

    ImageView weapon1_marketplace, weapon2_marketplace, weapon3_marketplace, weapon4_marketplace;
    ImageView Armor1_marketplace, Armor2_marketplace, Armor3_marketplace, Armor4_marketplace;
    ImageView Head1_marketplace, Head2_marketplace, Head3_marketplace, Head4_marketplace;
    ImageButton buy;
    TextView Head_text, Weapon_text, Armor_text, marketplace_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marketplace_activity);

        weapon1_marketplace = (ImageView)findViewById(R.id.weapon1_marketplace);
        weapon2_marketplace = (ImageView)findViewById(R.id.weapon2_marketplace);
        weapon3_marketplace = (ImageView)findViewById(R.id.weapon3_marketplace);
        weapon4_marketplace = (ImageView)findViewById(R.id.weapon4_marketplace);
        Armor1_marketplace = (ImageView)findViewById(R.id.Armor1_marketplace);
        Armor2_marketplace = (ImageView)findViewById(R.id.Armor2_marketplace);
        Armor3_marketplace = (ImageView)findViewById(R.id.Armor3_marketplace);
        Armor4_marketplace = (ImageView)findViewById(R.id.Armor4_marketplace);
        Head1_marketplace = (ImageView)findViewById(R.id.Head1_marketplace);
        Head2_marketplace = (ImageView)findViewById(R.id.Head2_marketplace);
        Head3_marketplace = (ImageView)findViewById(R.id.Head3_marketplace);
        Head4_marketplace = (ImageView)findViewById(R.id.Head4_marketplace);
        marketplace_text = (TextView)findViewById(R.id.marketplace);
        Weapon_text = (TextView)findViewById(R.id.weapon_text);
        Head_text = (TextView)findViewById(R.id.Head_text);
        Armor_text = (TextView)findViewById(R.id.Armor_text);
        buy = (ImageButton) findViewById(R.id.buy_marketplace);

        buy.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });
    }
}