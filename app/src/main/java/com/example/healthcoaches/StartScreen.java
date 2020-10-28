package com.example.healthcoaches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.healthcoaches.ui.login.LoginActivity;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        Button signUp = findViewById(R.id.btnStartSignUps);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent StartSignUpIntent= new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(StartSignUpIntent);
            }
        });

        Button Login = findViewById(R.id.btnStartLogin);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent StartLoginIntent= new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(StartLoginIntent);
            }
        });
    }
}