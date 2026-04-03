import java.util.*;

class InMemoryExamAttemptRepository {

    private Map<String, ExamAttempt> db = new HashMap<>();

    public Optional<ExamAttempt> findActiveByStudent(String studentId) {
        ExamAttempt attempt = db.get(studentId);
        if (attempt != null && !attempt.estaFinalizado()) {
            return Optional.of(attempt);
        }
        return Optional.empty();
    }

    public void save(ExamAttempt attempt) {
        db.put(attempt.getQuestions().toString(), attempt);
    }
}