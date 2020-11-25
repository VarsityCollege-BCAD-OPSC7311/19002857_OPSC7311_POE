package com.example.healthcoaches;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthcoaches.objectClasses.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {
    private String dbUsername;
    private String dbPassword;
    private String inUsername;
    private String inPassword;
    private static final String TAG = "";
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    //Getting Reference to Root Node
    DatabaseReference myRef = database.getReference("User");
    User user = new User();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         EditText logUsername = findViewById(R.id.logUsername);
         EditText logPassword = findViewById(R.id.logPassword);
         Button logIn = findViewById(R.id.btnLogin);

        inUsername = logUsername.getEditableText().toString();
        inPassword = logPassword.getEditableText().toString();

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Reading User Object from Firebase Realtime Database
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot data : dataSnapshot.getChildren()) {
                            //Getting User object from dataSnapshot
                            User user = data.getValue(User.class);
                            assert user != null;
                            user.getUsername();
                            user.getPassword();

                            if (inUsername.equals(user.ToString(user.getUsername())) && (inPassword.equals(user.ToString(user.getPassword())))) {
                                Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                                user.username = inUsername;
                                Intent LoginIntent= new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(LoginIntent);
                            }
                            else {
                                Toast.makeText(LoginActivity.this, "Login unsuccessful. Please check you username and/or password is correct and try again.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                        Log.i(TAG, "onCancelled: Error: " + databaseError.getMessage());

                    }
                });
            }
        });
}
}