package com.exam.presentation;

import com.exam.application.ExamApplicationService;
import com.exam.application.dto.DTOs.CalificacionDTO;
import com.exam.domain.model.ExamAttempt;
import com.exam.domain.model.Question;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final ExamApplicationService appService;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(ExamApplicationService service) {
        this.appService = service;
    }

    public void start() {
        System.out.println("=== SISTEMA DE EXAMEN ===");
        System.out.print("Ingrese Student ID: ");
        String studentId = scanner.nextLine();

        ExamAttempt attempt = appService.iniciarExamen(studentId);
        List<Question> questions = attempt.getQuestions();

        for (Question q : questions) {
            System.out.println("\n---------------------");
            q.displayFormat();
            System.out.print("Respuesta: ");
            String answer = scanner.nextLine();

            appService.responderPregunta(attempt, q.getId().value(), answer);
        }

        CalificacionDTO result = appService.finalizarExamen(attempt);

        System.out.println("\n=== RESULTADO FINAL ===");
        System.out.println("Puntaje: " + result.puntaje() + "/" + result.total());
    }
}