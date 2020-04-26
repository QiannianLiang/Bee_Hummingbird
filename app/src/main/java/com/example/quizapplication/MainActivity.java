package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mQuestionTest;
    private Button mTrueButton, mFalseButton, mNextButton;

    private int mCurrentIndex = 0;

    private TrueFalse[] mQuestions = new TrueFalse[] {
            new TrueFalse(R.string.questio_one, true),
            new TrueFalse(R.string.questio_two, true),
            new TrueFalse(R.string.questio_three, true),
            new TrueFalse(R.string.questio_four, true),
            new TrueFalse(R.string.questio_five, true),
            new TrueFalse(R.string.questio_six, true),
            new TrueFalse(R.string.questio_seven, true),
            new TrueFalse(R.string.questio_eight, true)
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuestionTest = (TextView) findViewById(R.id.question_text_view);
        final int Question = mQuestions[mCurrentIndex].getQuestion();
        mQuestionTest.setText(Question);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });


        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestions.length;
                int question = mQuestions[mCurrentIndex].getQuestion();
                mQuestionTest.setText(question);
            }
        });


    }





    private void checkAnswer(boolean userPressed) {
        boolean answer = mQuestions[mCurrentIndex].isTrueQuestion();
        if (userPressed == answer) {
            Toast.makeText(MainActivity.this, R.string.true_message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, R.string.false_message, Toast.LENGTH_SHORT).show();
        }
    }
}
