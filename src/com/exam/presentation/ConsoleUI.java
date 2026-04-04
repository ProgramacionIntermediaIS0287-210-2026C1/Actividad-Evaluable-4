package com.exam.presentation;

import com.exam.ExamApplicationService;
import com.exam.domain.model.Question;
import com.exam.domain.model.QuestionTypes.*;
import com.exam.domain.vo.ValueObjects.*;

import java.util.*;

public class ConsoleUI {

    private final Scanner scanner = new Scanner(System.in);
    private final ExamApplicationService appService = new ExamApplicationService();

    public void start(){

        // crear estudiante
        StudentId studentId = new StudentId("estu1");
        var attempt = appService.starAttempt(StudentId);

        // crear pregunta manualmente 
        List<Question> questions = List.of(new SingleChoiceQuestion(new QuestionId("q1"), "¿capital de francia?", List.of("Madrid", "Paris", "Roma"), new AnswerText("Paris")),new FillBlankQuestion( new QuestionId("q3"), "La POO significa ______", new AnswerText("Programación Orientada a Objetos")),new MultipleChoiceQuestion(new QuestionId("q4"), "Seleccione lenguajes de programación", List.of("Java", "HTML", "Python", "CSS"), new AnswerText("Java,Python")));

                // Mostrar preguntas y capturar respuestas
                for (Question q : questions){
                    q.displayFormat();
                    System.out.println("tu respuest es: ");
                    String resp = scanner.nextLine();

                    appService.answerQuestion(attempt, q.getId(), new AnswerText(resp));
                    System.out.println();
                }

                Calificacion result = appService.finishAttempt(attempt, questions);

                System.out.println("Examen finalizado ");
                System.out.println("Puntaje: " + result.puntaje() + "/" + result.total());

    }
}