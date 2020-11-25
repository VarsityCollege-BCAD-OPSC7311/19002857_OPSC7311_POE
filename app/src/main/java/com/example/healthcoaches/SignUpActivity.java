package com.example.healthcoaches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.healthcoaches.objectClasses.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final EditText username = findViewById(R.id.tilUsername);
        final EditText password = findViewById(R.id.tilPassword);
        Button signUp = findViewById(R.id.btnSignUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usernameS = username.getEditableText().toString();
                String passwordS = password.getEditableText().toString();
                //Creating and initializing User class object
                User user = new User(usernameS, passwordS);

                //Getting Instance of Firebase realtime database
                FirebaseDatabase databaseInstance = FirebaseDatabase.getInstance();

                //Getting Reference to a User node
                DatabaseReference userNode = database.getReference("User");

                //Writing the User class object to that reference
                userNode.setValue(user);

                user.username = usernameS;
                Intent SignUpIntent= new Intent(getApplicationContext(), BioInfoActivity.class);
                startActivity(SignUpIntent);
            }
        });
    }
}