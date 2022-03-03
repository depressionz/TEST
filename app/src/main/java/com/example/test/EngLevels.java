package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class EngLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eng_levels);

        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                 try {
                        Intent intent = new Intent(EngLevels.this, MainActivity.class);
                        startActivity(intent);finish();
                 }catch(Exception e) {

                }
            }
        });

        //Кнопка для перехода на 1 LVL - начало
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(EngLevels.this, level1.class);
                    startActivity(intent);finish();
                } catch (Exception e) {
                    //пусто
                }
            }
        });
        //Кнопка для перехода на 1 LVL - конец
    }
    //системная кнопка назад - начало
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(EngLevels.this, MainActivity.class);
            startActivity(intent);finish();
        }catch(Exception e) {

        }
    }
    //системная кнопка назад - начало
}