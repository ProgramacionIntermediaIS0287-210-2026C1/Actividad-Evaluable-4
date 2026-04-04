package domain.repository;

import domain.model.*;
import java.util.List;

public interface CsQuestionBankRepository {
    List<Question> findAll();
}