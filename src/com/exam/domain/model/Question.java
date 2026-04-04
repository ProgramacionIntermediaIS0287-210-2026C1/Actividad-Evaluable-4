package com.exam.domain.model;

import com.exam.domain.vo.ValueObjects.AnswerText;
import com.exam.domain.vo.ValueObjects.QuestionId;

//Entidad abstracta que representa el concepto de pregunta en el dominio (ocp).
public abstract class Question {

    protected final QuestionId id;
    protected final String text;
    protected final AnswerText correctAnswer;

    public Question(QuestionId id, String text, AnswerText correctAnswer){
        this.id = id;
        this.text = text;
        this.correctAnswer= correctAnswer;
    }

    public QuestionId getId(){
        return id;
    }

    public String getText(){
        return text;
}

    // Polimorfismo para evaluar respuestas segun el tipo de pregunta
    public abstract boolean isCorrect(AnswerText studenAnswer);

    
    // Poliformismo para la presentacion visual
    public abstract void displayFormat();
        
    
}