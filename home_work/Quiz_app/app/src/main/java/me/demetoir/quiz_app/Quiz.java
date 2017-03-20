package me.demetoir.quiz_app;

/**
 * Created by yujun on 2017-01-18.
 */

public class Quiz {
    private int problemResId;
    private boolean answer;

    Quiz(int problemResId, boolean answer) {
        this.problemResId = problemResId;
        this.answer = answer;
    }

    int getProblemResId() {
        return this.problemResId;
    }

    void setProblemResId(int problemResId) {
        this.problemResId = problemResId;
    }

    boolean getAnswer() {
        return this.answer;
    }

    void setAnswer(boolean answer) {
        this.answer = answer;
    }

}
