package com.exam.infrastructure;

import com.exam.domain.model.ExamAttempt;
import com.exam.domain.repository.ExamAttemptRepository;
import com.exam.domain.vo.ValueObjects.StudentId;
import java.util.*;

public class InMemoryExamAttemptRepository implements ExamAttemptRepository {

    private final Map<String,ExamAttempt> db=new HashMap<>();

    public Optional<ExamAttempt> findActiveByStudent(StudentId id){
        return Optional.ofNullable(db.get(id.getValue()));
    }

    public void save(ExamAttempt attempt){
        db.put("current",attempt);
    }
}