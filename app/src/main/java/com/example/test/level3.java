package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class level3 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;
    public int imgcenter;
    public int count = 0;
    private MediaPlayer have, make, try_1, know, think ,feel, see,give, put;

    Random random = new Random();
    Arrayfor3 array = new Arrayfor3();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.victorina3lvl);



        have = MediaPlayer.create(this, R.raw.have_three);
        make = MediaPlayer.create(this, R.raw.make_three);
        try_1 = MediaPlayer.create(this, R.raw.try_three);
        know = MediaPlayer.create(this, R.raw.know_three);
        think = MediaPlayer.create(this, R.raw.think_three);

        feel = MediaPlayer.create(this, R.raw.feel_three);
        see = MediaPlayer.create(this, R.raw.see_three);
        give = MediaPlayer.create(this, R.raw.give_three);
        put = MediaPlayer.create(this, R.raw.put_three);

        //Вызов диалогового окна в начале игры;
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрытие заголовка
        dialog.setContentView(R.layout.preview_3);//путь к макету диалог. окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозначный фон
        dialog.setCancelable(false);//окно нельзя закрыть системной кнопкой
        dialog.show();//показ диалог окна


        //_________________________________________________
        //Вызов диалогового окна в конце игры;
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрытие заголовка
        dialogEnd.setContentView(R.layout.preview_3_end);//путь к макету диалог. окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозначный фон
        dialogEnd.setCancelable(false);//окно нельзя закрыть системной кнопкой


        //кнопка которая закрывает диалоговое окно - начало
        TextView btnclose2 = (TextView)dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обработка нажатия кнопки - начало
                try {
                    //Вернуться назад к выбору уровня - начало
                    Intent intent = new Intent( level3.this, EngLevels.class); //намеренье для перехода
                    startActivity(intent); //Старт намеренье
                    finish();
                    //Вернуться назад к выбору уровня - конец

                }catch (Exception e) {
                    // нету кода
                }
                dialogEnd.dismiss();//закрытие диалогового окна
                //обработка нажатия кнопки - конец

            }
        });
        //кнопка которая закрывает диалоговое окно - конец

        //кнопка продолжить - начало
        Button btncontinue2 = (Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(level3.this, level4.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //Сдесь код не нужен
                }
                dialogEnd.dismiss(); // Закрываем диалоговое окно
            }
        });
        //кнопка продолжить - конец

        //_______________________________________________
        //Кнопка вернуться - начало
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обработка нажатия кнопки вернуться - начало
                try {
                    //Вернуться назад к выбору уровню - начало
                    Intent intent = new Intent(level3.this, EngLevels.class); //намеренье для перехода
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

        //кнопка которая закрывает диалоговое окно - начало
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обработка нажатия кнопки - начало
                try {
                    //Вернуться назад к выбору уровня - начало
                    Intent intent = new Intent( level3.this, EngLevels.class); //намеренье для перехода
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



        // Массив для прогресса игры - начало
        final int[] progress = {
                R.id.point1,R.id.point2,R.id.point3,R.id.point4,R.id.point5,R.id.point6,R.id.point7,R.id.point8,R.id.point9
        };
        // Массив для прогресса игры - конец
        //скругляем края картинки - начало
        final ImageView img_center = (ImageView)findViewById(R.id.img_center);
        img_center.setClipToOutline(true);
        //скругляем края картиники - конец

//Первая картинка - начало
        TextView text_center = (TextView)  findViewById(R.id.textview_center);
        img_center.setImageResource(array.images1[0]);
        text_center.setText(array.texts1[0]);

        img_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                soundPlayImage(have);
                TextView tv = findViewById(progress[0]);
                img_center.setImageResource(array.images1[1]);
                text_center.setText(array.texts1[1]);
                tv.setBackgroundResource(R.drawable.style_points_true);

                img_center.setImageResource(array.images1[1]);
                text_center.setText(array.texts1[1]);
                img_center.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        soundPlayImage(make);
                        TextView tv = findViewById(progress[1]);
                        img_center.setImageResource(array.images1[2]);
                        text_center.setText(array.texts1[2]);
                        tv.setBackgroundResource(R.drawable.style_points_true);

                        img_center.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                soundPlayImage(try_1);
                                TextView tv = findViewById(progress[2]);
                                img_center.setImageResource(array.images1[3]);
                                text_center.setText(array.texts1[3]);
                                tv.setBackgroundResource(R.drawable.style_points_true);

                                img_center.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        soundPlayImage(know);
                                        TextView tv = findViewById(progress[3]);
                                        img_center.setImageResource(array.images1[4]);
                                        text_center.setText(array.texts1[4]);
                                        tv.setBackgroundResource(R.drawable.style_points_true);

                                        img_center.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                soundPlayImage(think);

                                                TextView tv = findViewById(progress[4]);
                                                img_center.setImageResource(array.images1[5]);
                                                text_center.setText(array.texts1[5]);
                                                tv.setBackgroundResource(R.drawable.style_points_true);


                                                img_center.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        soundPlayImage(feel);

                                                        TextView tv = findViewById(progress[5]);
                                                        img_center.setImageResource(array.images1[6]);
                                                        text_center.setText(array.texts1[6]);
                                                        tv.setBackgroundResource(R.drawable.style_points_true);


                                                        img_center.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View view) {

                                                                soundPlayImage(see);
                                                                TextView tv = findViewById(progress[6]);
                                                                img_center.setImageResource(array.images1[7]);
                                                                text_center.setText(array.texts1[7]);
                                                                tv.setBackgroundResource(R.drawable.style_points_true);


                                                                img_center.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View view) {
                                                                        soundPlayImage(give);
                                                                        TextView tv = findViewById(progress[7]);
                                                                        img_center.setImageResource(array.images1[8]);
                                                                        text_center.setText(array.texts1[8]);
                                                                        tv.setBackgroundResource(R.drawable.style_points_true);


                                                                        img_center.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View view) {
                                                                                soundPlayImage(put);

                                                                                TextView tv = findViewById(progress[8]);
                                                                                tv.setBackgroundResource(R.drawable.style_points_true);
                                                                                dialogEnd.show();

                                                                            }
                                                                        });

                                                                    }
                                                                });

                                                            }
                                                        });

                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });

            }

        });

        //Первая картинка - конец
    }
    private void soundPlayImage(MediaPlayer sound) {
        sound.start();
        sound.seekTo(0);
        sound.setLooping(false);
        //  sound.seekTo();
    }










    //Системная кнопка назад - начало
    @Override
    public void onBackPressed(){
        //обработка нажатия кнопки вернуться - начало
        try {
            //Вернуться назад к выбору уровню - начало
            Intent intent = new Intent(level3.this, EngLevels.class); //намеренье для перехода
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