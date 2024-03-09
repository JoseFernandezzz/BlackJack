package Blackjack;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResultadoPartida {

    private int puntuacion;
    private Mano manoJugador;

    // Constructor por defecto necesario para JAXB
    public ResultadoPartida() {
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    @XmlElement
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    public void setManoJugador(Mano manoJugador) {
        this.manoJugador = manoJugador;
    }
}