package com.example.healthcoaches;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.healthcoaches.objectClasses.DailyLog;
import com.example.healthcoaches.objectClasses.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DailyLogActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    User user = new User();
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_log);

         Toolbar toolbar;
         DrawerLayout drawerLayout;
         NavigationView navigationView;
         TextView displayDate;
         Calendar calendar;
         SimpleDateFormat dateFormat;
         String date;
         EditText WeightLog = findViewById(R.id.edtWeightLog);
         Button logSubmit = findViewById(R.id.btnDailyLogSubmit);

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

        String weightLog;
        String username;

        weightLog = WeightLog.getEditableText().toString();
        username = user.username;

        final DailyLog dailyLog = new DailyLog(date, weightLog, username);

        //Getting Instance of Firebase realtime database
        FirebaseDatabase databaseInstance = FirebaseDatabase.getInstance();

        //Getting Reference to a Log node
        final DatabaseReference logNode = database.getReference("WeightLog");

        logSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Writing the Log class object to that reference
                logNode.setValue(dailyLog);
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