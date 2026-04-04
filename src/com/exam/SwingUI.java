package com.exam.presentation;

import com.exam.application.*;
import com.exam.application.dto.DTOs.*;
import com.exam.domain.model.*;
import com.exam.domain.vo.ValueObjects.AnswerText;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SwingUI extends JFrame {

    private ExamApplicationService app = new ExamApplicationService();
    private List<Question> preguntasDominio;
    private ExamAttempt intento = new ExamAttempt();

    private int index = 0;
    private JLabel lblPregunta = new JLabel();
    private JTextField txtRespuesta = new JTextField();

    public SwingUI() {

        setTitle("Sistema de Examen");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton btnSiguiente = new JButton("Siguiente");

        add(lblPregunta, BorderLayout.NORTH);
        add(txtRespuesta, BorderLayout.CENTER);
        add(btnSiguiente, BorderLayout.SOUTH);

        btnSiguiente.addActionListener(e -> siguiente());

        cargar();
        mostrar();

        setVisible(true);
    }

    private void cargar() {
        try {
            preguntasDominio = app.cargarDominio("preguntas.csv");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void mostrar() {
        Question q = preguntasDominio.get(index);
        lblPregunta.setText(q.getEnunciado());
        txtRespuesta.setText("");
    }

    private void siguiente() {

        Question q = preguntasDominio.get(index);

        intento.responder(q.getId(), new AnswerText(txtRespuesta.getText()));

        index++;

        if (index >= preguntasDominio.size()) {

            intento.finalizar();

            var result = app.calificar(preguntasDominio, intento);

            JOptionPane.showMessageDialog(this,
                    "Resultado: " + result.score + "/" + result.total);

            System.exit(0);
        }

        mostrar();
    }
}