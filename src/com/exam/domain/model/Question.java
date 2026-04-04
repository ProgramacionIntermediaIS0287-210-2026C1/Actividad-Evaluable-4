package com.exam.domain.model;

import com.exam.domain.vo.ValueObjects.AnswerText;

public abstract class Question {

    protected String id;
    protected String enunciado;

    public Question(String id, String enunciado) {
        this.id = id;
        this.enunciado = enunciado;
    }

    public String getId() { return id; }
    public String getEnunciado() { return enunciado; }

    public abstract boolean esCorrecta(AnswerText respuesta);

    public String getTexto() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTexto'");
    }
}