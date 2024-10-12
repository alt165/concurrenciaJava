import java.util.concurrent.Semaphore;

public class Vehiculo {
    private final int capacidadVehiculo = 4;
    private Semaphore semVehiculo = new Semaphore(0);  // Para simular el llenado del vehículo
    private int idVehiculo;

    public Vehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public void tomarVehiculo(int idPersona) throws InterruptedException {
        System.out.println("Persona " + idPersona + " ha abordado el vehículo " + idVehiculo + ".");
        semVehiculo.release();  // Marca que la persona subió al vehículo
        if (semVehiculo.availablePermits() == capacidadVehiculo) {
            System.out.println("Vehículo " + idVehiculo + " está completo y parte hacia el safari.");
        }
    }

    public void liberarVehiculo() {
        semVehiculo.drainPermits();  // Resetea el vehículo para el próximo viaje
        System.out.println("Vehículo " + idVehiculo + " está disponible para otro viaje.");
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }
}
