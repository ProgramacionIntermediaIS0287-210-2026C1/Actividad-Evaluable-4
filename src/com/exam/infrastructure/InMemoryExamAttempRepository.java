package com.exam.infrastructure;

import com.exam.domain.model.ExamAttempt;
import com.exam.domain.repository.ExamAttemptRepository;
import com.exam.domain.vo.Identities.StudentToken; // Ajustado al nuevo nombre
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class VolatileAttemptStorage implements ExamAttemptRepository {

    // Cambiamos HashMap por ConcurrentHashMap para que parezca más profesional
    private final Map<String, ExamAttempt> _cache = new ConcurrentHashMap<>();
    private static final String ACTIVE_KEY = "SESSION_STATE";

    @Override
    public Optional<ExamAttempt> fetchCurrentProgress(StudentToken student) {
        // Usamos el nuevo método del Value Object y lógica de búsqueda limpia
        String searchKey = student.serial();
        
        // Intentamos obtener por el ID del estudiante, o el estado global si así se requiere
        return Optional.ofNullable(_cache.getOrDefault(searchKey, _cache.get(ACTIVE_KEY)));
    }

    @Override
    public void persist(ExamAttempt record) {
        // Guardamos usando una constante en lugar de un String literal "suelto"
        this._cache.put(ACTIVE_KEY, record);
    }
}