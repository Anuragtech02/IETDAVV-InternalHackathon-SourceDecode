package com.sepsis.sepsis;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sepsis.sepsis.model.staff_reis_model;

public class signup extends AppCompatActivity {


    EditText name , password, username, empno,cnfpass;
    Button btn;
    DatabaseReference ref;
    staff_reis_model model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.pinkAccent));
            getWindow().setStatusBarColor(getResources().getColor(R.color.grey_font));
        }
        setContentView(R.layout.signup);

        name= (EditText)findViewById(R.id.editText_name);
        empno= (EditText)findViewById(R.id.editText_empno);
        username= (EditText)findViewById(R.id.editText_uname);
        password= (EditText)findViewById(R.id.editText_pass);
        cnfpass= (EditText)findViewById(R.id.editText_confPass);
        btn=(Button)findViewById(R.id.signup_signup);

        model= new staff_reis_model();



            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(name.getText().toString().isEmpty())
                    {

                    }
                    if(empno.getText().toString().isEmpty()){

                    }
                    if(username.getText().toString().isEmpty()){

                    }
                    if(password.getText().toString().isEmpty()){

                    }
                    if(cnfpass.getText().toString().isEmpty()){
                        
                    }
                    if(cnfpass.getText().toString().equals(password.getText().toString())){
                        staffdata();
                        Intent intent = new Intent(signup.this,sirs.class);
                        startActivity(intent);
                    }
                }
            });

    }


    public void staffdata(){
        ref= FirebaseDatabase.getInstance().getReference("staff").child("details").push();
        model.setMname(name.getText().toString());
        model.setMempno(empno.getText().toString());
        model.setPassword(password.getText().toString());
        model.setUsername(username.getText().toString());

        ref.child("name").setValue(model.getMname());
        ref.child("empno").setValue(model.getMempno());
        ref.child("password").setValue(model.getPassword());
        ref.child("username").setValue(model.getUsername());


    }
}
