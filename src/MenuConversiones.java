import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConversiones {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);

        while (true){
            System.out.println("Menú de conversiones: ");
            System.out.println("1. Dólar => Peso Argentino");
            System.out.println("2. Peso Argentino => Dólar");
            System.out.println("3. Peso Colombiano => Dólar");
            System.out.println("4. Dólar => Peso Colombiano");
            System.out.println("5. Real Brasileño => Dólar");
            System.out.println("6. Dólar => Real Brasileño");
            System.out.println("7. Yuan Chino => Dólar");
            System.out.println("8. Dólar => Yuan Chino");
            System.out.println("9. Euro => Dólar");
            System.out.println("10. Dólar => Euro");

            System.out.println("11. Salir");
            System.out.println("Seleccione una opción válida: ");
            System.out.println("*******************************************");

            try{
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
                    ConsultaTasaAPI.convertir("CNY","USD");
                } else if (opcion == 8) {
                    ConsultaTasaAPI.convertir("USD","CNY");
                } else if (opcion == 9) {
                    ConsultaTasaAPI.convertir("EUR","USD");
                } else if (opcion == 10) {
                    ConsultaTasaAPI.convertir("USD","EUR");
                } else if (opcion == 11) {
                    break;
                }else {
                    System.out.println("Opción invalida.");
                }
            }catch (InputMismatchException e){
                System.out.println("Ocurrio un error de tipo: "+ e.getMessage());
                System.out.println("Finalizó la ejecución del programa.");
                break;
            }catch (Exception e) {
                System.out.println("Ocurrio un error inesperado de tipo: " + e.getMessage());
                System.out.println("Finalizó la ejecución del programa.");
                break;

            }
        }
    }
}
