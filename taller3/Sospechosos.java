package taller;
import java.util.ArrayList;

public class Sospechosos { // <-- Inicio de la declaración de la clase

    // Atributos para un solo sospechoso
    private String nombreDelSospechoso; // Cambiado de 'nombre'
    private String aliasDelSospechoso = null; // Cambiado de 'alias'
    private int edadDelSospechoso; // Cambiado de 'edad'
    private String ultimaDireccionConocida; // Cambiado de 'ultimaDireccion'
    private String descripcionFisicaDelSospechoso; // Cambiado de 'descripcionFisica'

    // Atributo para la lista de sospechosos (para la instancia "gestora")
    private ArrayList<Sospechosos> listaDeSospechosos; // Cambiado de 'sospechosos'

    // Constructor para crear una instancia de UN SOLO sospechoso
    // Este se usará cuando se registre un nuevo sospechoso.
    public Sospechosos(String nombreDelSospechoso, String aliasDelSospechoso, int edadDelSospechoso,
                       String ultimaDireccionConocida, String descripcionFisicaDelSospechoso) {
        this.nombreDelSospechoso = nombreDelSospechoso;
        this.aliasDelSospechoso = aliasDelSospechoso;
        this.edadDelSospechoso = edadDelSospechoso;
        this.ultimaDireccionConocida = ultimaDireccionConocida;
        this.descripcionFisicaDelSospechoso = descripcionFisicaDelSospechoso;
    }

    // Constructor para la INSTANCIA QUE GESTIONA la lista de sospechosos
    public Sospechosos(ArrayList<Sospechosos> listaDeSospechosos) {
        this.listaDeSospechosos = listaDeSospechosos;
    }

    // Getters actualizados
    public String getNombreDelSospechoso() {
        return this.nombreDelSospechoso;
    }

    public String getAliasDelSospechoso() {
        return aliasDelSospechoso;
    }

    public int getEdadDelSospechoso() { // Añadido getter para edad
        return edadDelSospechoso;
    }

    public String getUltimaDireccionConocida() {
        return ultimaDireccionConocida;
    }

    public String getDescripcionFisicaDelSospechoso() {
        return descripcionFisicaDelSospechoso;
    }

    // Método para registrar un sospechoso
    // Cambiado el nombre del método de 'registrarSospechos' a 'registrarSospechoso' (singular)
    public Sospechosos registrarSospechoso(String nombre, String alias, int edad, String ultimaDireccion,
                                           String descripcionFisica) {

        // Asegurarse de que el objeto "gestor" tenga la lista inicializada
        if (this.listaDeSospechosos == null) {
            System.err.println("Error: La lista de sospechosos no ha sido inicializada en el gestor.");
            return null;
        }

        for (Sospechosos sospechosoExistente : this.listaDeSospechosos) { // Usando listaDeSospechosos
            if (sospechosoExistente.getNombreDelSospechoso().equals(nombre)) { // Usando getter actualizado
                System.out.println("Sospechoso ya registrado");
                return null;
            }
        }
        // Crea una nueva instancia de Sospechosos usando el constructor que inicializa sus atributos
        Sospechosos nuevoSospechoso = new Sospechosos(nombre, alias, edad, ultimaDireccion, descripcionFisica);
        this.listaDeSospechosos.add(nuevoSospechoso); // Añade el nuevo sospechoso a la lista gestionada
        return nuevoSospechoso;
    }

    @Override
    public String toString() {
        return "Sospechoso{" +
               "nombreDelSospechoso='" + nombreDelSospechoso + '\'' +
               ", aliasDelSospechoso='" + aliasDelSospechoso + '\'' +
               ", edadDelSospechoso=" + edadDelSospechoso +
               ", ultimaDireccionConocida='" + ultimaDireccionConocida + '\'' +
               ", descripcionFisicaDelSospechoso='" + descripcionFisicaDelSospechoso + '\'' +
               '}';
    }

} // <-- Fin de la declaración de la clase