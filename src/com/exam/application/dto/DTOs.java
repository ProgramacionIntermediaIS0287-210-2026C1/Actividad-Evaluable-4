import java.util.List;

public record ExamAttemptDTO(
        StudentId studentId,
        List<Question> questions
) {}
