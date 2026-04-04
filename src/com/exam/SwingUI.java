import javax.swing.*;
import java.awt.*;

public class SwingUI {

    private ExamApplicationService appService;

    public SwingUI(ExamApplicationService appService) {
        this.appService = appService;
    }

    public void start() {
        JFrame frame = new JFrame("Sistema de Exámenes");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton iniciarBtn = new JButton("Iniciar Examen");

        iniciarBtn.addActionListener(e -> {
            StudentId student = new StudentId("1");

            ExamAttemptDTO attempt = appService.iniciarExamen(student);

            JOptionPane.showMessageDialog(frame,
                    "Examen iniciado con " + attempt.questions().size() + " preguntas");
        });

        frame.setLayout(new FlowLayout());
        frame.add(iniciarBtn);

        frame.setVisible(true);
    }
}