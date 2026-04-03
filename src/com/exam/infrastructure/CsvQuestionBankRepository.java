package com.exam.infrastructure;

import com.exam.domain.repository.repositories.*;
import com.exam.domain.model.*;
import com.exam.domain.model.QuestionTypes.*;
import com.exam.domain.vo.ValueObjects.*;

import java.util.*;

public class CsvQuestionBankRepository implements QuestionBankRepository {

    @Override
    public List<Question> findAll() {
        return List.of(
            new TrueFalseQuestion(new QuestionId("1"), "Java es tipado fuerte", new AnswerText("true")),
            new FillBlankQuestion(new QuestionId("2"), "Capital de Francia", new AnswerText("paris")),
            new SingleChoiceQuestion(
                    new QuestionId("3"),
                    "2+2=?",
                    List.of("3","4","5"),
                    new AnswerText("4"))
        );
    }
}