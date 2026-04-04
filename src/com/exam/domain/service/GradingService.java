package domain.service;

public class GradingService {

    public int calificar(ExamAttempt attempt) {
        int score = 0;

        for (Question q : attempt.getQuestions()) {
            String answer = attempt.getAnswers().get(q.id);
            if (answer != null && q.isCorrect(answer)) {
                score++;
            }
        }
        return score;
    }
}