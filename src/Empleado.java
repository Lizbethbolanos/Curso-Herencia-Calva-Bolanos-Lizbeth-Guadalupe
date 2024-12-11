public class Empleado {
    private String nombre;
    private int idEmpleado;
    private String puesto;
    protected double[] sueldoQuincenal;

    public Empleado(int idEmpleado, String nombre, String puesto) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.puesto = puesto;
        this.sueldoQuincenal = new double[2]; // Sueldo y horas extras
    }

    public void calcularSueldo(double horasExtrasDiurnas, double horasExtrasNocturnas) {
        if (puesto.equalsIgnoreCase("Empleado")) {
            double sueldoBase = 5000;
            double pagoHorasExtras = (horasExtrasDiurnas * 50) + (horasExtrasNocturnas * 60);
            sueldoQuincenal[0] = sueldoBase + pagoHorasExtras;
        } else {
            System.out.println("El puesto no corresponde a Empleado.");
        }
    }

    public void mostrarSueldo() {
        System.out.println("Sueldo Quincenal de " + nombre + ": $" + sueldoQuincenal[0]);
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getPuesto() {
        return puesto;
    }
}
