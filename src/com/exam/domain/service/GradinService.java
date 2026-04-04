package com.exam.domain.service;

import com.exam.domain.model.*;
import com.exam.domain.vo.ValueObjects.AnswerText;
import java.util.*;

public class GradinService {

    public int calificar(List<Question> preguntas, ExamAttempt intento) {

        int score = 0;

        for (Question q : preguntas) {

            AnswerText r = intento.getRespuestas().get(q.getId());

            if (r != null && q.esCorrecta(r)) {
                score++;
            }
        }

        return score;
    }
}