package domain.service;

public class AttemptManager {

    private InMemoryExamAttemRepository repository;

    public AttemptManager(InMemoryExamAttemRepository repository) {
        this.repository = repository;
    }

    public void verificarIntentoActivo(String studentId) {
        if (repository.findActiveByStudent(studentId).isPresent()) {
            throw new RuntimeException("Ya existe un intento activo");
        }
    }
}