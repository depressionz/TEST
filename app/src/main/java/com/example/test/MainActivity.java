package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static long back_pressed;
    private Toast backToast;
   @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);


       Button buttonStart = (Button)findViewById(R.id.buttonstart);

       buttonStart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
                try{
                        Intent intent = new Intent(MainActivity.this, EngLevels.class);
                        startActivity(intent);finish();
                } catch (Exception e ){

                }
           }
       });



   }
//системная кнопка назад //начало

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis())
            super.onBackPressed();
        else
            Toast.makeText(getBaseContext(), "Press once again to exit!",
                    Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }

    //системная кнопка назад //конец
}