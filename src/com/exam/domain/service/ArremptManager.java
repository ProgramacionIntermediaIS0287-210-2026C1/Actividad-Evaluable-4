package com.exam.domain.service;

import com.exam.domain.model.ExamAttempt;
import com.exam.domain.repository.repositories.ExamAttemptRepository;
import com.exam.domain.vo.ValueObjects.StudentId;

public class AttemptManager {

    private final ExamAttemptRepository repo;

    public AttemptManager(ExamAttemptRepository repo) {
        this.repo = repo;
    }

    public void verificarIntentoActivo(StudentId studentId) {
        if (repo.findActiveByStudent(studentId).isPresent()) {
            throw new IllegalStateException("El estudiante ya tiene un intento activo");
        }
    }
}