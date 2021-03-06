package com.example.androidapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class mydb extends SQLiteOpenHelper {
    public static  final String DATABASE_NAME="employes.db";
    public static  final String TABLE_NAME="register";
    public static  final String COL_1="ID";
    public static  final String COL_2="firstname";
    public static  final String COL_3="lastname";
    public static  final String COL_4="password";
    public static  final String COL_5="username";
    public static  final String COL_6="phone";



    public mydb(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("CREATE TABLE " +TABLE_NAME+ "(ID INTEGER PRIMARY KEY AUTOINCREMENT, firstname TEXT,lastname TEXT,password TEXT,username TEXT,phone TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
