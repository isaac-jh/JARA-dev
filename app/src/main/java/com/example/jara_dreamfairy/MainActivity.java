package com.example.jara_dreamfairy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jara_dreamfairy.dialog.tutorial_Dialog;
import com.example.jara_dreamfairy.model.UserModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView gold;
    ImageButton setting;
    ImageButton social;
    ImageButton equipment;
    ImageButton marketplace;
    ImageButton achievement;
    ImageButton door;
    ImageButton character;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private tutorial_Dialog tutorial_dialog;
    private int GOLD;


    public void onBackPressed(){
        android.app.AlertDialog.Builder dig = new AlertDialog.Builder(MainActivity.this);
        dig.setTitle("경고");
        dig.setMessage("앱을 종료하시겠습니까?");
        dig.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                ActivityCompat.finishAffinity(MainActivity.this);
                System.exit(0);
            }
        });
        dig.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                return;
            }
        });
        dig.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        GOLD= intent.getIntExtra("Gold",0);

        gold = (TextView)findViewById(R.id.text_gold_main);
        gold.setText(Integer.toString(GOLD));
        setting = (ImageButton)findViewById(R.id.button_setting_main);
        social = (ImageButton)findViewById(R.id.button_social_main);
        equipment = (ImageButton)findViewById(R.id.equipment_main);
        marketplace = (ImageButton)findViewById(R.id.marketplace_main);
        achievement = (ImageButton)findViewById(R.id.achieve_main);
        door = (ImageButton)findViewById(R.id.button_door_main);
        character = (ImageButton)findViewById(R.id.image_button_charactor_main);

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        final String uid = firebaseAuth.getCurrentUser().getUid();
        tutorial_dialog = new tutorial_Dialog(MainActivity.this);

        firebaseDatabase.getReference().child("user").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    if (uid.equals(snapshot.getKey())){
                        UserModel userModel = snapshot.getValue(UserModel.class);
                        if (userModel.tutorial){
                            tutorial_dialog.show();
                            userModel.tutorial = false;
                            firebaseDatabase.getReference().child("user").child(uid).setValue(userModel);
                        }
                        mainCharacter(character, userModel.selectionModel.fairy_state);
                        gold.setText(userModel.gold);

                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this,"알 수 없는 오류가 발생하였습니다.", Toast.LENGTH_LONG).show();
            }
        });




        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setting();
            }
        });

        social.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                social();
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
                selectBoss();
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
        overridePendingTransition(R.anim.transition_activity_bottom_to_center, R.anim.transition_activity_noting);
    }
    public void marketplace(){
        Intent intent = new Intent(MainActivity.this, Marketplace_Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.transition_activity_bottom_to_center, R.anim.transition_activity_noting);
    }
    public void Achieve(){
        Intent intent = new Intent(MainActivity.this, Achiev_Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.transition_activity_bottom_to_center, R.anim.transition_activity_noting);
    }
    public void setting(){
        Intent intent = new Intent(MainActivity.this, Setting_Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.transition_activity_right_to_center, R.anim.transition_activity_noting);
    }
    public void select(){
        Intent intent = new Intent(MainActivity.this, Character_selection_Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.transition_activity_top_to_center, R.anim.transition_activity_noting);
    }
    public void selectBoss() {
        Intent intent = new Intent(MainActivity.this, select_boss_activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.transition_activity_right_to_center, R.anim.transition_activity_noting);
    }
    public void social() {
        Intent intent = new Intent(MainActivity.this, Social_Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.transition_activity_right_to_center, R.anim.transition_activity_noting);
    }
    public void mainCharacter(ImageButton mainCharacter, String fairyState) {
        if (fairyState.equals("fairy_steam"))
            mainCharacter.setImageResource(R.drawable.steam_fairy);
        else if (fairyState.equals("fairy_neckpillow"))
            mainCharacter.setImageResource(R.drawable.neckpillow);
        else if (fairyState.equals("fairy_earplug"))
            mainCharacter.setImageResource(R.drawable.earplug);
        else if (fairyState.equals("fairy_sleepeyemask"))
            mainCharacter.setImageResource(R.drawable.eyemask);
        else if (fairyState.equals("fairy_flapper"))
            mainCharacter.setImageResource(R.drawable.flapper);
        else
            Toast.makeText(MainActivity.this, "캐릭터를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show();

    }

}