package com.exam.domain.vo;

public class ValueObjects {

    public static class AnswerText {

        private String value;

        public AnswerText(String value) {
            if (value == null || value.isBlank()) {
                throw new RuntimeException("Respuesta vacía");
            }
            this.value = value.trim();
        }

        public String getValue() {
            return value;
        }
    }
}