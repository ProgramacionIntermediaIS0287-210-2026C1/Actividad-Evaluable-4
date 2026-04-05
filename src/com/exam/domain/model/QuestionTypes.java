package com.exam.domain.model;

import java.util.List;

public class QuestionTypes {

    public static class UniqueChoice extends Question {
        private List<String> opciones;
        private String correcta;

        public UniqueChoice(String id, String texto, List<String> opciones, String correcta) {
            super(id, texto);
            this.opciones = opciones;
            this.correcta = correcta;
        }

        public List<String> getOpciones() {
            return opciones;
        }

        @Override
        public boolean esCorrecta(String respuesta) {
            return correcta.equalsIgnoreCase(respuesta);
        }
    }

    public static class TrueFalse extends Question {
        private boolean correcta;

        public TrueFalse(String id, String texto, boolean correcta) {
            super(id, texto);
            this.correcta = correcta;
        }

        @Override
        public boolean esCorrecta(String respuesta) {
            return (respuesta.equalsIgnoreCase("V") && correcta) ||
                   (respuesta.equalsIgnoreCase("F") && !correcta);
        }
    }
}