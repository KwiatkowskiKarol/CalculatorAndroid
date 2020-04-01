package com.s15752.CalculatorBMI;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.learn2crack.activities.R;

public class MainActivity extends Activity {

    private Button mBtLaunchActivity;
    private Button gameLaunchActivity;
    private Button quizLaunchActivity;

    @Override
    protected void onCreate(Bundle savedInstanceSate)
    {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.start_screen);

        mBtLaunchActivity = (Button) findViewById(R.id.bt_launch_activity);
        mBtLaunchActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                launchActivityCalculateBMI();
            }

            gameLaunchActivity = (Button) findViewById(R.id.game);
        gameLaunchActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                launchActivityCalculateBMI();
            }

        quizLaunchActivity = (Button) findViewById(R.id.bt_launch_activity);
        quizLaunchActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view)
            {
                launchActivityCalculateBMI();
            }
    });
    }

    private void launchActivityCalculateBMI()
    {
        Intent intent = new Intent(this, CalculateBMI.class);
        startActivity(intent);
    }

    private void launchActivityGame()
    {
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }

    private void launchActivityQuiz()
    {
        Intent intent = new Intent(this, Quiz.class);
        startActivity(intent);
    }
}