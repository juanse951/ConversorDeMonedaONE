import java.io.IOException;
import java.util.Scanner;

public class MenuConversiones {
    public static void mostrarMenu() throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);

        while (true){
            System.out.println("Menú de conversiones: ");
            System.out.println("1. USD a ARS");
            System.out.println("2. ARS a USD");
            System.out.println("3. COP a USD");
            System.out.println("4. USD a COP");
            System.out.println("5. BRL a USD");
            System.out.println("6. USD a BRL");
            System.out.println("7. Salir");
            System.out.println("Seleccione una opción: ");

            int opcion = lectura.nextInt();
            lectura.nextLine(); // consume el salto de linea

            if(opcion == 1){
                ConsultaTasaAPI.convertir("USD","ARS");
            } else if (opcion == 2) {
                ConsultaTasaAPI.convertir("ARS","USD");
            } else if (opcion == 3) {
                ConsultaTasaAPI.convertir("COP","USD");
            } else if (opcion == 4) {
                ConsultaTasaAPI.convertir("USD","COP");
            } else if (opcion == 5) {
                ConsultaTasaAPI.convertir("BRL","USD");
            } else if (opcion == 6) {
                ConsultaTasaAPI.convertir("USD","BRL");
            } else if (opcion == 7) {
                break;
            }else {
                System.out.println("Opción invalida.");
            }
        }
    }
}
