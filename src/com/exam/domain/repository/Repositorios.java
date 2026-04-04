import java.util.Optional;

public interface ExamAttemptRepository {
    Optional<ExamAttempt> findActiveByStudent(StudentId studentId);
    void save(ExamAttempt attempt);
}