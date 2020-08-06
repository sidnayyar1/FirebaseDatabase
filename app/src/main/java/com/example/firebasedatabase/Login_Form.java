package com.example.firebasedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Form extends AppCompatActivity {

    EditText txtemail, txtpassword;

    Button btnlogin;
    Button btnskiplogin;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__form);
        getSupportActionBar().setTitle("Login Form");

        txtemail = (EditText) findViewById(R.id.username);
        txtpassword = (EditText) findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnskiplogin = (Button)findViewById(R.id.skiploginbtn);
        firebaseAuth = FirebaseAuth.getInstance();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtemail.getText().toString().trim();
                String password = txtpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Login_Form.this, "please enter email", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Login_Form.this, "please enter password", Toast.LENGTH_LONG).show();
                    return;
                }

                if(password.length()<6) {
                    Toast.makeText(Login_Form.this,"Password is too short",Toast.LENGTH_LONG).show();
                }
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login_Form.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(), MainScreen.class));
                                } else {
                                    Toast.makeText(Login_Form.this, "Login failed or user not available", Toast.LENGTH_LONG).show();
                                }

                                // ...
                            }
                        });


            }
        });
    }

        public void btn_signup_Form (View view){
            startActivity(new Intent(getApplicationContext(), Signup_Form.class));

    }

    public void SkipLogin(View view) {
        startActivity(new Intent(getApplicationContext(), PhoneVerification.class));

    }


}