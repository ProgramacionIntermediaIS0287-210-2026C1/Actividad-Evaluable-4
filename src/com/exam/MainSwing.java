package com.exam.presentation;

import com.exam.application.ExamApplicationService;
import com.exam.domain.service.AttemptManager;
import com.exam.domain.service.GradingService;
import com.exam.infrastructure.CsvQuestionBankRepository;
import com.exam.infrastructure.InMemoryExamAttemptRepository;

import javax.swing.SwingUtilities;

public class MainSwing {

    public static void main(String[] args) {

        var qRepo = new CsvQuestionBankRepository();
        var aRepo = new InMemoryExamAttemptRepository();
        var manager = new AttemptManager(aRepo);
        var grading = new GradingService();

        var appService = new ExamApplicationService(qRepo, aRepo, manager, grading);

        SwingUtilities.invokeLater(() -> {
            new SwingUI(appService).setVisible(true);
        });
    }
}