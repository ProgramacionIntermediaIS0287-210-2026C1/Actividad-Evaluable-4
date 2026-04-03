package com.exam.domain.service;

import com.exam.domain.model.*;
import com.exam.domain.vo.ValueObjects.*;

public class GradingService {
    public Calificacion calificar(ExamAttempt attempt){
        int score=0;
        for(Question q:attempt.getQuestions()){
            var ans=attempt.getAnswers().get(q.getId());
            if(ans!=null && q.isCorrect(ans)) score++;
        }
        return new Calificacion(score,attempt.getQuestions().size());
    }
}