import java.util.*;

// ======= OBJETO VALOR =======
class AnswerText {
    private String value;

    public AnswerText(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Respuesta vacía");
        }
        this.value = value.trim();
    }

    public String getValue() {
        return value;
    }
}

// ======= CLASE ABSTRACTA =======
abstract class Question {
    protected String enunciado;

    public Question(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public abstract boolean esCorrecta(AnswerText respuesta);
}

// ======= PREGUNTA VERDADERO/FALSO =======
class TrueFalseQuestion extends Question {
    private boolean correcta;

    public TrueFalseQuestion(String enunciado, boolean correcta) {
        super(enunciado);
        this.correcta = correcta;
    }

    @Override
    public boolean esCorrecta(AnswerText respuesta) {
        String r = respuesta.getValue().toUpperCase();
        boolean user = r.equals("V");
        return user == correcta;
    }
}

// ======= PREGUNTA OPCIÓN ÚNICA =======
class UniqueChoiceQuestion extends Question {
    private List<String> opciones;
    private String correcta;

    public UniqueChoiceQuestion(String enunciado, List<String> opciones, String correcta) {
        super(enunciado);
        this.opciones = opciones;
        this.correcta = correcta;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    @Override
    public boolean esCorrecta(AnswerText respuesta) {
        return respuesta.getValue().equalsIgnoreCase(correcta);
    }
}

// ======= EXAMEN =======
class Exam {
    private String titulo;
    private List<Question> preguntas;

    public Exam(String titulo) {
        this.titulo = titulo;
        this.preguntas = new ArrayList<>();
    }

    public void agregarPregunta(Question q) {
        preguntas.add(q);
    }

    public List<Question> getPreguntas() {
        return preguntas;
    }
}

// ======= SERVICIO DE CALIFICACIÓN =======
class GradingService {
    public int calificar(Exam exam, List<AnswerText> respuestas) {
        int score = 0;
        for (int i = 0; i < exam.getPreguntas().size(); i++) {
            if (exam.getPreguntas().get(i).esCorrecta(respuestas.get(i))) {
                score++;
            }
        }
        return score;
    }
}

// ======= MAIN (EJECUTABLE) =======
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear examen
        Exam examen = new Exam("Examen Demo");

        examen.agregarPregunta(
            new TrueFalseQuestion("Java es un lenguaje compilado (V/F):", true)
        );

        examen.agregarPregunta(
            new UniqueChoiceQuestion(
                "¿Capital de Colombia?",
                Arrays.asList("1. Bogotá", "2. Lima", "3. Quito"),
                "1"
            )
        );

        // Responder preguntas
        List<AnswerText> respuestas = new ArrayList<>();

        for (Question q : examen.getPreguntas()) {
            System.out.println(q.getEnunciado());

            if (q instanceof UniqueChoiceQuestion) {
                for (String op : ((UniqueChoiceQuestion) q).getOpciones()) {
                    System.out.println(op);
                }
            }

            System.out.print("Tu respuesta: ");
            String input = sc.nextLine();
            respuestas.add(new AnswerText(input));
        }

        // Calificar
        GradingService grading = new GradingService();
        int resultado = grading.calificar(examen, respuestas);

        System.out.println("\nResultado: " + resultado + "/" + examen.getPreguntas().size());

        sc.close();
    }
}