package com.sepsis.sepsis;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class dashboard extends AppCompatActivity {

    private LinearLayout prescriptionLayout,sirs_layout,patient_layout;
    ImageView prescription,sirs,quick_checkup,cure,patient;
    TextView Usenname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.white));
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        setContentView(R.layout.activity_main);

        Usenname= findViewById(R.id.username);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        Usenname.setText(message);
        prescriptionLayout = findViewById(R.id.layout_prescription);
        sirs_layout = findViewById(R.id.layout_sirs);
        patient_layout = findViewById(R.id.layout_patient);

        prescription = findViewById(R.id.medicines);
        sirs = findViewById(R.id.image_sirs);
        patient = findViewById(R.id.image_patient);


        prescriptionLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prescription_layout = new Intent(dashboard.this, prescription.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(dashboard.this,prescription,"prescriptionTransition");
                startActivity(prescription_layout, options.toBundle());
            }
        });
        sirs_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(dashboard.this, sirs.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(dashboard.this,sirs,"sirsTransition");
                startActivity(i,options.toBundle());
            }
        });

        patient_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(dashboard.this, patient_registration.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(dashboard.this,patient,"patientTransition");
                startActivity(i,options.toBundle());
            }
        });


    }


    public void sofa(View v)
    {
        Intent activity = new Intent(dashboard.this, sofa.class);
        startActivity(activity);
    }

    public void cure(View v)
    {
        Intent activity = new Intent(dashboard.this, cure.class);
        startActivity(activity);
    }

    public void quickCheckup(View v)
    {
        Intent activity = new Intent(dashboard.this, HeartRate.class);
        startActivity(activity);
    }

}
