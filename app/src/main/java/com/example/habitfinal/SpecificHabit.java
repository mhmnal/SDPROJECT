package com.example.habitfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SpecificHabit extends AppCompatActivity {

    private TextView example, name, motivation;
    String name1;
    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference1;
    private Button delete;
    ArrayList<cHabitInfo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_habit);


        cHabitInfo chabitInfo = getIntent().getParcelableExtra("Example");


        String line1 = chabitInfo.getText1();
        String line2 = chabitInfo.getNameHabit();
        String line3 = chabitInfo.getMotiv();

        example = findViewById(R.id.tvSpecificHabit);
        name = findViewById(R.id.specname);
        motivation = findViewById(R.id.specmotiv);
        delete = findViewById(R.id.btndelete);

        auth = FirebaseAuth.getInstance();
        databaseReference1 = FirebaseDatabase.getInstance().getReference("UserInfo").child(auth.getUid());

        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                name1 = snapshot.child("userName").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        example.setText(line1);
        name.setText(line2);
        motivation.setText(line3);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference1.child("Habit").child(name1).push().setValue(null);

                startActivity(new Intent(SpecificHabit.this, DashboardActivity.class));
        }
    });
}

}