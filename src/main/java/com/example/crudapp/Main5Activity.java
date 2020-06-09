package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {

    Button btnwarden;
    EditText passcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        btnwarden=findViewById(R.id.btnwarden);
        passcode=findViewById(R.id.passcode);
        btnwarden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(passcode.getText().toString().equals("warden")){
                    Intent j = new Intent(Main5Activity.this,WardenPage.class);
                    startActivity(j);
                }
                else{
                    Toast.makeText(Main5Activity.this,"Incorrect Input",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
