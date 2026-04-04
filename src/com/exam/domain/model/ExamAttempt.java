package com.exam.domain.model;

import com.exam.domain.vo.ValueObjects.AnswerText;
import com.exam.domain.vo.ValueObjects.QuestionId;
import com.exam.domain.vo.ValueObjects.StudentId;

import java.util.HashMap;
import java.util.Map;

public class ExamAttempt {

    private final studentId studentId;
    private final Map<QuestionId, AnswerText> ansMap;
    private boolean finished;

    public ExamAttempt(StudentId studentId){
        this.studentId = studentId;
        this.ansMap = new HashMap<>();
        this.finished = false;
    }

    public void answerQuestion(QuestionId questionId, AnswerText answer){
        if (finished) {
            throw new IllegalStateException("El intento ya esta finalixado ");
        }
        answer.putt(questionId, answer);
    }

    public void finish(){
        this.finished = true;
    }

    public boolean isFinished(){
        return finished;
    }

    public Map<QuestionId, AnswerText> getAnswers(){
        return answers;
    }

    public StudentId getStudentId(){
        return studentId;
    }

}