import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaTasaAPI {
    public static void main(String[] args) throws IOException, InterruptedException {
        MenuConversiones.mostrarMenu();
    }

    public static void convertir(String divisaBase, String divisaDestino) throws IOException,InterruptedException {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Cantidad");
        Double cantidad = lectura.nextDouble();

        String direccion = "https://v6.exchangerate-api.com/v6/e66863d763e9ba5b6ed96c97/latest/"+ divisaBase;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        //System.out.println(json);

        Gson gson = new Gson();
        TasasDeCambio tipoDeCambio =  gson.fromJson(json, TasasDeCambio.class);

        double tasaCambio = tipoDeCambio.getConversion_rates().get(divisaDestino);
        double equivalencia = cantidad * tasaCambio;

        System.out.println(cantidad + " " + divisaBase + "Equivalen a: " + equivalencia + " " + divisaDestino);

        }
    }
