package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class level1 extends AppCompatActivity {
    Array array = new Array();
    Dialog dialog;
    private ImageView a_latter, d_latter, b_latter, c_latter, o_latter, h_latter, j_latter, l_latter, n_latter;


    public int count = 0;
    private MediaPlayer a_latter_sound;
    private MediaPlayer d_latter_sound, b_latter_sound, c_latter_sound, o_latter_sound, h_latter_sound, j_latter_sound, l_latter_sound, n_latter_sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alphabet);
        a_latter = findViewById(R.id.a_latter);
        d_latter = findViewById(R.id.d_latter);
        // Массив для прогресса игры - начало
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7, R.id.point8
        };
        // Массив для прогресса игры - конец

        a_latter_sound = MediaPlayer.create(this, R.raw.letter_a);
        d_latter_sound = MediaPlayer.create(this, R.raw.letter_d);
        b_latter_sound = MediaPlayer.create(this, R.raw.letter_b);
        c_latter_sound = MediaPlayer.create(this, R.raw.letter_c);
        o_latter_sound = MediaPlayer.create(this, R.raw.letter_o);
        h_latter_sound = MediaPlayer.create(this, R.raw.letter_h);
        j_latter_sound = MediaPlayer.create(this, R.raw.letter_j);
        l_latter_sound = MediaPlayer.create(this, R.raw.letter_l);
        n_latter_sound = MediaPlayer.create(this, R.raw.letter_n);

        a_latter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPlayImage(a_latter_sound);
                showinfo("A - Apple [ˈap(ə)l]");
                //Определяем правильный ответ + закрашиваем  - начало
                    int i = 0;
                    TextView tv = findViewById(progress[i]);
                    tv.setBackgroundResource(R.drawable.style_points_true);

                //Определяем правильный ответ + закрашиваем  - конец
            }

            //Для буквы а - конец

//метод для звука
            private void soundPlayImage(MediaPlayer sound) {
                sound.start();
                sound.seekTo(0);
                sound.setLooping(false);
                //  sound.seekTo();
            }
        });
        d_latter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundPlayImage(d_latter_sound);
                showinfo("D - Dad [dæd]");
                //Определяем правильный ответ + закрашиваем  - начало
                int i = 1;
                TextView tv = findViewById(progress[i]);
                tv.setBackgroundResource(R.drawable.style_points_true);

                //Определяем правильный ответ + закрашиваем  - конец
            }

            //Для буквы d - конец

            //метод для звука
            private void soundPlayImage(MediaPlayer sound) {
                sound.start();
                sound.seekTo(0);
                sound.setLooping(false);
                //  sound.seekTo();
            }
        });





        //Вызов диалогового окна в начале игры;
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрытие заголовка
        dialog.setContentView(R.layout.priviewdialog);//путь к макету диалог. окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозначный фон
        dialog.setCancelable(false);//окно нельзя закрыть системной кнопкой
        dialog.show();//показ диалог окна

        //кнопка которая закрывает диалоговое окно - начало
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обработка нажатия кнопки - начало
                try {
                        //Вернуться назад к выбору уровня - начало
                    Intent intent = new Intent( level1.this, EngLevels.class); //намеренье для перехода
                    startActivity(intent); //Старт намеренье
                    finish();
                        //Вернуться назад к выбору уровня - конец

                }catch (Exception e) {
                    // нету кода
                }
                dialog.dismiss();//закрытие диалогового окна
                //обработка нажатия кнопки - конец

            }
        });
        //кнопка которая закрывает диалоговое окно - конец

        //кнопка продолжить - начало
        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss(); // Закрываем диалоговое окно



            }
        });
        //кнопка продолжить - конец

        //Кнопка вернуться - начало
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обработка нажатия кнопки вернуться - начало
                try {
                    //Вернуться назад к выбору уровню - начало
                    Intent intent = new Intent(level1.this, EngLevels.class); //намеренье для перехода
                    startActivity(intent);
                    finish();
                    //Вернуться назад к выбору уровню - конец
                }catch (Exception e){
                    //сдесь не будет кода так же)0
                }
                //обработка нажатия кнопки вернуться - конец
            }
        });
        //Кнопка вернуться - конец


    }



    public void showinfo(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();

    }
    //Системная кнопка назад - начало
    @Override
    public void onBackPressed(){
        //обработка нажатия кнопки вернуться - начало
        try {
            //Вернуться назад к выбору уровню - начало
            Intent intent = new Intent(level1.this, EngLevels.class); //намеренье для перехода
            startActivity(intent);
            finish();
            //Вернуться назад к выбору уровню - конец
        }catch (Exception e){
            //сдесь не будет кода так же)0
        }
        //обработка нажатия кнопки вернуться - конец
    }
    //Системная кнопка назад - конец


}