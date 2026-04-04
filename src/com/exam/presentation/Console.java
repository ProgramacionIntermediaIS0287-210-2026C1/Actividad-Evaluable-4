package com.exam.presentation;
import java.util.Scanner;
import com.exam.application.ExamApplicationService;
import com.exam.application.dto.DTOs.ResultDTO;
import com.exam.domain.model.*;
import com.exam.domain.vo.ValueObjects.AnswerText;
import com.exam.presentation.Estudiante;


import java.util.*;

public class Console {

    private Scanner sc = new Scanner(System.in);
    private ExamApplicationService app = new ExamApplicationService();
    
public static class Main {

public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== SISTEMA DE EXÁMENES ===");
            System.out.println("1. Ejecutar en consola");
            System.out.println("2. Ejecutar en Swing (Interfaz gráfica)");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int op = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            if (op == 1) {
                System.out.println("Iniciando consola...");
                new Console().run();
            } 
            else if (op == 2) {
                System.out.println("Swing no disponible en Codespaces");
            } 
            else if (op == 3) {
                System.exit(0);
            }
        }
    }
}

 public void run() {

        try {
            
            List<Question> preguntas = app.cargarDominio("preguntas.csv");

            System.out.print("Ingrese ID del estudiante: ");
            String id = sc.nextLine();

            System.out.print("Ingrese nombre del estudiante: ");
            String nombre = sc.nextLine();

            Estudiante estudiante = new Estudiante(id, nombre);

            // iniciar intento
            ExamAttempt intento = app.iniciarExamen(estudiante.getId());

            // recorrer preguntas
            for (Question q : preguntas) {

                mostrarPregunta(q);

                System.out.print("Respuesta: ");
                String resp = sc.nextLine();

                intento.responder(q.getId(), new AnswerText(resp));
            }

            // finalizar examen
            var resultado = app.finalizarExamen(estudiante.getId(), preguntas, intento);

            System.out.println("\n=== RESULTADO ===");
            System.out.println("Puntaje: " + ((ResultDTO) resultado).getScore() + "/" + ((ResultDTO) resultado).getTotal());

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void mostrarPregunta(Question q) {

        System.out.println("\n" + q.getTexto());

        if (q instanceof QuestionTypes.UniqueChoice) {
            QuestionTypes.UniqueChoice uc = (QuestionTypes.UniqueChoice) q;

            for (String op : uc.getOpciones()) {
                System.out.println("- " + op);
            }
        }

        if (q instanceof QuestionTypes.TrueFalse) {
            System.out.println("Opciones: V / F");
        }
    }

    public void iniciar() {
        
        throw new UnsupportedOperationException("Unimplemented method 'iniciar'");
    }
}