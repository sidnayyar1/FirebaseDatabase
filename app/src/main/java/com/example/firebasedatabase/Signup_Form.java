package com.example.firebasedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup_Form extends AppCompatActivity {
EditText txtFullName,txtUserName,txtEmail,txtPassword;
Button btnRegister;
RadioButton btnMale;
RadioButton btnFemale;
DatabaseReference databaseReference;
    String gender = "";
    FirebaseAuth firebaseAuth;
//FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);
        getSupportActionBar().setTitle("Signup Form");


        txtFullName=(EditText)findViewById(R.id.fullname);
        txtUserName=(EditText)findViewById(R.id.username);
        txtEmail=(EditText)findViewById(R.id.emailid);
        txtPassword=(EditText)findViewById(R.id.password);
        btnMale=(RadioButton)findViewById(R.id.radiobtnmale);
        btnFemale=(RadioButton)findViewById(R.id.radiobuttonfemale);
        btnRegister=(Button)findViewById(R.id.btnregister);

        databaseReference=FirebaseDatabase.getInstance().getReference("Customer");
    firebaseAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String fullname = txtFullName.getText().toString();
                String username = txtUserName.getText().toString();
                String email= txtEmail.getText().toString();
                String password = txtPassword.getText().toString();

                if(btnMale.isChecked()){
                    gender = "Male";
                }
                if(btnFemale.isChecked()){
                    gender = "Female";
                }

           if (TextUtils.isEmpty(email)){
               Toast.makeText(Signup_Form.this,"please enter email",Toast.LENGTH_LONG).show();
           }
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(Signup_Form.this,"please enter password",Toast.LENGTH_LONG).show();
                }
                if (TextUtils.isEmpty(username)){
                    Toast.makeText(Signup_Form.this,"please enter username",Toast.LENGTH_LONG).show();

                }
                if (TextUtils.isEmpty(fullname)){
                    Toast.makeText(Signup_Form.this,"please enter fullname",Toast.LENGTH_LONG).show();

                }

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Signup_Form.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                } else {

                                }

                                // ...
                            }
                        });

            }
        });
    }


}
