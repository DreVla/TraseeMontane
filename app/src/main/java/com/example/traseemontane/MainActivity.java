package com.example.traseemontane;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemReselectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        Ask for permissions
        if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED){
            System.out.println("Permission Granted");

        } else{
            String[] permissionRequested={Manifest.permission.WRITE_EXTERNAL_STORAGE};
            requestPermissions(permissionRequested, 1024);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        BottomNavigationView navigation = findViewById(R.id.menu);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeFragment());
    }

    private boolean loadFragment(Fragment fragment){

        if(fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit);

            transaction.replace(R.id.fragment_container, fragment );
            transaction.addToBackStack(null);
            transaction.commit();

            return true;
        } else return false;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()){
            case R.id.menu_search:
                fragment = new SearchFragment();
                break;
            case R.id.menu_map:
                fragment = new MapFragment();
                break;
            case R.id.menu_home:
                fragment = new HomeFragment();
                break;
            case R.id.menu_info:
                fragment = new InfoFragment();
                break;
            case R.id.menu_settings:
                fragment = new SettingsFragment();
                break;
        }

        return loadFragment(fragment);
    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

    }
}