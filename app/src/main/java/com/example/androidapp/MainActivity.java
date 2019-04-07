package com.example.androidapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnreg,_btnlogin;
    EditText _txtfname,_txtlname,_txtpassword,_txtusername,_txtphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelper=new mydb(this);
        _btnreg=(Button)findViewById(R.id.btnreg);
        _txtfname=(EditText)findViewById(R.id.txtfname);
        _txtlname=(EditText)findViewById(R.id.txtlname);
        _txtpassword=(EditText)findViewById(R.id.txtpassword);
        _txtusername=(EditText)findViewById(R.id.txtUsername);
        _txtphone=(EditText)findViewById(R.id.txtphone);
        _btnlogin=(Button)findViewById(R.id.btnlogin);
        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String fname=_txtfname.getText().toString();
                String lname=_txtfname.getText().toString();
                String pass=_txtfname.getText().toString();
                String usernmae=_txtfname.getText().toString();
                String phone=_txtfname.getText().toString();
                insertdata(fname,lname,pass,usernmae,phone);
                Toast.makeText(getApplicationContext(), "registration successful"+ " " +fname, Toast.LENGTH_LONG).show();


            }
        });
        _btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,login.class);
                startActivity(intent);

            }
        });
    }
    public  void insertdata(String fname,String lname,String pass,String username,String phone){
        ContentValues contentValues=new ContentValues();
        contentValues.put(mydb.COL_2,fname);
        contentValues.put(mydb.COL_3,lname);
        contentValues.put(mydb.COL_4,pass);
        contentValues.put(mydb.COL_5,username);
        contentValues.put(mydb.COL_6,phone);
        long id=db.insert(mydb.TABLE_NAME,null,contentValues);
    }
}
