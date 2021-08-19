package com.example.android;

public class Question {
    private int questionsText;
    private boolean questionsTrue;
    public Question(int questionsText, boolean questionsTrue){
        this.questionsText=questionsText;
        this.questionsTrue=questionsTrue;
    }

    public void setQuestionsText(int questionsText) {
        this.questionsText = questionsText;
    }

    public int getQuestionsText() {
        return questionsText;
    }

    public boolean isQuestionsTrue() {
        return questionsTrue;
    }

    public void setQuestionsTrue(boolean questionsTrue) {
        this.questionsTrue = questionsTrue;
    }
}
