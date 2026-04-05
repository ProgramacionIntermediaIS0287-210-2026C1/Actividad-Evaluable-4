package com.exam.domain.model;

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

    public abstract boolean esCorrecta(String respuesta);
}