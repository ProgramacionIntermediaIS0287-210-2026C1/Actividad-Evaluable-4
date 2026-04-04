package com.exam.application;

import com.exam.application.dto.ResultDTO;
import com.exam.domain.model.Question;
import com.exam.domain.model.ExamAttempt;
import com.exam.domain.service.GradingService;

import java.util.List;

public class ExamApplicationService {

    private GradingService gradingService = new GradingService();

    public ExamAttempt iniciarExamen(String studentId) {
        return new ExamAttempt(studentId);
    }

    public ResultDTO finalizarExamen(String studentId, List<Question> preguntas, ExamAttempt intento) {
        return gradingService.calificar(preguntas, intento);
    }
}