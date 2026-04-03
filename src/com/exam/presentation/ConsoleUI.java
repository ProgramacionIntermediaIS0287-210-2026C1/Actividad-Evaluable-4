package com.exam.presentation;

import com.exam.application.ExamApplicationService;
import java.util.Scanner;

public class ConsoleUI {
    private final ExamApplicationService app;
    public ConsoleUI(ExamApplicationService app){ this.app=app; }

    public void start(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Student ID: ");
        var attempt=app.iniciarExamen(sc.nextLine());

        attempt.getQuestions().forEach(q->{
            q.displayFormat();
            System.out.print("Respuesta: ");
            app.responderPregunta(attempt,q.getId().value(),sc.nextLine());
        });

        var res=app.finalizarExamen(attempt);
        System.out.println("Resultado: "+res.puntaje()+"/"+res.total());
    }
}