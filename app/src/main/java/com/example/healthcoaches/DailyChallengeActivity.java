package com.example.healthcoaches;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class DailyChallengeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView DailyChallenge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_challenge);

        toolbar = findViewById(R.id.daily_challenge_main_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.daily_challenge_drawer_layout);
        navigationView = findViewById(R.id.daily_challenge_nav_view);
        DailyChallenge = findViewById(R.id.tvDailyChallengeInfo);

        DailyChallenge.setText(R.string.daily_challenge);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openNavDrawer, R.string.closeNavDrawer);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        Button challengeComplete = findViewById(R.id.btnChallengeComplete);
        challengeComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(findViewById(R.id.LinearLayoutChallenge), R.string.challenge_success,
                        Snackbar.LENGTH_SHORT)
                        .show();
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