package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class LoginScreen extends AppCompatActivity {

    private Button login;
    private EditText email,password;
    private TextView forgotpassword,register;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        //defining objects in coding
        login = findViewById(R.id.btnlogin);
        email = findViewById(R.id.etemail);
        password = findViewById(R.id.etpassword);
        forgotpassword = findViewById(R.id.txtfgtpass);
        register = findViewById(R.id.registertxt);


        //import firebase funct.
    /*    mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        //If the user alr signed in, direct to dashboard.
        if (user != null) {
            finish();
            startActivity(new Intent(LoginScreen.this, MainActivity.class));
        }*/

        //direct the buttons and funct to another interface
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validate(email.getText().toString(), password.getText().toString());
                startActivity(new Intent(LoginScreen.this, MainActivity.class));
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginScreen.this, RegisterScreen.class));
            }
        });



    }

  /*  private void validate(String userName, String userPassword) {
        mAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    checkEmailVerification();
                } else {
                    Toast.makeText(LoginScreen.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkEmailVerification(){
        FirebaseUser firebaseUser = mAuth.getInstance().getCurrentUser();
        Boolean emailflag = firebaseUser.isEmailVerified();

        if (emailflag) {
            finish();
            startActivity(new Intent(LoginScreen.this,MainActivity.class));
        } else {
            Toast.makeText(this, "Verify Email", Toast.LENGTH_SHORT).show();
            mAuth.signOut();
        }


    }*/

}