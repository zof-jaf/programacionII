package taller;
import java.util.ArrayList;

public class Caso { // <-- ¡Aquí empieza la declaración de la clase!

    // Atributos
    private String idDelCaso; // Cambiado de idCaso a idDelCaso
    private String nombreClaveDelCaso; // Cambiado de nombreCasoClave a nombreClaveDelCaso
    private String descripcionDelCaso; // Cambiado de descripcion a descripcionDelCaso
    private Detectives detectivePrincipal; // Cambiado de detectiveAsignado a detectivePrincipal
    private Sospechosos sospechosoPrincipal; // Cambiado de sospechoso a sospechosoPrincipal

    private ArrayList<Caso> listaDeCasos; // Cambiado de casos a listaDeCasos

    // Constructor para la creación de un Caso específico (que se usa al registrar)
    public Caso(String idDelCaso, String nombreClaveDelCaso, String descripcionDelCaso,
                Detectives detectivePrincipal, Sospechosos sospechosoPrincipal) {
        this.idDelCaso = idDelCaso;
        this.nombreClaveDelCaso = nombreClaveDelCaso;
        this.descripcionDelCaso = descripcionDelCaso;
        this.detectivePrincipal = detectivePrincipal;
        this.sospechosoPrincipal = sospechosoPrincipal;
    }

    // Constructor para el objeto que gestiona la lista de casos
    public Caso(ArrayList<Caso> listaDeCasos) { // <-- Constructor corregido
        this.listaDeCasos = listaDeCasos;
    }

    // Getters
    public String getIdDelCaso() { // Getter actualizado
        return idDelCaso;
    }

    public String getNombreClaveDelCaso() { // Getter actualizado
        return nombreClaveDelCaso;
    }

    public String getDescripcionDelCaso() { // Getter actualizado
        return descripcionDelCaso;
    }

    public Detectives getDetectivePrincipal() { // Getter añadido
        return detectivePrincipal;
    }

    public Sospechosos getSospechosoPrincipal() { // Getter añadido
        return sospechosoPrincipal;
    }

    // Método para registrar un caso
    public Caso registrarCaso(
            String idCaso, // Mantengo el nombre original para el parámetro para tu comodidad
            String nombreClave, // Mantengo el nombre original para el parámetro
            String descripcion, // Mantengo el nombre original para el parámetro
            Detectives detectiveAsignado, // Mantengo el nombre original para el parámetro
            Sospechosos sospechoso) { // Mantengo el nombre original para el parámetro

        // Asegurarse de que el objeto "gestor" tenga la lista inicializada
        if (this.listaDeCasos == null) {
            System.err.println("Error: La lista de casos no ha sido inicializada en el gestor.");
            return null;
        }

        for (Caso caso : this.listaDeCasos) { // Usando listaDeCasos
            if (caso.getIdDelCaso().equals(idCaso)) { // Usando el getter actualizado
                System.out.println("El caso ya esta registrado");
                return null;
            }
        }
        // Creamos una nueva instancia de Caso usando el constructor específico de Caso
        Caso nuevoCaso = new Caso(idCaso, nombreClave, descripcion, detectiveAsignado, sospechoso);
        this.listaDeCasos.add(nuevoCaso); // Usando listaDeCasos

        return nuevoCaso;
    }

    @Override
        public String toString() {
        return "Caso{ idDelCaso='" + this.idDelCaso + "', nombreClaveDelCaso='" + this.nombreClaveDelCaso + "', descripcionDelCaso='" + this.descripcionDelCaso + ", sospechosoPrincipal=" + this.sospechosoPrincipal.getNombreDelSospechoso() + " }";
    }

}