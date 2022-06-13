package com.example.test;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class level6 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;
    public String rightAnswer;
    public int rightAnswerCount = 0;
    public int quizCount = 1;
    public int count = 0; //счетчик правильных ответов
    Arrayfor6 array = new Arrayfor6();
    private ImageView image_center;

    final int[] progress = {
            R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6
    };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spelling6lvl);




        EditText ext_edit = findViewById(R.id.edit_text);
        Button btn_next = findViewById(R.id.btn_next);
        //Вызов диалогового окна в начале игры;
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрытие заголовка
        dialog.setContentView(R.layout.preview_6);//путь к макету диалог. окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозначный фон
        dialog.setCancelable(false);//окно нельзя закрыть системной кнопкой
        dialog.show();//показ диалог окна

        //Вызов диалогового окна в конце игры;
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрытие заголовка
        dialogEnd.setContentView(R.layout.preview_6_end);//путь к макету диалог. окна
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
                    Intent intent = new Intent( level6.this, EngLevels.class); //намеренье для перехода
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
                    Intent intent = new Intent(level6.this, level7.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //Сдесь код не нужен
                }
                dialogEnd.dismiss(); // Закрываем диалоговое окно
            }
        });
        //кнопка продолжить - конец
        //кнопка которая закрывает диалоговое окно - начало
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTextAnswer();
            }
        });
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обработка нажатия кнопки - начало
                try {
                    //Вернуться назад к выбору уровня - начало
                    Intent intent = new Intent( level6.this, EngLevels.class); //намеренье для перехода
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
                    Intent intent = new Intent(level6.this, EngLevels.class); //намеренье для перехода
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
        // Скругляем края для правой картинки - начало
        final ImageView img_center = (ImageView)findViewById(R.id.img_right);
        img_center.setClipToOutline(true);
        // Скругляем края для правой картинки - конец

        image_center = (ImageView)findViewById(R.id.img_right);
        setQuestion(0);
        // Receive quizCategory from StartActivity.
        int quizCategory = getIntent().getIntExtra("QUIZ_CATEGORY", 0);
        showNextQuiz();
    }

    private void setQuestion(int numberQuestion) {
        image_center.setImageResource(array.images1[numberQuestion]);
        rightAnswer = getString(array.texts1[numberQuestion]);
    }

    private void checkTextAnswer() {
        EditText editText = findViewById(R.id.edit_text);

        String playerAnswer = editText.getText().toString();
        if (playerAnswer.equalsIgnoreCase(rightAnswer)){
            Toast.makeText(this, "Right answer", Toast.LENGTH_SHORT).show();
            increaseProgress();
        } else {
            Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show();
        }
        showNextQuiz();


    }

    private void increaseProgress() {
        if (rightAnswerCount < progress.length){

            TextView tv = findViewById(progress[rightAnswerCount]);
            tv.setBackgroundResource(R.drawable.style_points_true);
            rightAnswerCount++;

            } else{
                dialogEnd.show();
            }

    }

    public void showNextQuiz() {
        Random random = new Random();
        setQuestion(random.nextInt(array.texts1.length));
    }

    public void checkAnswer(View view) {
        EditText answerBtn = (EditText) findViewById(view.getId());
        String editText = answerBtn.getText().toString();

        if (editText.equals(rightAnswer))
        {
            rightAnswerCount++;
            TextView tv = findViewById(progress[0]);
            tv.setBackgroundResource(R.drawable.style_points_true);
            rightAnswerCount++;
        }

        else {

        }
    }
    //Системная кнопка назад - начало
    @Override
    public void onBackPressed(){
        //обработка нажатия кнопки вернуться - начало
        try {
            //Вернуться назад к выбору уровню - начало
            Intent intent = new Intent(level6.this, EngLevels.class); //намеренье для перехода
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