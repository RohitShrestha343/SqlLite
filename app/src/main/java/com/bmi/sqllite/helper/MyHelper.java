package com.bmi.sqllite.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyHelper extends SQLiteOpenHelper {

    //database name and version

    private static final String db_name="Dictionary";
    private static final int db_version=1;

    //Table name

    private static final String tblWord="tblWord";

    //Columns
    private static final String wordId="wordId";
    private static final String wordName="wordName";
    private static final String meaning="meaning";

    public MyHelper(@Nullable Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase=getWritableDatabase();
        String query="CREATE TABLE "+tblWord+"("+wordId+"Integer Primary Key AutoIncrement, "+wordName+" TEXT,"+meaning+" TEXT "+")";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
