public ExamAttempt iniciarExamen(StudentId studentId) {
    attemptManager.verificarIntentoActivo(studentId);

    var questions = questionRepo.findAll();
    var attempt = new ExamAttempt(studentId, questions);

    attemptRepo.save(attempt);

    return new ExamAttemptDTO(studentId, questions);
}