package com.exam.application;

import com.exam.domain.model.*;
import com.exam.domain.service.GradingService;
import com.exam.domain.vo.ValueObjects.*;

import java.util.List;

public class ExamApplicationService {

    private final GradingService gradingService;

    public ExamApplicationService(){
        this.gradingService = new GradingService();
    }

    // inciar intento
    public ExamAttempt starAttempt(StudentId studentId) {
        return new ExamAttempt(studentId);
    }

    // responder pregunta 
    public void answerQuestion(ExamAttempt attempt, QuestionId questionId, AnswerText answer){
        attempt.answerQuestion(questionId, answer);
    }

    // finalizar y calificar
    public Calificacion finishAttempt(ExamAttempt attempt, List<Question> questions){
        attempt.finish();
        return gradingService.grade(questions, attempt);
    }
}