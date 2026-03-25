import  src.com.exam.domain.vo.ValueObjects.AnswerText;
import  src.com.exam.domain.vo.ValueObjects.QuestionId;
import java.util.*;

public class QuestionTypes{

    public static class SingleChoiceQuestion extends Question{
        private final  List<String> options;

        public SingleChoiceQuestion(QuestionId id, String text, List<String> options, AnswerText correct) {
            super(id, text, correct);
            this.options = options;
        }

        @Override
        public boolean isCorrect(AnswerText studentAnswer) {
            return correctAnswer.value().trim().equalsIgnoreCase(studentAnswer.value().trim());
        }

         @Override
        public void displayFormat() {
            System.out.println("[Única respuesta]" + text);
            options.forEach(o -> System.out.println(" ( ) " + o));
        }
    }

    public static class TrueFalseQuestion extends Question {
        public TrueFalseQuestion(QuestionId id, String text, AnswerText correct) {
            super(id, text, correct);
        }
        @Override
        public boolean isCorrect(AnswerText studentAnswer) {
            return correctAnswer.value().trim().equalsIgnoreCase(studentAnswer.value().trim());
    }

        @Override
        public void displayFormat() {
            System.out.println("[Verdadero/Falso] (Escriba 'Verdadero' o 'Falso') ");
            System.out.println(text + "/v Verdadero ( ) Falso");
        }
    }
    public static class {
        
    }

