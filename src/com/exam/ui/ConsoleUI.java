package com.exam.ui;

import com.exam.application.ExamService;
import com.exam.domain.model.Question;
import com.exam.domain.vo.ValueObjects.StudentId;
import java.util.*;

public class ConsoleUI {

    private final ExamService service;
    private final Scanner sc=new Scanner(System.in);

    public ConsoleUI(ExamService s){ service=s; }

    public void start(){
        System.out.println("ID estudiante:");
        StudentId id=new StudentId(sc.nextLine());
        service.startExam(id);

        for(Question q:service.getQuestions()){
            System.out.println(q.getText());
            String ans=sc.nextLine();
            service.answerQuestion(q.getId().getValue(),ans);
        }

        System.out.println("Puntaje: "+service.finishExam());
    }
}