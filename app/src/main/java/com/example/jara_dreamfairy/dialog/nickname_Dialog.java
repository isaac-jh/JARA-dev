package com.example.jara_dreamfairy.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.jara_dreamfairy.R;
import com.example.jara_dreamfairy.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class nickname_Dialog extends Dialog {

    private TextView textView;
    private EditText nicknameValue;
    private Button confirm;
    private FirebaseDatabase firebaseDatabase;
    private FirebaseAuth firebaseAuth;


    public nickname_Dialog(@NonNull Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);   //다이얼로그의 타이틀바를 없애주는 옵션입니다.
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  //다이얼로그의 배경을 투명으로 만듭니다.
        setContentView(R.layout.nickname_dialog_layout);     //다이얼로그에서 사용할 레이아웃입니다.

        textView = (TextView)findViewById(R.id.nickname_Textview);
        nicknameValue = (EditText) findViewById(R.id.nickname_EditText);
        confirm = (Button)findViewById(R.id.nickname_confirm);
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        final String nickname = nicknameValue.getText().toString();
        final String uid = firebaseAuth.getCurrentUser().getUid();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseDatabase.getReference().child("user").child(uid).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        UserModel userModel = snapshot.getValue(UserModel.class);
                        userModel.name = nickname;
                        firebaseDatabase.getReference().child("user").child(uid).setValue(userModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    dismiss();
                                }
                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getContext(),"알 수 없는 오류가 발생하였습니다.", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
