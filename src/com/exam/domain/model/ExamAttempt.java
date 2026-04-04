package com.exam.domain.model;

import java.util.HashMap;
import java.util.Map;

public class ExamAttempt {

    private String studentId;
    private Map<String, String> respuestas = new HashMap<>();

    public ExamAttempt(String studentId) {
        this.studentId = studentId;
    }

    public void responder(String questionId, String respuesta) {
        respuestas.put(questionId, respuesta);
    }

    public Map<String, String> getRespuestas() {
        return respuestas;
    }
}