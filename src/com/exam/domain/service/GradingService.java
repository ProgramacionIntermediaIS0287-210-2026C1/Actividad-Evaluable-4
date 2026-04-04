package domain.service;

import java.util.List;

public class GradingService {

    public int calificar(ExamAttempt exam, List<String> respuestas) {
        int score = 0;

        for (int i = 0; i < exam.getPreguntas().size(); i++) {
            if (exam.getPreguntas().get(i).esCorrecta(respuestas.get(i))) {
                score++;
            }
        }

        return score;
    }
}