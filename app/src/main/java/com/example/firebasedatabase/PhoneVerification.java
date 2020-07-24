package com.example.firebasedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class PhoneVerification extends AppCompatActivity {

    EditText phoneVerifynum,verifycode;
    Button phoneNumber,singin;
FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_verification);
    phoneVerifynum=(EditText)findViewById(R.id.phoneNumber);
    verifycode=(EditText)findViewById(R.id.verificationcode);

phoneNumber=(Button)findViewById(R.id.btnphoneverifycode);
singin = (Button)findViewById(R.id.btnsignin);
firebaseAuth = FirebaseAuth.getInstance();
phoneNumber.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
sendVerificationCode();
    }
});
singin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

    }
});



    }

    private void sendVerificationCode(){

    }
}