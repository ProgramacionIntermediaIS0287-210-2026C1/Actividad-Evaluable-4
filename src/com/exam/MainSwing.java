package com.exam;

import com.exam.application.ExamService;
import com.exam.infrastructure.CsvQuestionBankRepository;
import com.exam.infrastructure.InMemoryExamAttemptRepository;
import com.exam.ui.SwingUI;

public class MainSwing {

    public static void main(String[] args) {
        ExamService service = new ExamService(
                new CsvQuestionBankRepository(),
                new InMemoryExamAttemptRepository()
        );
        new SwingUI(service);
    }
}