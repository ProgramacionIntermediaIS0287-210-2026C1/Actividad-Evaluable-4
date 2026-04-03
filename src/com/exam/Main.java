package com.exam.presentation;

import com.exam.application.*;
import com.exam.domain.service.*;
import com.exam.infrastructure.*;

public class Main {
    public static void main(String[] args){
        var repo=new InMemoryExamAttemptRepository();
        var app=new ExamApplicationService(
                new CsvQuestionBankRepository(),
                repo,
                new AttemptManager(repo),
                new GradingService());
        new ConsoleUI(app).start();
    }
}