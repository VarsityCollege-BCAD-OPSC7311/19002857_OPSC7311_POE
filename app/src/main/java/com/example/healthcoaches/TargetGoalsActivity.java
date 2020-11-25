package com.example.healthcoaches;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.healthcoaches.objectClasses.TargetGoals;
import com.example.healthcoaches.objectClasses.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.navigation.NavigationView;

public class TargetGoalsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    User user = new User();
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target_goals);

        Toolbar toolbar;
        DrawerLayout drawerLayout;
        NavigationView navigationView;
        EditText WeightGoal = findViewById(R.id.edtWeightGoal);
        EditText CalorieGoal = findViewById(R.id.edtCalorieGoal);
        Button goalSubmit = findViewById(R.id.btnGoalSubmit);

        toolbar = findViewById(R.id.target_Goals_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.goals_drawer_layout);
        navigationView = findViewById(R.id.goals_nav_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openNavDrawer, R.string.closeNavDrawer);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        String weightGoal;
        String calorieGoal;
        String username;

        username = user.username;
        weightGoal = WeightGoal.getEditableText().toString();
        calorieGoal = CalorieGoal.getEditableText().toString();

        final TargetGoals targetGoals = new TargetGoals(weightGoal, calorieGoal, username);

        //Getting Instance of Firebase realtime database
        FirebaseDatabase databaseInstance = FirebaseDatabase.getInstance();

        //Getting Reference to a Goal node
        final DatabaseReference goalNode = database.getReference("TargetGoals");

        goalSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Writing the Goals class object to that reference
                goalNode.setValue(targetGoals);
            }
        });
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}