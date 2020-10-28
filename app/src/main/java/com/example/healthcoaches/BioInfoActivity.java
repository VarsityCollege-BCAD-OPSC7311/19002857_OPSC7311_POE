package com.example.healthcoaches;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class BioInfoActivity extends AppCompatActivity {

    private EditText Weight = findViewById(R.id.edtWeight);
    private EditText Height = findViewById(R.id.edtHeight);
    private EditText Age = findViewById(R.id.edtAge);
    private EditText WeightGoal = findViewById(R.id.edtWeightGoal);
    private RadioGroup FoodPReference = findViewById(R.id.rgbFoodPreference);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_info);

        String weight;
        String height;
        String age;
        String weightGoal;
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
        }

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
