package com.exam;

import com.exam.application.ExamApplicationService;
import com.exam.application.dto.ResultDTO;
import com.exam.domain.model.*;
import com.exam.presentation.Estudiante;

import javax.swing.*;
import java.util.*;

public class SwingUI {

    public static void main(String[] args) {

        ExamApplicationService app = new ExamApplicationService();

        String id = JOptionPane.showInputDialog("Ingrese ID:");
        String nombre = JOptionPane.showInputDialog("Ingrese nombre:");

        Estudiante estudiante = new Estudiante(id, nombre);

        List<Question> preguntas = new ArrayList<>();

        preguntas.add(new QuestionTypes.TrueFalse("1", "Java es lenguaje?", true));
        preguntas.add(new QuestionTypes.UniqueChoice(
                "2",
                "Capital de Colombia?",
                Arrays.asList("Bogotá", "Lima", "Quito"),
                "Bogotá"
        ));

        ExamAttempt intento = app.iniciarExamen(estudiante.getId());

        for (Question q : preguntas) {

            String texto = q.getTexto();

            if (q instanceof QuestionTypes.UniqueChoice) {
                texto += "\nOpciones:\n";
                for (String op : ((QuestionTypes.UniqueChoice) q).getOpciones()) {
                    texto += "- " + op + "\n";
                }
            }

            if (q instanceof QuestionTypes.TrueFalse) {
                texto += "\n(V/F)";
            }

            String resp = JOptionPane.showInputDialog(texto);
            intento.responder(q.getId(), resp);
        }

        ResultDTO resultado = app.finalizarExamen(estudiante.getId(), preguntas, intento);

        JOptionPane.showMessageDialog(null,
                "Puntaje: " + resultado.getScore() + "/" + resultado.getTotal());
    }
}