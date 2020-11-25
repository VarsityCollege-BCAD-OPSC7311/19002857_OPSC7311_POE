package com.example.healthcoaches;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

public class SettingsFragment extends  androidx.fragment.app.Fragment implements View.OnClickListener {


    public View onCreate(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        RadioButton b = (RadioButton) v.findViewById(R.id.rbtnMetricSystem);
        RadioButton c = (RadioButton) v.findViewById(R.id.rtbnImperialSystem);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rbtnMetricSystem:


                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    public SettingsFragment() {
        // Required empty public constructor
    }
}
