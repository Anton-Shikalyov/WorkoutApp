package com.varyag.testworkoutapp;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.varyag.testworkoutapp.databinding.ActivityMainBinding;
import com.varyag.testworkoutapp.ui.home.HomeFragment;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawerLayout;
    public static Context context;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        drawerLayout = findViewById(R.id.drawer_layout);
        context = this;
    }
    public void openDrawer() {
        if (drawerLayout != null) {
            drawerLayout.openDrawer(Gravity.LEFT);
        }
    }
}

