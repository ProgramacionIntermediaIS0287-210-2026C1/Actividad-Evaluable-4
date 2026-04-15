package com.exam.application.dto;

public class ResultDTO {
    private int score;
    private int total;

    public ResultDTO(int score, int total) {
        this.score = score;
        this.total = total;
    }

    public int getScore() {
        return score;
    }

    public int getTotal() {
        return total;
    }
}

