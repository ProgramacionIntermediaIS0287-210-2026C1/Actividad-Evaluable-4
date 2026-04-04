package domain.vo;

public class ValueObjects {

    // =========================
    // StudentId
    // =========================
    public static class StudentId {

        private final String value;

        public StudentId(String value) {
            if (value == null || value.isEmpty()) {
                throw new IllegalArgumentException("StudentId no puede ser vacío");
            }
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    // =========================
    // QuestionId
    // =========================
    public static class QuestionId {

        private final String value;

        public QuestionId(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    // =========================
    // AnswerText
    // =========================
    public static class AnswerText {

        private final String value;

        public AnswerText(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    // =========================
    // Calificacion
    // =========================
    public static class Calificacion {

        private final int puntaje;
        private final int total;

        public Calificacion(int puntaje, int total) {
            this.puntaje = puntaje;
            this.total = total;
        }

        public int getPuntaje() {
            return puntaje;
        }

        public int getTotal() {
            return total;
        }
    }
}