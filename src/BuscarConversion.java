import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscarConversion {
    private static final String apiKey = "c028974642f448503639df27"; // tu API key

    public ConversionRate obtenerTasa(String monedaOrigen, String monedaDestino) {
        URI direccion = URI.create(
                String.format("https://v6.exchangerate-api.com/v6/%s/pair/%s/%s",
                        apiKey, monedaOrigen, monedaDestino)
        );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), ConversionRate.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro el cambio");
        }
    }
}