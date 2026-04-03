abstract class Question {
    protected String id;
    protected String text;
    protected String correctAnswer;

    public Question(String id, String text, String correctAnswer) {
        this.id = id;
        this.text = text;
        this.correctAnswer = correctAnswer;
    }

    public abstract boolean isCorrect(String studentAnswer);

    public abstract void displayFormat();

    public String getId() {
        return id;
    }
}