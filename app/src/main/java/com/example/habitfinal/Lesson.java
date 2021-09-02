package com.example.habitfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Lesson extends AppCompatActivity {

    Random random = new Random();
    TextView textQuot;
    Button buttonQuot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);

        textQuot = findViewById(R.id.quotes_textview);
        buttonQuot = findViewById(R.id.Btn_next_quote);

        buttonQuot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayQuote();
            }
        });
        displayQuote();
    }

    public void displayQuote(){
        int randNum = random.nextInt((10+1) - 1) + 1;
        String randQuote = "";

        switch (randNum){
            case 1 :
                randQuote = getString(R.string.quote1);
                break;
            case 2 :
                randQuote = getString(R.string.quote2);
                break;
            case 3 :
                randQuote = getString(R.string.quote3);
                break;
            case 4 :
                randQuote = getString(R.string.quote4);
                break;
            case 5 :
                randQuote = getString(R.string.quote5);
                break;
            case 6 :
                randQuote = getString(R.string.quote6);
                break;
            case 7 :
                randQuote = getString(R.string.quote7);
                break;
            case 8 :
                randQuote = getString(R.string.quote8);
                break;
            case 9 :
                randQuote = getString(R.string.quote9);
                break;
            case 10 :
                randQuote = getString(R.string.quote10);
                break;
        }

        textQuot.setText(randQuote);
    }
}
