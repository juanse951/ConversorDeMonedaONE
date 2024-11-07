import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaTasaAPI {

    private static List<String> tasasLista = new ArrayList<>();

    public static void convertir(String divisaBase, String divisaDestino) throws IOException,InterruptedException {
        Scanner lectura = new Scanner(System.in);

        System.out.println("Ingrese el valor que desea convertir \nsin comas ni puntos: ");
        double cantidad = lectura.nextDouble();

        String apiKeyCodificada = URLEncoder.encode("e66863d763e9ba5b6ed96c97", StandardCharsets.UTF_8);
        String direccion = "https://v6.exchangerate-api.com/v6/"+apiKeyCodificada+"/latest/"+ divisaBase;

        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String marcaTiempo = LocalDateTime.now().format(formateador);

        String mensajeError = "";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new Gson();
            TasasDeCambio tipoDeCambio = gson.fromJson(json, TasasDeCambio.class);

            double tasaCambio = tipoDeCambio.conversion_rates().get(divisaDestino);
            double equivalencia = cantidad * tasaCambio;

            String mensaje = ("La cantidad: " + String.format("%.2f", cantidad) + " " + divisaBase + " Equivale a: " + String.format("%.2f", equivalencia) + " " + divisaDestino + "\n" +"Registro: "+ marcaTiempo + "\n");

            tasasLista.add(mensaje);
            System.out.println(mensaje);

            try (FileWriter escritura = new FileWriter("historial.txt", true)) {
                escritura.write(mensaje);
            }
        } catch (IOException e){
            mensajeError = marcaTiempo + " - Error al escribir en el archivo: " + e.getMessage() + "/n";
            tasasLista.add(mensajeError);
            System.out.println(mensajeError);

        } catch (Exception e){
            mensajeError = marcaTiempo + " - Error general: " + e.getMessage() + "/n";
            tasasLista.add(mensajeError);
            System.out.println(mensajeError);
        }

        try(FileWriter escritor = new FileWriter("historial.txt", true)){
            escritor.write(mensajeError);
        } catch (IOException e){
            System.out.println("Error al escribir el mensaje de error en el archivo: " + e.getMessage());
        }
        }
    }
