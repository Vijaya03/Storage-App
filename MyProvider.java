package com.example.hp.storageaap;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.hp.storageaap.dbutil.CompanyManager;
import com.example.hp.storageaap.dbutil.Company_constant;

/**
 * Created by HP on 10-03-2018.
 */

public class MyProvider extends ContentProvider {
    CompanyManager companymanager;
    SQLiteDatabase sqLiteDatabase;
    @Override
    public boolean onCreate() {
        companymanager = new CompanyManager(getContext());
        sqLiteDatabase = companymanager.openDB();

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        Cursor c=sqLiteDatabase.query(Company_constant.TABLE_NAME,null,null,null,null,null,null);
        return c;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
