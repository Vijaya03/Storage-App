package com.example.hp.storageaap;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.storageaap.dbutil.CompanyManager;
import com.example.hp.storageaap.dbutil.Company_constant;

public class Database_demo extends AppCompatActivity {
    CompanyManager companymanager;
    SQLiteDatabase sqLiteDatabase;
    EditText text,name,salary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_demo);
        companymanager = new CompanyManager(this);
        sqLiteDatabase = companymanager.openDB();
        text = findViewById(R.id.text);
        name=findViewById(R.id.name);
        salary=findViewById(R.id.salary);


    }

    public void insertData(View view) {
        int id = Integer.parseInt(text.getText().toString());
        String nam = name.getText().toString();
        int sal = 7878;

        ContentValues contentValues = new ContentValues();
        contentValues.put(Company_constant.COL_ID, id);

        contentValues.put(Company_constant.COL_NAME, nam);
        contentValues.put(Company_constant.COL_SALARY, sal);
        long l = sqLiteDatabase.insert(Company_constant.TABLE_NAME, null, contentValues);
        if (l > 0) {
            Toast.makeText(this, "data inserted is", Toast.LENGTH_LONG).show();
        }

    }

    public void viewdata(View view) {
        Intent intent=new Intent(this,ViewDetails.class);
        startActivity(intent);
        /*StringBuilder sb = new StringBuilder();
        Cursor c = sqLiteDatabase.query(Company_constant.TABLE_NAME, null, null, null, null, null, null);
        if (c != null && c.moveToFirst()) {
            do {
                int id = c.getInt(c.getColumnIndex(Company_constant.COL_ID));
                String name = c.getString(c.getColumnIndex(Company_constant.COL_NAME));
                int sal = c.getInt(c.getColumnIndex(Company_constant.COL_SALARY));
                sb.append(id + "" + name + "" + sal + "");


            }

            while (c.moveToNext());
        }
        Toast.makeText(this, "" + sb.toString(), Toast.LENGTH_LONG).show();
        c.close();*/
    }

    public void searchdata(View view) {
        Intent intent=new Intent(this,Search.class);
        startActivity(intent);
    }
}