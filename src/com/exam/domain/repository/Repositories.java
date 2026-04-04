package com.exam.domain.repository;

import com.exam.domain.model.ExamAttempt;
import java.util.Optional;

public class Repositories {

    // Puerto (interfaz)
    public interface ExamAttemptRepository {

        void save(String studentId, ExamAttempt attempt);

        Optional<ExamAttempt> findByStudent(String studentId);

        boolean existsActiveAttempt(String studentId);

        void remove(String studentId);
    }
}