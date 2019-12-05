package com.bmi.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bmi.sqllite.helper.MyHelper;

public class MainActivity extends AppCompatActivity {
private EditText etWord,etMeaning;
private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etWord=findViewById(R.id.etWord);
        etMeaning=findViewById(R.id.etMeaning);
        btnSave=findViewById(R.id.btnSave);
//        final SQLiteDatabase sqLiteDatabase=myHelper.getWritableDatabase();
        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                MyHelper myHelper=new MyHelper(MainActivity.this);

            }
        });

    }
}
