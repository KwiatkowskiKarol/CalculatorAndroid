package com.s15752.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.s15752.R;

public class QuizActivity extends AppCompatActivity {

    private QuestionData questionData = new QuestionData();

    private TextView mScoreView;
    private TextView mQuestionView;
    private TextView resultQuiz;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button buttonQuit;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        buttonQuit = (Button)findViewById(R.id.quit);
        resultQuiz = (TextView)findViewById(R.id.resultQuiz);

        updateQuestion();

        //Start of Button Listener for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //logic for Button goes in here

                if (mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button1

        //Start of Button Listener for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //logic for Button goes

                if (mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button2

        //Start of Button Listener for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //logic for Button goes in here

                if (mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();

                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });

        //End of Button Listener for Button3
        // Button Exit to main paige
        buttonQuit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

    }

    private void updateQuestion(){
        if(mQuestionNumber <= 5) {
            mQuestionView.setText(questionData.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(questionData.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(questionData.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(questionData.getChoice3(mQuestionNumber));

            mAnswer = questionData.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }else {
            resultQuiz.setText("Your score :" + mScore);
        }
    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }

}
