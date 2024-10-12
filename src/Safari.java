import java.util.concurrent.Semaphore;

public class Safari extends Atraccion{
    private final int capacidadSafari = 52;
    private Semaphore semSafari = new Semaphore(capacidadSafari, true);
    private int personasEnSafari = 0;
    private Semaphore mutex = new Semaphore(1, true);  // Para sincronizar el acceso al contador

    public Safari() {
        super("Safari", Constantes.CAPACIDAD_SAFARI);
    }

    public void entrar(Persona persona) throws InterruptedException {
        semSafari.acquire();
        System.out.println(persona + " ha entrado al safari.");
        incrementarVisitantes();
    }

    public void salir(Persona persona) {
        semSafari.release();
        System.out.println(persona + " ha salido del safari.");
    }

    private void incrementarVisitantes() throws InterruptedException {
        mutex.acquire();
        cantidadDevisitas++;
        mutex.release();
    }

    public int getPersonasEnSafari() {
        return personasEnSafari;
    }
}
