import java.util.concurrent.Semaphore;

public class ParqueDiversiones {

    protected Semaphore semaforoParque = new Semaphore(Constantes.CAPACIDAD_PARQUE, true);
    public final Museo museo = new Museo();
    public final Safari safari = new Safari();
    public final ShowRealidadVirtual showRealidadVirtual = new ShowRealidadVirtual();
    public int personasEnElParque = 0;

    public ParqueDiversiones() {

        // Registrar un shutdown hook para esperar la señal TERM
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Recibida señal TERM. Imprimiendo estadísticas...");
            imprimirEstadisticas();
        }));
    }

    public void ingresarPersona(Persona persona) {
        try {
            semaforoParque.acquire();
            System.out.println(persona + " entra al parque.");
            personasEnElParque++;
            persona.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void imprimirEstadisticas() {
        System.out.println("Estadísticas del parque de diversiones:");
        System.out.println("Personas que visitaron el museo: " + museo.cantidadDevisitas);
        System.out.println("Personas que vieron el show de realidad virtual: " + showRealidadVirtual.cantidadDevisitas);
        System.out.println("Personas que visitaron el safari: " + safari.cantidadDevisitas);

    }

    public static void main(String[] args) {
        ParqueDiversiones parque = new ParqueDiversiones();
        int contadorPersonas = 0;

        while (true){ // Más de la capacidad del parque
            contadorPersonas++;
            Persona persona = new Persona(contadorPersonas, parque);
            parque.ingresarPersona(persona);
        }
    }
}
