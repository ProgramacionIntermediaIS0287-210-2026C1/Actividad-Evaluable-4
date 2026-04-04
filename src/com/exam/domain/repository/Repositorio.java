package com.exam.repository;

import com.exam.domain.model.*;
import java.util.*;

public interface Repositorio {

    interface ExamAttemptRepository {
        Optional<ExamAttempt> findActiveByStudent(String studentId);
        void save(ExamAttempt attempt);
    }

    interface QuestionBankRepository {
        List<Question> findAll();
    }
}