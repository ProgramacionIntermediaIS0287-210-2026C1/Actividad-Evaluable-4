package com.exam.domain.repository;
import com.exam.domain.model.ExamAttempt;
import com.exam.domain.vo.ValueObjects.StudentId;
import java.util.Optional;

public interface ExamAttemptRepository {
    Optional<ExamAttempt> findActiveByStudent(StudentId studentId);
    void save(ExamAttempt attempt);
}