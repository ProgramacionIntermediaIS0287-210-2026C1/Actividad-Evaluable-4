package com.exam.domain.model;

import com.exam.domain.vo.ValueObjects.QuestionId;

public class Question {

    private final QuestionId id;
    private final String text;
    private final String correctAnswer;
    private final QuestionTypes type;

    public Question(QuestionId id, String text, String correctAnswer, QuestionTypes type) {
        this.id = id;
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.type = type;
    }

    public QuestionId getId(){ return id; }
    public String getText(){ return text; }
    public QuestionTypes getType(){ return type; }

    public boolean isCorrect(String answer){
        return correctAnswer.equalsIgnoreCase(answer.trim());
    }
}