import java.util.*;

class InMemoryExamAttemptRepository {

    private Map<String, ExamAttempt> db = new HashMap<>();

    
        }
        return Optional.empty();
    }

    public void save(ExamAttempt attempt) {
        db.put(attempt.getQuestions().toString(), attempt);
    }
}