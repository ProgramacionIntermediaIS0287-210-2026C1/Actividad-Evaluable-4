import java.util.List;

public class MainSwing {

    public static void main(String[] args) {

        // Repos fake (para probar)
        CsvQuestionBankRepository questionRepo = () -> List.of(
                new TrueFalseQuestion(
                        new Question("1"),
                        "Java es un lenguaje?",
                        new AnswerText("true")
                )
        );

        ExamAttempt attemptRepo = new InMemoryExamAttemRepository();

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