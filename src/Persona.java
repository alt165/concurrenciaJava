import java.util.concurrent.ThreadLocalRandom;

public class Persona extends Thread {
    private int numero;
    private ParqueDiversiones parque;
    private boolean[] visitado = {false, false, false}; // Para museo, show, safari

    public Persona(int numero, ParqueDiversiones parque) {
        this.numero = numero;
        this.parque = parque;
    }

    @Override
    public void run() {
        try {

            while (true) {
                // Elegir aleatoriamente una atracción no visitada
                int eleccion = elegirAtraccion();

                if (eleccion == -1) {
                    System.out.println(this + " ha visitado todas las atracciones y se va del parque.");
                    salirDelParque();
                    break;
                }

                switch (eleccion) {
                    case 0:
                        parque.museo.entrar(this);
                        System.out.println();
                        break;
                    case 1:
                        parque.showRealidadVirtual.entrar(this);
                        break;
                    case 2:
                        parque.safari.entrar(this);
                        break;
                    case 3:
                        salirDelParque();
                        System.out.println(this + " no visitó todo pero se va del parque.");
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    private void salirDelParque(){
        System.out.println(numero + " sale del parque.");
        this.parque.semaforoParque.release();
        parque.personasEnElParque--;
        System.out.println("personas en el parque =========> " + parque.personasEnElParque);
    }
    private int elegirAtraccion() {
        // Selecciona una atracción que no haya visitado
        int eleccion = ThreadLocalRandom.current().nextInt(Constantes.CANTIDAD_DE_ATRACCIONES + 1);
        if (eleccion == Constantes.CANTIDAD_DE_ATRACCIONES)
            return eleccion; // Salir del parque
        for (int i = 0; i < 3; i++) {
            int index = (eleccion + i) % 3;
            if (!visitado[index]) {
                visitado[index] = true;
                return index;
            }
        }
        return -1; // Ya visitó todas las atracciones
    }

    @Override
    public String toString() {
        String visitas="";
        if (this.visitado[0])
            visitas = "MUSEO ";
        if (this.visitado[1])
            visitas += "SHOW ";
        if (this.visitado[2])
            visitas += "SAFARI";
        return "Persona: " + numero + " visitado: " + visitas;
    }
}
