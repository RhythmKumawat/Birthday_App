package com.example.birthdayapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class OuizApp extends AppCompatActivity {

    private final String SCORE_KEY = "SCORE";
    private final String INDEX_KEY = "INDEX";

    private TextView mTxtQuestions;
    private Button btnTrue;
    private Button btnWrong;

    private int mQuestionIndex;
    private int mQuizQuestion;

    private ProgressBar mProgressBar;
    private TextView mQuizStatsTextView;

    private int mUserScore;

    private OuizModel[] questionCollection = new OuizModel[]{

            new OuizModel(R.string.q1, true),
            new OuizModel(R.string.q2, false),
            new OuizModel(R.string.q3, true),
            new OuizModel(R.string.q4, false),
            new OuizModel(R.string.q5, false),
            new OuizModel(R.string.q6, true),
            new OuizModel(R.string.q7, true),
            new OuizModel(R.string.q8, true),
            new OuizModel(R.string.q9, true),
            new OuizModel(R.string.q10, true),

    };

    final int USER_PROGRESS = (int) Math.ceil(100.0 / questionCollection.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {

            mUserScore = savedInstanceState.getInt(SCORE_KEY);
            mQuestionIndex = savedInstanceState.getInt(INDEX_KEY);

        } else {

            mUserScore = 0;
            mQuestionIndex = 0;

        }

        // first life cycle method
        Toast.makeText(getApplicationContext(), "OnCreate methods is called", Toast.LENGTH_LONG).show();

        mTxtQuestions = findViewById(R.id.txtQuestion);
        OuizModel q1 = questionCollection[mQuestionIndex];
        mQuizQuestion = q1.getQuestions();
        mTxtQuestions.setText(mQuizQuestion);
        mProgressBar = findViewById(R.id.quizPB);
        mQuizStatsTextView = findViewById(R.id.txtQuizStats);
        mQuizStatsTextView.setText(mUserScore + "");
        btnTrue = findViewById(R.id.btnTrue);


        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                evaluateUsersAnswers(true);
                changeQuestionOnButtonClick();

            }
        });

        btnWrong = findViewById(R.id.btnWrong);

        //   btnWrong.setOnClickListener(myClickListener);
        //

        btnWrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                evaluateUsersAnswers(false);
                changeQuestionOnButtonClick();

            }
        });

    }

    private void changeQuestionOnButtonClick() {

        // Modular Operator :-)
        // 20 % 15 = 5 and 30 % 25 = 5

        // Rules:-)
        // 5 % 10 = 5 and 1 % 4 = 1

        mQuestionIndex = (mQuestionIndex + 1) % 10;

        if (mQuestionIndex == 0) {

            AlertDialog.Builder quizAlert = new AlertDialog.Builder(this);
            quizAlert.setCancelable(false);
            quizAlert.setTitle("The Quiz is Finished");
            quizAlert.setMessage("Your Score is " + mUserScore);
            quizAlert.setPositiveButton("Finish the Quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    finish();

                }

            });

            quizAlert.show();

        }

        // 0 = 0 + 1 = 1 % 10 = 1
        // 1 = 1 + 1 = 2 % 10 = 2

        // 9 = 9 + 1 = 10 % 10 = 0

        mQuizQuestion = questionCollection[mQuestionIndex].getQuestions();
        mTxtQuestions.setText(mQuizQuestion);

        mProgressBar.incrementProgressBy(USER_PROGRESS);

        mQuizStatsTextView.setText(mUserScore + "");

    }

    private void evaluateUsersAnswers(boolean userGuess) {

        boolean currentQuestionAnswer = questionCollection[mQuestionIndex].isAnswers();

        if (currentQuestionAnswer == userGuess) {

            Toast.makeText(getApplicationContext(), R.string.correct_toast_message, Toast.LENGTH_SHORT).show();
            mUserScore = mUserScore + 1;

        } else {

            Toast.makeText(getApplicationContext(), R.string.incorrect_toast_message, Toast.LENGTH_SHORT).show();

        }

    }
}
