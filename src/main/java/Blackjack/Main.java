package Blackjack;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JAXBException {

        Scanner scanner = new Scanner(System.in);

        Mazo mazo1 = new Mazo();
        mazo1.barajar();

        Mano jugador = new Mano();

        while (true) {
            System.out.println("¿Quieres una carta? (s/n)");
            char respuesta = scanner.next().charAt(0);

            if (respuesta == 's') {
                jugador.pedirCarta(mazo1);
                System.out.println("Tu mano:");
                System.out.println(jugador.listaMano);
                System.out.println("Tu mano suma: " + jugador.valorMano());

                if (jugador.finJuego()) {
                    System.out.println("Te has pasado de 21. Has perdido.");
                    break;
                }
            } else if (respuesta == 'n') {
                System.out.println("Te plantas con una puntuación de " + jugador.valorMano());
                break;
            } else {
                System.out.println("Respuesta no válida. Por favor, introduce 's' o 'n'.");
            }
        }

        // Guardar el resultado en XML
        guardarResultado(jugador.valorMano());

        scanner.close();
    }

    private static void guardarResultado(int puntuacion) {
        try {
            ResultadoPartida resultadoPartida = new ResultadoPartida();
            resultadoPartida.setPuntuacion(puntuacion);

            // Serializar a XML
            JAXBContext context = JAXBContext.newInstance(ResultadoPartida.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(resultadoPartida, new File("resultado.xml"));

            // Deserializar desde XML (ejemplo)
            Unmarshaller unmarshaller = context.createUnmarshaller();
            ResultadoPartida resultadoLeido = (ResultadoPartida) unmarshaller.unmarshal(new File("resultado.xml"));

            // Resto del código...
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
