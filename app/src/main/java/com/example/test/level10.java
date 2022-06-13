package com.example.test;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class level10 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;
    Dialog dialogEnd_over;
    private TextView countLabel;
    private TextView questionlabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    public int count = 0; //счетчик правильных ответов

    public String rightAnswer;
    public int rightAnswerCount = 0;
    public int quizCount = 1;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            //{"Вопрос", "Правильный ответ", "Ответ1"б "Ответ2"}
            {"Stop", "Останавливать", "Сказать", "Идти"},
            {"Walk", "Идти", "Знать", "Считать"},
            {"Remember", "Помнить", "Строить", "Служить"},
            {"Teach", "Учить", "Предлагать", "Объяснять"},
            {"Grow", "Расти", "Сказать", "Смотреть"},
            {"Consider", "Считать", "Ударять", "Объяснять"},
            {"Die", "Умирать", "Знать", "Учить"},
            {"Win", "Побеждать", "Предлагать", "Объяснить"},
            {"Take", "Взять", "Иметь", "Ударять"},
            {"Learn", "Учить", "Ломать", "Выбирать"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.victorina4lvl);

        countLabel = findViewById(R.id.countLabel);
        questionlabel = findViewById(R.id.questionLabel);
        answerBtn1 = findViewById(R.id.answerBtn1);
        answerBtn2 = findViewById(R.id.answerBtn2);
        answerBtn3 = findViewById(R.id.answerBtn3);

        // Receive quizCategory from StartActivity.
        int quizCategory = getIntent().getIntExtra("QUIZ_CATEGORY", 0);


        // Create quizArray from quizData.
        for (int i = 0; i < quizData.length; i++) {

            // Prepare array.
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); // Country
            tmpArray.add(quizData[i][1]); // Right Answer
            tmpArray.add(quizData[i][2]); // Choice1
            tmpArray.add(quizData[i][3]); // Choice2// Choice3
            quizArray.add(tmpArray);
        }
        showNextQuiz();
        //Вызов диалогового окна в начале игры;
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрытие заголовка
        dialog.setContentView(R.layout.preview_4);//путь к макету диалог. окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозначный фон
        dialog.setCancelable(false);//окно нельзя закрыть системной кнопкой
        dialog.show();//показ диалог окна


        //_________________________________________________
        //Вызов диалогового окна в конце игры;
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрытие заголовка
        dialogEnd.setContentView(R.layout.preview_4_end);//путь к макету диалог. окна
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
                    Intent intent = new Intent( level10.this, EngLevels.class); //намеренье для перехода
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
                    Intent intent = new Intent(level10.this, level10.class);
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
                    Intent intent = new Intent(level10.this, EngLevels.class); //намеренье для перехода
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
                    Intent intent = new Intent( level10.this, EngLevels.class); //намеренье для перехода
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
        //Вызов диалогового окна в конце игры;
        dialogEnd_over = new Dialog(this);
        dialogEnd_over.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрытие заголовка
        dialogEnd_over.setContentView(R.layout.preview_4_end_over);//путь к макету диалог. окна
        dialogEnd_over.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозначный фон
        dialogEnd_over.setCancelable(false);//окно нельзя закрыть системной кнопкой


        //кнопка которая закрывает диалоговое окно - начало
        TextView btnclose3 = (TextView)dialogEnd_over.findViewById(R.id.btnclose);
        btnclose3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обработка нажатия кнопки - начало
                try {
                    //Вернуться назад к выбору уровня - начало
                    Intent intent = new Intent( level10.this, EngLevels.class); //намеренье для перехода
                    startActivity(intent); //Старт намеренье
                    finish();
                    //Вернуться назад к выбору уровня - конец

                }catch (Exception e) {
                    // нету кода
                }
                dialogEnd_over.dismiss();//закрытие диалогового окна
                //обработка нажатия кнопки - конец

            }
        });
        //кнопка которая закрывает диалоговое окно - конец

        //кнопка продолжить - начало
        Button btncontinue3 = (Button)dialogEnd_over.findViewById(R.id.btncontinue);
        btncontinue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(level10.this, EngLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //Сдесь код не нужен
                }
                dialogEnd_over.dismiss(); // Закрываем диалоговое окно
            }
        });
        //кнопка продолжить - конец

        //_______________________________________________
        //Кнопка вернуться - начало
        Button btn_back1 = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обработка нажатия кнопки вернуться - начало
                try {
                    //Вернуться назад к выбору уровню - начало
                    Intent intent = new Intent(level10.this, EngLevels.class); //намеренье для перехода
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
        TextView btnclose1 = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обработка нажатия кнопки - начало
                try {
                    //Вернуться назад к выбору уровня - начало
                    Intent intent = new Intent( level10.this, EngLevels.class); //намеренье для перехода
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
    }
    public void showinfo(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();

    }


    public void showNextQuiz() {
        // Generate random number between 0 and 14 (quizArray's size - 1)
        countLabel.setText("Вопрос:" + quizCount);
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());
        // Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

        // Set question and right answer.
        // Array format: {"Country", "Right Answer", "Choice1", "Choice2", "Choice3"}
        questionlabel.setText(quiz.get(0));
        rightAnswer = quiz.get(1);

        // Remove "Country" from quiz and Shuffle choices.
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set choices.
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);

    }
    public void checkAnswer(View view) {
        Button answerBtn = (Button) findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7, R.id.point8, R.id.point7
        };


        if (btnText.equals(rightAnswer))
        {
            rightAnswerCount++;
            if (count<9){
                count=count+1;
                //Определяем правильный ответ + закрашиваем  - начало
                for (int i=0; i<count; i++) {
                    TextView tv = findViewById(progress[i]);
                    tv.setBackgroundResource(R.drawable.style_points_true);
                    rightAnswerCount++;

                }
                if (count == 9){
                    dialogEnd_over.show();
                }
                //Определяем правильный ответ + закрашиваем  - конец
            }

        }

        else {
            showinfo("Ошибка!");
            dialogEnd.show();
            //Если неправильно нажмал
            if(count>0){

            }
            //закрашиваем прогресс серым - начало
            for (int i = 0; i<9; i++){
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
            //  if (count == 8){
            //         dialogEnd.show();
            //   }
        }
        showNextQuiz();
    }

}
