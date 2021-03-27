package com.example.basicdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static String database_Name = "studentsDB";
    String table_Name = "studentsInfo";
    String column_id = "id";
    String column_name = "name";
    String column_email = "email";
    String column_phone = "phone";


    public DBHelper(@Nullable Context context) {
        super(context, database_Name, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table studentsInfo" + "(id integer primary key autoincrement,name text,email text,phone text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists studentsInfo");
        onCreate(db);
    }
    public String addStudentInfo(String nameText,String emailText,String phoneText){
        ContentValues content=new ContentValues();
        content.put("name",nameText);
        content.put("email",emailText);
        content.put("phone",phoneText);
        SQLiteDatabase mydb=this.getWritableDatabase();
        mydb.insert("studentsInfo",null,content);
        mydb.close();
        return "y";
    }
}
