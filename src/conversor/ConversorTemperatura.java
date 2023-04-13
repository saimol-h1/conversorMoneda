package conversor;

public class ConversorTemperatura {
    private static final double FAHRENHEIT_A_CELSIUS = 0.55555555556;
    private static final double KELVIN_A_CELSIUS = 273.15;


    public static double convertirACualquierUnidadDesdeCelsius(String unidadDestino, double cantidad) {
        double temperaturaIntermedia = 0;
        switch (unidadDestino) {
            case "Fahrenheit":
                temperaturaIntermedia = cantidad * 1.8 + 32;
                break;
            case "Kelvin":
                temperaturaIntermedia = cantidad + KELVIN_A_CELSIUS;
                break;
            default:
                temperaturaIntermedia = cantidad;
                break;
        }
        return temperaturaIntermedia;
    }

    public static double convertirACelsiusDesdeCualquierUnidad(String unidadOrigen, double cantidad) {
        double temperaturaIntermedia = 0;
        switch (unidadOrigen) {
            case "Fahrenheit":
                temperaturaIntermedia = (cantidad - 32) * FAHRENHEIT_A_CELSIUS;
                break;
            case "Kelvin":
                temperaturaIntermedia = cantidad - KELVIN_A_CELSIUS;
                break;
            default:
                temperaturaIntermedia = cantidad;
                break;
        }
        return temperaturaIntermedia;
    }

}
