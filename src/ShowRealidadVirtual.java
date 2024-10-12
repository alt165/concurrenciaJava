import java.util.concurrent.Semaphore;

public class ShowRealidadVirtual extends Atraccion {
    private int visitantesActuales = 0;
    private final Semaphore semaphoreShow = new Semaphore(Constantes.CAPACIDAD_SHOW, true);

    public ShowRealidadVirtual() {
        super("Show de Realidad Virtual", Constantes.CAPACIDAD_SHOW);
    }

    @Override
    public synchronized void entrar(Persona persona) throws InterruptedException {
        if (visitantesActuales < Constantes.CAPACIDAD_SHOW) {
            semaphoreShow.acquire();
            visitantesActuales++;
            System.out.println(persona + " entra al show de realidad virtual.");
            System.out.println(persona + " espera a que comience el show.");
        }

        // Verificar si el show está lleno
        if (visitantesActuales == Constantes.CAPACIDAD_SHOW) {
            System.out.println("El show de realidad virtual comienza con " + visitantesActuales + " personas.");
            cantidadDevisitas += visitantesActuales;

            // Simulación de duración del show
            System.out.println("visitantesActuales = " + visitantesActuales);
            Thread.sleep(Constantes.DURACION_SHOW); // Duración fija del show
        }
    }

    @Override
    public synchronized void salir(Persona persona) {
        // Se vacía la sala
        for (int i = 0; i < visitantesActuales; i++) {
            semaphoreShow.release();
        }

        System.out.println("El show de realidad virtual termina. " + cantidadDevisitas +
                "  personas vieron el show.");
        visitantesActuales = 0; // Reiniciar el contador de visitantes para el siguiente show
    }
}
