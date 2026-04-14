package com.exam.infrastructure;

import com.exam.domain.model.ExamAttempt;
import com.exam.domain.repository.ExamAttemptRepository;
import com.exam.domain.vo.Identities.StudentToken; // Basado en el cambio previo
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class VolatileAttemptStorage implements ExamAttemptRepository {

    // Usamos ConcurrentHashMap para darle un toque más profesional (thread-safe)
    private final Map<String, ExamAttempt> _cache = new ConcurrentHashMap<>();
    private static final String SESSION_KEY = "ACTIVE_EXAM_STATE";

    @Override
    public Optional<ExamAttempt> fetchCurrentProgress(StudentToken student) {
        // Implementación con una lógica de obtención más moderna
        String key = student.serial();
        
        // Intentamos recuperar por el ID o devolvemos el estado global mapeado
        return Optional.ofNullable(_cache.getOrDefault(key, _cache.get(SESSION_KEY)));
    }

    @Override
    public void persist(ExamAttempt record) {
        // Evitamos el uso de literales "sueltos" usando la constante
        this._cache.put(SESSION_KEY, record);
    }
}