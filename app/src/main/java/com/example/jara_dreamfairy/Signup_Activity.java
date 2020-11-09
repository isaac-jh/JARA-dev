package com.example.jara_dreamfairy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.jara_dreamfairy.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Signup_Activity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private EditText emailValue;
    private EditText passwordValue;
    private EditText passwordValueCheck;
    private TextView returnButton;
    private Button signupButton;
    private EditText nicknameValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        emailValue = (EditText)findViewById(R.id.email_sign_up);
        passwordValue = (EditText)findViewById(R.id.password_sign_up);
        passwordValueCheck = (EditText)findViewById(R.id.password_again);
        returnButton = (TextView)findViewById(R.id.email_return_button);
        signupButton = (Button)findViewById(R.id.sign_up_button);
        nicknameValue = (EditText)findViewById(R.id.nickname_EditText);

        firebaseAuth = FirebaseAuth.getInstance();

        returnButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Signup_Activity.this);

                builder.setTitle("알림").setMessage("지금 이전으로 돌아가시면 작성하고 계시던 정보는 손실됩니다. OK를 누르면 이전으로 돌아갑니다.");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        startActivity(new Intent(Signup_Activity.this, Login_Activity.class));

                        overridePendingTransition(R.anim.transition_activity_noting, R.anim.transition_activity_center_to_right);
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) { }
                });

                AlertDialog alertDialog = builder.create();

                alertDialog.show();

            }

        });

        signupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = emailValue.getText().toString();
                String password = passwordValue.getText().toString();
                String passwordCheck = passwordValueCheck.getText().toString();

                if (!checkEmailForm(email))
                    return;
                else if (!checkPasswordForm(password, passwordCheck))
                    return;

                // 회원가입
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Signup_Activity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            // 유저 기본 정보 데이터베이스에 등록
                            String uid = firebaseAuth.getCurrentUser().getUid();
                            String nickname = nicknameValue.getText().toString();

                            firebaseDatabase = FirebaseDatabase.getInstance();

                            UserModel userModel = new UserModel();

                            userModel.name = nickname;

                            firebaseDatabase.getReference().child("user").child(uid).setValue(userModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        finish();
                                        startActivity(new Intent(Signup_Activity.this, Login_Activity.class));

                                        overridePendingTransition(R.anim.transition_activity_noting, R.anim.transition_activity_center_to_right);
                                    }
                                    else {
                                        Toast.makeText(Signup_Activity.this, "데이터 쓰기 오류", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                        }
                        else {
                            Toast.makeText(Signup_Activity.this, "이미 가입된 이메일이거나 네트워크 오류입니다.", Toast.LENGTH_SHORT).show();

                        }
                    }
                });



            }
        });

    }

    private boolean checkEmailForm(String email) {
        boolean flag1 = false;
        boolean flag2 = false;

        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@')
                flag1 = true;
            else if (email.charAt(i) == '.')
                flag2 = true;

        }
        if (flag1 && flag2)
            return true;
        else {
            Toast.makeText(Signup_Activity.this, "\n이메일 형식이 맞지 않습니다.", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    private boolean checkPasswordForm(String password, String passCheck) {

        boolean flag1 = false;
        boolean flag2 = false;

        if (password.length() < 8) {
            flag1 = false;
            Toast.makeText(Signup_Activity.this, "비밀번호는 8자리 이상이어야 합니다.", Toast.LENGTH_LONG).show();
        }
        else
            flag1 = true;

        if (password.equals(passCheck))
            flag2 = true;
        else {
            flag2 = false;
            Toast.makeText(Signup_Activity.this, "비밀번호와 비밀번호 확인이 서로 다릅니다.", Toast.LENGTH_LONG).show();
        }

        if (flag1 == true && flag2 == true)
            return true;
        else
            return false;
    }

}