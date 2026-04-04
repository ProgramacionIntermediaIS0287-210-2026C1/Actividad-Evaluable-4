
import com.exam.domain.model.Question;
import java.util.List;

public class DTOs {

    private String studentId;
    private List<Question> questions;

    public DTOs(String studentId, List<Question> questions) {
        this.studentId = studentId;
        this.questions = questions;
    }

    public String getStudentId() {
        return studentId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return "ExamAttemptDTO{" +
                "studentId='" + studentId + '\'' +
                ", questions=" + questions.size() +
                '}';
    }
}
