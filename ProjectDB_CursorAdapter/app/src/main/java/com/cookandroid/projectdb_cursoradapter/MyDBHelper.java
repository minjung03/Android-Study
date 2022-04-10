package com.cookandroid.projectdb_cursoradapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {

    public MyDBHelper(Context context){
        super(context, "contactDB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE contactDB(_id integer PRIMARY KEY autoincrement, name text, tel text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contactDB");
        onCreate(db);
    }
}
