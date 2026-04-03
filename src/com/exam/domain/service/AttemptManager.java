package com.exam.domain.service;

import com.exam.domain.repository.ExamAttemptRepository;
import com.exam.domain.vo.ValueObjects.StudentId;

public class AttemptManager {
    private final ExamAttemptRepository repo;
    public AttemptManager(ExamAttemptRepository repo){ this.repo=repo; }
    public void verificarIntentoActivo(StudentId id){
        if(repo.findActiveByStudent(id).isPresent())
            throw new IllegalStateException("Intento activo existente");
    }
}