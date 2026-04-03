package com.exam.infrastructure;

import com.exam.domain.model.*;
import com.exam.domain.repository.QuestionBankRepository;
import com.exam.domain.vo.ValueObjects.QuestionId;
import java.util.*;

public class CsvQuestionBankRepository implements QuestionBankRepository {

    public List<Question> findAll(){
        List<Question> list = new ArrayList<>();

        list.add(new Question(new QuestionId("1"), "Capital de Colombia", "Bogotá", QuestionTypes.SHORT_ANSWER));
        list.add(new Question(new QuestionId("2"), "5 + 5 = ?", "10", QuestionTypes.SHORT_ANSWER));
        list.add(new Question(new QuestionId("3"), "El cielo es azul (true/false)", "true", QuestionTypes.TRUE_FALSE));

        return list;
    }
}