import java.util.HashSet;

public class Utilidades {
    private static HashSet<Integer> idsEmpleados = new HashSet<>();

    public static boolean validarIDUnico(int id) {
        return !idsEmpleados.contains(id);
    }

    public static void agregarID(int id) {
        idsEmpleados.add(id);
    }

    public static boolean validarPuesto(String puesto) {
        return puesto.equalsIgnoreCase("Empleado") || puesto.equalsIgnoreCase("Supervisor");
    }

    public static boolean esNumero(String texto) {
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
