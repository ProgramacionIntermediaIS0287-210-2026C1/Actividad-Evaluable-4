package com.exam.application.dto;

import java.util.*;

public class DTOs {

    public record ExamAttemptDTO(String studentId, List<String> questions) {}
    public record CalificacionDTO(int puntaje, int total) {}
}