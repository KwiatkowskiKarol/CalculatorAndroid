package com.s15752.CalculatorBMI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.learn2crack.activities.R;

public class MainActivity extends Activity{

    private Button mBtLaunchActivity;
    private Button game;
    private Button quiz;
    public String manorwoman;

    @Override
    protected void onCreate(Bundle savedInstanceSate)
    {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.start_screen);

        mBtLaunchActivity = (Button) findViewById(R.id.bt_launch_activity);
        mBtLaunchActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                launchActivity();
            }
        });


        game = (Button) findViewById(R.id.game);
        game.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                launchActivityGame();
            }
        });





        quiz = (Button) findViewById(R.id.quiz);
        quiz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                launchActivityQuiz();
            }
        });
    }

    private void launchActivity()
    {
        Intent intent = new Intent(this, CalculateBMI.class);
        startActivity(intent);
    }

    private void launchActivityGame()
    {
        Intent intent = new Intent(this, GameElement.class);
        startActivity(intent);
    }

    private void launchActivityQuiz()
    {
        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.man:
                if (checked)
                    manorwoman = "man";
                break;
            case R.id.woman:
                if (checked)
                    manorwoman = "woman";
                break;
        }
    }
}