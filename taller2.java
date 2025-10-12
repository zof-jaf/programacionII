import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase para el Ejercicio 1 (Rectángulo y Báscula)
class Rectangulo {
    double base;
    double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return base * altura;
    }

    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}

class Bascula {
    public double calcularIMC(double peso, double estatura) {
        return peso / (estatura * estatura);
    }
}

// Clase para el Ejercicio 2 (Calculadora)
class CalculadoraSimple {
    public double sumar(double num1, double num2) {
        return num1 + num2;
    }

    public double restar(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    public double dividir(double num1, double num2) {
        return num1 / num2;
    }
}

// Clase para el Ejercicio 3 (Estudiante)
class EstudianteSimple {
    String nombre;
    int edad;
    double notaFinal;

    public EstudianteSimple(String nombre, int edad, double notaFinal) {
        this.nombre = nombre;
        this.edad = edad;
        this.notaFinal = notaFinal;
    }

    public String obtenerInformacion() {
        return "Nombre: " + nombre + "\nEdad: " + edad + " años\nNota Final: " + notaFinal;
    }
}

// Clase para el Ejercicio 4 (Producto y Tienda)
class ProductoSimple {
    String nombre;
    double precio;
    int cantidadStock;

    public ProductoSimple(String nombre, double precio, int cantidadStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
    }

    public String obtenerInformacion() {
        return "Nombre: " + nombre + "\nPrecio: $" + String.format("%.2f", precio) + "\nStock: " + cantidadStock + " unidades";
    }
}

class TiendaSimple {
    private List<ProductoSimple> productos;

    public TiendaSimple() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(ProductoSimple producto) {
        productos.add(producto);
        System.out.println("Producto '" + producto.nombre + "' agregado con éxito.");
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en la tienda.");
            return;
        }
        System.out.println("\n--- Lista de Productos ---");
        for (int i = 0; i < productos.size(); i++) {
            ProductoSimple p = productos.get(i);
            System.out.println((i + 1) + ". " + p.obtenerInformacion());
        }
        System.out.println("--------------------------");
    }

    public ProductoSimple buscarProductoPorNombre(String nombreBuscado) {
        for (ProductoSimple producto : productos) {
            if (producto.nombre.equalsIgnoreCase(nombreBuscado)) {
                return producto;
            }
        }
        return null;
    }
}

public class taller2 {

    public static void ejecutarEjercicio1(Scanner scanner) {
        System.out.println("\n--- Ejecutando Ejercicio 1: Rectángulo y Báscula ---");

        try {
            System.out.print("Ingrese la base del rectángulo: ");
            double baseRect = Double.parseDouble(scanner.nextLine());

            System.out.print("Ingrese la altura del rectángulo: ");
            double alturaRect = Double.parseDouble(scanner.nextLine());

            Rectangulo miRectangulo = new Rectangulo(baseRect, alturaRect);
            System.out.println("area del rectángulo: " + miRectangulo.calcularArea());
            System.out.println("Perímetro del rectángulo: " + miRectangulo.calcularPerimetro());

            System.out.print("Ingrese el peso (kg) para calcular IMC: ");
            double pesoPersona = Double.parseDouble(scanner.nextLine());

            System.out.print("Ingrese la estatura (m) para calcular IMC: ");
            double estaturaPersona = Double.parseDouble(scanner.nextLine());

            if (estaturaPersona <= 0) {
                System.out.println("Error: La estatura debe ser mayor que 0.");
                return;
            }

            Bascula miBascula = new Bascula();
            System.out.println("IMC de la persona: " + miBascula.calcularIMC(pesoPersona, estaturaPersona));
        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada inválida. Asegúrese de ingresar números correctamente.");
        }
    }

