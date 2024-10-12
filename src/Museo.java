import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Museo extends Atraccion {
    private final Semaphore semaphoreMuseo = new Semaphore(Constantes.CAPACIDAD_MUSEO, true);

    public Museo() {
        super("Museo", Constantes.CAPACIDAD_MUSEO);
    }

    @Override
    public synchronized void entrar(Persona persona) throws InterruptedException {
        semaphoreMuseo.acquire();
        System.out.println(persona + " ha entrado al museo.");
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 3000));
        cantidadDevisitas++;
        salir(persona);
    }

    @Override
    public synchronized void salir(Persona persona) {
        System.out.println(persona + " sale del museo.");
        semaphoreMuseo.release();
    }
}
