package com.example.test;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class level2 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    public int numleft; //переменная для лев картинки
    public int numright; //переменная для правой картинки
    public int text_level_2; //переменная для текста
    Array array = new Array();
    Random random = new Random(); //Для генерации случайной картинки  (чисел)
    public int count = 0; //счетчик правильных ответов
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.victorinal);



        showMyDialog(R.layout.preview_2, view -> dialog.dismiss());


        //_______________________________________________
        //Кнопка вернуться - начало
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обработка нажатия кнопки вернуться - начало
                try {
                    //Вернуться назад к выбору уровню - начало
                    Intent intent = new Intent(level2.this, EngLevels.class); //намеренье для перехода
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


        //переменная text_levels
        TextView text_level = findViewById(R.id.text_level);


        //Скругляем края для левой картинки - начало
        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        img_left.setClipToOutline(true);
        //Скругляем края для левой картинки - конец

        // Скругляем края для правой картинки - начало
        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        img_right.setClipToOutline(true);
        // Скругляем края для правой картинки - конец

        //Путь к TextView
        //final TextView text_left = findViewById(R.id.text_level);


        numleft = random.nextInt(10); //генерируем рандомное число от 0 до 9
        img_left.setImageResource(array.images1[numleft]); //Достаем из массива картинку

        numright = random.nextInt(10); //генерируем рандомное число от 0 до 10

        //цикл с предусловием - начало
        while (numleft==numright) {
            numright = random.nextInt(10 );
        }
        //цикл с предусловием - конец

        //Цикл для текста - генерируем пока не будет левой или правой картинки - начало
      while (text_level_2 != numleft && text_level_2 != numright){
           text_level_2 = random.nextInt(9);
       }
        text_level.setText(array.texts1[text_level_2]);
        //Цикл для текста - генерируем пока не будет левой или правой картинки - конец


        img_right.setImageResource(array.images1[numright]); //Достаем с массива картинку
        text_level.setText(array.texts1[text_level_2]);

        // Массив для прогресса игры - начало
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
        };
        // Массив для прогресса игры - конец


        //Подключение анимации - начало
        final Animation a = AnimationUtils.loadAnimation(level2.this, R.anim.alpha);
        //Подключение анимации - конец



        //Обрабатываем нажатие на левую картинку - начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                //Условие касания картинки - начало
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //Если коснулся картинки - начало
                    img_right.setEnabled(false); //блокируем правую картинку
                    if(numleft == text_level_2) {
                        img_left.setImageResource(R.drawable.img_true);
                    } else{
                        img_left.setImageResource(R.drawable.img_false);
                        //Если коснулся картинки конец
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //Если отпустил палец - начало
                    if (numleft == text_level_2){
                        //Если правильно нажмал
                        if (count<5){
                            count=count+1;
                        }

                        //закрашиваем прогресс серым - начало
                        for (int i = 0; i<5; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);

                        }
                        //закрашиваем прогресс серым - конец

                        //Определяем правильный ответ + закрашиваем  - начало
                                for (int i=0; i<count; i++) {
                                    TextView tv = findViewById(progress[i]);
                                    tv.setBackgroundResource(R.drawable.style_points_true);
                                }
                        //Определяем правильный ответ + закрашиваем  - конец
                    }else{
                        //Если неправильно нажмал
                        if(count>0){
                            if(count==1){
                                count=0;
                            }else{
                                count=count-1;
                            }
                        }
                        //закрашиваем прогресс серым - начало
                        for (int i = 0; i<4; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);

                        }
                        //закрашиваем прогресс серым - конец

                        //Определяем правильный ответ + закрашиваем  - начало
                        for (int i=0; i<count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_true);
                        }
                        //Определяем правильный ответ + закрашиваем  - конец
                    }
                    //Если отпустил палец - конец
                    if (count==5){
                        //ВЫХОД ИЗ УРОВНЯ
                        showDialogEnd();
                    }else{

                        numleft = random.nextInt(10); //генерируем рандомное число от 0 до 9
                        img_left.setImageResource(array.images1[numleft]); //Достаем из массива картинку
                        img_left.startAnimation(a);

                        numright = random.nextInt(10); //генерируем рандомное число от 0 до 10

                        //цикл с предусловием - начало
                        while (numleft==numright) {
                            numright = random.nextInt(10 );
                        }
                        //цикл с предусловием - конец

                        //Цикл для текста - генерируем пока не будет левой или правой картинки - начало
                        while (text_level_2 != numleft && text_level_2 != numright){
                            text_level_2 = random.nextInt(9);

                        }
                        text_level.setText(array.texts1[text_level_2]);
                        //Цикл для текста - генерируем пока не будет левой или правой картинки - конец


                        img_right.setImageResource(array.images1[numright]); //Достаем с массива картинку
                        img_right.startAnimation(a);
                        text_level.setText(array.texts1[text_level_2]);

                        img_right.setEnabled(true); //включаем обратно правую картинку
                    }
                }
                    //
                    // конец
                    return true;
            }
        });
        //Обрабатываем нажатие на левую картинку - конец

        //Обрабатываем нажатие на правую картинку - начало
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                //Условие касания картинки - начало
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //Если коснулся картинки - начало
                    img_left.setEnabled(false); //блокируем левую картинку
                    if(numright == text_level_2) {
                        img_right.setImageResource(R.drawable.img_true);
                    } else{
                        img_right.setImageResource(R.drawable.img_false);
                        //Если коснулся картинки конец
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //Если отпустил палец - начало
                    if (numright == text_level_2){
                        //Если правильно нажмал
                        if (count<5){
                            count=count+1;
                        }

                        //закрашиваем прогресс серым - начало
                        for (int i = 0; i<5; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);

                        }
                        //закрашиваем прогресс серым - конец

                        //Определяем правильный ответ + закрашиваем  - начало
                        for (int i=0; i<count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_true);
                        }
                        //Определяем правильный ответ + закрашиваем  - конец
                    }else{
                        //Если неправильно нажмал
                        if(count>0){
                            if(count==1){
                                count=0;
                            }else{
                                count=count-1;
                            }
                        }
                        //закрашиваем прогресс серым - начало
                        for (int i = 0; i<4; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);

                        }
                        //закрашиваем прогресс серым - конец

                        //Определяем правильный ответ + закрашиваем  - начало
                        for (int i=0; i<count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_true);
                        }
                        //Определяем правильный ответ + закрашиваем  - конец
                    }
                    //Если отпустил палец - конец
                    if (count==5){
                        //ВЫХОД ИЗ УРОВНЯ
                        showDialogEnd();
                    }else{
                        numleft = random.nextInt(10); //генерируем рандомное число от 0 до 9
                        img_left.setImageResource(array.images1[numleft]); //Достаем из массива картинку
                        img_left.startAnimation(a);

                        numright = random.nextInt(10); //генерируем рандомное число от 0 до 10

                        //цикл с предусловием - начало
                        while (numleft==numright) {
                            numright = random.nextInt(10 );
                        }
                        //цикл с предусловием - конец

                        //Цикл для текста - генерируем пока не будет левой или правой картинки - начало
                        while (text_level_2 != numleft && text_level_2 != numright){
                            text_level_2 = random.nextInt(9);

                        }
                        text_level.setText(array.texts1[text_level_2]);
                        //Цикл для текста - генерируем пока не будет левой или правой картинки - конец


                        img_right.setImageResource(array.images1[numright]); //Достаем с массива картинку
                        img_right.startAnimation(a);
                        text_level.setText(array.texts1[text_level_2]);

                        img_left.setEnabled(true); //включаем обратно левую картинку
                    }
                }
                //
                // конец
                return true;
            }
        });
        //Обрабатываем нажатие на правую картинку - конец

    }

    private void showMyDialog(int maketId, View.OnClickListener onContinueClick) {
        //Вызов диалогового окна в начале игры;
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрытие заголовка
        dialog.setContentView(maketId);//путь к макету диалог. окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозначный фон
        dialog.setCancelable(false);//окно нельзя закрыть системной кнопкой

        //кнопка которая закрывает диалоговое окно - начало
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обработка нажатия кнопки - начало
                try {
                    //Вернуться назад к выбору уровня - начало
                    Intent intent = new Intent( level2.this, EngLevels.class); //намеренье для перехода
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
        btncontinue.setOnClickListener(onContinueClick);
        //кнопка продолжить - конец

        dialog.show(); //показать диалоговое окно

    }

    //Системная кнопка назад - начало
    @Override
    public void onBackPressed(){
        //обработка нажатия кнопки вернуться - начало
        try {
            //Вернуться назад к выбору уровню - начало
            Intent intent = new Intent(level2.this, EngLevels.class); //намеренье для перехода
            startActivity(intent);
            finish();
            //Вернуться назад к выбору уровню - конец
        }catch (Exception e){
            //сдесь не будет кода так же)0
        }
        //обработка нажатия кнопки вернуться - конец
    }
    //Системная кнопка назад - конец

    private void showDialogEnd(){
        showMyDialog(R.layout.preview_2_end, view -> {
            //обработка нажатия кнопки - начало
            try {
                //Вернуться назад к выбору уровня - начало
                Intent intent = new Intent( level2.this, level3.class); //намеренье для перехода
                startActivity(intent); //Старт намеренье
                finish();
                //Вернуться назад к выбору уровня - конец

            }catch (Exception e) {
                // нету кода
            }
            dialog.dismiss();//закрытие диалогового окна
            //обработка нажатия кнопки - конец
        });
    }



}