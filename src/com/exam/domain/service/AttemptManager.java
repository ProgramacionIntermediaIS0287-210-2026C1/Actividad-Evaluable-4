package com.exam.domain.service;

import com.exam.domain.model.ExamAttempt;
import com.exam.domain.repository.Repositories.ExamAttemptRepository;

public class AttemptManager {

    private ExamAttemptRepository repo;

    public AttemptManager(ExamAttemptRepository repo) {
        this.repo = repo;
    }

    public ExamAttempt iniciarIntento(String studentId) {

        if (repo.existsActiveAttempt(studentId)) {
            throw new RuntimeException("Ya tiene intento activo");
        }

        ExamAttempt intento = new ExamAttempt();
        repo.save(studentId, intento);

        return intento;
    }

    public void finalizarIntento(String studentId) {
        repo.remove(studentId);
    }
}