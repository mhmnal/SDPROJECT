package com.example.habitfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class ForgotPasswordActivity extends AppCompatActivity {

    private Button back,confirm;
    private EditText forgotpassword;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        back = findViewById(R.id.forgotback);
        confirm = findViewById(R.id.confirmforgot);
        forgotpassword = findViewById(R.id.forgotnewpass);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForgotPasswordActivity.this, MainActivity.class));
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useremail = forgotpassword.getText().toString().trim();

                if (useremail.equals("")) {
                    Toast.makeText(ForgotPasswordActivity.this, " Enter Email ID", Toast.LENGTH_SHORT).show();
                } else {
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ForgotPasswordActivity.this, "Password Reset SENT!", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(ForgotPasswordActivity.this, MainActivity.class));
                            } else {
                                Toast.makeText(ForgotPasswordActivity.this, "Password Reset not sent", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            }
        });
    }
}