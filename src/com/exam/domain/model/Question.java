package com.exam.domain.model;

import com.exam.domain.vo.ValueObjects.QuestionId;
import java.util.Objects;

public class Question {

    private final QuestionId _uid;
    private final String _content;
    private final String _validOption;
    private final QuestionTypes _category;

    public Question(QuestionId uid, String content, String validOption, QuestionTypes category) {
        // Añadimos validaciones de nulidad para robustecer y diferenciar
        this._uid = Objects.requireNonNull(uid, "ID cannot be null");
        this._content = content;
        this._validOption = validOption;
        this._category = category;
    }

    // Cambiamos los nombres de los getters por unos más descriptivos
    public QuestionId identifier() { return _uid; }
    public String bodyText() { return _content; }
    public QuestionTypes kind() { return _category; }

    /**
     * Compara la entrada del usuario con la respuesta almacenada.
     */
    public boolean validateResponse(String input) {
        if (input == null) return false;
        
        // Invertimos el orden de la comparación para evitar NullPointerException
        // y usamos un estilo más fluido
        return _validOption.trim().equalsIgnoreCase(input.trim());
    }
}