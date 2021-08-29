package com.example.habitfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreateHabit extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText namehabit ;
    private Button createhabit;
    String name, nameHabit,text1;
    private Spinner spinn;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_habit);

        namehabit = findViewById(R.id.etHabitName);
        createhabit = findViewById(R.id.btnCreateHabit);
        spinn = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinn.setAdapter(adapter);
        spinn.setOnItemSelectedListener(this);

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
                databaseReference = FirebaseDatabase.getInstance().getReference("Habit").child(name).push();

                nameHabit = namehabit.getEditableText().toString().trim();
                cHabitInfo chabitinfo = new cHabitInfo();
                chabitinfo.setNameHabit(nameHabit);
                chabitinfo.setText1(text1);
                databaseReference.setValue(chabitinfo);

                startActivity(new Intent(CreateHabit.this,DashboardActivity.class));
            }
            }
        });


    }

    private boolean validate() {
        Boolean result = false;
        nameHabit = namehabit.getText().toString();


        if (nameHabit.isEmpty() ) {
            Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }

        return result;
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        text1 = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(),text1,Toast.LENGTH_SHORT);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}