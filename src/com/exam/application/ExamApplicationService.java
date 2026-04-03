package application;

import domain.model.*;
import domain.repository.*;
import domain.service.*;
import domain.value.*;

import java.util.*;

public class ExamApplicationService {

    private QuestionBankRepository questionRepo;
    private ExamAttemptRepository attemptRepo;
    private AttemptManager attemptManager;
    private GradingService gradingService;

    public ExamApplicationService(
            QuestionBankRepository qRepo,
            ExamAttemptRepository aRepo
    ) {
        this.questionRepo = qRepo;
        this.attemptRepo = aRepo;
        this.attemptManager = new AttemptManager(aRepo);
        this.gradingService = new GradingService();
    }

    public ExamAttempt iniciarExamen(StudentId studentId) {

        attemptManager.verificarIntentoActivo(studentId);

        List<Question> questions = questionRepo.findAll();
        ExamAttempt attempt = new ExamAttempt(studentId, questions);

        attemptRepo.save(attempt);
        return attempt;
    }

    public void responderPregunta(StudentId studentId, QuestionId qId, AnswerText answer) {
        ExamAttempt attempt = attemptRepo.findActiveByStudent(studentId).orElseThrow();
        attempt.responder(qId, answer);
    }

    public Calificacion finalizarExamen(StudentId studentId) {
        ExamAttempt attempt = attemptRepo.findActiveByStudent(studentId).orElseThrow();

        Calificacion cal = gradingService.calificar(attempt);
        attempt.finalizar(cal);

        return cal;
    }
}