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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class level7 extends AppCompatActivity {


    public int numleft;
    public int numleft1;//переменная для лев картинки
    public int numright;
    public int numright1;//переменная для правой картинки
    public int text_level_2; //переменная для текста
    private TextView text_level;
    private ImageView img_left;
    private ImageView img_left1;
    private ImageView img_right;
    private ImageView img_right1;
    private ArrayList<ImageView> imageViews;
    int answerNum;
    Arrayfor7 array = new Arrayfor7();
    Random random = new Random(); //Для генерации случайной картинки  (чисел)
    public int count = 0; //счетчик правильных ответов
    Dialog dialog;
    private List<Integer> answersNumbers;


    private final int[] progress = {
            R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.victorina7lvl);


        //Вызов диалогового окна в начале игры;
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрытие заголовка
        dialog.setContentView(R.layout.preview_7);//путь к макету диалог. окна
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
                    Intent intent = new Intent( level7.this, EngLevels.class); //намеренье для перехода
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
                    Intent intent = new Intent(level7.this, EngLevels.class); //намеренье для перехода
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

        text_level = findViewById(R.id.text_level);

        //Скругляем края для левой картинки - начало
        img_left = (ImageView)findViewById(R.id.img_left);
        img_left.setClipToOutline(true);
        img_left1 = (ImageView)findViewById(R.id.img_left1);
        img_left.setClipToOutline(true);
        //Скругляем края для левой картинки - конец

        // Скругляем края для правой картинки - начало
        img_right = (ImageView)findViewById(R.id.img_right);
        img_right.setClipToOutline(true);
        img_right1 = (ImageView)findViewById(R.id.img_right1);
        img_right.setClipToOutline(true);
        // Скругляем края для правой картинки - конец

        imageViews = new ArrayList<>();
        imageViews.add(img_right);
        imageViews.add(img_right1);
        imageViews.add(img_left);
        imageViews.add(img_left1);

        //тут создаем переменную массива с вариантами ответов
       generateRandomQuestion();

        // крашитсья?да


        //Цикл для текста - генерируем пока не будет левой или правой картинки - конец

//
//        text_level.setText(array.texts1[text_level_2]);
//        img_left1.setImageResource(array.images1[numleft1]);
//        img_left.setImageResource(array.images1[numleft]); //тут картинка с этих переменных достается, и как раз рандомит ее, может отдельные создать переменные?  плохо без звука ++
//        img_right.setImageResource(array.images1[numright]);
//        img_right1.setImageResource(array.images1[numright1]);
        //Обрабатываем нажатие на левую картинку - начало




        //обработка на правую картинку 1  - начало
        img_left.setOnTouchListener((view, event) -> {
            onImageTap(event, numleft, img_left);
            return true;
        });

        img_left1.setOnTouchListener((view, event) -> {
            onImageTap(event, numleft1, img_left1);
            return true;
        });
        img_right.setOnTouchListener((view, event) -> {
            onImageTap(event, numright, img_right);
            return true;
        });
        img_right1.setOnTouchListener((view, event) -> {
            onImageTap(event, numright1, img_right1);
            return true;
        });
        //Обрабатываем нажатие на правую картинку - конец

    }

    private void generateRandomQuestion() {

        numleft = -1;
        numleft1 = -1;
        numright = -1;
        numright1 = -1;
        answersNumbers = new ArrayList<>();

        while (numleft==numright || numleft == numleft1 || numleft == numright1
                || numleft1 == numright1 || numright == numleft1 ||
                numright == numright1 && text_level_2 != numleft1) {
            numleft = random.nextInt(array.texts1.length );
            numleft1 = random.nextInt(array.texts1.length);
            numright = random.nextInt(array.texts1.length);
            numright1= random.nextInt(array.texts1.length);

        }


        // тут мы добавили все варианты ответов в коллекцию смотри
        answersNumbers.add(numleft);
        answersNumbers.add(numleft1);
        answersNumbers.add(numright);
        answersNumbers.add(numright1);

        answerNum = random.nextInt(answersNumbers.size());
        text_level_2 = answersNumbers.get(answerNum);
        //Цикл для текста - генерируем пока не будет к;артинки - начало
        // еще раз

        text_level.setText(array.texts1[text_level_2]);
        img_left.setImageResource(array.images1[answersNumbers.get(0)]);
        img_left1.setImageResource(array.images1[answersNumbers.get(1)]);
        img_right.setImageResource(array.images1[answersNumbers.get(2)]);
        img_right1.setImageResource(array.images1[answersNumbers.get(3)]);
    }

    //Системная кнопка назад - начало
    @Override
    public void onBackPressed(){
        //обработка нажатия кнопки вернуться - начало
        try {
            //Вернуться назад к выбору уровню - начало
            Intent intent = new Intent(level7.this, EngLevels.class); //намеренье для перехода
            startActivity(intent);
            finish();
            //Вернуться назад к выбору уровню - конец
        }catch (Exception e){
            //сдесь не будет кода так же)0
        }
        //обработка нажатия кнопки вернуться - конец
    }
    //Системная кнопка назад - конец

    private void onImageTap(MotionEvent event, int numAnswer, ImageView answerImageView){

        //Условие касания картинки - начало
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //Если коснулся картинки - начало

            imageViews.forEach((imageView) -> {
                if (imageView == answerImageView){
                    return;
                }
                imageView.setEnabled(false);

            });
//
//            img_right.setEnabled(false); //блокируем правую картинку
//            img_right1.setEnabled(false);
//            img_left1.setEnabled(false);


            if(numAnswer == text_level_2) {
                answerImageView.setImageResource(R.drawable.img_true);
            } else{
                answerImageView.setImageResource(R.drawable.img_false);
                //Если коснулся картинки конец
            }
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            //Если отпустил палец - начало
            if (numAnswer == text_level_2){
                //Если правильно нажмал
                if (count<6){
                    count=count+1;
                }

                //закрашиваем прогресс серым - начало
                for (int i = 0; i<progress.length; i++){
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
                for (int i = 0; i<progress.length; i++){
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
            if (count==6){
                //ВЫХОД ИЗ УРОВНЯ - dialog.show

            }else{

                generateRandomQuestion();
                img_right.setEnabled(true); //включаем обратно правую картинку
                img_right1.setEnabled(true); //включаем обратно правую картинку
                img_left.setEnabled(true); //включаем обратно правую картинку
                img_left1.setEnabled(true); //включаем обратно правую картинку
            }
        }

    }


}