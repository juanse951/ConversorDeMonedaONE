import java.util.Map;

public record TasasDeCambio(Map<String, Double> conversion_rates, String base_code) {
}
