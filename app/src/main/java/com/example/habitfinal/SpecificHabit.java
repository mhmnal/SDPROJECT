package com.example.habitfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SpecificHabit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_habit);

        Intent intent = getIntent();
        cHabitInfo chabitInfo = intent.getParcelableExtra("Example");

        String line1 = chabitInfo.getText1();

        TextView example = findViewById(R.id.tvSpecificHabit);
        example.setText(line1);
    }
}