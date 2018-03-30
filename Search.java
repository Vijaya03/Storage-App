package com.example.hp.storageaap;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.storageaap.dbutil.CompanyManager;
import com.example.hp.storageaap.dbutil.Company_constant;

public class Search extends AppCompatActivity  implements DialogInterface.OnClickListener{
    EditText empID,empsalary;
    TextView txtname;
    CompanyManager companymanager;
    SQLiteDatabase sqLiteDatabase;
TextView txtsalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        empID=findViewById(R.id.empID);
        txtname=findViewById(R.id.txtname);
        txtsalary=findViewById(R.id.txtsalary);
        empsalary=findViewById(R.id.empsalary);
        companymanager = new CompanyManager(this);
        sqLiteDatabase = companymanager.openDB();
    }

    public void fetchdata(View view) {
        String id=empID.getText().toString().trim();
       String[]args={id};
       String[]colname={Company_constant.COL_NAME,Company_constant.COL_SALARY};

        Cursor cursor=sqLiteDatabase.query(Company_constant.TABLE_NAME,colname,Company_constant.COL_ID+"=?",args,null,null,null);

        if(cursor!=null && cursor.moveToFirst())
        {
            String name=cursor.getString(cursor.getColumnIndex(Company_constant.COL_NAME));
            txtname.setText(name);
            String sal=cursor.getString(cursor.getColumnIndex(Company_constant.COL_SALARY));
            txtsalary.setText(sal);

        }
        else
        {
            Toast.makeText(this,"no such id exists",Toast.LENGTH_LONG).show();
        }
        cursor.close();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(companymanager!=null)
        {
           companymanager.closeDB();
        }
    }

    public void updateData(View view) {
        int salary=Integer.parseInt(empsalary.getText().toString());

        String id=empID.getText().toString();
        String[]args={id};
        ContentValues cv= new ContentValues();

        cv.put(Company_constant.COL_SALARY,salary);
        int rw= sqLiteDatabase.update(Company_constant.TABLE_NAME,cv,Company_constant.COL_ID+"=?",args);
        if(rw>0)
        {
            Toast.makeText(this,"dataUdated",Toast.LENGTH_LONG).show();
        }




    }

    public void delete(View view) {


        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setTitle("Record deletion");
        ad.setMessage("are you sure U want to delete record");
        ad.setPositiveButton("yes",this );
        ad.setNegativeButton("No",this);
        AlertDialog adg=ad.create();
        adg.show();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        switch(i)
        {
            case DialogInterface.BUTTON_POSITIVE:{
                deleteRecord();
                break;
            }
            case DialogInterface.BUTTON_NEGATIVE:
            {

            }
        }

    }

    private void deleteRecord() {
        String id=empID.getText().toString();
        if(TextUtils.isEmpty(id))
        {
            Toast.makeText(this,"Enter id",Toast.LENGTH_LONG).show();
            return;
        }
        String[]args={id};
       int rw= sqLiteDatabase.delete(Company_constant.TABLE_NAME,Company_constant.COL_ID+"=?",args);

    if(rw>0)
    {
        Toast.makeText(this,"data deleted successfully",Toast.LENGTH_LONG).show();
    }
}}
