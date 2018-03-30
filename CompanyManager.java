package com.example.hp.storageaap.dbutil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by HP on 14-02-2018.
 */

public class CompanyManager {
    companyhelper Companyhelper;
    SQLiteDatabase sqLiteDatabase;
    public CompanyManager(Context context)
    {
        Companyhelper=new companyhelper(context,Company_constant.DBNAME,null,Company_constant.DBVERSION) ;
    }
    public SQLiteDatabase openDB()
    {
        sqLiteDatabase=Companyhelper.getWritableDatabase();
        return sqLiteDatabase;


    }
    public void closeDB()
    {
        Companyhelper.close();

    }
}
