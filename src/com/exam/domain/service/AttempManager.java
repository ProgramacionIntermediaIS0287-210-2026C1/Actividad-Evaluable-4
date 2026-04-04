package com.exam.domain.service;

import com.exam.infrastructure.InMemoryExamAttemptRepository;
import com.exam.domain.model.ExamAttempt;

public class AttemptManager {

    private InMemoryExamAttemptRepository repo;

    public AttemptManager(InMemoryExamAttemptRepository repo) {
        this.repo = repo;
    }

    // Iniciar intento (valida regla de negocio)
    public ExamAttempt iniciarIntento(String studentId) {

        if (repo.existsActiveAttempt(studentId)) {
            throw new RuntimeException("El estudiante ya tiene un intento activo");
        }

        ExamAttempt intento = new ExamAttempt();
        repo.save(studentId, intento);

        return intento;
    }

    // Finalizar intento
    public void finalizarIntento(String studentId) {

        repo.remove(studentId);
    }
}