package com.exam.presentation;

import com.exam.application.ExamApplicationService;
import com.exam.application.dto.ResultDTO;
import com.exam.domain.model.*;

import java.util.*;

public class Console {

    private Scanner sc = new Scanner(System.in);
    private ExamApplicationService app = new ExamApplicationService();

    public void run() {

        System.out.print("Ingrese ID: ");
        String id = sc.nextLine();

        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();

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
            mostrarPregunta(q);
            System.out.print("Respuesta: ");
            String resp = sc.nextLine();
            intento.responder(q.getId(), resp);
        }

        ResultDTO resultado = app.finalizarExamen(estudiante.getId(), preguntas, intento);

        System.out.println("\n=== RESULTADO ===");
        System.out.println("Puntaje: " + resultado.getScore() + "/" + resultado.getTotal());
    }

    private void mostrarPregunta(Question q) {
        System.out.println("\n" + q.getTexto());

        if (q instanceof QuestionTypes.UniqueChoice) {
            for (String op : ((QuestionTypes.UniqueChoice) q).getOpciones()) {
                System.out.println("- " + op);
            }
        }

        if (q instanceof QuestionTypes.TrueFalse) {
            System.out.println("Opciones: V / F");
        }
    }
}