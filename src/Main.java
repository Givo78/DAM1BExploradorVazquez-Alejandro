//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("**********************************************");
        System.out.println("Juego Explorador Alejandro Vazquez");
        System.out.println("**********************************************");

        Mapa mapa = new Mapa();
        Explorador explorador = new Explorador("Jugador1");
        Enemigo enemigo = new Enemigo("Enemigo1");

        mapa.actualizarPosicion(explorador.getPosicion().getCoordenadaFila(), explorador.getPosicion().getCoordenadaCol(), 'O');
        mapa.actualizarPosicion(enemigo.getPosicion().getCoordenadaFila(), enemigo.getPosicion().getCoordenadaCol(), 'X');

        Scanner scanner = new Scanner(System.in);
        boolean juegoActivo = true;

        while (juegoActivo = true) {
            mapa.mostrarMapa();
            System.out.println("O: Jugador X: Enemigo T: Trampa \nIntroduce el siguiente movimiento (1: Arriba 2: Abajo 3: Derecha 4: Izquierda)");
            int direccion = scanner.nextInt();

            mapa.limpiarPosicion(explorador.getPosicion().getCoordenadaFila(), explorador.getPosicion().getCoordenadaCol());
            explorador.moverse(direccion);

            if (mapa.esTrampa(explorador.getPosicion().getCoordenadaFila(), explorador.getPosicion().getCoordenadaCol())) {
                System.out.println("Has caido en una trampa");
                juegoActivo = false;
                break;
            }

            mapa.actualizarPosicion(explorador.getPosicion().getCoordenadaFila(), explorador.getPosicion().getCoordenadaCol(),'O');

            mapa.limpiarPosicion(enemigo.getPosicion().getCoordenadaFila(), enemigo.getPosicion().getCoordenadaCol());
            enemigo.moverse();
            mapa.actualizarPosicion(enemigo.getPosicion().getCoordenadaFila(), enemigo.getPosicion().getCoordenadaCol(), 'X');

            if (explorador.getPosicion().getCoordenadaFila() == enemigo.getPosicion().getCoordenadaFila() && explorador.getPosicion().getCoordenadaCol() == enemigo.getPosicion().getCoordenadaCol()){
                System.out.println("Has sido atrapado por un enemigo");
                juegoActivo = false;
                break;
            }

        }
        scanner.close();
    }
}
