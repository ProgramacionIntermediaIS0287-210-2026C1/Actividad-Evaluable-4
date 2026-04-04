import domain.service.*;
import java.util.*;

public class ExamApplicationService {

    private CvsQuestionBankRepository questionRepo;
    private ExamAttempt attemptRepo;
    private AttemptManager attemptManager;
    private GradingService gradingService;

    public ExamApplicationService(
            CvsQuestionBankRepository qRepo,
            ExamAttempt aRepo
    ) {
        this.questionRepo = qRepo;
        this.attemptRepo = aRepo;
        this.attemptManager = new AttemptManager (aRepo);
        this.gradingService = new GradingService();
    }

    public ExamAttempt iniciarExamen(StudentId studentId) {

        attemptManager.verificarIntentoActivo(studentId);

        List<Question> questions = que