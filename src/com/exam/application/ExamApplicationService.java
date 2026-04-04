package com.exam.application;

import com.exam.domain.model.*;
import com.exam.domain.service.*;
import com.exam.infrastructure.*;
import com.exam.application.dto.DTOs.*;

import java.util.*;

public class ExamApplicationService {

    private CsvQuestionBankRepository csvRepo = new CsvQuestionBankRepository();
    private InMemoryExamAttemptRepository attemptRepo = new InMemoryExamAttemptRepository();
    private AttemptManager attemptManager = new AttemptManager(attemptRepo);
    private GradinService grading = new GradinService();

    public List<Question> cargarDominio(String path) throws Exception {
        return csvRepo.load(path);
    }

    // Iniciar examen
    public ExamAttempt iniciarExamen(String studentId) {
        return attemptManager.iniciarIntento(studentId);
    }

    // Finalizar examen
    public ResultDTO finalizarExamen(String studentId, List<Question> preguntas, ExamAttempt intento) {

        intento.finalizar();

        int score = grading.calificar(preguntas, intento);

        attemptManager.finalizarIntento(studentId);

        return new ResultDTO(score, preguntas.size());
    }
}