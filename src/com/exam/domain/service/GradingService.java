package com.exam.domain.service;

import com.exam.domain.model.ExamAttempt;
import com.exam.domain.model.Question;
import com.exam.domain.vo.ValueObjects.Calificacion;
import com.exam.domain.vo.ValueObjects.QuestionId;
import com.exam.domain.vo.ValueObjects.AnswerText;

import java.util.List;
import java.util.Map;

public class GradingService {

    public Calificacion grade(List<Question> questions, ExamAttempt attempt) {

        int score = 0;
        Map<QuestionId, AnswerText> answers = attempt.getAnswers();

        for (Question q : questions) {
            AnswerText studentAnswer = answers.get(q.getId());

            if (studentAnswer != null && q.isCorrect(studentAnswer)) {
                score++;
            }
        }

        return new Calificacion(score, questions.size());
    }
}