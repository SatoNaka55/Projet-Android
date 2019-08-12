package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_error);


        TextView loginErrorText = (TextView) findViewById(R.id.loginErrorText);

        Intent intent = getIntent();

        String receivedUsername = intent.getStringExtra("username");
        String receivedPassword = intent.getStringExtra("password");


        loginErrorText.setText("The username"+ receivedUsername + "and password" + receivedPassword + " is not a valid combination.");
    }
}
