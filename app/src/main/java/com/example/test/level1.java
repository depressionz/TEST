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

import java.util.ArrayList;
import java.util.List;

public class level1 extends AppCompatActivity implements View.OnClickListener {

    List<Letter> array = new ArrayList<>();
    Dialog dialog;
    Dialog dialogEnd;


    private ImageView  a_latter, b_latter,  c_latter,  d_latter, e_latter, f_latter, g_latter, h_latter, i_latter,  j_latter, k_latter,  l_latter, m_latter, n_latter, o_latter, p_latter , q_latter, r_latter, s_latter, t_latter, u_latter, v_latter, w_latter, x_latter, y_latter, z_latter ;

    final int[] progress = {
            R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6, R.id.point7, R.id.point8
    };
    int progressCounter = 0;
    public int count = 0;
    private MediaPlayer a_latter_sound, b_latter_sound,  c_latter_sound,  d_latter_sound, e_latter_sound, f_latter_sound, g_latter_sound, h_latter_sound, i_latter_sound,  j_latter_sound, k_latter_sound,  l_latter_sound, m_latter_sound, n_latter_sound, o_latter_sound, p_latter_sound , q_latter_sound, r_latter_sound, s_latter_sound, t_latter_sound, u_latter_sound, v_latter_sound, w_latter_sound, x_latter_sound, y_latter_sound, z_latter_sound  ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.alphabet);
        a_latter = findViewById(R.id.a_latter);
        b_latter = findViewById(R.id.b_latter);
        c_latter = findViewById(R.id.c_latter);
        d_latter = findViewById(R.id.d_latter);
        e_latter = findViewById(R.id.e_latter);
        f_latter = findViewById(R.id.f_latter);
        g_latter = findViewById(R.id.g_latter);
        h_latter = findViewById(R.id.h_latter);
        i_latter = findViewById(R.id.i_latter);
        j_latter = findViewById(R.id.j_latter);
        k_latter = findViewById(R.id.k_latter);
        l_latter = findViewById(R.id.l_latter);
        m_latter = findViewById(R.id.m_latter);
        n_latter = findViewById(R.id.n_latter);
        o_latter = findViewById(R.id.o_latter);
        p_latter = findViewById(R.id.p_latter);
        q_latter = findViewById(R.id.q_latter);
        r_latter = findViewById(R.id.r_latter);
        s_latter = findViewById(R.id.s_latter);
        t_latter = findViewById(R.id.t_latter);
        u_latter = findViewById(R.id.u_latter);
        v_latter = findViewById(R.id.v_latter);
        w_latter = findViewById(R.id.w_latter);
        x_latter = findViewById(R.id.x_latter);
        y_latter = findViewById(R.id.y_latter);
        z_latter = findViewById(R.id.z_latter);





        //Вызов диалогового окна в начале игры;
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрытие заголовка
        dialog.setContentView(R.layout.priviewdialog);//путь к макету диалог. окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозначный фон
        dialog.setCancelable(false);//окно нельзя закрыть системной кнопкой
        dialog.show();//показ диалог окна
        //_________________________________________________
        //Вызов диалогового окна в конце игры;
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрытие заголовка
        dialogEnd.setContentView(R.layout.priviewdialog_end);//путь к макету диалог. окна
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
                    Intent intent = new Intent( level1.this, EngLevels.class); //намеренье для перехода
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
        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss(); // Закрываем диалоговое окно
            }
        });
        //кнопка продолжить - конец

        //кнопка продолжить - начало
        Button btncontinue2 = (Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(level1.this, level2.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //Сдесь код не нужен
                }
                dialogEnd.dismiss(); // Закрываем диалоговое окно
            }
        });
        //кнопка продолжить - конец

        array.add(new Letter(0, "A", "A - Apple [ˈap(ə)l]", MediaPlayer.create(this, R.raw.letter_a)));
        array.add(new Letter(1, "B", "B - Babe [beib]", MediaPlayer.create(this, R.raw.letter_b)));
        array.add(new Letter(2, "C", "C - Case [keis]", MediaPlayer.create(this, R.raw.letter_c)));
        array.add(new Letter(3, "D", "D - Day [dei]", MediaPlayer.create(this, R.raw.letter_d)));
        array.add(new Letter(4, "E", "E - Ever ['evə]", MediaPlayer.create(this, R.raw.letter_e)));
        array.add(new Letter(5, "F", "F - Family ['fæmili]", MediaPlayer.create(this, R.raw.letter_f)));
        array.add(new Letter(6, "G", "G - Good [gud]", MediaPlayer.create(this, R.raw.letter_g)));
        array.add(new Letter(7, "H", "H - Had [həd]", MediaPlayer.create(this, R.raw.letter_h)));
        array.add(new Letter(8, "I", "I - Important [im'pɔ:t(ə)nt]", MediaPlayer.create(this, R.raw.letter_i)));
        array.add(new Letter(9, "J", "J - Job [ʤɔb]", MediaPlayer.create(this, R.raw.letter_j)));
        array.add(new Letter(10, "K", "K - Keep [ki:p]", MediaPlayer.create(this, R.raw.letter_k)));
        array.add(new Letter(11, "L", "L - Last [la:st]", MediaPlayer.create(this, R.raw.letter_l)));
        array.add(new Letter(12, "M", "M - Many ['meni]", MediaPlayer.create(this, R.raw.letter_m)));
        array.add(new Letter(13, "N", "N - Never ['nevə]", MediaPlayer.create(this, R.raw.letter_n)));
        array.add(new Letter(14, "O", "O - Object ['ɔbʤikt]]", MediaPlayer.create(this, R.raw.letter_o)));
        array.add(new Letter(15, "P", "P - People ['pi:pl]", MediaPlayer.create(this, R.raw.letter_p)));
        array.add(new Letter(16, "Q", "Q - Quickly ['kwikli]", MediaPlayer.create(this, R.raw.letter_q)));
        array.add(new Letter(17, "R", "R - Run [rʌn]", MediaPlayer.create(this, R.raw.letter_r)));
        array.add(new Letter(18, "S", "S - Spent [spent]", MediaPlayer.create(this, R.raw.letter_s)));
        array.add(new Letter(19, "T", "T - Two [tu:]", MediaPlayer.create(this, R.raw.letter_t)));
        array.add(new Letter(20, "U", "U - Ugly ['ʌgli]", MediaPlayer.create(this, R.raw.letter_u)));
        array.add(new Letter(21, "V", "V - Very ['veri]", MediaPlayer.create(this, R.raw.letter_v)));
        array.add(new Letter(22, "W", "W - Who [ˈhu:]", MediaPlayer.create(this, R.raw.letter_w)));
        array.add(new Letter(23, "X", "X - boX [bɔks]", MediaPlayer.create(this, R.raw.letter_x)));
        array.add(new Letter(24, "Y", "Y - Young [jʌŋ]", MediaPlayer.create(this, R.raw.letter_y)));
        array.add(new Letter(25, "Z", "Z - Zoo [zu:]", MediaPlayer.create(this, R.raw.letter_z)));



        a_latter_sound = MediaPlayer.create(this, R.raw.letter_a);
        b_latter_sound = MediaPlayer.create(this, R.raw.letter_b);
        c_latter_sound = MediaPlayer.create(this, R.raw.letter_c);
        d_latter_sound = MediaPlayer.create(this, R.raw.letter_d);
        e_latter_sound = MediaPlayer.create(this, R.raw.letter_e);
        f_latter_sound = MediaPlayer.create(this, R.raw.letter_f);
        g_latter_sound = MediaPlayer.create(this, R.raw.letter_g);
        h_latter_sound = MediaPlayer.create(this, R.raw.letter_h);
        i_latter_sound = MediaPlayer.create(this, R.raw.letter_i);
        j_latter_sound = MediaPlayer.create(this, R.raw.letter_j);
        k_latter_sound = MediaPlayer.create(this, R.raw.letter_k);
        l_latter_sound = MediaPlayer.create(this, R.raw.letter_l);
        m_latter_sound = MediaPlayer.create(this, R.raw.letter_m);
        n_latter_sound = MediaPlayer.create(this, R.raw.letter_n);
        o_latter_sound = MediaPlayer.create(this, R.raw.letter_o);
        p_latter_sound = MediaPlayer.create(this, R.raw.letter_p);
        q_latter_sound = MediaPlayer.create(this, R.raw.letter_q);
        r_latter_sound = MediaPlayer.create(this, R.raw.letter_r);
        s_latter_sound = MediaPlayer.create(this, R.raw.letter_s);
        t_latter_sound = MediaPlayer.create(this, R.raw.letter_t);
        u_latter_sound = MediaPlayer.create(this, R.raw.letter_u);
        v_latter_sound = MediaPlayer.create(this, R.raw.letter_v);
        w_latter_sound = MediaPlayer.create(this, R.raw.letter_w);
        x_latter_sound = MediaPlayer.create(this, R.raw.letter_x);
        y_latter_sound = MediaPlayer.create(this, R.raw.letter_y);
        z_latter_sound = MediaPlayer.create(this, R.raw.letter_z);



        a_latter.setOnClickListener(this);
        b_latter.setOnClickListener(this);
        c_latter.setOnClickListener(this);
        d_latter.setOnClickListener(this);
        e_latter.setOnClickListener(this);
        f_latter.setOnClickListener(this);
        g_latter.setOnClickListener(this);
        h_latter.setOnClickListener(this);
        i_latter.setOnClickListener(this);
        j_latter.setOnClickListener(this);
        k_latter.setOnClickListener(this);
        l_latter.setOnClickListener(this);
        m_latter.setOnClickListener(this);
        n_latter.setOnClickListener(this);
        o_latter.setOnClickListener(this);
        p_latter.setOnClickListener(this);
        q_latter.setOnClickListener(this);
        r_latter.setOnClickListener(this);
        s_latter.setOnClickListener(this);
        t_latter.setOnClickListener(this);
        u_latter.setOnClickListener(this);
        v_latter.setOnClickListener(this);
        w_latter.setOnClickListener(this);
        x_latter.setOnClickListener(this);
        y_latter.setOnClickListener(this);
        z_latter.setOnClickListener(this);









        }


    public void showinfo(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();

    }

    private void soundPlayImage(MediaPlayer sound) {
        sound.start();
        sound.seekTo(0);
        sound.setLooping(false);
        //  sound.seekTo();
    }
     private void setProgress(){
         TextView tv = findViewById(progress[progressCounter]);
         tv.setBackgroundResource(R.drawable.style_points_true);
         if(progressCounter < progress.length){
             progressCounter++;
         }
         if (progressCounter > 7){
             dialogEnd.show();
         }
     }

    private void onLetterClick(Letter letter){
        soundPlayImage(letter.getLatterSound());
        showinfo(letter.getMessage());
        //Определяем правильный ответ + закрашиваем  - начало
        setProgress();
        //Определяем правильный ответ + закрашиваем  - конец
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

    @Override
    public void onClick(View view) {
        int num = 0;
        switch (view.getId()){
            case R.id.a_latter: {
                num = 0;
                break;
            }
            case R.id.b_latter: {
                num = 1;
                break;
            }
            case R.id.c_latter: {
               num = 2;
                break;
            }
            case R.id.d_latter: {
                num = 3;
                break;
            }
            case R.id.e_latter: {
                num = 4;
                break;
            }
            case R.id.f_latter: {
                num = 5;
                break;
            }
            case R.id.g_latter: {
                num = 6;
                break;
            }
            case R.id.h_latter: {
                num = 7;
                break;
            }
            case R.id.i_latter: {
                num = 8;
                break;
            }
            case R.id.j_latter: {
                num = 9;
                break;
            }
            case R.id.k_latter: {
                num = 10;
                break;
            }
            case R.id.l_latter: {
                num = 11;
                break;
            }
            case R.id.m_latter: {
                num = 12;
                break;
            }
            case R.id.n_latter: {
                num = 13;
                break;
            }
            case R.id.o_latter: {
                num = 14;
                break;
            }
            case R.id.p_latter: {
                num = 15;
                break;
            }
            case R.id.q_latter: {
                num = 16;
                break;
            }
            case R.id.r_latter: {
                num = 17;
                break;
            }
            case R.id.s_latter: {
                num = 18;
                break;
            }
            case R.id.t_latter: {
                num = 19;
                break;
            }case R.id.u_latter: {
                num = 20;
                break;
            }
            case R.id.v_latter: {
                num = 21;
                break;
            }
            case R.id.w_latter: {
                num = 22;
                break;
            }
            case R.id.x_latter: {
                num = 23;
                break;
            }
            case R.id.y_latter: {
                num = 24;
                break;
            }
            case R.id.z_latter: {
                num = 25;
                break;
            }



        }
        onLetterClick(array.get(num));


    }




}