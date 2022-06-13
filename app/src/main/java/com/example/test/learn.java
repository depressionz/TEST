package com.example.test;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yalantis.library.Koloda;

import java.util.ArrayList;
import java.util.List;

public class learn extends AppCompatActivity {

    private SwipeAdapter adapter;
    private List<Integer> list;


    Koloda koloda;
    DatabaseHelper sqlHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    private ImageView Done_1;




    long userId=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_koloda);
        Done_1 = findViewById(R.id.okey);
        ImageView image  = findViewById(R.id.image);

        list = new ArrayList<>();

        sqlHelper = new DatabaseHelper(this);
        db = sqlHelper.open();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userId = extras.getLong("id");
        }
        // если 0, то добавление
        if (userId > 0) {
            // получаем элемент по id из бд
            userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE + " where " +
                    DatabaseHelper.COLUMN_ID + "=?", new String[]{String.valueOf(userId)});
            userCursor.moveToFirst();
            byte[] byteArray = userCursor.getBlob(2);
            Bitmap bm = BitmapFactory.decodeByteArray(byteArray, 0 ,byteArray.length);
            userCursor.close();
            image.setImageBitmap(bm);

            Done_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent( learn.this, MainActivityBase.class); //намеренье для перехода
                    startActivity(intent); //Старт намеренье
                    finish();
                }
            });
        }




    }

    //системная кнопка назад - начало
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(learn.this, MainActivity.class);
            startActivity(intent);finish();
        }catch(Exception e) {

        }
    }
    //системная кнопка назад - начало
}