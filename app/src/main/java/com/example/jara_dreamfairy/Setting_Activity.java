package com.example.jara_dreamfairy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jara_dreamfairy.model.UserModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Setting_Activity extends AppCompatActivity {

    private ImageButton close;
    private TextView nickname;
    private TextView uidValue;
    private SeekBar lightBar;
    private SeekBar soundBar;
    private Button logout;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_);

        close = (ImageButton)findViewById(R.id.setting_close);
        nickname = (TextView)findViewById(R.id.username_setting);
        uidValue = (TextView)findViewById(R.id.uid_setting);
        lightBar = (SeekBar)findViewById(R.id.light_setting);
        soundBar = (SeekBar)findViewById(R.id.sound_setting);
        logout = (Button)findViewById(R.id.logout_button);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        audioManager = (AudioManager)getSystemService(AUDIO_SERVICE);

        int soundMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolumn = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        soundBar.setMax(soundMax);
        soundBar.setProgress(currentVolumn);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Setting_Activity.this, MainActivity.class));
                overridePendingTransition(R.anim.transition_activity_noting, R.anim.setting_and_social_out);
            }
        });

        String uid = firebaseAuth.getCurrentUser().getUid();

        firebaseDatabase.getReference().child("user").child(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserModel userModel = snapshot.getValue(UserModel.class);

                nickname.setText(userModel.name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Setting_Activity.this,"닉네임을 가져오는데 실패했습니다.",Toast.LENGTH_LONG).show();
            }
        });

        uidValue.setText(uid);

        //밝기 조절
        lightBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setBrightness(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //소리 조절
        soundBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                startActivity(new Intent(Setting_Activity.this, Start_Activity.class));
                overridePendingTransition(R.anim.transition_activity_left_to_center, R.anim.transition_activity_center_to_right);
            }
        });


    }

    private void setBrightness(int value) {
        if (value < 10) {
            value = 10;
        } else if (value > 100) {
            value = 100;
        }
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = (float) value / 100;
        getWindow().setAttributes(params);
    }

}