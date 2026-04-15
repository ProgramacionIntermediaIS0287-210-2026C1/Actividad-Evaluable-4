package com.exam.domain.repository;
import com.exam.domain.model.Question;
import java.util.List;

public interface QuestionBankRepository {
    List<Question> findAll();
}