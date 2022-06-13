package com.example.test;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class level9 extends AppCompatActivity {

    Dialog dialog;

    ArrayList<Level9Question> questions = new ArrayList<>();

    TextView questionText;
    ImageView questionImage;
    Button buttonTrue, buttonFalse;

    QuizBook quizBook = new QuizBook();
    int currentQuestionCounter = 0;

    int numCurrentQuestion = 0;
    Level9Question currentQuestion;

    private final int[] progress = {
            R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,R.id.point6, R.id.point7, R.id.point8
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.victorina9lvl);


        //Вызов диалогового окна в начале игры;
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрытие заголовка
        dialog.setContentView(R.layout.preview_9);//путь к макету диалог. окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозначный фон
        dialog.setCancelable(false);//окно нельзя закрыть системной кнопкой
        dialog.show();//показ диалог окна

        //кнопка которая закрывает диалоговое окно - начало
        TextView btnclose = (TextView) dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //обработка нажатия кнопки - начало
                try {
                    //Вернуться назад к выбору уровня - начало
                    Intent intent = new Intent(level9.this, EngLevels.class); //намеренье для перехода
                    startActivity(intent); //Старт намеренье
                    finish();
                    //Вернуться назад к выбору уровня - конец

                } catch (Exception e) {
                    // нету кода
                }
                dialog.dismiss();//закрытие диалогового окна
                //обработка нажатия кнопки - конец

            }
        });
        //кнопка которая закрывает диалоговое окно - конец

        //кнопка продолжить - начало
        Button btncontinue = (Button) dialog.findViewById(R.id.btncontinue);
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
                    Intent intent = new Intent(level9.this, EngLevels.class); //намеренье для перехода
                    startActivity(intent);
                    finish();
                    //Вернуться назад к выбору уровню - конец
                } catch (Exception e) {
                    //сдесь не будет кода так же)0
                }
                //обработка нажатия кнопки вернуться - конец
            }
        });
        //Кнопка вернуться - конец


        initViews();
        loadingQuestions();
        generateQuestion();
        updateQuestion();
        setListenersTrueFalseButtons();

    }

    private void setListenersTrueFalseButtons() {
        buttonTrue.setOnClickListener(view -> checkAnswer(true));
        buttonFalse.setOnClickListener(view -> checkAnswer(false));
    }

    private void checkAnswer(boolean isTrue) {

        if (currentQuestion.isRightAnswer() == isTrue){
            Toast.makeText(this, "Right Answer", Toast.LENGTH_SHORT).show();
            if (currentQuestionCounter < progress.length){
                generateQuestion();
                updateQuestion();
                TextView tv = findViewById(progress[currentQuestionCounter]);
                tv.setBackgroundResource(R.drawable.style_points_true);
                currentQuestionCounter++;

            } else {

                // end
            }

        } else {
            Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
            currentQuestionCounter--;
            TextView tv = findViewById(progress[currentQuestionCounter]);
            tv.setBackgroundResource(R.drawable.style_points);
            generateQuestion();
            updateQuestion();
        }
    }

    private void updateQuestion() {
        questionText.setText(currentQuestion.getText());
        questionImage.setImageResource(currentQuestion.getImageRes());

    }

    private void generateQuestion() {
        Random random = new Random();
        numCurrentQuestion = random.nextInt(questions.size());
        currentQuestion = questions.get(numCurrentQuestion);
    }

    private void loadingQuestions() {
        for (int i = 0; i < QuizBook.questions.length; i++) {
            questions.add(new Level9Question(QuizBook.questions[i], QuizBook.images[i], QuizBook.answers[i]));
        }
    }

    private void initViews() {
        questionText = findViewById(R.id.textViewQuestion);
        questionImage = findViewById(R.id.img_right);
        buttonTrue = findViewById(R.id.button5);
        buttonFalse = findViewById(R.id.button6);

    }

    //Системная кнопка назад - начало
    @Override
    public void onBackPressed() {
        //обработка нажатия кнопки вернуться - начало
        try {
            //Вернуться назад к выбору уровню - начало
            Intent intent = new Intent(level9.this, EngLevels.class); //намеренье для перехода
            startActivity(intent);
            finish();
            //Вернуться назад к выбору уровню - конец
        } catch (Exception e) {
            //сдесь не будет кода так же)0
        }
        //обработка нажатия кнопки вернуться - конец
    }
    //Системная кнопка назад - конец


}