package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    EditText email,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        email=findViewById(R.id.Email_student);
        password=findViewById(R.id.Password_student);
        login=findViewById(R.id.btn_student);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals("student@gmail.com") &&
                        password.getText().toString().equals("student")){
                    Intent j = new Intent(Main3Activity.this,next1.class);
                    startActivity(j);
                }
                else{
                    Toast.makeText(Main3Activity.this,"Incorrect Input",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
