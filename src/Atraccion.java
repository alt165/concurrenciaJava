import java.util.concurrent.Semaphore;

public abstract class Atraccion {
    protected String nombre;
    protected int capacidad;
    protected int cantidadDevisitas;

    public Atraccion(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.cantidadDevisitas = 0;
    }

    public abstract void entrar(Persona persona) throws InterruptedException;
    public abstract void salir(Persona persona);
}
