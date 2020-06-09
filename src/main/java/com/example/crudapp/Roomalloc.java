package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Roomalloc extends AppCompatActivity {
    EditText recipent,subject,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomalloc);
        recipent=findViewById(R.id.recipent);
        subject=findViewById(R.id.subject);
        message=findViewById(R.id.message);
        Button btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }
    void sendMail()
    {
        String recipentList=recipent.getText().toString();
        String[] recipents=recipentList.split(",");
        String subjects=subject.getText().toString();
        String messages=message.getText().toString();
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipents);
        intent.putExtra(Intent.EXTRA_SUBJECT,subjects);
        intent.putExtra(Intent.EXTRA_TEXT,messages);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose an email client"));
    }
}