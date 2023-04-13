package conversor;

public class ConversorMoneda {
    private static final double DOLAR_A_COP = 4421.58;
    private static final double EURO_A_COP = 4890.22;
    private static final double LIBRA_A_COP = 5540.75;
    private static final double YEN_A_COP = 33.43;
    private static final double WON_A_COP = 3.40;

    public static double convertirDesdeCOP(String monedaDestino, double cantidad) {
        switch (monedaDestino) {
            case "Dólar":
                return cantidad / DOLAR_A_COP;
            case "Euro":
                return cantidad / EURO_A_COP;
            case "Libra Esterlina":
                return cantidad / LIBRA_A_COP;
            case "Yen Japonés":
                return cantidad / YEN_A_COP;
            case "Won sul-coreano":
                return cantidad / WON_A_COP;
            default:
                return 0;
        }
    }

    public static double convertirHaciaCOP(String monedaOrigen, double cantidad) {
        switch (monedaOrigen) {
            case "Dólar":
                return cantidad * DOLAR_A_COP;
            case "Euro":
                return cantidad * EURO_A_COP;
            case "Libra Esterlina":
                return cantidad * LIBRA_A_COP;
            case "Yen Japonés":
                return cantidad * YEN_A_COP;
            case "Won sul-coreano":
                return cantidad * WON_A_COP;
            default:
                return 0;
        }
    }

}
