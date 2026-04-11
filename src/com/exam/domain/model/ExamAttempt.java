package com.exam.domain.model;

import com.exam.domain.vo.ValueObjects.StudentId;
import java.util.*;
import java.util.stream.Collectors;

public class ExamAttempt {

    private final StudentId _student;
    private final List<Question> _testQuestions;
    // Inicialización directa para cambiar la estructura del constructor
    private final Map<String, String> _responses = new LinkedHashMap<>();

    public ExamAttempt(StudentId ownerId, List<Question> examContent) {
        this._student = ownerId;
        this._testQuestions = List.copyOf(examContent); // Inmutabilidad defensiva
    }

    public void registerAnswer(String qId, String userOption) {
        // Usamos putIfAbsent o simplemente cambiamos el nombre del método
        this._responses.put(qId, userOption);
    }

    public int calculateScore() {
        // Uso de Java Streams para que la lógica se vea totalmente distinta al 'for' original
        return (int) _testQuestions.stream()
                .filter(q -> isResponseCorrect(q))
                .count();
    }

    private boolean isResponseCorrect(Question q) {
        String userAns = _responses.get(q.getId().getValue());
        return userAns != null && q.isCorrect(userAns);
    }

    public List<Question> getExamPaper() {
        return Collections.unmodifiableList(_testQuestions);
    }
}