package com.exam.presentation;

import com.exam.application.EvaluationManager; // Nombre nuevo del servicio
import com.exam.domain.model.Question;
import com.exam.domain.vo.Identities.StudentToken; // Nombre nuevo del VO
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AssessmentTerminal extends JFrame {

    private final EvaluationManager _logicManager;
    private List<Question> _testBank;
    private int _cursor = 0;
    private Question _activeItem;

    // Componentes con nombres descriptivos
    private final JTextField _inputResponse = new JTextField(25);
    private final JLabel _questionDisplay = new JLabel("Cargando...", SwingConstants.CENTER);
    private final JButton _actionButton = new JButton("Confirmar y Continuar");

    public AssessmentTerminal(EvaluationManager manager) {
        super("Módulo de Evaluación");
        this._logicManager = manager;

        // Proceso de inicio
        initializeSession();
        setupLayout();
        refreshView();

        // Configuración de ventana
        this.pack();
        this.setSize(450, 250);
        this.setLocationRelativeTo(null); // Centra la ventana
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void initializeSession() {
        String input = JOptionPane.showInputDialog(this, "Ingrese Identificación del Estudiante:");
        StudentToken token = new StudentToken(input != null ? input : "invitado");
        
        _logicManager.beginTest(token);
        _testBank = _logicManager.retrieveCurrentQuestions();
    }

    private void setupLayout() {
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        _questionDisplay.setFont(new Font("Arial", Font.BOLD, 14));
        
        mainPanel.add(_questionDisplay, BorderLayout.NORTH);
        mainPanel.add(_inputResponse, BorderLayout.CENTER);
        mainPanel.add(_actionButton, BorderLayout.SOUTH);

        this.add(mainPanel);
        _actionButton.addActionListener(evt -> processStep());
    }

    private void refreshView() {
        if (_cursor < _testBank.size()) {
            _activeItem = _testBank.get(_cursor);
            _questionDisplay.setText(_activeItem.bodyText());
            _inputResponse.setText("");
            _inputResponse.requestFocus();
        } else {
            finalizeAssessment();
        }
    }

    private void processStep() {
        String answer = _inputResponse.getText();
        _logicManager.registerResponse(_activeItem.identifier().asRaw(), answer);
        
        _cursor++;
        refreshView();
    }

    private void finalizeAssessment() {
        int finalResult = _logicManager.closeAndGetGrade();
        JOptionPane.showMessageDialog(this, "Evaluación finalizada.\nPuntaje obtenido: " + finalResult);
        this.dispose();
    }
}