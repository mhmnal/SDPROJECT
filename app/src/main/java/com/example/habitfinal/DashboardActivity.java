package com.example.habitfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DashboardActivity extends AppCompatActivity {

    private Button profile,createhabit,listhabit,lesson,aboutus,contactus;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        profile = findViewById(R.id.btnprofile);
        createhabit = findViewById(R.id.dbCreateHabit);
        listhabit = findViewById(R.id.listhabit);
        lesson = findViewById(R.id.btn_Lesson);
        aboutus = findViewById(R.id.btn_AboutUs);
        contactus = findViewById(R.id.btn_ContactUs);


        firebaseAuth = FirebaseAuth.getInstance();
        DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference("UserInfo").child(firebaseAuth.getUid());

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(DashboardActivity.this, ProfileActivity.class));
            }
        });

        createhabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, CreateHabit.class));
            }
        });

        listhabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, ShowHabit.class));
            }
        });

        lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, Lesson.class));
            }
        });

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, AboutUs.class));
            }
        });

        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, ContactUs.class));
            }
        });
    }
}