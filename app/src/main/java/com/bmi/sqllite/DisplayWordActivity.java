package com.bmi.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bmi.sqllite.helper.MyHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DisplayWordActivity extends AppCompatActivity {
private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_word);
        listView=findViewById(R.id.listview);
        LoadWord();
    }
    private void  LoadWord(){
        final MyHelper myHelper=new MyHelper(this);
        final SQLiteDatabase sqLiteDatabase=myHelper.getWritableDatabase();

        List<Word> wordList=new ArrayList<>();
        wordList=myHelper.GetAllWords(sqLiteDatabase);

        HashMap<String,String>hashMap=new HashMap<>();
            for (int i=0; i<wordList.size();i++){
                hashMap.put(wordList.get(i).getWord(),wordList.get(i).getMeaning());
            }
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>(
                this,android.R.layout.simple_list_item_1,new ArrayList<>(hashMap.keySet()));

            listView.setAdapter(arrayAdapter);
    }
}
