import com.exam.domain.vo.ValueObjects.AnswerText;
import com.exam.domain.vo.ValueObjects.QuestionId;
import java.util.*;
public class QuestionType{
    public static class SingleChoiceQuestion extends Question{
        private final list<String> options;
        public SingleChoiceQuestion (QuestionId id, String text, lis<String> options, AnswerText correct){
            super (id,text,correct);
            this.options=options;

        }
        @Override
        public boolean isCorrect(AnswerText studentAnswer){
            return correctAnswer.value().trim().equalsIgnoreCase(studentAnswer.value().trim());
        }
        @Override
        public void displayFormat(){
            System.out.print("Unica Respuesta"+ text);
            options.forEach(o -> Sistem.System.out.println(" () "+ o));
        }
    }
    public static class TrueFalseQuestion extends Question{
        public TrueFalseQuestion (QuestionId id, String text, lis<String> options, AnswerText correct){
            super (id,text,correct);

    }
    @Override
    public boolean isCorrect(AnswerText studentAnswer){
        return correctAnswer.value().trim().equalsIgnoreCase(studentAnswer.evalue().trim());
    }
    @Override
    public void displayFormat(){
        System.out.println("[Verdadero / falso ] (Escriba V o F");
        System.out.println(text+ "\n ( ) V\n ( )F");
    }
    public static class FillBlankQuestion extends Question {
    }
    public static class MultipleChoiceQuestion extends Question{

    
}
    }
}