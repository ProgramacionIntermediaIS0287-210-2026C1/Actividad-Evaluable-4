package presentation;

import application.*;
import domain.model.*;
import domain.value.*;

import java.util.*;

public class ConsoleUI {

    private ExamApplicationService appService;

    public ConsoleUI(ExamApplicationService appService) {
        this.appService = appService;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        System.out.print("ID estudiante: ");
        StudentId studentId = new StudentId(sc.nextLine());

        ExamAttempt attempt = appService.iniciarExamen(studentId);

        for (Question q : attempt.getQuestions()) {
            q.displayFormat();
            String ans = sc.nextLine();

            appService.responderPregunta(
                    studentId,
                    q.getId(),
                    new AnswerText(ans)
            );
        }

        var result = appService.finalizarExamen(studentId);

        System.out.println("Resultado: " + result.puntaje() + "/" + result.total());
    }
}