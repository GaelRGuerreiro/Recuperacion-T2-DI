package com.example.f1racinglpg;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
            }
        };

        getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int title = getTitle(menuItem);
        showFragment(title);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private int getTitle(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();

        if (itemId == R.id.inicio) {
            return R.string.inicio;
        } else if (itemId == R.id.circuitos) {
            return R.string.circuitos;
        } else if (itemId == R.id.perfil) {
            return R.string.Perfil;
        } else if (itemId == R.id.escuderias) {
            return R.string.escuderias;
        } else if (itemId == R.id.pilotos) {
            return R.string.pilotos;
        } else {
            throw new IllegalArgumentException("Opción de menú no implementada!!");
        }
    }

    private void showFragment(@StringRes int titleId) {
        Fragment fragment = MainContentFragment.newInstance(titleId);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.home_content, fragment)
                .commit();

        setTitle(getString(titleId));
    }
}