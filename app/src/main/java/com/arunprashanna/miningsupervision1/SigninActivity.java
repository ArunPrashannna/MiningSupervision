package com.arunprashanna.miningsupervision1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class SigninActivity extends AppCompatActivity {
    Button signin_txtBtn;
    MaterialButton signin_btn;
    FirebaseAuth myAuth;
    TextInputEditText signin_email, signin_pswd;
    LinearProgressIndicator sign_progInd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        myAuth = FirebaseAuth.getInstance();

        signin_txtBtn = findViewById(R.id.signin_txtBtn);
        signin_btn = findViewById(R.id.signin_btn);
        signin_email = findViewById(R.id.signin_email);
        signin_pswd = findViewById(R.id.signin_pswd);
        sign_progInd = findViewById(R.id.signin_progInd);

        signin_txtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SigninActivity.this, SignupActivity.class));
            }
        });

        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUser();
            }
        });
    }

    private void LoginUser(){
        sign_progInd.setVisibility(View.VISIBLE);
        String email="", password="";

        email = Objects.requireNonNull(signin_email.getText()).toString();
        password = Objects.requireNonNull(signin_pswd.getText()).toString();

        if(email.length()==0){
            Toast.makeText(this, "enter email id", Toast.LENGTH_SHORT).show();
            sign_progInd.setVisibility(View.GONE);
            return;
        }
        if(password.length()==0){
            Toast.makeText(this, "enter password", Toast.LENGTH_SHORT).show();
            sign_progInd.setVisibility(View.GONE);
            return;
        }
        myAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                sign_progInd.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Toast.makeText(SigninActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SigninActivity.this, DashBoard.class));
                    finish();
                }
                else{
                    Toast.makeText(SigninActivity.this, "Invalid Usename and Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser firebaseUser = myAuth.getCurrentUser();
        if(firebaseUser != null) {
            startActivity(new Intent(this, DashBoard.class));
            finish();
        }
    }
}