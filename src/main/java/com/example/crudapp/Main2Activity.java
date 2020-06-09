package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText Email,Password;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Email=findViewById(R.id.Email);
        Password=findViewById(R.id.Password);
        Login=findViewById(R.id.btn3);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Email.getText().toString().equals("warden@gmail.com") &&
                        Password.getText().toString().equals("warden")){
                    Intent j = new Intent(Main2Activity.this,next.class);
                    startActivity(j);
                }
                else{
                    Toast.makeText(Main2Activity.this,"Incorrect Input",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
