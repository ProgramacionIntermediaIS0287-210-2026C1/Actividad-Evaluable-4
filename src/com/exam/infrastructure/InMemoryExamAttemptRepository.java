package com.exam.infrastructure;

import com.exam.domain.model.ExamAttempt;
import com.exam.domain.repository.Repositories.ExamAttemptRepository;

import java.util.*;

public class InMemoryExamAttemptRepository implements ExamAttemptRepository {

    private Map<String, ExamAttempt> data = new HashMap<>();

    @Override
    public void save(String studentId, ExamAttempt attempt) {
        data.put(studentId, attempt);
    }

    @Override
    public Optional<ExamAttempt> findByStudent(String studentId) {
        return Optional.ofNullable(data.get(studentId));
    }

    @Override
    public boolean existsActiveAttempt(String studentId) {
        return data.containsKey(studentId);
    }

    @Override
    public void remove(String studentId) {
        data.remove(studentId);
    }
}
