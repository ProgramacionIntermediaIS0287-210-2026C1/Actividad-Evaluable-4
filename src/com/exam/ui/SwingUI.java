package com.exam.ui;

import com.exam.application.ExamService;
import com.exam.domain.model.Question;
import com.exam.domain.vo.ValueObjects.StudentId;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingUI extends JFrame {

    private final ExamService service;
    private List<Question> questions;
    private int index=0;
    private Question current;
    private JTextField field=new JTextField(20);
    private JLabel label=new JLabel();

    public SwingUI(ExamService service){
        this.service=service;

        StudentId id=new StudentId(JOptionPane.showInputDialog("Student ID"));
        service.startExam(id);
        questions=service.getQuestions();

        setLayout(new GridLayout(3,1));
        add(label); add(field);
        JButton btn=new JButton("Next");
        add(btn);

        btn.addActionListener(e->next());
        showQuestion();

        setSize(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void showQuestion(){
        if(index<questions.size()){
            current=questions.get(index);
            label.setText(current.getText());
            field.setText("");
        }else{
            JOptionPane.showMessageDialog(this,"Score: "+service.finishExam());
            System.exit(0);
        }
    }

    private void next(){
        service.answerQuestion(current.getId().getValue(),field.getText());
        index++;
        showQuestion();
    }
}