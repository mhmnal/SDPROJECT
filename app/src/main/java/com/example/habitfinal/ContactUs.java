package com.example.habitfinal;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ContactUs extends AppCompatActivity {

    ImageButton androidImageButton;

    Button buttonCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        TextView email = (TextView) findViewById(R.id.tv_habitcom);
        email.setText(Html.fromHtml("<a href=\"mailto:HabitSmart@gmail.com\">HabitSmart@gmail.com</a>"));
        email.setMovementMethod(LinkMovementMethod.getInstance());


        buttonCall = findViewById(R.id.btn_call1);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+60 13-317-4100"));
                startActivity(intent);
            }
        });
    }
}