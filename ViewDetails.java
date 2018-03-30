package com.example.hp.storageaap;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hp.storageaap.Beans.Company;
import com.example.hp.storageaap.dbutil.CompanyManager;
import com.example.hp.storageaap.dbutil.Company_constant;

import java.util.ArrayList;

public class ViewDetails extends AppCompatActivity {
    CompanyManager companymanager;
    SQLiteDatabase sqLiteDatabase;
    Company cp;
    ArrayList<Company> companylist;
    ListView listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);
        companylist=new ArrayList<>();
        listData=findViewById(R.id.listData);
        companymanager = new CompanyManager(this);
        sqLiteDatabase = companymanager.openDB();
        populateList();
    }
    public void populateList()
    {
       // StringBuilder sb = new StringBuilder();
        Cursor c = sqLiteDatabase.query(Company_constant.TABLE_NAME, null, null, null, null, null, null);
        if (c != null && c.moveToFirst()) {
            do {

                int id = c.getInt(c.getColumnIndex(Company_constant.COL_ID));
                String name = c.getString(c.getColumnIndex(Company_constant.COL_NAME));
                int sal = c.getInt(c.getColumnIndex(Company_constant.COL_SALARY));
              //  sb.append(id + "" + name + "" + sal + "");
                cp=new Company(name,id,sal);
                companylist.add(cp);


            }

            while (c.moveToNext());
        }
       // Toast.makeText(this, "" + sb.toString(), Toast.LENGTH_LONG).show();
        ArrayAdapter<Company>ad=new ArrayAdapter<Company>(this,android.R.layout.simple_list_item_1,companylist);
        listData.setAdapter(ad);
        c.close();
    }
}

