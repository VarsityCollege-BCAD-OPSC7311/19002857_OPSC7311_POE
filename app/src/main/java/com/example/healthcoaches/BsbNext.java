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
import android.widget.EditText;

import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class BsbNext extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsb_next);

        Toolbar toolbar;
        DrawerLayout drawerLayout;
        NavigationView navigationView;
        final EditText GiInput = findViewById(R.id.edtGiInp);
        final EditText CarbInput = findViewById(R.id.edtCarbInp);
        Button CalcGl = findViewById(R.id.btnCalcBsb);

        toolbar = findViewById(R.id.bsb_next_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.bsb_next_drawer_layout);
        navigationView = findViewById(R.id.bsb_next_nav_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openNavDrawer, R.string.closeNavDrawer);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        CalcGl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int iGiInp = Integer.parseInt(GiInput.getText().toString());
               int iCarbInp = Integer.parseInt(CarbInput.getText().toString());

               int GlOutput = CalculateGl(iGiInp, iCarbInp);

                Snackbar.make(findViewById(R.id.LinearLayoutBsb), "The GL of that food item is " + GlOutput,
                        Snackbar.LENGTH_SHORT)
                        .show();
            }
        });
    }

    private static int CalculateGl(int Gi, int Carbs) {
        int Gl = (Gi * Carbs) / 100;

        return Gi;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}