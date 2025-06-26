public class ConvertidorDeMoneda {

    private final BuscarConversion buscador = new BuscarConversion();

    public double convertir(String monedaOrigen, String monedaDestino, double cantidad) {
        double tasa = buscador.obtenerTasa(monedaOrigen, monedaDestino).conversion_rate();
        if (tasa == 0.0) {
            System.out.println("No se pudo obtener la tasa de conversión.");
            return 0.0;
        }
        return cantidad * tasa;
    }
}
