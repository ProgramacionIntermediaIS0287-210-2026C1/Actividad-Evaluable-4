package com.exam.domain.model;

import com.exam.domain.vo.ValueObjects.*;
import java.util.*;

public class ExamAttempt {

    private final StudentId studentId;
    private final List<Question> questions;
    private final Map<QuestionId,AnswerText> answers=new HashMap<>();
    private boolean finished=false;
    private Calificacion result;

    public ExamAttempt(StudentId studentId,List<Question> questions){
        this.studentId=studentId; this.questions=questions;
    }

    public void responder(QuestionId qId,AnswerText ans){
        if(finished) throw new IllegalStateException("Examen finalizado");
        answers.put(qId,ans);
    }

    public void finalizar(Calificacion cal){ finished=true; result=cal; }

    public List<Question> getQuestions(){ return questions; }
    public Map<QuestionId,AnswerText> getAnswers(){ return answers; }
    public StudentId getStudentId(){ return studentId; }
}