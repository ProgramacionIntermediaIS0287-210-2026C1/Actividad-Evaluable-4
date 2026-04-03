package com.exam.infrastructure;

import com.exam.domain.repository.repositories.*;
import com.exam.domain.model.*;
import com.exam.domain.vo.ValueObjects.*;
import java.util.*;

public class InMemoryExamAttemptRepository implements ExamAttemptRepository {

    private final Map<String, ExamAttempt> db = new HashMap<>();

    @Override
    public Optional<ExamAttempt> findActiveByStudent(StudentId studentId) {
        return Optional.ofNullable(db.get(studentId.value()));
    }

    @Override
    public void save(ExamAttempt attempt) {
        db.put(attempt.getStudentId().value(), attempt);
    }
}