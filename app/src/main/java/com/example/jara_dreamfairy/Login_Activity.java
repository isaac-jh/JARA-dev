package com.example.jara_dreamfairy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Activity extends AppCompatActivity{

    private FirebaseAuth firebaseAuth;

    private EditText emailValue;
    private EditText passwordValue;
    private TextView textViewValue;
    private Button SigninButton;
    private Button SignupButton;
    private boolean allFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailValue = (EditText)findViewById(R.id.email);
        passwordValue = (EditText)findViewById(R.id.password);
        textViewValue = (TextView)findViewById(R.id.textviewMessage);

        SigninButton = (Button)findViewById(R.id.email_sign_in_button);
        SignupButton = (Button)findViewById(R.id.email_sign_up_button);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null){
            //이미 로그인 되었다면 이 액티비티를 종료함
            finish();

            startActivity(new Intent(Login_Activity.this, start_Activity.class)); //start_Activity추가
        }


        SigninButton.setOnClickListener(new View.OnClickListener() {
                String email = emailValue.getText().toString().trim();
                String password = passwordValue.getText().toString().trim();

                @Override
                public void onClick(View v) {
                    if(TextUtils.isEmpty(email)){
                        Toast.makeText(Login_Activity.this, "email을 입력해 주세요.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if(TextUtils.isEmpty(password))){
                        Toast.makeText(Login_Activity.this, "password를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                finish();
                                startActivity(new Intent(Login_Activity.this, start_Activity.class));
                            }
                            else {
                                Toast.makeText(Login_Activity.this, "이메일과 비밀번호를 다시 확인해주세요.", Toast.LENGTH_LONG).show();
                                textViewValue.setText("이메일 또는 비밀번호가 틀렸습니다!");
                            }
                        }
                    });

                }

            });

            SignupButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(Login_Activity.this, Signup_Activity.class);
                }
            });


    }

    private boolean checkEmailForm(String email) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < email.length(); i++) {
            if (email.indexOf('@') > -1)
                flag1 = true;
            if (email.indexOf('.') > -1)
                flag2 = true;

        }
        if (flag1 == true && flag2 == true)
            return true;
        else
            builder.setTitle("이메일 오류").setMessage("올바른 이메일 형식을 기입해주세요.");
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            return false;
    }

    private boolean checkPasswordForm(String password) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (password.length() < 8){
            builder.setTitle("패스워드 오류").setMessage("패스워드가 너무 짧습니다.");
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            return false;
        }

        else
            return true;
    }

}
