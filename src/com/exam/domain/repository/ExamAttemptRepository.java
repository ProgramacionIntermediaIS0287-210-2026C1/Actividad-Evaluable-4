package com.exam.domain.repository;

import com.exam.domain.model.ExamAttempt;
import com.exam.domain.vo.ValueObjects.StudentId;
import java.util.Optional;

/**
 * Contrato para la gestión de persistencia de intentos de evaluación.
 */
public interface ExamAttemptRepository {

    /**
     * Recupera el progreso actual de un estudiante si existe.
     
    Optional<ExamAttempt> fetchCurrentProgress(StudentId owner);

    /**
     * Almacena o actualiza el estado de un intento en la base de datos.
     */
    void persist(ExamAttempt record);
}