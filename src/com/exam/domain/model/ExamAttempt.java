import java.time.LocalDateTime;
import java.util.Map;

public class ExamAttempt {

    private final ExamId examId;
    private final StudentId studentId;
    private final localDateTime startTime;
    private LocalDateTime endTime;

    private final Map<QuestionId, AnswerText> respuesta = new HashMap<>();

    public ExamAttempt (ExamtId examId, StudentId studentId){
        this.examId = examId;
        this.studentId = studentId;
        this.startTime = LocalDateTime.now();
    }

    public void responder (QuestionId questionId, AnswerText respuesta){
        if (estaFinalizado()) {
            throw new IllegalStateException("El examen ya fue finalizado");

        }
        respuesta.put(questionId, respuesta);
    }

    public void finalizar(){
        this.endTime = LocalDateTime.now();
    }

    public boolean estaFinalizado(){
        return endTime != null;
    }

    public Map<QuestionId, AnswerText> getRespuestas(){
        return respuestas;
    }

    public ExamId getExamId(){
        return examId;
    }

    public StudentId getStudentId(){
        return studentId;
    }
}