package com.example.android;

public class Question {
    private int questionsText;
    private int explanations;
    private boolean questionsTrue;
    private boolean answer;
    public Question(int questionsText, boolean questionsTrue ,int explanations){
        this.questionsText=questionsText;
        this.questionsTrue=questionsTrue;
        this.explanations=explanations;
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

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public int getExplanations() {
        return explanations;
    }
}
