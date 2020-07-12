package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private Button signUpPhoneButton;
    private EditText phoneEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_sign_up);

        signUpPhoneButton = findViewById(R.id.sign_up_phone);
        phoneEditText = findViewById(R.id.phone_edit_text);

        signUpPhoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo = phoneEditText.getText().toString();
                Intent intent=new Intent(SignUpActivity.this,OtpActivity.class);
                intent.putExtra("phone",phoneNo);
                startActivity(intent);
            }
        });

    }
}