package com.example.healthcoaches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button signUp = findViewById(R.id.btnSignUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SignUpIntent= new Intent(getApplicationContext(), BioInfoActivity.class);
                startActivity(SignUpIntent);
            }
        });
    }
}