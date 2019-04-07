package com.example.androidapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button _btnLogin;
    EditText _txtUsername,_txtPass;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        openHelper=new mydb(this);
        db=openHelper.getReadableDatabase();
        _btnLogin=(Button)findViewById(R.id.btnlogin);
        _txtUsername=(EditText)findViewById(R.id.txtUsername);
        _txtPass=(EditText)findViewById(R.id.txtPass);
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=_txtUsername.getText().toString();
                String pass=_txtPass.getText().toString();
                cursor = db.rawQuery(" SELECT * FROM " + mydb.TABLE_NAME + " WHERE " + mydb.COL_5 + " =? AND " + mydb.COL_4 + " =?" , new String[]{username,pass});
            if (cursor!=null){
                if (cursor.getCount()>0){
                    cursor.moveToNext();

                    Toast.makeText(getApplicationContext(),"login successful ",Toast.LENGTH_LONG).show();

                }
                else {


                    Toast.makeText(getApplicationContext(),"invalid usrname and password",Toast.LENGTH_LONG).show();
                }
            }

            }
        });
    }
}
