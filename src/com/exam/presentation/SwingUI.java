package com.exam.ui;

import com.exam.application.ExamService;
import com.exam.domain.model.Question;
import com.exam.domain.vo.ValueObjects.StudentId;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingUI extends JFrame {

    private final ExamService examService;
    private Question currentQuestion;
    private int currentQuestionIndex = 0;
    private List<Question> questions;
    private StudentId studentId;

    private JLabel questionLabel;
    private JTextField answerField;
    private JButton nextButton;

    public SwingUI(ExamService examService) {
        this.examService = examService;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Exam System");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        studentId = new StudentId(
                JOptionPane.showInputDialog("Ingrese su ID de estudiante:")
        );

        examService.startExam(studentId);
        questions = examService.getQuestions();

        questionLabel = new JLabel();
        answerField = new JTextField(20);
        nextButton = new JButton("Siguiente");

        nextButton.addActionListener(e -> submitAnswer());

        JPanel panel = new JPanel(new GridLayout(3,1));
        panel.add(questionLabel);
        panel.add(answerField);
        panel.add(nextButton);

        add(panel);

        showNextQuestion();
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            currentQuestion = questions.get(currentQuestionIndex);
            questionLabel.setText(currentQuestion.getText());
            answerField.setText("");
        } else {
            int score = examService.finishExam();
            JOptionPane.showMessageDialog(this,
                    "Examen terminado. Puntaje: " + score);
            System.exit(0);
        }
    }

    private void submitAnswer() {
        String answer = answerField.getText();
        examService.answerQuestion(currentQuestion.getId(), answer);
        currentQuestionIndex++;
        showNextQuestion();
    }
}