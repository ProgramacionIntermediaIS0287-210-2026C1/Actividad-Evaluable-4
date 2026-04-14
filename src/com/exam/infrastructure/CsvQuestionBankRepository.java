package com.exam.infrastructure;

import com.exam.domain.model.*;
import com.exam.domain.repository.QuestionBankRepository;
import com.exam.domain.vo.Identities.QRef; // Usando el nombre nuevo que definimos
import java.util.*;

public class FileBasedQuestionRepository implements QuestionBankRepository {

    /**
     * Recupera el catálogo completo de preguntas predefinidas.
     */
    @Override
    public List<Question> retrieveAllQuestions() {
        // Usamos una estructura más moderna y compacta
        return Arrays.asList(
            create("101", "¿Cuál es la capital de Colombia?", "Bogotá", QuestionTypes.OPEN_TEXT),
            create("102", "¿Cuánto es 5 + 5?", "10", QuestionTypes.OPEN_TEXT),
            create("103", "El cielo es azul (true/false)", "true", QuestionTypes.BOOLEAN_VAL)
        );
    }

    /**
     * Método auxiliar para simplificar la creación de objetos y limpiar la vista del código.
     */
    private Question create(String code, String query, String answer, QuestionTypes category) {
        return new Question(new QRef(code), query, answer, category);
    }
}