    public static void ejecutarEjercicio2(Scanner scanner) {
        System.out.println("\n--- Ejecutando Ejercicio 2: Calculadora ---");
        CalculadoraSimple calculadora = new CalculadoraSimple();

        try {
            System.out.print("Ingrese el primer número: ");
            double num1 = Double.parseDouble(scanner.nextLine());

            System.out.print("Ingrese el segundo número: ");
            double num2 = Double.parseDouble(scanner.nextLine());

            System.out.println("Elija la operación:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.print("Ingrese el número de la operación deseada: ");
            int opcionOperacion = Integer.parseInt(scanner.nextLine());

            double resultado = 0;
            String operacionTexto = "";

            switch (opcionOperacion) {
                case 1:
                    resultado = calculadora.sumar(num1, num2);
                    operacionTexto = "Suma";
                    break;
                case 2:
                    resultado = calculadora.restar(num1, num2);
                    operacionTexto = "Resta";
                    break;
                case 3:
                    resultado = calculadora.multiplicar(num1, num2);
                    operacionTexto = "Multiplicación";
                    break;
                case 4:
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(null, "No se puede dividir por cero.", "Error de Operación", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    resultado = calculadora.dividir(num1, num2);
                    operacionTexto = "División";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción de operación no válida.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }

            String mensaje = String.format("Operación: %s\nNúmeros: %.2f y %.2f\nResultado: %.2f", operacionTexto, num1, num2, resultado);
            JOptionPane.showMessageDialog(null, mensaje, "Resultado de la Operación", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            System.out.println("Error: Entrada inválida. Asegúrese de ingresar números válidos.");
        }
    }

    public static void ejecutarEjercicio3(Scanner scanner) {
        System.out.println("\n--- Ejecutando Ejercicio 3: Gestión de Estudiantes ---");

        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        try {
            System.out.print("Ingrese la edad del estudiante: ");
            int edad = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese la nota final del estudiante: ");
            double notaFinal = Double.parseDouble(scanner.nextLine());

            EstudianteSimple estudiante = new EstudianteSimple(nombre, edad, notaFinal);
            JOptionPane.showMessageDialog(null, estudiante.obtenerInformacion(), "Información del Estudiante", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            System.out.println("Error: Edad o nota inválida.");
        }
    }

    public static void ejecutarEjercicio4(Scanner scanner) {
        System.out.println("\n--- Ejecutando Ejercicio 4: Gestión de Productos ---");
        TiendaSimple miTienda = new TiendaSimple();

        int opcionTienda;
        do {
            System.out.println("\n--- Menú de la Tienda ---");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Mostrar lista de productos");
            System.out.println("3. Buscar producto por nombre");
            System.out.println("4. Volver al menú principal");
            System.out.print("Ingrese su opción: ");

            try {
                opcionTienda = Integer.parseInt(scanner.nextLine());

                switch (opcionTienda) {
                    case 1:
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese el precio del producto: ");
                        double precio = Double.parseDouble(scanner.nextLine());
                        System.out.print("Ingrese la cantidad en stock: ");
                        int cantidad = Integer.parseInt(scanner.nextLine());

                        ProductoSimple nuevoProducto = new ProductoSimple(nombre, precio, cantidad);
                        miTienda.agregarProducto(nuevoProducto);
                        break;
                    case 2:
                        miTienda.mostrarProductos();
                        break;
                    case 3:
                        System.out.print("Ingrese el nombre del producto a buscar: ");
                        String nombreBuscar = scanner.nextLine();
                        ProductoSimple productoEncontrado = miTienda.buscarProductoPorNombre(nombreBuscar);

                        if (productoEncontrado != null) {
                            JOptionPane.showMessageDialog(null, productoEncontrado.obtenerInformacion(), "Producto Encontrado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "Producto '" + nombreBuscar + "' no encontrado.", "Producto No Encontrado", JOptionPane.WARNING_MESSAGE);
                        }
                        break;
                    case 4:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente nuevamente.");
                opcionTienda = 0; // evitar salir accidentalmente
            }

        } while (opcionTienda != 4);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal;

        do {
            System.out.println("\n=====================================");
            System.out.println("       MENÚ PRINCIPAL DE EJERCICIOS");
            System.out.println("=====================================");
            System.out.println("1. Ejecutar Ejercicio 1 (Rectángulo y Báscula)");
            System.out.println("2. Ejecutar Ejercicio 2 (Calculadora)");
            System.out.println("3. Ejecutar Ejercicio 3 (Gestión de Estudiantes)");
            System.out.println("4. Ejecutar Ejercicio 4 (Gestión de Productos)");
            System.out.println("5. Salir");
            System.out.print("Seleccione un ejercicio para ejecutar: ");

            try {
                opcionPrincipal = Integer.parseInt(scanner.nextLine());

                switch (opcionPrincipal) {
                    case 1:
                        ejecutarEjercicio1(scanner);
                        break;
                    case 2:
                        ejecutarEjercicio2(scanner);
                        break;
                    case 3:
                        ejecutarEjercicio3(scanner);
                        break;
                    case 4:
                        ejecutarEjercicio4(scanner);
                        break;
                    case 5:
                        System.out.println("Saliendo del programa principal. ¡Adiós!");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese un número entre 1 y 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
                opcionPrincipal = 0; // evitar salir accidentalmente
            }

            System.out.println("\nPresione Enter para continuar...");
            scanner.nextLine();
        } while (opcionPrincipal != 5);

        scanner.close();
    }
}
