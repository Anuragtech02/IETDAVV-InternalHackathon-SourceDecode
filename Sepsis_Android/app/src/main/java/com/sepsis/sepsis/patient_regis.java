package com.sepsis.sepsis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sepsis.sepsis.model.patient_model;

public class patient_regis extends AppCompatActivity {
    EditText name, username, age;
    Button button;
    DatabaseReference databaseReference;
    patient_model patient_model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_regis);

        name= (EditText)findViewById(R.id.editText6);
        age=(EditText)findViewById(R.id.editText7);
        username=(EditText)findViewById(R.id.editText8);
        button=(Button)findViewById(R.id.button4);


        patient_model=new patient_model();


        databaseReference= FirebaseDatabase.getInstance().getReference("users").child("details");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patient_model.setMname(name.getText().toString());

                patient_model.setMage(age.getText().toString());
                patient_model.setMusermae(username.getText().toString());

                databaseReference.child("name").setValue(patient_model.getMname());
                //databaseReference.child("empno").setValue(patient_model.get);
                databaseReference.child("age").setValue(patient_model.getMage());
                databaseReference.child("email").setValue(patient_model.getMusermae());
            }
        });

    }
}
