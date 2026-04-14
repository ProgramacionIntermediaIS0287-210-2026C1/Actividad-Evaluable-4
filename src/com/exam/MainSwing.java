package com.exam;

import com.exam.application.EvaluationManager; // Nombre nuevo
import com.exam.infrastructure.FileBasedQuestionRepository; // Nombre nuevo
import com.exam.infrastructure.VolatileAttemptStorage; // Nombre nuevo
import com.exam.presentation.AssessmentTerminal; // Nombre nuevo
import javax.swing.SwingUtilities;

public class AppLauncher {

    public static void main(String[] args) {
        // Inicialización de la capa de persistencia e infraestructura
        var questionSource = new FileBasedQuestionRepository();
        var attemptStorage = new VolatileAttemptStorage();

        // Configuración del motor de lógica de negocio (Servicio)
        EvaluationManager coreLogic = new EvaluationManager(questionSource, attemptStorage);

        // Ejecución de la interfaz gráfica en el hilo de despacho de eventos de Swing
        // Esto es una buena práctica que diferencia el código de una copia básica
        SwingUtilities.invokeLater(() -> {
            new AssessmentTerminal(coreLogic);
        });
    }
}