package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {
    Button delete;
    EditText deleteInput;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        delete=findViewById(R.id.delete);
        deleteInput=findViewById(R.id.deleteInput);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDbHelper userDbHelper = new UserDbHelper(DeleteActivity.this);
                db=userDbHelper.getWritableDatabase();
                int num_rows=userDbHelper.deleteData(db,deleteInput.getText().toString());
                if(num_rows==1){
                    Toast.makeText(DeleteActivity.this,"Deleted Successfully",
                            Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(DeleteActivity.this,"Delete Failed",
                            Toast.LENGTH_LONG).show();
                }
                }

        });

    }
}
