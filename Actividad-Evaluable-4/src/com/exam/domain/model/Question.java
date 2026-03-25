import  src.com.exam.domain.vo.ValueObjects.AnswerText;
import  src.com.exam.domain.vo.ValueObjects.QuestionId;

public abstract class Question {
    protected final QuestionId id;
    protected final String text;
    protected final AnswerText correctAnswer;

    public Question(QuestionId id, String text, AnswerText correctAnswer) {
        this.id = id;
        this.text = text;
        this.correctAnswer = correctAnswer;
    }
    
    public QuestionId getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public abstract boolean isCorrect(AnswerText studentAnswer);

    public  abstract void displayFormat();

}