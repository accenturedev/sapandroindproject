package com.sap.northwindapplication.mdui;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.sap.northwindapplication.R;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.ic_logo_carrefourp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SettingsFragment settingFragment = new SettingsFragment();
        settingFragment.setRetainInstance(true);
        getSupportFragmentManager().beginTransaction().replace(R.id.settings_container, settingFragment).commit();
    }
}
