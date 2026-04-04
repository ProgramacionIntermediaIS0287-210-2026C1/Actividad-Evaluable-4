package com.exam.domain.model;

import com.exam.domain.vo.ValueObjects;

public abstract class Question {

    protected String id;
    protected String texto;

    public Question(String id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public String getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    // 🔥 ESTE MÉTODO ES EL QUE FALTA
    public abstract boolean esCorrecta(ValueObjects.AnswerText answer);
}