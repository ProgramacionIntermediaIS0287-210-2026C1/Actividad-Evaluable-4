package com.exam.application.dto;

import java.util.List;

public class DTOs {

   
    public static class QuestionDTO {
        public String id;
        public String enunciado;
        public List<String> opciones;

        public QuestionDTO(String id, String enunciado, List<String> opciones) {
            this.id = id;
            this.enunciado = enunciado;
            this.opciones = opciones;
        }
    }

    // Resultado final
    public static class ResultDTO {
        public int score;
        public int total;

        public ResultDTO(int score, int total) {
            this.score = score;
            this.total = total;
        }

    public int getScore() {
        return score;
    }

    public int getValue() {
        return total;
    }
}
    }

