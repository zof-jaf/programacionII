// Clase principal para probar las clases (opcional, para demostración)
public class taller2 {
    public static void main(String[] args) {
        // Ejemplo de uso de la clase Rectangulo
        Rectangulo miRectangulo = new Rectangulo(5.0, 10.0);
        System.out.println("Área del rectángulo: " + miRectangulo.calcularArea());
        System.out.println("Perímetro del rectángulo: " + miRectangulo.calcularPerimetro());

        // Ejemplo de uso de la clase Bascula
        Bascula miBascula = new Bascula();
        double pesoPersona = 70.0; // kg
        double estaturaPersona = 0; // metros
        System.out.println("IMC de la persona: " + miBascula.calcularIMC(pesoPersona, estaturaPersona));

        double pesoPersona2 = 85.0; // kg
        double estaturaPersona2 = 1.60; // metros
        System.out.println("IMC de la persona 2: " + miBascula.calcularIMC(pesoPersona2, estaturaPersona2));
    }
}

// Clase Rectángulo
class Rectangulo {
    double base;
    double altura;

    // Constructor
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Método para calcular el área
    public double calcularArea() {
        return base * altura;
    }

    // Método para calcular el perímetro
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}

// Clase Báscula
class Bascula {

    // Método para calcular el Índice de Masa Corporal (IMC)
    public double calcularIMC(double peso, double estatura) {
        // El IMC es el peso dividido el cuadrado de la estatura (peso / estatura^2)
        if (estatura <= 0) {
            throw new IllegalArgumentException("La estatura debe ser mayor que cero para calcular el IMC.");
        }
        return peso / (estatura * estatura);
    }
}

