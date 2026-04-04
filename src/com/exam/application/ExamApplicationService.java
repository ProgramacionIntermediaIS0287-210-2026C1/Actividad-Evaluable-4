package com.exam.application;

import java.util.List;

import com.exam.domain.model.Question;
import com.exam.domain.model.ExamAttempt;
import com.exam.domain.service.GradingService;
import com.exam.application.dtos.ResultDTO;

public class ExamApplicationService {

    private GradingService gradingService = new GradingService();

    // iniciar examen
    public ExamAttempt iniciarExamen(String studentId) {
        return new ExamAttempt(studentId);
    }

    // finalizar examen
    public ResultDTO finalizarExamen(String studentId, List<Question> preguntas, ExamAttempt intento) {

        int score = 0;

        for (Question q : preguntas) {

            // obtener respuesta del intento
            var respuesta = intento.getRespuesta(q.getId());

            // validar respuesta
            if (q.esCorrecta(respuesta)) {
                score++;
            }
        }

        int total = preguntas.size();

        // 🔥 ESTA ES LA LÍNEA QUE TE FALLABA
        ResultDTO result = new ResultDTO(score, total);

        return result;
    }
}