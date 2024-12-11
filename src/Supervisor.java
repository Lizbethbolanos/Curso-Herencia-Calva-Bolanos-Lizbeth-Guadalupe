public class Supervisor extends Empleado {

    public Supervisor(int idEmpleado, String nombre) {
        super(idEmpleado, nombre, "Supervisor");
    }

    @Override
    public void calcularSueldo(double horasExtrasDiurnas, double horasExtrasNocturnas) {
        if (getPuesto().equalsIgnoreCase("Supervisor")) {
            double sueldoBase = 8000;
            // Cálculo de deducciones
            double deduccionInfonavit = sueldoBase * 0.002;
            double deduccionSeguro = sueldoBase * 0.001;
            double deduccionISR = sueldoBase * 0.0016;

            double totalDeducciones = deduccionInfonavit + deduccionSeguro + deduccionISR;
            double sueldoFinal = sueldoBase - totalDeducciones;
            sueldoQuincenal[0] = sueldoFinal + (horasExtrasDiurnas * 50) + (horasExtrasNocturnas * 60);
        } else {
            System.out.println("El puesto no corresponde a Supervisor.");
        }
    }
}
