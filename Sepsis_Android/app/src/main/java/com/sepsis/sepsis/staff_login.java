package com.sepsis.sepsis;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class staff_login extends AppCompatActivity {
    EditText  username, password;
    DatabaseReference reference;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        username= (EditText) findViewById(R.id.editText_uname);
        password= (EditText) findViewById(R.id.editText_pass);
        button= (Button)findViewById(R.id.login_login);

        reference= FirebaseDatabase.getInstance().getReference("staff").child("details");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                String fusername= dataSnapshot.child("username").getValue().toString();
                                String fpassword=dataSnapshot.child("password").getValue().toString();

                                if (username.getText().toString().equals(fusername)){
                                    if (password.getText().toString().equals(fpassword)){
                                        Toast.makeText(staff_login.this, "Logged in", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(staff_login.this, dashboard.class);
                                        i.putExtra("message", username.getText().toString());
                                        startActivity(i);



                                    }else{
                                        Toast.makeText(staff_login.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                                    }
                                }else {
                                    Toast.makeText(staff_login.this, "Incorrect username", Toast.LENGTH_SHORT).show();
                                }



                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });



    }

    public void signup(View view)
    {
        Intent i = new Intent(staff_login.this, signup.class);
        startActivity(i);

    }

}

