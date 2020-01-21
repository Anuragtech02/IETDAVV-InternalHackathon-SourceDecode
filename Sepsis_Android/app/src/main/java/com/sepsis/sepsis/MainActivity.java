package com.sepsis.sepsis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button signup, login;
    SessionManager session;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.theme_welcome);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
            getWindow().setStatusBarColor(getResources().getColor(R.color.blueAccent));
        }
        setContentView(R.layout.layout_welcome);


        signup = findViewById(R.id.welcome_signup);
        login = findViewById(R.id.welcome_login);

        session = new SessionManager(getApplicationContext());

        if(session.isLoggedIn())
        {
            Intent i = new Intent(MainActivity.this, dashboard.class);
            startActivity(i);
            finish();
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(MainActivity.this, signup.class);
                startActivity(activity);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(MainActivity.this, staff_login.class);
                startActivity(activity);
            }
        });


    }
}
