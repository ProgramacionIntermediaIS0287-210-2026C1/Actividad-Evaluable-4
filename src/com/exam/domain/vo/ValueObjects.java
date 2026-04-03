package com.exam.domain.vo;

public class ValueObjects {

    public static class QuestionId {
        private final String value;
        public QuestionId(String value){ this.value=value; }
        public String getValue(){ return value; }
    }

    public static class StudentId {
        private final String value;
        public StudentId(String value){ this.value=value; }
        public String getValue(){ return value; }
    }
}