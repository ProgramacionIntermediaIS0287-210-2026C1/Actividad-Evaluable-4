package com.exam.presentation;

import com.exam.application.*;
import com.exam.domain.service.*;
import com.exam.infrastructure.*;
import javax.swing.SwingUtilities;

public class MainSwing {
    public static void main(String[] args){
        var repo=new InMemoryExamAttemptRepository();
        var app=new ExamApplicationService(
                new CsvQuestionBankRepository(),
                repo,
                new AttemptManager(repo),
                new GradingService());
        SwingUtilities.invokeLater(() -> new SwingUI(app).setVisible(true));
    }
}