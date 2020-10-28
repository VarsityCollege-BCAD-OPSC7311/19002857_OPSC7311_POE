package com.example.healthcoaches;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

private Toolbar toolbar;
private DrawerLayout drawerLayout;
private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        Button targetGoals = findViewById(R.id.btnTargetGoals);
        targetGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent targetGoalsIntent = new Intent(getApplicationContext(), TargetGoalsActivity.class);
                startActivity(targetGoalsIntent);
            }
        });

        Button dailyLog = findViewById(R.id.btnDailyLog);
        targetGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DailyLogIntent= new Intent(getApplicationContext(), DailyLogActivity.class);
                startActivity(DailyLogIntent);
            }
        });

        Button dailyChallenge = findViewById(R.id.btnDailyChallenge);
        targetGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DailyChallengeIntent= new Intent(getApplicationContext(), DailyChallengeActivity.class);
                startActivity(DailyChallengeIntent);
            }
        });

        Button SaveMeals = findViewById(R.id.btnSaveMeals);
        targetGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SaveMealsIntent= new Intent(getApplicationContext(), SaveMealsActivity.class);
                startActivity(SaveMealsIntent);
            }
        });

        Button Quiz = findViewById(R.id.btnQuiz);
        targetGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent QuizIntent= new Intent(getApplicationContext(), QuizActivity.class);
                startActivity(QuizIntent);
            }
        });

        Button BloodSugarBalancing = findViewById(R.id.btnGlCalc);
        targetGoals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent BloodSugarBalancingIntent= new Intent(getApplicationContext(), BloodSugarBalancingActivity.class);
                startActivity(BloodSugarBalancingIntent);
            }
        });

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openNavDrawer, R.string.closeNavDrawer);

       drawerLayout.addDrawerListener(actionBarDrawerToggle);
       actionBarDrawerToggle.syncState();
       navigationView.setNavigationItemSelectedListener(this);

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        Fragment fragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()) {
            case R.id.nav_profile:
                fragmentClass = ProfileFragment.class;
                break;
            case R.id.nav_settings:
                fragmentClass = SettingsFragment.class;
                break;
            default:
                fragmentClass = ProfileFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}