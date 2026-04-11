package com.exam.application;

import com.exam.domain.model.*;
import com.exam.domain.repository.*;
import com.exam.domain.vo.ValueObjects.StudentId;
import java.util.List;

public class EvaluationManager {

    private final QuestionBankRepository _questionData;
    private final ExamAttemptRepository _attemptData;
    private ExamAttempt activeSession;

    // Uso de nombres de parámetros más descriptivos
    public EvaluationManager(QuestionBankRepository questionSource, ExamAttemptRepository persistence) {
        this._questionData = questionSource;
        this._attemptData = persistence;
    }

    /**
     * Inicializa un nuevo proceso de evaluación para un estudiante.
     */
    public void beginTest(StudentId student) {
        var availableQuestions = _questionData.findAll();
        this.activeSession = new ExamAttempt(student, availableQuestions);
        
        // Persistencia inmediata de la sesión creada
        _attemptData.save(this.activeSession);
    }

    public List<Question> retrieveCurrentQuestions() {
        return (this.activeSession != null) ? this.activeSession.getQuestions() : List.of();
    }

    public void registerResponse(String questionId, String selectedOption) {
        if (activeSession != null) {
            activeSession.answerQuestion(questionId, selectedOption);
        }
    }

    public int closeAndGetGrade() {
        int finalScore = this.activeSession.calculateScore();
        // Opcional: podrías guardar el estado final aquí para diferenciarlo más
        _attemptData.save(this.activeSession); 
        return finalScore;
    }
}