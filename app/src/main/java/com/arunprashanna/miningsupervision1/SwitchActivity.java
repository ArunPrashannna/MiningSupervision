package com.arunprashanna.miningsupervision1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SwitchActivity extends AppCompatActivity {
    TextInputEditText switch_name, switch_tagId, switch_mobileNo, switch_dob, switch_age, switch_address;
    MaterialButton switch_add_btn;
    WorkerDetails workerDetails;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        /* Start of Hooks */
        switch_name = findViewById(R.id.switch_name);
        switch_tagId = findViewById(R.id.switch_tagId);
        switch_mobileNo = findViewById(R.id.switch_mobileNo);
        switch_age = findViewById(R.id.switch_age);
        switch_dob = findViewById(R.id.switch_dob);
        switch_address = findViewById(R.id.switch_address);
        switch_add_btn = findViewById(R.id.switch_add_btn);

        workerDetails= new WorkerDetails();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("/Mining_Center_1/workerDetails");
        /* End of Hooks */

        switch_add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = switch_name.getText().toString();
                String tagId = switch_tagId.getText().toString();
                String mobileNo = switch_mobileNo.getText().toString();
                String age = switch_age.getText().toString();
                String dob = switch_dob.getText().toString();
                String address = switch_address.getText().toString();

                if(TextUtils.isEmpty(name) || TextUtils.isEmpty(tagId) || TextUtils.isEmpty(mobileNo) || TextUtils.isEmpty(age) ||
                TextUtils.isEmpty(dob) || TextUtils.isEmpty(address)){
                    Toast.makeText(SwitchActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    workerDetails.setName(name);
                    workerDetails.setTagId(tagId);
                    workerDetails.setMobileNo(mobileNo);
                    workerDetails.setAge(age);
                    workerDetails.setDob(dob);
                    workerDetails.setAddress(address);
                    addWorkerToDatabase();
                }
            }
        });

    }

    void addWorkerToDatabase(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.setValue(workerDetails);
                Toast.makeText(SwitchActivity.this, "Worker details added successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(SwitchActivity.this, "Failed to add! Try again!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}