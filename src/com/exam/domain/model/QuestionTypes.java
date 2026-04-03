package domain;

import com.exam.domain.vo.ValueObjects.AnswerText;
import com.exam.domain.vo.ValueObjects.QuestionId;
import java.util.*;

public class QuestionTypes{
    public static class  singleChoiceQuestion extends Question {
    private final List<String> options;

    public singleChoiceQuestion(Question id, String text, List<String> options, AnswerText correct){
        super(id, text, correct);
        this.options = options;

    }

    @Override
    public boolean isCorrect(AnswerText studenAnswer){
        return correctAnswer.value().trim().equalsIgnoreCase(studenAnswer.value().trim());
    }

    @Override
    public void displayFormat(){
        System.out.println("[Unica respuesta]"+ text);
        options.forEach(o-> System.out.println("()" + o));
    }

    }
     

}