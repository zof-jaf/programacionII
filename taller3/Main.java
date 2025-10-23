package taller;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Renombrando las listas para mayor claridad
        ArrayList<Sospechosos> listaDeSospechosos = new ArrayList<>();
        ArrayList<Caso> listaDeCasos = new ArrayList<>();

        // Creando las instancias de gestión, pasando las listas correspondientes
        // Nota: Estas instancias de Sospechosos y Caso se usan como "gestores"
        // ya que contienen las listas y los métodos de registro.
        Sospechosos gestorDeSospechosos = new Sospechosos(listaDeSospechosos);
        Caso gestorDeCasos = new Caso(listaDeCasos);

        // Creando una instancia de Detective
        Detectives detective1 = new Detectives("Sherlock Holmes");

        // Registrando sospechosos primero para poder asignarlos a los casos.
        // Los métodos de registro ahora se llaman 'registrarSospechoso' (singular).
        Sospechosos sospechosoAsignado1 = gestorDeSospechosos.registrarSospechoso("John Doe", "El Fantasma", 30, "123 Calle Falsa", "Alto, delgado");
        Detectives detective2 = new Detectives("Julián");
        Sospechosos sospechosoAsignado2 = gestorDeSospechosos.registrarSospechoso("Jane Doe", "El Mudo", 30, "123 Calle Falsa", "Alto, delgado");

        // Registrando casos. Ahora se pasan instancias de 'Detectives' y 'Sospechosos'.
        // Los parámetros del método registrarCaso coinciden con los atributos que esperan.
        Caso caso1 = gestorDeCasos.registrarCaso(
            "C001",
            "El Misterio de la Calle Falsa",
            "Un caso intrigante",
            detective1, // Pasamos la instancia de Detective
            sospechosoAsignado1 // Pasamos la instancia de Sospechosos
        );

        Caso caso2 = gestorDeCasos.registrarCaso(
            "C002",
            "El Secreto del Templo",
            "Un caso misterioso",
            detective2, // Otro detective
            sospechosoAsignado2 // Otro sospechoso
        );

        // --- Impresión de resultados ---

        System.out.println("--- Lista de Sospechosos Registrados ---");
        for (Sospechosos sospechoso : listaDeSospechosos) { // Iteramos sobre la listaDeSospechosos
            System.out.println("Sospechoso: " + sospechoso.getNombreDelSospechoso() +
                               ", Alias: " + sospechoso.getAliasDelSospechoso() +
                               ", Edad: " + sospechoso.getEdadDelSospechoso() +
                               ", Dirección: " + sospechoso.getUltimaDireccionConocida());
        }

        System.out.println("\n--- Lista de Casos Registrados ---");
        for (Caso caso : listaDeCasos) { // Iteramos sobre la listaDeCasos
            System.out.println(caso.toString()); // El toString de Caso ahora usa los getters correctos
        }
        
        System.out.println("\n--- Detalles de Detectives ---");
        System.out.println(detective1.toString());
        System.out.println(detective2.toString());
    }
}