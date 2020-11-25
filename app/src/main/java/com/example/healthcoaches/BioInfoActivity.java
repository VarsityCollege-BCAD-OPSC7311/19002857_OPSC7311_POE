package com.example.healthcoaches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.healthcoaches.objectClasses.BioInfo;
import com.example.healthcoaches.objectClasses.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BioInfoActivity extends AppCompatActivity {

    private EditText Weight = findViewById(R.id.edtWeight);
    private EditText Height = findViewById(R.id.edtHeight);
    private EditText Age = findViewById(R.id.edtAge);
    private EditText WeightGoal = findViewById(R.id.edtWeightGoal);
    private RadioGroup FoodPReference = findViewById(R.id.rgbFoodPreference);

    User user = new User();
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_info);

        String weight;
        String height;
        String age;
        String weightGoal;
        String username;
        int foodPreference;
        String foodPreferenceS;
       weight = Weight.getEditableText().toString();
       height = Height.getEditableText().toString();
       age = Age.getEditableText().toString();
       weightGoal = WeightGoal.getEditableText().toString();
       foodPreference = FoodPReference.getCheckedRadioButtonId();

        switch (foodPreference) {
            case 0:
                foodPreferenceS = "Vegetarian";
                break;
            case 1:
                foodPreferenceS = "Vegan";
                break;
            case 2:
                foodPreferenceS = "Pescatarian";
                break;
            case 3:
                foodPreferenceS = "No Preference";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + foodPreference);
        }
        username = user.username;

        BioInfo bioInfo = new BioInfo(weight, height, age, weightGoal, foodPreferenceS, username);

        //Getting Instance of Firebase realtime database
        FirebaseDatabase databaseInstance = FirebaseDatabase.getInstance();

        //Getting Reference to a User node
        DatabaseReference userNode = database.getReference("BiologicalInfo");

        //Writing the User class object to that reference
        userNode.setValue(bioInfo);

        Button bioInfoSubmit = findViewById(R.id.btnBioInfoSubmit);
        bioInfoSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bioInfoIntent= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(bioInfoIntent);
            }
        });
    }
    }
