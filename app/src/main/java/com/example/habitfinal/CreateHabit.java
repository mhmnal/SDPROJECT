package com.example.habitfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateHabit extends AppCompatActivity {

    private EditText namehabit, motiva;
    private Button createhabit;
    String name,motiv, nameHabit;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_habit);

        namehabit = findViewById(R.id.etHabitName);
        motiva = findViewById(R.id.etmotiv);
        createhabit = findViewById(R.id.btnCreateHabit);

        firebaseAuth = FirebaseAuth.getInstance();
        DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference("UserInfo").child(firebaseAuth.getUid());

        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                name = snapshot.child("userName").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        createhabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(validate()){
                databaseReference = FirebaseDatabase.getInstance().getReference("Habit").child("test").push();

                nameHabit = namehabit.getEditableText().toString().trim();
                motiv = motiva.getEditableText().toString().trim();
                cHabitInfo chabitinfo = new cHabitInfo();
                chabitinfo.setNameHabit(nameHabit);
                chabitinfo.setMotiv(motiv);
                databaseReference.setValue(chabitinfo);

                startActivity(new Intent(CreateHabit.this,CreateHabit2.class));
            }
            }
        });


    }

    private boolean validate() {
        Boolean result = false;
        nameHabit = namehabit.getText().toString();
        motiv = motiva.getText().toString();


        if (nameHabit.isEmpty() || motiv.isEmpty()) {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }

        return result;
    }
}