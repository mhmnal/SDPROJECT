package com.example.habitfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SpecificHabit extends AppCompatActivity {

    private TextView example, name, motivation;
    private Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_habit);

        Intent intent = getIntent();
        cHabitInfo chabitInfo = intent.getParcelableExtra("Example");

        String line1 = chabitInfo.getText1();
        String line2 = chabitInfo.getNameHabit();
        String line3 = chabitInfo.getMotiv();

        example = findViewById(R.id.tvSpecificHabit);
        name = findViewById(R.id.specname);
        motivation = findViewById(R.id.specmotiv);
        delete = findViewById(R.id.btndelete);

        example.setText(line1);
        name.setText(line2);
        motivation.setText(line3);


    }
}