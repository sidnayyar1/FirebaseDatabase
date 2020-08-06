package com.example.firebasedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Signup_Form extends AppCompatActivity {
    EditText txtFullName, username, txtEmail, txtPassword, txtConfirmpassword;
    Button btnRegister;
    RadioButton btnMale;
    RadioButton btnFemale;
    String gender = "";
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup__form);
        getSupportActionBar().setTitle("Signup Form");


        txtFullName = (EditText) findViewById(R.id.fullname);
        username = (EditText) findViewById(R.id.username1);
        txtEmail = (EditText) findViewById(R.id.emailid);
        txtPassword = (EditText) findViewById(R.id.password);
        txtConfirmpassword = (EditText) findViewById(R.id.confirmpassword);
        btnMale = (RadioButton) findViewById(R.id.radiobtnmale);
        btnFemale = (RadioButton) findViewById(R.id.radiobuttonfemale);
        btnRegister = (Button) findViewById(R.id.btnregister);

        databaseReference = FirebaseDatabase.getInstance().getReference("Customer");
        firebaseAuth = FirebaseAuth.getInstance();


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String fullname = txtFullName.getText().toString();
                final String username1 = username.getText().toString();
                final String email = txtEmail.getText().toString();
                final String password1 = txtPassword.getText().toString();
                String confirmPassword = txtConfirmpassword.getText().toString();


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Signup_Form.this, "please enter email", Toast.LENGTH_LONG).show();
                }
                if (TextUtils.isEmpty(password1)) {
                    Toast.makeText(Signup_Form.this, "please enter password", Toast.LENGTH_LONG).show();
                }
                if (TextUtils.isEmpty(username1)) {
                    Toast.makeText(Signup_Form.this, "please enter username", Toast.LENGTH_LONG).show();

                }

                if (TextUtils.isEmpty(fullname)) {
                    Toast.makeText(Signup_Form.this, "please enter fullname", Toast.LENGTH_LONG).show();

                }

                if (TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(Signup_Form.this, "please enter password again", Toast.LENGTH_LONG).show();

                }

                if (txtPassword.length() < 6) {
                    Toast.makeText(Signup_Form.this, "Password is too short", Toast.LENGTH_LONG).show();
                }

                if (password1 != confirmPassword) {
                    Toast.makeText(Signup_Form.this, "Please Enter same password on both fields", Toast.LENGTH_LONG).show();

                }
                if (btnMale.isChecked()) {
                    gender = "Male";
                }
                if (btnFemale.isChecked()) {
                    gender = "Female";
                }


                firebaseAuth.createUserWithEmailAndPassword(email, password1)
                        .addOnCompleteListener(Signup_Form.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    customer information = new customer(
                                            fullname,
                                            username1,
                                            email,
                                            password1,
                                            gender
                                    );

                                    FirebaseDatabase.getInstance().getReference("customer")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(Signup_Form.this, "registration complete", Toast.LENGTH_LONG).show();
                                            startActivity(new Intent(getApplicationContext(), Login_Form.class));
                                        }
                                    });

                                } else {


                                }

                                // ...
                            }
                        });

            }
        });
    }
}
//    private void register(final String username, String password, String email){
//firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//    @Override
//    public void onComplete(@NonNull Task<AuthResult> task) {
//    if (task.isSuccessful()){
//        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
//        String userId = firebaseUser.getUid();
//        databaseReference = FirebaseDatabase.getInstance().getReference("Users").child(userId);
//
//        HashMap<String, String>hashMap = new HashMap<>();
//        hashMap.put("id",userId);
//        hashMap.put("username",username);
//        databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()){
//                    Intent i= new Intent(Signup_Form.this,MainActivity.class);
//                    startActivity(i);
//                    finish();
//                }
//            }
//        });
//    }else {
//        Toast.makeText(Signup_Form.this,"Registration not done",Toast.LENGTH_LONG).show();
//    }
//    }
//});
//    }
//}



