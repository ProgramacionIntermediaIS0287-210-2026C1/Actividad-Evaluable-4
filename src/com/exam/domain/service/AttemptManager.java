package domain.service;

import domain.repository.*;
import domain.value.*;

public class AttemptManager {

    private InMemoryExamAttemRepository repository;

    public AttemptManager(ExamAttemptRepository repository) {
        this.repository = repository;
    }

    public void verificarIntentoActivo(StudentId studentId) {
        repository.findActiveByStudent(studentId)
                .ifPresent(a -> {
                    throw new RuntimeException("Ya existe un intento activo");
                });
    }
}