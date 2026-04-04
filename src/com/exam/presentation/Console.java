package com.exam.presentation;

import java.util.List;
import java.util.Scanner;

import com.exam.application.ExamApplicationService;
import com.exam.domain.model.ExamAttempt;
import com.exam.domain.model.Question;
import com.exam.domain.model.QuestionTypes;
import com.exam.domain.vo.ValueObjects.AnswerText;

public class Console {

    private ExamApplicationService app;
    private Scanner sc;

    public Console() {
        app = new ExamApplicationService();
        sc = new Scanner(System.in);
    }

    public void iniciar() {

        try {

            System.out.println("=== SISTEMA DE EXÁMENES ===");

            // Cargar preguntas
            List<Question> preguntas = app.cargarDominio("preguntas.csv");

            // Pedir estudiante
            System.out.print("Ingrese ID del estudiante: ");
            String id = sc.nextLine();

            System.out.print("Ingrese nombre del estudiante: ");
            String nombre = sc.nextLine();

// Crear objeto estudiante
            com.exam.Estudiante estudiante = new com.exam.Estudiante(id, nombre);

// Iniciar intento con el ID
            ExamAttempt intento = app.iniciarExamen(estudiante.getId());
        

            // Iterar preguntas
            for (Question q : preguntas) {

                mostrarPregunta(q);

                System.out.print("Respuesta: ");
                String resp = sc.nextLine();

                intento.responder(q.getId(), new AnswerText(resp));
            }

            // Finalizar examen
            var resultado = app.finalizarExamen(estudiante.getId(), preguntas, intento);

            System.out.println("\n=== RESULTADO ===");
            System.out.println("Puntaje: " + resultado.score + "/" + resultado.total);

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    // Mostrar pregunta según tipo
    /**
     * @param q
     */
    private void mostrarPregunta(Question q) {

        System.out.println("\n" + q.getEnunciado());

       if (q instanceof QuestionTypes.UniqueChoice) {

    QuestionTypes.UniqueChoice uc =
            (QuestionTypes.UniqueChoice) q;

    for (String op : uc.getOpciones()) {
        System.out.println("- " + op);
    }
}
            
        

        if (q instanceof QuestionTypes.TrueFalse) {
            System.out.println("Opciones: V / F");
        }
    }
}