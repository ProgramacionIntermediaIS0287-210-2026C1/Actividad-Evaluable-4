package com.exam.domain.model;

import java.util.HashMap;
import java.util.Map;

public class ExamAttempt {

    private String studentId;
    private Map<String, String> respuestas;

    // ✅ CONSTRUCTOR VACÍO (ESTE TE FALTABA)
    public ExamAttempt() {
        this.respuestas = new HashMap<>();
    }

    // (Opcional pero recomendado)
    public ExamAttempt(String studentId) {
        this.studentId = studentId;
        this.respuestas = new HashMap<>();
    }

    public void responder(String preguntaId, String respuesta) {
        respuestas.put(preguntaId, respuesta);
    }

    public Map<String, String> getRespuestas() {
        return respuestas;
    }

    public String getStudentId() {
        return studentId;
    }
}