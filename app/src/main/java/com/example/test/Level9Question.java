package com.example.test;

public class Level9Question {
    private String text;
    private int imageRes;
    private boolean rightAnswer;

    public Level9Question(String text, int imageRes, boolean rightAnswer) {
        this.text = text;
        this.imageRes = imageRes;
        this.rightAnswer = rightAnswer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public boolean isRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(boolean rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
