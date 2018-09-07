package com.sm.banitro.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.sm.banitro.R;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigation;
    private Toolbar toolbar;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.activity_main_bottom_navigation);
        toolbar = findViewById(R.id.activity_main_toolbar);
        toast = Toast.makeText(this, R.string.toast_click_again_to_exit, Toast.LENGTH_SHORT);
        setValueBottomNavigation();
    }

    private void setValueBottomNavigation() {

        bottomNavigation.setSelectedItemId(R.id.bottom_navigation_recent);
        toolbar.setTitle(R.string.recent);
        goToRecentFragment();

        bottomNavigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.bottom_navigation_profile:
                                toolbar.setTitle(R.string.profile);
                                goToProfileFragment();
                                break;
                            case R.id.bottom_navigation_recent:
                                toolbar.setTitle(R.string.recent);
                                goToRecentFragment();
                                break;
                            case R.id.bottom_navigation_incoming:
                                toolbar.setTitle(R.string.incoming);
                                goToIncomingFragment();
                                break;
                        }
                        return true;
                    }
                });
    }

    private void goToProfileFragment() {

    }

    private void goToRecentFragment() {

    }

    private void goToIncomingFragment() {

    }

    @Override
    public void onBackPressed() {
        if (toast.getView().isShown()) {
            toast.cancel();
            super.onBackPressed();
            return;
        } else {
            toast.show();
        }
    }
}