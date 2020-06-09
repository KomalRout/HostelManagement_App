package com.example.crudapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class next1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    wardencontactfragment wardencontactfragment;
    Laundrycontactfragment laundrycontactfragment;
    Room_AllotmentFragment room_allotmentFragment;
    MessFragment messFragment;
    ViewFlipper viewFlipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigationactivity);
        toolbar = findViewById(R.id.toolbar_menu);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.nav);
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(next1.this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        viewFlipper = findViewById(R.id.viewflipper);
        toggle.syncState();//for showing the hamburger icon

        viewFlipper.setAutoStart(true);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.startFlipping();
        navigationView.setNavigationItemSelectedListener(next1.this);
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.menu_roomc:
                room_allotmentFragment=new Room_AllotmentFragment();
                replaceFragment(room_allotmentFragment);
                Toast.makeText(this,"Room Allotment",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_wardenc:
                wardencontactfragment = new wardencontactfragment();
                replaceFragment(wardencontactfragment);
                Toast.makeText(next1.this, "wardencontact number", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_laundryc:
                laundrycontactfragment = new Laundrycontactfragment();
                replaceFragment(laundrycontactfragment);
                Toast.makeText(next1.this, "laundry contact number", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menue_messmenuec:
                messFragment = new MessFragment();
                replaceFragment(messFragment);
                Toast.makeText(next1.this, "Mess Menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_logoutacc:
                Intent intent = new Intent(next1.this,Main4Activity.class);
                startActivity(intent);
        }
        drawerLayout.closeDrawer(Gravity.LEFT);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(Gravity.LEFT)){
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
        else {
            super.onBackPressed();
        }
    }
    private void replaceFragment(Fragment fragment){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_holder,fragment).commit();
    }
}
