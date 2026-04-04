package com.exam.domain.model;

import com.exam.domain.vo.ValueObjects.AnswerText;
import java.util.*;

public class QuestionTypes {

    public static class UniqueChoice extends Question {

        private List<String> opciones;
        private String correcta;

        public UniqueChoice(String id, String enunciado, List<String> opciones, String correcta) {
            super(id, enunciado);
            this.opciones = opciones;
            this.correcta = correcta;
        }

        @Override
        public boolean esCorrecta(AnswerText r) {
            return r.getValue().equalsIgnoreCase(correcta);
        }

        public List<String> getOpciones() {
            return opciones;
        }
    }

    public static class TrueFalse extends Question {

        private boolean correcta;

        public TrueFalse(String id, String enunciado, boolean correcta) {
            super(id, enunciado);
            this.correcta = correcta;
        }

        @Override
        public boolean esCorrecta(AnswerText r) {
            return r.getValue().equalsIgnoreCase("V") == correcta;
        }
    }
}