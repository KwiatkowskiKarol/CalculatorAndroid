package com.s15752;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.s15752.CalculatorBMI.CalculateBMI;
import com.s15752.Game.GameActivity;
import com.s15752.Game.MainActivityFragment;
import com.s15752.Quiz.QuizActivity;

public class MainActivity extends AppCompatActivity {

    private Button buttonBmi;
    private Button buttonQuiz;
    private Button buttonCovid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBmi = findViewById(R.id.buttonBmi);
        buttonBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalcActivity();
            }
        });

        buttonCovid = findViewById(R.id.buttonCovid);
        buttonCovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChartActivity();
            }
        });

        buttonQuiz = findViewById(R.id.buttonQuiz);
        buttonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizActivity();
            }
        });
    }

    public void openCalcActivity() {
        Intent intent = new Intent(this, CalculateBMI.class);
        startActivity(intent);
    }

    public void openChartActivity() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void openQuizActivity() {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}