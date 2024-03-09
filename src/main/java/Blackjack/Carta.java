package Blackjack;

public class Carta {
    public enum Palo {
        TREBOL, DIAMANTES, CORAZONES, PICAS;
    }

    ;
    private int numero;
    private Palo palo;

    public int getNumero() {
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }

    public Carta(int numero, Palo palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public int getValor() {
            if (numero >= 11 && numero <= 12) {
                return 10;
            } else if (numero == 1) {
                return 11;
            } else {
                return numero;

        }
    }

    public String mostrarNumero() {
        for (int i = 0; i < numero; i++) {
            if (numero == 1) {
                return "AS";
            } else if (numero == 10) {
                return "J";
            } else if (numero == 11) {
                return "Q";
            } else if (numero == 12) {
                return "K";
            }
            else {
                return Integer.toString(numero);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "[" + numero + " - " + palo + "]";
    }
}
