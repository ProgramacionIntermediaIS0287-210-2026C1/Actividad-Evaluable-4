package domain.service;

import domain.model.*;
import domain.value.*;

public class GradinService {

    public Calificacion calificar(ExamAttempt attempt) {
        int correct = 0;

        for (Question q : attempt.getQuestions()) {
            AnswerText ans = attempt.getAnswers().get(q.getId());

            if (ans != null && q.isCorrect(ans)) {
                correct++;
            }
        }

        return new Calificacion(correct, attempt.getQuestions().size());
    }
}