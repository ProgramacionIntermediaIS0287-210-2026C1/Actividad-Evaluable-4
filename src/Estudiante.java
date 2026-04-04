public class Estudiante {

    private String id;
    private String nombre;

    public Estudiante(String id, String nombre) {
        if (id == null || id.isBlank()) {
            throw new RuntimeException("ID inválido");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new RuntimeException("Nombre inválido");
        }

        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }
}
