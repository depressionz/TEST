package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        //Кнопка для перехода на 2 LVL - начало
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(EngLevels.this, level2.class);
                    startActivity(intent);finish();
                } catch (Exception e) {
                    //пусто
                }
            }
        });
        //Кнопка для перехода на 2 LVL - конец
        //Кнопка для перехода на 3 LVL - начало
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(EngLevels.this, level3.class);
                    startActivity(intent);finish();
                } catch (Exception e) {
                    //пусто
                }
            }
        });
        //Кнопка для перехода на 3 LVL - конец
        //Кнопка для перехода на 4 LVL - начало
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(EngLevels.this, level4.class);
                    startActivity(intent);finish();
                } catch (Exception e) {
                    //пусто
                }
            }
        });
        //Кнопка для перехода на 4 LVL - конец
        //Кнопка для перехода на 5 LVL - начало
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(EngLevels.this, level5.class);
                    startActivity(intent);finish();
                } catch (Exception e) {
                    //пусто
                }
            }
        });
        //Кнопка для перехода на 5 LVL - конец
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