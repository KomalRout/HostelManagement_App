package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewActivity extends AppCompatActivity {
    TextView tv;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        tv=findViewById(R.id.tv);
        UserDbHelper userDbHelper= new UserDbHelper(ViewActivity.this);
        db=userDbHelper.getReadableDatabase();
        Cursor c= userDbHelper.viewData(db);
        if(c.getCount()==0) {
            tv.setText("No Data present in Database");
        }else{
            StringBuffer sb=new StringBuffer();
            c.moveToFirst();

            do{

                sb.append("\nName: "+c.getString(0)+ "\n");
                sb.append("Email: "+c.getString(1)+ "\n");
                sb.append("Phone no: "+c.getString(2)+ "\n");
            }while(c.moveToNext());
            tv.setText(sb.toString());
        }
    }
}
