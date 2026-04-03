package com.exam.application;

import com.exam.domain.model.*;
import com.exam.domain.repository.repositories.*;
import com.exam.domain.service.*;
import com.exam.domain.vo.ValueObjects.*;
import com.exam.application.dto.DTOs.*;

import java.util.*;

public class ExamApplicationService {

    private final QuestionBankRepository questionRepo;
    private final ExamAttemptRepository attemptRepo;
    private final AttemptManager attemptManager;
    private final GradingService gradingService;

    public ExamApplicationService(
            QuestionBankRepository qRepo,
            ExamAttemptRepository aRepo,
            AttemptManager manager,
            GradingService grading) {

        this.questionRepo = qRepo;
        this.attemptRepo = aRepo;
        this.attemptManager = manager;
        this.gradingService = grading;
    }

    public ExamAttempt iniciarExamen(String student) {
        StudentId id = new StudentId(student);
        attemptManager.verificarIntentoActivo(id);
        List<Question> questions = questionRepo.findAll();
        ExamAttempt attempt = new ExamAttempt(id, questions);
        attemptRepo.save(attempt);
        return attempt;
    }

    public void responderPregunta(ExamAttempt attempt, String qId, String answer) {
        attempt.responder(new QuestionId(qId), new AnswerText(answer));
    }

    public CalificacionDTO finalizarExamen(ExamAttempt attempt) {
        Calificacion cal = gradingService.calificar(attempt);
        attempt.finalizar(cal);
        attemptRepo.save(attempt);
        return new CalificacionDTO(cal.puntaje(), cal.total());
    }
}