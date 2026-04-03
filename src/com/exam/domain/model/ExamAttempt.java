import java.util.*;

class ExamAttempt {
    private String studentId;
    private List<Question> questions;
    private Map<String, String> answers = new HashMap<>();
    private boolean isFinished = false;
    private int score = 0;

    public ExamAttempt(String studentId, List<Question> questions) {
        this.studentId = studentId;
        this.questions = questions;
    }

    public void responder(String qId, String answer) {
        if (!isFinished) {
            answers.put(qId, answer);
        }
    }

    public void finalizar() {
        isFinished = true;
    }

    public boolean estaFinalizado() {
        return isFinished;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Map<String, String> getAnswers() {
        return answers;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}