import java.util.concurrent.ThreadLocalRandom;

public class borrar {
    //private void irSafari() throws InterruptedException {
    }
//    semaforoSafari.acquire();
//    visitantesSafari++;
//    System.out.println(nombre + " quiere ir al safari.");
//
//    // Esperar a que haya espacio en un vehículo de ida
//    synchronized (filaVehiculoIda) {
//        filaVehiculoIda.add(this);
//        if (filaVehiculoIda.size() >= CAPACIDAD_VEHICULO) {
//            int vehiculoAsignado = asignarVehiculo();
//            if (vehiculoAsignado != -1) {
//                System.out.println("El vehículo " + vehiculoAsignado + " se llena y va al safari.");
//                for (int j = 0; j < CAPACIDAD_VEHICULO; j++) {
//                    Persona persona = filaVehiculoIda.poll(); // Personas entran en el vehículo
//                    System.out.println(persona.nombre + " aborda el vehículo " + vehiculoAsignado + " al safari.");
//                    filaVehiculoRegreso.add(persona); // Añadir a la fila de regreso
//                }
//                // Incrementar el contador de personas transportadas por el vehículo
//                vehiculosTransportados[vehiculoAsignado] += CAPACIDAD_VEHICULO;
//
//                // Simular tiempo de safari
//                Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 5000));
//                System.out.println("El vehículo " + vehiculoAsignado + " regresa del safari.");
//                semaforoVehiculo[vehiculoAsignado].release(); // Liberar el vehículo para otros
//
//                // Transportar de vuelta
//                transportarDeRegreso(vehiculoAsignado);
//            }
//        } else {
//            System.out.println(nombre + " espera para abordar el vehículo al safari.");
//        }
//    }
//
//    semaforoSafari.release();
//}
//
//    private void transportarDeRegreso(int vehiculoAsignado) throws InterruptedException {
//        synchronized (filaVehiculoRegreso) {
//            if (filaVehiculoRegreso.size() >= CAPACIDAD_VEHICULO) {
//                System.out.println("El vehículo " + vehiculoAsignado + " se llena para el regreso.");
//                for (int j = 0; j < CAPACIDAD_VEHICULO; j++) {
//                    Persona persona = filaVehiculoRegreso.poll(); // Personas suben al vehículo para el regreso
//                    System.out.println(persona.nombre + " aborda el vehículo " + vehiculoAsignado + " para regresar del safari.");
//                }
//
//                // Simular tiempo de regreso del safari
//                Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 5000));
//                System.out.println("El vehículo " + vehiculoAsignado + " llega de regreso del safari.");
//            }
//        }
//    }
//
//    private int asignarVehiculo() {
//        for (int i = 0; i < NUM_VEHICULOS; i++) {
//            int vehiculoActual = (indiceVehiculo + i) % NUM_VEHICULOS;
//            if (semaforoVehiculo[vehiculoActual].tryAcquire()) {
//                // Asignar el vehículo y actualizar el índice circular
//                indiceVehiculo = (vehiculoActual + 1) % NUM_VEHICULOS;
//                return vehiculoActual;
//            }
//        }
//        return -1; // No hay vehículos disponibles
//

