package Blackjack;

import java.util.ArrayList;

public class Mano extends Mazo{
    ArrayList<Carta> listaMano;
    public Mano(){
        listaMano = new ArrayList<Carta>();
    }
    public int valorMano(){
        int valor = 0;
        int ases = 0;
        for(Carta carta : listaMano){
            valor += carta.getValor();
            if (carta.getNumero() == 1) {
                ases++;
            }
        }

        // Manejo de los ases para evitar pasarse de 21
        while (ases > 0 && valor > 21) {
            valor -= 10;
            ases--;
        }

        return valor;
    }
    public boolean finJuego(){
        return valorMano() > 21;
        }

    @Override
    public String toString() {
        return super.toString() + "\nPuntuación de la mano: " + valorMano();
    }
    public void pedirCarta (Mazo m){
         listaMano.add(m.solicitarCarta());
    }
}

