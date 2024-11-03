package com.varyag.testworkoutapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import com.varyag.testworkoutapp.databinding.ActivityMainBinding;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    @SuppressLint("StaticFieldLeak")
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.varyag.testworkoutapp.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        drawerLayout = findViewById(R.id.drawer_layout);
        context = this;
    }
    @SuppressLint("RtlHardcoded")
    public void openDrawer() {
        if (drawerLayout != null) {
            drawerLayout.openDrawer(Gravity.LEFT);
        }
    }
}

