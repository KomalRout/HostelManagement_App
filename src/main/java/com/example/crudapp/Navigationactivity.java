package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class Navigationactivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next1);
        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("studentpage");

        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_icons,menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.room_allotment:
                Toast.makeText(this,"Room Allotment",Toast.LENGTH_SHORT).show();
                break;
            case R.id.wardencontact:
                Toast.makeText(this,"warden contact no.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.laundrycontact:
                Toast.makeText(this,"laundry contact no.",Toast.LENGTH_SHORT).show();
                break;
            case R.id.messfragment:
                Toast.makeText(this,"Mess Menu.",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
