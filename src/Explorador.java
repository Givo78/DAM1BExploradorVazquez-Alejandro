public class Explorador {
    private String nombre;
    private Posicion posicion;

    public Explorador(String nombre) {
        this.nombre = nombre;
        this.posicion = new Posicion(0, 0);
    }

    public void moverse(int direccion) {
        switch (direccion) {
            case Direcciones.IZQUIERDA:
                if (posicion.getCoordenadaFila() > 0) {
                    posicion.setCoordenadaFila(posicion.getCoordenadaFila() - 1);
                }
                break;
            case Direcciones.DERECHA:
                if (posicion.getCoordenadaFila() < 29) {
                    posicion.setCoordenadaFila(posicion.getCoordenadaFila() + 1);
                }
                break;
            case Direcciones.ARRIBA:
                if (posicion.getCoordenadaCol() > 0) {
                    posicion.setCoordenadaCol(posicion.getCoordenadaCol() - 1);
                }
                break;
            case Direcciones.ABAJO:
                if (posicion.getCoordenadaCol() < 9) {
                    posicion.setCoordenadaCol(posicion.getCoordenadaCol() + 1);
                }
                break;
        }
    }

    public Posicion getPosicion() {
        return posicion;
    }
}
