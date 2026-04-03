package com.exam.domain.model;

import com.exam.domain.vo.ValueObjects.AnswerText;
import com.exam.domain.vo.ValueObjects.QuestionId;

import java.util.List;

public class QuestionTypes {

    public static class SingleChoiceQuestion extends Question {

        private final List<String> options;

        public SingleChoiceQuestion(QuestionId id, String text,
                                    List<String> options, AnswerText correct) {
            super(id, text, correct);
            this.options = options;
        }

        @Override
        public boolean isCorrect(AnswerText studentAnswer) {
            return correctAnswer.value().trim()
                    .equalsIgnoreCase(studentAnswer.value().trim());
        }

        @Override
        public void displayFormat() {
            System.out.println("[Única respuesta] " + text);
            options.forEach(o -> System.out.println("( ) " + o));
        }
    }

    public static class TrueFalseQuestion extends Question {

        public TrueFalseQuestion(QuestionId id, String text, AnswerText correct) {
            super(id, text, correct);
        }

        @Override
        public boolean isCorrect(AnswerText studentAnswer) {
            return correctAnswer.value().trim()
                    .equalsIgnoreCase(studentAnswer.value().trim());
        }

        @Override
        public void displayFormat() {
            System.out.println("[Verdadero / Falso] (escriba V o F)");
            System.out.println(text + "\n( ) V\n( ) F");
        }
    }

    public static class FillBlankQuestion extends Question {
    
        public FillBlankQuestion (QuestionId id, String text, AnswerText correct) {
            super(id, text, correct);

        }
    }

        public static class MultipleChoiceQuestion extends Question {

        private final List<String> options;

        public MultipleChoiceQuestion(QuestionId id, String text,
                                      List<String> options, AnswerText correct) {
            super(id, text, correct);
            this.options = options;
        }

        @Override
        public boolean isCorrect(AnswerText studentAnswer) {

            // Respuestas separadas por coma: "A,B,C"
            var correctSet = List.of(correctAnswer.value().split(","));
            var studentSet = List.of(studentAnswer.value().split(","));

            return studentSet.containsAll(correctSet)
                    && correctSet.containsAll(studentSet);
        }

        @Override
        public void displayFormat() {
            System.out.println("[Múltiple respuesta] " + text);
            System.out.println("Seleccione varias opciones separadas por coma:");
            options.forEach(o -> System.out.println("( ) " + o));
        }
    }
}