import java.util.ArrayList;
import java.util.List;

public class Mapa {
    private char[][] tablero;
    private List<Posicion> trampas;

    public Mapa() {
        tablero = new char[10][10];
        trampas = new ArrayList<>();
        inicializarTablero();
        generarTrampas(3);
    }

    private void inicializarTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i + j) % 2 == 0) {
                    tablero[i][j] = '.';
                } else {
                    tablero[i][j] = ' ';
                }
            }
        }
    }
    // Para generar las trampas me ayude de un video de yt y de chatgpt
    private void generarTrampas(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            int x;
            int y;
            do {
                x = (int) (Math.random() * 10);
                y = (int) (Math.random() * 10);
            } while (tablero[y][x] != '.' && tablero[y][x] != ' ');

            trampas.add(new Posicion(x, y));
            tablero[y][x] = 'T';
        }
    }

    public void actualizarPosicion(int x,int y,char simbolo) {
        tablero[y][x] = simbolo;
    }

    public void limpiarPosicion(int x, int y) {
        if ((x + y) % 2 == 0) {
            tablero[y][x] = '.';
        } else {
            tablero[y][x] = ' ';
        }
    }

    public void mostrarMapa() {
        for (char[] fila : tablero ) {
            for (char celda : fila) {
                System.out.print(celda + " ");
            }
            System.out.println();
        }
    }

    public boolean esTrampa(int x, int y) {
        return tablero[y][x] == 'T';
    }
}
