import java.util.List;

public class MainSwing {

    public static void main(String[] args) {

        // Repos fake (para probar)
        QuestionBankRepository questionRepo = () -> List.of(
                new TrueFalseQuestion(
                        new QuestionId("1"),
                        "Java es un lenguaje?",
                        new AnswerText("true")
                )
        );

        ExamAttemptRepository attemptRepo = new InMemoryExamAttemptRepository();

        AttemptManager attemptManager = new AttemptManager(attemptRepo);
        GradingService gradingService = new GradingService();

        ExamApplicationService appService =
                new ExamApplicationService(
                        questionRepo,
                        attemptRepo,
                        attemptManager,
                        gradingService
                );

        new SwingUI(appService).start();
    }
}