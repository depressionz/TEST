package com.example.test;

import android.annotation.SuppressLint;
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
import java.util.Collection;
import java.util.Collections;
import java.util.Random;


public class level5 extends AppCompatActivity {

    Dialog dialog;
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
            {"Семья", "Family", "Group", "Help"},
            {"Бабушка", "Grandmother", "Mother", "Brother"},
            {"Бабушка с дедушкой", "Grandparents", "Parents", "Sister"},
            {"Брат", "Brother", "Mother", "Other"},
            {"Мама", "Mother", "Grandmother", "Father"},
            {"Сестра", "Sister", "Beget", "Dad"},
            {"Ребёнок", "Kid", "Boy", "Girl"},
            {"Родственник", "Relative", "Beget", "Child"},
            {"Great-grandfather", "Прадедушка", "Прабабушка", "Дедушка"},
            {"Папа", "Father", "Family", "Grandfather"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.victorina5lvl);

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
        //Кнопка вернуться - начало
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обработка нажатия кнопки вернуться - начало
                try {
                    //Вернуться назад к выбору уровню - начало
                    Intent intent = new Intent(level5.this, EngLevels.class); //намеренье для перехода
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


    public void showNextQuiz() {
        // Generate random number between 0 and 14 (quizArray's size - 1)
        countLabel.setText("Q" + quizCount);
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
        String alertTitle;
        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7, R.id.point8, R.id.point9
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
                    //Определяем правильный ответ + закрашиваем  - конец
            }
        }

        else {
            showinfo("Ошибка!");
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
        showNextQuiz();
    }
}
