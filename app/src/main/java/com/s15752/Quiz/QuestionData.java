package com.s15752.Quiz;

public class QuestionData {

    private String mQuestions [] = {
            "What is a coronavirus?",
            "What are the symptoms of someone infected with a coronavirus?",
            "COVID-'number'?" ,
            "How can I protect myself against infection?",
            "Can animals get coronavirus?",
            "where the coronavirus comes from"
    };


    private String mChoices [][] = {
            {"bacteria", "virus", "mushroom"},
            {"fever", "blindness", "deafness"},
            {"17", "9", "19"},
            {"go to the gym", "go on a walk", "stay in home"},
            {"Yes", "No", "don't know"},
            {"Russia", "Poland", "China"}
    };


    private String mCorrectAnswers[] = {"virus", "fever", "19", "stay in home", "don't know","China"};


    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}
