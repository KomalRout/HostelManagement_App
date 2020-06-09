package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {
    EditText searchInput;
    Button search;
    TextView searchResult;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchInput = findViewById(R.id.searchinput);
        search=findViewById(R.id.search);
        searchResult=findViewById(R.id.searchResult);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDbHelper userDbHelper= new UserDbHelper(SearchActivity.this);
                db= userDbHelper.getReadableDatabase();
                Cursor c= userDbHelper.searchData(db,searchInput.getText().toString());
                if(c.getCount()==0){
                    searchResult.setText("Nothing Found");
                }else{
                    StringBuffer sb = new StringBuffer();
                    c.moveToFirst();
                    do{
                        sb.append("\nName: "+c.getString(0)+ "\n");
                        sb.append("Email: "+c.getString(1)+ "\n");
                        sb.append("Phone no: "+c.getString(2)+ "\n");

                    }while(c.moveToNext());
                    searchResult.setText(sb.toString());
                }

            }
        });
    }
}
