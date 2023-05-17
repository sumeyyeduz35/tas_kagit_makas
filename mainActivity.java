package com.example.tas_kagit_makas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button tas, kagit, makas;

    TextView comScore, userScore, result, comChoiceResult;

    int comSrc=0, userSrc=0, comChoice, userChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tas = findViewById(R.id.mainbtntas);
        kagit = findViewById(R.id.mainbtnkagit);
        makas = findViewById(R.id.mainbtnmakas);
        comScore = findViewById(R.id.maintxtcomputer_score);
        userScore = findViewById(R.id.maintxtuser_score);
        result = findViewById(R.id.maintxtsonuc);
        comChoiceResult = findViewById(R.id.mainTxtComChoice);
        comScore.setText(String.valueOf(comSrc));
        userScore.setText(String.valueOf(userSrc));

    }

    public void mainBtnClick(View view) {
        switch(view.getId()) {
            case R.id.mainbtntas: comChoiceMethod( userChoice = 1);
                break;
            case R.id.mainbtnkagit : comChoiceMethod( userChoice = 2);
                break;
            case R.id.mainbtnmakas : comChoiceMethod( userChoice = 3);
                break;
        }
    }

    public void comChoiceMethod(int userChoice){
        comChoice = (int) (Math.random()*3+1);
        String comSecimi = null;
        if(comChoice == 1) comSecimi="Tas";
        if(comChoice == 2) comSecimi="Kagit";
        if(comChoice == 3) comSecimi="Makas";
        comChoiceResult.setText(String.format("Compute Choice : %s", comSecimi));
        if((comChoice == 1 && userChoice == 1) || (comChoice == 2 && userChoice == 2) || (comChoice == 3 && userChoice == 3)) {
            result.setText("berabere_kaldiniz");
        }
        else if ((comChoice == 1 && userChoice == 3) || (comChoice == 2 && userChoice == 1) || (comChoice == 3 && userChoice == 1) ) {
            result.setText("bilgisayar_kazandı");
            comSrc++; comScore.setText(String.valueOf(comSrc));
        }

        else {
            result.setText("siz_kazandiniz");
            userSrc++; userScore.setText(String.valueOf(userSrc));
        }
    }
}
