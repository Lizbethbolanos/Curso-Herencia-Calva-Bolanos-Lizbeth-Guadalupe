import java.util.Scanner;

public class Main {
    // Códigos ANSI para colores
    public static final String RESET = "\033[0m";
    public static final String ROJO = "\033[31m";
    public static final String VERDE = "\033[32m";
    public static final String AZUL = "\033[34m";
    public static final String AMARILLO = "\033[33m";
    public static final String NEGRITA = "\033[1m";

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int idEmpleado;
        String nombreEmpleado;
        String puestoEmpleado;

        // Título con color
        imprimirEncabezado();

        // Ingreso y validación de datos: ID
        System.out.print(AMARILLO + "Ingrese el ID del empleado (6 dígitos): " + RESET);
        String idInput = scanner.nextLine();

        // Validar que el ID sea numérico y de 6 dígitos
        while (!esNumero(idInput) || idInput.length() != 6) {
            System.out.println(
                    ROJO + "¡Ups! El ID debe ser un número de 6 dígitos, como el código de un superhéroe." + RESET);
            System.out.print(AMARILLO + "Ingrese el ID del empleado (6 dígitos): " + RESET);
            idInput = scanner.nextLine();
        }

        // Convertir a número
        idEmpleado = Integer.parseInt(idInput);

        // Validar que el ID sea único
        if (!Utilidades.validarIDUnico(idEmpleado)) {
            System.out.println(ROJO + "¡Vaya! El ID no es único, parece que otro superhéroe ya lo tiene." + RESET);
            return; // Salir si el ID no es único
        }

        // Agregar el ID a la lista de IDs utilizados
        Utilidades.agregarID(idEmpleado);

        // Ingreso y validación de nombre completo
        System.out.print(AMARILLO + "Ingrese el nombre completo del empleado: " + RESET);
        nombreEmpleado = scanner.nextLine();

        // Validación de que el nombre completo contenga al menos dos palabras
        while (nombreEmpleado.trim().split("\\s+").length < 2) {
            System.out.println(ROJO
                    + "¡Espera un momento! Parece que solo me diste un nombre. ¡Necesito al menos un nombre y un apellido!"
                    + RESET);
            System.out.print(AMARILLO + "Ingrese el nombre completo del empleado: " + RESET);
            nombreEmpleado = scanner.nextLine();
        }

        // Ingreso y validación del puesto
        System.out.print(AMARILLO + "Ingrese el puesto (Empleado o Supervisor): " + RESET);
        puestoEmpleado = scanner.nextLine();

        // Validar que el puesto sea correcto
        while (!Utilidades.validarPuesto(puestoEmpleado)) {
            System.out.println(
                    ROJO + "¡Alerta! El puesto no es válido. ¿Tal vez querías ser 'Empleado' o 'Supervisor'?" + RESET);
            System.out.print(AMARILLO + "Ingrese el puesto: " + RESET);
            puestoEmpleado = scanner.nextLine();
        }

        // Crear el empleado o supervisor dependiendo del puesto
        Empleado empleado;
        if (puestoEmpleado.equalsIgnoreCase("Supervisor")) {
            empleado = new Supervisor(idEmpleado, nombreEmpleado);
        } else {
            empleado = new Empleado(idEmpleado, nombreEmpleado, puestoEmpleado);
        }

        // Ingreso de horas extras
        System.out.print(AMARILLO + "Ingrese las horas extras diurnas: " + RESET);
        double horasExtrasDiurnas = scanner.nextDouble();
        System.out.print(AMARILLO + "Ingrese las horas extras nocturnas: " + RESET);
        double horasExtrasNocturnas = scanner.nextDouble();

        // Calcular el sueldo
        empleado.calcularSueldo(horasExtrasDiurnas, horasExtrasNocturnas);

        // Mostrar el sueldo
        System.out.println(VERDE + "\nSueldo calculado para " + nombreEmpleado + ":" + RESET);
        empleado.mostrarSueldo();

        scanner.close();
    }

    // Método para verificar si el texto es un número
    public static boolean esNumero(String texto) {
        try {
            Integer.parseInt(texto); // Intentamos convertir a entero
            return true;
        } catch (NumberFormatException e) {
            return false; // Si ocurre un error, no es un número
        }
    }

    // Imprimir encabezado bonito
    public static void imprimirEncabezado() {
        System.out.println(AZUL + NEGRITA + "*******************************************" + RESET);
        System.out.println(AZUL + NEGRITA + "*     Bienvenido al Sistema de Sueldos    *" + RESET);
        System.out.println(AZUL + NEGRITA + "*******************************************" + RESET);
        System.out.println();
    }
}
