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

import com.google.android.material.navigation.NavigationView;

public class BloodSugarBalancingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_sugar_balancing);

         Toolbar toolbar;
         DrawerLayout drawerLayout;
         NavigationView navigationView;
         Button bsbNext = findViewById(R.id.btnbsbNext);


        toolbar = findViewById(R.id.bsb_main_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.bsb_drawer_layout);
        navigationView = findViewById(R.id.bsb_nav_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openNavDrawer, R.string.closeNavDrawer);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        bsbNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bsbNextIntent = new Intent(getApplicationContext(), BsbNext.class);
                startActivity(bsbNextIntent);
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