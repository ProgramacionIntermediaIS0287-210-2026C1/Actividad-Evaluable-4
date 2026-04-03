package com.exam.presentation;

import com.exam.application.ExamApplicationService;
import com.exam.application.dto.DTOs.CalificacionDTO;
import com.exam.domain.model.ExamAttempt;
import com.exam.domain.model.Question;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingUI extends JFrame {

    private final ExamApplicationService appService;
    private ExamAttempt attempt;
    private List<Question> questions;
    private int currentIndex = 0;

    private JLabel questionLabel = new JLabel("");
    private JTextField answerField = new JTextField(20);
    private JButton nextButton = new JButton("Responder");

    public SwingUI(ExamApplicationService service) {
        this.appService = service;

        setTitle("Sistema de Examen");
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,1));
        center.add(questionLabel);
        center.add(answerField);
        center.add(nextButton);

        add(center, BorderLayout.CENTER);

        iniciarExamen();
        mostrarPregunta();

        nextButton.addActionListener(e -> responderPregunta());
    }

    private void iniciarExamen() {
        String studentId = JOptionPane.showInputDialog(this, "Ingrese Student ID:");
        attempt = appService.iniciarExamen(studentId);
        questions = attempt.getQuestions();
    }

    private void mostrarPregunta() {
        if (currentIndex < questions.size()) {
            Question q = questions.get(currentIndex);
            questionLabel.setText("Pregunta " + (currentIndex+1) + ": " + q.getText());
            answerField.setText("");
        } else {
            finalizarExamen();
        }
    }

    private void responderPregunta() {
        String respuesta = answerField.getText();
        Question q = questions.get(currentIndex);

        appService.responderPregunta(attempt, q.getId().value(), respuesta);
        currentIndex++;
        mostrarPregunta();
    }

    private void finalizarExamen() {
        CalificacionDTO result = appService.finalizarExamen(attempt);
        JOptionPane.showMessageDialog(this,
                "Resultado final: " + result.puntaje() + "/" + result.total());

        System.exit(0);
    }
}