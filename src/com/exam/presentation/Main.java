package com.exam.presentation;

import com.exam.application.*;
import com.exam.domain.model.*;
import com.exam.domain.vo.ValueObjects.AnswerText;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);
            ExamApplicationService app = new ExamApplicationService();

            List<Question> preguntas = app.cargarDominio("preguntas.csv");

            System.out.print("ID estudiante: ");
            String student = sc.nextLine();

            // 🔥 ahora usa AttemptManager
            ExamAttempt intento = app.iniciarExamen(student);

            for (Question q : preguntas) {

                System.out.println("\n" + q.getEnunciado());

                if (q instanceof QuestionTypes.UniqueChoice uc) {
                    uc.getOpciones().forEach(op -> System.out.println("- " + op));
                }

                System.out.print("Respuesta: ");
                String resp = sc.nextLine();

                intento.responder(q.getId(), new AnswerText(resp));
            }

            var result = app.finalizarExamen(student, preguntas, intento);

            System.out.println("\nResultado: " + result.score + "/" + result.total);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}