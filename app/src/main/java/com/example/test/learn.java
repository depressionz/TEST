package com.example.test;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.yalantis.library.Koloda;

import java.util.ArrayList;
import java.util.List;

public class learn extends AppCompatActivity {

    private SwipeAdapter adapter;
    private List<Integer> list;
    Koloda koloda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tickethelp);

        list = new ArrayList<>();

        adapter = new SwipeAdapter(this, list);
        koloda.setAdapter(adapter);
        koloda = findViewById(R.id.koloda);


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