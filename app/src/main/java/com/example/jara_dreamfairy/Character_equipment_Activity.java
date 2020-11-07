package com.example.jara_dreamfairy;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Character_equipment_Activity extends AppCompatActivity {

    ImageView weapon1, weapon2, weapon3, weapon4;
    ImageView Armor1, Armor2, Armor3, Armor4;
    ImageView Head1, Head2, Head3, Head4;
    ImageView character;
    TextView equipment, Item_text, Head_text, Armor_text, weapon_text;
    ImageButton equip, release;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.character_equipment_activity);

        weapon1 = (ImageView)findViewById(R.id.weapon1_equipment);
        weapon2 = (ImageView)findViewById(R.id.weapon2_equipment);
        weapon3 = (ImageView)findViewById(R.id.weapon3_equipment);
        weapon4 = (ImageView)findViewById(R.id.weapon4_equipment);
        Armor1 = (ImageView)findViewById(R.id.Armor1_equipment);
        Armor2 = (ImageView)findViewById(R.id.Armor2_equipment);
        Armor3 = (ImageView)findViewById(R.id.Armor3_equipment);
        Armor4 = (ImageView)findViewById(R.id.Armor4_equipment);
        Head1 = (ImageView)findViewById(R.id.Head1_equipment);
        Head2 = (ImageView)findViewById(R.id.Head2_equipment);
        Head3 = (ImageView)findViewById(R.id.Head3_equipment);
        Head4 = (ImageView)findViewById(R.id.Head4_equipment);
        character = (ImageView)findViewById(R.id.character_equipment);
        equipment = (TextView)findViewById(R.id.equipment);
        Item_text = (TextView)findViewById(R.id.Item_text_equipment);
        Head_text = (TextView)findViewById(R.id.Head_text);
        Armor_text = (TextView)findViewById(R.id.Armor_text);
        weapon_text = (TextView)findViewById(R.id.weapon_text);
        equip = (ImageButton) findViewById(R.id.equip);
        release = (ImageButton) findViewById(R.id.release);

        equip.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });

        release.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

            }
        });

    }


}