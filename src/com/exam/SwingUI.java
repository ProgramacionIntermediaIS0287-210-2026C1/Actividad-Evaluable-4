package com.exam;

import com.exam.application.*;
import com.exam.application.dto.DTOs.*;
import com.exam.domain.model.*;
import com.exam.domain.vo.ValueObjects.AnswerText;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class SwingUI extends JFrame {

    private ExamApplicationService app = new ExamApplicationService();
    private List<Question> preguntasDominio;
    private ExamAttempt intento = new ExamAttempt();

    private int score;
    private int total;

    private int index = 0;
    private JLabel lblPregunta = new JLabel();
    private JTextField txtRespuesta = new JTextField();
      
      public void ResultDTO(int score, int total) {
        this.score = score;
        this.total = total;
    }

    public int getScore() {
        return score;
    }

    public int getTotal() {
        return total;
    }


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
        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage());
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

            var result =app.finalizarExamen("estudiante1", preguntasDominio, intento);


            JOptionPane.showMessageDialog(this,
    "Resultado: " + result.getScore() + "/" + result.getTotal()
);
            System.exit(0);
        }

        mostrar();
    }
}