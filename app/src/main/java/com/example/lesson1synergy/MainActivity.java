package com.example.lesson1synergy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     //задаём поля
        float Palt = 70; //пальто
        byte PaltDiscount = 77; //скидка
        float Shlap = 25; //шляпа
        byte ShlapDiscount = 37; //скидка
        float DelCos = 53; //деловой костюм
        byte DelCosDiscount = 44; //скидка
        float Sor = 19; //сорочка
        float Tuf = 41; //туфли
        byte TufDiscount = 32; //скидка
        float account = 312; //счёт пользователя
        private Object setText;

        //метод подсчёта стоимости делового гардероба
        private float calculation() {
            //создание и инициализация переменной подсчёта стоимости делового гардероба
            float count = (Palt * (100-PaltDiscount)
                    + Shlap * (100-ShlapDiscount)
                    + DelCos * (100-DelCosDiscount)
                    + Sor
                    + Tuf * (100-TufDiscount)) / 100;
            return count ; //возврат подсчитанного значения
        }

        //метод определения возможностей бюджета покупки делового гардероба

        private boolean possibility () {
            //если стоимость гардероба меньше имеющихся средств
            // иначе
            //возврат ложного значения
            return calculation() <= account; //возврат истинного значения
        }

        // метод определения возможной сдачи
        private float balance() {
            if (possibility()) { //если имеется возможность купить деловой гардероб
                return account - calculation(); //то возвращается остаток от покупки
            } else { //иначе
                return -1; // возвращается маркер недостатка денежных средств
            }
        }

        //создание дополнительных полей для вывода на экарн полученных значений
        private TextView possibilityOut;    //поле возможности покупки
        private TextView balanceOut;    //поле возможного остатка от покупки

            //вывод на экран полученных значений

        @Override
        protected void onCreate(Bundle savedInstanceState) { //создание жизненного цикла активности
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main); //присваивание жизненному циклу активити представления
            //activity main

            // присваивание переменным активити элементов представления активити мэйн
            possibilityOut = findViewById(R.id.possibilityOut);
            balanceOut = findViewById(R.id.balanceOut);
            if (possibility()) {//если имеется возможность купить деловой гардероб
                 possibilityOut.setText("Имеется достаточно средств для покупки делового гардероба");
                 balanceOut.setText("остаток от покупки: " + balance() + " серебрянных монет");
            } else {
                 possibilityOut.setText("Недостаточно средств для покупки делового гардероба");
                 balanceOut.setText("-");
            }


        }
}

