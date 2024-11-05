import java.util.Map;

public class TasasDeCambio {
    private String result;
    private String documentation;
    private String terms_of_use;
    private long time_last_update_unix;
    private String time_last_update_utc;
    private long time_next_update_unix;
    private String time_next_update_utc;
    private String base_code;
    private Map<String, Double> conversion_rates;

    public TasasDeCambio(Map<String, Double> conversion_rates, String base_code){
        this.conversion_rates = conversion_rates;
        this.base_code = base_code;
    }

    public String getResult() {
        return result;
    }

    public String getDocumentation() {
        return documentation;
    }

    public String getTerms_of_use() {
        return terms_of_use;
    }

    public long getTime_last_update_unix() {
        return time_last_update_unix;
    }

    public String getTime_last_update_utc() {
        return time_last_update_utc;
    }

    public long getTime_next_update_unix() {
        return time_next_update_unix;
    }

    public String getTime_next_update_utc() {
        return time_next_update_utc;
    }

    public String getBase_code() {
        return base_code;
    }

    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo de Divisa: ").append(base_code).append("\n");
        sb.append("Tasas de cambio:\n");

        sb.append("COP: ").append(conversion_rates.get("COP")).append("\n");
        sb.append("USD: ").append(conversion_rates.get("USD")).append("\n");
        sb.append("ARS: ").append(conversion_rates.get("ARS")).append("\n");
        sb.append("BRL: ").append(conversion_rates.get("BRL")).append("\n");

        return sb.toString();
    }
}
