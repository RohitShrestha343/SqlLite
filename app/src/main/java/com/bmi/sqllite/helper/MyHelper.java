package com.bmi.sqllite.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.bmi.sqllite.Word;

import java.util.ArrayList;
import java.util.List;

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
        String query="CREATE TABLE "+tblWord+"("+wordId+" Integer Primary Key AutoIncrement, "+wordName+" TEXT,"+meaning+" TEXT "+")";
        sqLiteDatabase.execSQL(query);

    }
public boolean InsertData(String word, String meaning, SQLiteDatabase db){
        try{
            String query1="insert into tblWord(wordName,meaning) values('"+ word+"','"+meaning+"')";
            db.execSQL(query1);
            return true;
        }catch (Exception e){
            Log.d("Error: ",e.toString());
            return false;
        }
}
public List<Word>GetAllWords(SQLiteDatabase db){
        List<Word> dictionaryList= new ArrayList<>();
    Cursor cursor=db.rawQuery("select * from tblWord",null);
    if(cursor.getCount()>0){
        while (cursor.moveToNext()){
            dictionaryList.add(new Word(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
        }
    }
    return dictionaryList;
}

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
