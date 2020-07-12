package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class OtpActivity extends AppCompatActivity {

    private String phoneNo;
    private Button otpVerification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_otp);

        Intent intent = getIntent();
        phoneNo = intent.getStringExtra("phone");

        otpVerification=findViewById(R.id.otp_verify);

        otpVerification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OtpActivity.this,phoneNo,Toast.LENGTH_LONG).show();
            }
        });
    }

    

}