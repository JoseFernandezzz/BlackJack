package Blackjack;

import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    public ArrayList<Carta> baraja;

    public Mazo () {
        baraja = new ArrayList<Carta>();
        for (Carta.Palo p : Carta.Palo.values())
            for (int numero = 1; numero <= 12; numero++) {
                baraja.add(new Carta(numero, p));
            }
    }
    public void barajar(){
            Collections.shuffle(baraja);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Carta carta : baraja) {
            result.append(carta.toString()).append("\n");
        }
        return result.toString();
    }
    public Carta solicitarCarta(){
        if (baraja.isEmpty()) {
            throw new IllegalStateException("No hay cartas en el mazo");
        }

        return baraja.remove(0);
    }
}

