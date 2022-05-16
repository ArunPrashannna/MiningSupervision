package com.arunprashanna.miningsupervision1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class DashBoard extends AppCompatActivity {
    MaterialButton dashBoard_btn1, dashBoard_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        //Hooks
        dashBoard_btn1 = findViewById(R.id.dashBoard_btn1);
        dashBoard_btn2 = findViewById(R.id.dashBoard_btn2);

        dashBoard_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBoard.this, SwitchActivity.class));
            }
        });

        dashBoard_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBoard.this, MainActivity.class));
            }
        });
    }
}