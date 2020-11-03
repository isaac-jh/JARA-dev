package com.example.jara_dreamfairy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_Activity extends AppCompatActivity{

    private FirebaseAuth firebaseAuth;

    private EditText emailValue;
    private EditText passwordValue;
    private TextView textViewValue;
    private Button SigninButton;
    private TextView SignupButton;
    private TextView findPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailValue = (EditText)findViewById(R.id.email);
        passwordValue = (EditText)findViewById(R.id.password);
        textViewValue = (TextView)findViewById(R.id.textviewMessage);

        SigninButton = (Button)findViewById(R.id.email_sign_in_button);
        SignupButton = (TextView)findViewById(R.id.email_sign_up_button);

        findPassword = (TextView)findViewById(R.id.find_password_button);

        firebaseAuth = FirebaseAuth.getInstance();


        SigninButton.setOnClickListener(new View.OnClickListener() {
                String email = emailValue.getText().toString().trim();
                String password = passwordValue.getText().toString().trim();

                @Override
                public void onClick(View v) {
                    if(TextUtils.isEmpty(email)){
                        Toast.makeText(Login_Activity.this, "email을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(TextUtils.isEmpty(password)){
                        Toast.makeText(Login_Activity.this, "password를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(Login_Activity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Log.d("signIn", "signInWithEmail:success");
                                finish();
                                startActivity(new Intent(Login_Activity.this, Start_Activity.class));
                            }
                            else {
                                Toast.makeText(Login_Activity.this, "이메일과 비밀번호를 다시 확인해주세요.", Toast.LENGTH_LONG).show();
                                textViewValue.setText("이메일 또는 비밀번호가 틀렸습니다!");
                                textViewValue.setTextColor(getColor(R.color.colorWarning));
                            }
                        }
                    });

                }

            });

            SignupButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Login_Activity.this, Signup_Activity.class));
                }
            });

            findPassword.setOnClickListener(new View.OnClickListener() {

                String email = emailValue.getText().toString().trim();

                @Override
                public void onClick(View v) {

                    firebaseAuth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Login_Activity.this, "등록하신 이메일로 비밀번호 재설정 이메일을 보냈습니다.", Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(Login_Activity.this, "메일 보내기 실패!", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                }
            });


    }



}
