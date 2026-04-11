package com.exam.domain.model;

import com.exam.domain.vo.ValueObjects.StudentId;
import java.util.*;

public class ExamAttempt {

    private final StudentId studentId;
    private final List<Question> questions;
    private final Map<String,String> answers = new HashMap<>();

    public ExamAttempt(StudentId studentId, List<Question> questions){
        this.studentId = studentId;
        this.questions = questions;
    }

    public void answerQuestion(String questionId, String answer){
        answers.put(questionId, answer);
    }

    public int calculateScore(){
        int score = 0;
        for(Question q : questions){
            String ans = answers.get(q.getId().getValue());
            if(ans != null && q.isCorrect(ans)) score++;
        }
        return score;
    }

    public List<Question> getQuestions(){
        return questions;
    }
}