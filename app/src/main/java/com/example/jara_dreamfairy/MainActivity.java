package com.example.jara_dreamfairy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

        alertDialog.setMessage("앱을 종료하시겠습니까?");
        alertDialog.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialog.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gold = (TextView)findViewById(R.id.text_gold_main);
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

}