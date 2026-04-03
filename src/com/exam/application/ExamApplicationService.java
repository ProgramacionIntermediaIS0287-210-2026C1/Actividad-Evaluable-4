package com.exam.application;

import com.exam.domain.model.*;
import com.exam.domain.repository.*;
import com.exam.domain.service.*;
import com.exam.domain.vo.ValueObjects.*;
import com.exam.application.dto.DTOs.CalificacionDTO;
import java.util.List;

public class ExamApplicationService {

    private final QuestionBankRepository qRepo;
    private final ExamAttemptRepository aRepo;
    private final AttemptManager manager;
    private final GradingService grading;

    public ExamApplicationService(QuestionBankRepository q,ExamAttemptRepository a,AttemptManager m,GradingService g){
        qRepo=q; aRepo=a; manager=m; grading=g;
    }

    public ExamAttempt iniciarExamen(String student){
        StudentId id=new StudentId(student);
        manager.verificarIntentoActivo(id);
        ExamAttempt attempt=new ExamAttempt(id,qRepo.findAll());
        aRepo.save(attempt); return attempt;
    }

    public void responderPregunta(ExamAttempt attempt,String qId,String ans){
        attempt.responder(new QuestionId(qId),new AnswerText(ans));
    }

    public CalificacionDTO finalizarExamen(ExamAttempt attempt){
        var cal=grading.calificar(attempt);
        attempt.finalizar(cal); aRepo.save(attempt);
        return new CalificacionDTO(cal.puntaje(),cal.total());
    }
}