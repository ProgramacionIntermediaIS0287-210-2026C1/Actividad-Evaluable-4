package domain.repository;

import domain.model.*;
import java.util.List;

public interface QuestionBankRepository {
    List<Question> findAll();
}