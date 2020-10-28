package com.example.healthcoaches;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DailyLogActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView displayDate;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_log);

        toolbar = findViewById(R.id.daily_log_main_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.daily_log_drawer_layout);
        navigationView = findViewById(R.id.daily_log_nav_view);
        displayDate = findViewById(R.id.tvDateDisplay);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openNavDrawer, R.string.closeNavDrawer);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        date = simpleDateFormat.format(calendar.getTime());
        displayDate.setText(date);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}