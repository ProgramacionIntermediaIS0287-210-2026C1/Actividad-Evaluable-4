package com.exam.application;

import com.exam.domain.model.*;
import com.exam.domain.repository.*;
import com.exam.domain.vo.ValueObjects.StudentId;
import java.util.List;

public class ExamAplicationService {

    private final QuestionBankRepository questionRepo;
    private final ExamAttemptRepository attemptRepo;
    private ExamAttempt currentAttempt;

    public ExamService(QuestionBankRepository q, ExamAttemptRepository a){
        this.questionRepo = q;
        this.attemptRepo = a;
    }

    public void startExam(StudentId id){
        List<Question> questions = questionRepo.findAll();
        currentAttempt = new ExamAttempt(id, questions);
        attemptRepo.save(currentAttempt);
    }

    public List<Question> getQuestions(){
        return currentAttempt.getQuestions();
    }

    public void answerQuestion(String qId, String answer){
        currentAttempt.answerQuestion(qId, answer);
    }

    public int finishExam(){
        return currentAttempt.calculateScore();
    }
}