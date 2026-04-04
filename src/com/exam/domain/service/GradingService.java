package com.exam.domain.service;

import com.exam.application.dto.ResultDTO;
import com.exam.domain.model.Question;
import com.exam.domain.model.ExamAttempt;

import java.util.List;

public class GradingService {

    public ResultDTO calificar(List<Question> preguntas, ExamAttempt intento) {
        int score = 0;

        for (Question q : preguntas) {
            String respuesta = intento.getRespuestas().get(q.getId());
            if (respuesta != null && q.esCorrecta(respuesta)) {
                score++;
            }
        }

        return new ResultDTO(score, preguntas.size());
    }
}