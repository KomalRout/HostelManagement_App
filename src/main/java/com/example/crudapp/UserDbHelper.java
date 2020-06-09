package com.example.crudapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="crud1";
    private static final int DB_VERSION= 1;
    private static final String TABLE_NAME= "user";
    private static final String FIRST_COL ="name";
    private static final String SECOND_COL ="email";
    private static final String THIRD_COL="phone";

    private static final String CREATE_QUERY="CREATE TABLE " + TABLE_NAME + "(" + FIRST_COL + " text," +
            SECOND_COL + " text," + THIRD_COL + " text);";

    public UserDbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        Log.i("DB LOG", "Database Created");
    }
    public void insetData(String name, String email, String phone, SQLiteDatabase db){
        ContentValues content = new ContentValues();
        content.put(FIRST_COL,name);
        content.put(SECOND_COL,email);
        content.put(THIRD_COL,phone);
        db.insert(TABLE_NAME, null,content);
        Log.i("DB LOG", "1 row inserted");
    }
    public Cursor viewData(SQLiteDatabase db){
        Cursor cursor = db.rawQuery("SELECT * FROM " +TABLE_NAME,null);
        return cursor;
    }

    public Cursor searchData(SQLiteDatabase db, String name){
        Cursor cursor = db.rawQuery("SELECT * FROM "+ TABLE_NAME+ " WHERE "+FIRST_COL+ " LIKE "+
                "'"+ name+ "'",null);
        return cursor;
    }
    public int updatedata(SQLiteDatabase db, String name, String email, String phone){
        ContentValues content= new ContentValues();
        content.put(FIRST_COL,name);
        content.put(THIRD_COL,phone);
        String where="email=?";
        String [] whereArgs = new String[] {String.valueOf(email)};
        int status=db.update(TABLE_NAME,content,where,whereArgs);
        return status;
    }
    public int deleteData(SQLiteDatabase db, String email) {
        String where = "email=?";
        String[] whereArgs = new String[]{String.valueOf(email)};
        int num_rows = db.delete(TABLE_NAME, where, whereArgs);
        return num_rows;
    }
    public void onCreate(SQLiteDatabase db)
    {
       db.execSQL(CREATE_QUERY);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){


    }
}
