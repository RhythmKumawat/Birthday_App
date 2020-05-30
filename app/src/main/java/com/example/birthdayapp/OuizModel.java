package com.example.birthdayapp;

public class OuizModel {

    private int mQuestions;
    private boolean mAnswers;

//    public QuizModel (int questions, boolean answer)  {
//
//     mQuestions = questions;
//     mAnswers = answer;

//    }


    public OuizModel(int questions, boolean answers) {
        mQuestions = questions;
        mAnswers = answers;
    }

    public int getQuestions() {
        return mQuestions;
    }

    public void setQuestions(int question) {
        mQuestions = question;
    }

    public boolean isAnswers() {
        return mAnswers;
    }

    public void setAnswers(boolean answer) {
        mAnswers = answer;
    }

}
