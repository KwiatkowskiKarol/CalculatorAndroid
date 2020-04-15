package com.s15752.Quiz

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.s15752.R

class QuizActivity : AppCompatActivity() {
    private val questionData = QuestionData()
    private var mScoreView: TextView? = null
    private var mQuestionView: TextView? = null
    private var resultQuiz: TextView? = null
    private var mButtonChoice1: Button? = null
    private var mButtonChoice2: Button? = null
    private var mButtonChoice3: Button? = null
    private var buttonQuit: Button? = null
    private var mAnswer: String? = null
    private var mScore = 0
    private var mQuestionNumber = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        mScoreView = findViewById<View>(R.id.score) as TextView
        mQuestionView = findViewById<View>(R.id.question) as TextView
        mButtonChoice1 = findViewById<View>(R.id.choice1) as Button
        mButtonChoice2 = findViewById<View>(R.id.choice2) as Button
        mButtonChoice3 = findViewById<View>(R.id.choice3) as Button
        buttonQuit = findViewById<View>(R.id.quit) as Button
        resultQuiz = findViewById<View>(R.id.resultQuiz) as TextView
        updateQuestion()
        //Start of Button Listener for Button1
        mButtonChoice1!!.setOnClickListener {
            //logic for Button goes in here
            if (mButtonChoice1!!.text === mAnswer) {
                mScore = mScore + 1
                updateScore(mScore)
                updateQuestion()
                Toast.makeText(this@QuizActivity, "correct", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@QuizActivity, "wrong", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
        }
        //End of Button Listener for Button1
//Start of Button Listener for Button2
        mButtonChoice2!!.setOnClickListener {
            //logic for Button goes
            if (mButtonChoice2!!.text === mAnswer) {
                mScore = mScore + 1
                updateScore(mScore)
                updateQuestion()
                Toast.makeText(this@QuizActivity, "correct", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@QuizActivity, "wrong", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
        }
        //End of Button Listener for Button2
//Start of Button Listener for Button3
        mButtonChoice3!!.setOnClickListener {
            //logic for Button goes in here
            if (mButtonChoice3!!.text === mAnswer) {
                mScore = mScore + 1
                updateScore(mScore)
                updateQuestion()
                Toast.makeText(this@QuizActivity, "correct", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@QuizActivity, "wrong", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
        }
        //End of Button Listener for Button3
// Button Exit to main paige
        buttonQuit!!.setOnClickListener { finish() }
    }

    private fun updateQuestion() {
        if (mQuestionNumber <= 5) {
            mQuestionView!!.text = questionData.getQuestion(mQuestionNumber)
            mButtonChoice1!!.text = questionData.getChoice1(mQuestionNumber)
            mButtonChoice2!!.text = questionData.getChoice2(mQuestionNumber)
            mButtonChoice3!!.text = questionData.getChoice3(mQuestionNumber)
            mAnswer = questionData.getCorrectAnswer(mQuestionNumber)
            mQuestionNumber++
        } else {
            resultQuiz!!.text = "Your score :$mScore"
        }
    }

    private fun updateScore(point: Int) {
        mScoreView!!.text = "" + mScore
    }
}