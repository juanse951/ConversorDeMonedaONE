import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
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

        double tasaCambio = tipoDeCambio.conversion_rates().get(divisaDestino);
        double equivalencia = cantidad * tasaCambio;
        String mensaje = ("La cantidad: " + String.format("%.2f", cantidad) + " " + divisaBase + " Equivale a: " + String.format("%.2f", equivalencia) + " " + divisaDestino + "\n");

        tasasLista.add(mensaje);
        System.out.println(mensaje);
        //System.out.println(tasasLista); //para ver la lista

        try(FileWriter escritura = new FileWriter("historial.txt", true)){
            escritura.write(mensaje);
         }
        }
    }
