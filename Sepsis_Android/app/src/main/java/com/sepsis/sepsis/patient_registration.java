package com.sepsis.sepsis;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sepsis.sepsis.model.patientReg_model;


public class patient_registration extends AppCompatActivity {

    EditText name, username, age;
    Button button;
    DatabaseReference databaseReference;
    patientReg_model patient_model;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.pinkAccent));
            getWindow().setStatusBarColor(getResources().getColor(R.color.grey_font));
        }
        setContentView(R.layout.activity_patient_registration);
        name= (EditText)findViewById(R.id.editText_name);
        age=(EditText)findViewById(R.id.editText_age);
        username=(EditText)findViewById(R.id.editText_username);
        button=(Button)findViewById(R.id.register);


        patient_model=new patientReg_model();

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);


        databaseReference= FirebaseDatabase.getInstance().getReference("users").child("details").push();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        patient_model.setMname(name.getText().toString());

                        patient_model.setMage(age.getText().toString());
                        patient_model.setMusermae(username.getText().toString());

                        databaseReference.child("name").setValue(patient_model.getMname());
                        //databaseReference.child("empno").setValue(patientReg_model.get);
                        databaseReference.child("age").setValue(patient_model.getMage());
                        databaseReference.child("email").setValue(patient_model.getMusermae());
                        Toast.makeText(patient_registration.this, "Successfully Registered :)", Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                }, 2000);

            }
        });

    }
}
