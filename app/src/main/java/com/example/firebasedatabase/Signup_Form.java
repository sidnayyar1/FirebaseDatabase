package com.example.firebasedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup_Form extends AppCompatActivity {
EditText txtFullName,txtUserName,txtEmail,txtPassword;
Button btnRegister;
RadioButton btnMale;
RadioButton btnFemale;
DatabaseReference databaseReference;
    String gender = "";
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
                
            }
        });
    }


}
