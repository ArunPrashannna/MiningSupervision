package com.arunprashanna.miningsupervision1;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    TextInputEditText em, pswd;
    MaterialButton btn;
    FirebaseAuth myAuth;
    Button txtBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Log.d(TAG, "INSIDE signup: onCreate");

        myAuth = FirebaseAuth.getInstance();
        btn = findViewById(R.id.signup_btn);
        em = findViewById(R.id.signup_email);
        pswd = findViewById(R.id.signup_pswd);
        txtBtn = findViewById(R.id.signup_txtBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerNewUser();
            }
        });

        txtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, SigninActivity.class));
                finish();
            }
        });
    }

    private void registerNewUser() {
        String email, password;
        email = em.getText().toString();
        password = pswd.getText().toString();

        if(email.length()==0){
            Toast.makeText(this, "Enter email Id!", Toast.LENGTH_LONG).show();
            return;
        }
        if(password.length()==0){
            Toast.makeText(this, "Enter Password!", Toast.LENGTH_LONG).show();
            return;
        }
        myAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(SignupActivity.this, DashBoard.class));
                            finish();
                        }
                        else{
                            Toast.makeText(SignupActivity.this, "Registration Unsuccessful", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}