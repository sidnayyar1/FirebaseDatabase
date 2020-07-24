package com.example.firebasedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

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

        String phone = phoneVerifynum.getText().toString();
        if(phone.isEmpty()){
phoneVerifynum.setText("Phone number is required");
phoneVerifynum.requestFocus();
            return;
        }
        if (phone.length()<10){
            phoneVerifynum.setText("Phone number is not valid");
            phoneVerifynum.requestFocus();
            return;
        }


        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {

        }
    };
}