package taller;
public class Detectives { // <-- Inicio de la declaración de la clase

    // Atributos
    private String nombreDelDetective; // Cambiado de 'detective'
    private int numeroDeCasosAsignados; // Cambiado de 'casosASignados'

    // Constructor principal
    public Detectives(String nombreDelDetective) {
        this.nombreDelDetective = nombreDelDetective;
        this.numeroDeCasosAsignados = 0; // Inicializar casos asignados a 0
    }

    // Getters actualizados
    public String getNombreDelDetective() {
        return nombreDelDetective;
    }

    public int getNumeroDeCasosAsignados() {
        return numeroDeCasosAsignados;
    }

    // Método para incrementar los casos asignados (es útil tenerlo)
    public void incrementarNumeroDeCasosAsignados() {
        this.numeroDeCasosAsignados++;
    }

    // El método registrarDetective es un poco redundante si solo llama al constructor.
    // Usualmente, si gestionas una lista de detectives, este método viviría en una clase "GestorDeDetectives".
    // Por ahora, lo mantengo como lo tenías, asumiendo que el objetivo es crear una nueva instancia.
    public Detectives registrarDetective(String nombreDelDetective) { // Parámetro actualizado
        // Simplemente crea y retorna una nueva instancia de Detective
        return new Detectives(nombreDelDetective);
    }

    @Override
    public String toString() {
        return "Detective{" +
               "nombreDelDetective='" + nombreDelDetective + '\'' +
               ", numeroDeCasosAsignados=" + numeroDeCasosAsignados +
               '}';
    }

} // <-- Fin de la declaración de la clase