package com.exam.domain.model;

import com.exam.domain.vo.ValueObjects;
import com.exam.domain.vo.ValueObjects.AnswerText;
import java.util.*;

public class ExamAttempt {

    private Map<String, AnswerText> respuestas = new HashMap<>();
    private boolean finalizado = false;

    public void responder(String questionId, AnswerText r) {
        if (finalizado) throw new RuntimeException("Examen ya finalizado");
        respuestas.put(questionId, r);
    }

    public void finalizar() {
        finalizado = true;
    }
    public ValueObjects.AnswerText getRespuesta(String questionId) {
    return respuestas.get(questionId);
}

    public Map<String, AnswerText> getRespuestas() {
        return respuestas;
    }
}