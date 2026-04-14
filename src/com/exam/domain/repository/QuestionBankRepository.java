package com.exam.domain.repository;

import com.exam.domain.model.Question;
import java.util.List;

/**
 * Interfaz para el acceso a la fuente de datos de reactivos.
 */
public interface QuestionBankRepository {

    /**
     * Obtiene la colección completa de preguntas disponibles en el banco.
     */
    List<Question> retrieveAllQuestions();
}