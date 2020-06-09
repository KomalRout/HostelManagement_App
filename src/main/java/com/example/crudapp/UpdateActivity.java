package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText updateName, updateEmail,updatePhone;
    Button update;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        updateName=findViewById(R.id.updateName);
        updateEmail=findViewById(R.id.updateEmail);
        updatePhone=findViewById(R.id.updatePhone);
        update=findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDbHelper userDbHelper= new UserDbHelper(UpdateActivity.this);
                db=userDbHelper.getWritableDatabase();
                int status= userDbHelper.updatedata(db,updateName.getText().toString(),updateEmail.getText().toString(),
                        updatePhone.getText().toString());
                if(status==1){
                    Toast.makeText(UpdateActivity.this,"Updated Successfully",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(UpdateActivity.this,"Updated Failed",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
