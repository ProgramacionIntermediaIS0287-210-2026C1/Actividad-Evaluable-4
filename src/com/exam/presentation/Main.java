import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Crear preguntas
        List<Question> questions = new ArrayList<>();
        questions.add(new TrueFalseQuestion("1", "Java es orientado a objetos", "true"));
        questions.add(new SingleChoiceQuestion(
                "2",
                "Capital de Francia",
                "Paris",
                List.of("Madrid", "Berlin", "Paris", "Roma")
        ));

        ExamApplicationService app = new ExamApplicationService();

        System.out.print("Ingrese su ID: ");
        String studentId = scanner.nextLine();

        ExamAttempt attempt = app.iniciarExamen(studentId, questions);

        for (Question q : attempt.getQuestions()) {
            q.displayFormat();
            String answer = scanner.nextLine();
            app.responderPregunta(studentId, q.id, answer);
        }

        int score = app.finalizarExamen(studentId);

        System.out.println("Resultado: " + score + "/" + questions.size());
    }
}