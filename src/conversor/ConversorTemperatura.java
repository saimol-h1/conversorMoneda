package conversor;

public class ConversorTemperatura {
    public static double convertir(double valor, String origen, String destino) {
        double resultado = 0.0;

        if (origen.equals("Celsius")) {
            if (destino.equals("Fahrenheit")) {
                resultado = valor * 1.8 + 32.0;
            } else if (destino.equals("Kelvin")) {
                resultado = valor + 273.15;
            } else {
                resultado = valor;
            }
        } else if (origen.equals("Fahrenheit")) {
            if (destino.equals("Celsius")) {
                resultado = (valor - 32.0) / 1.8;
            } else if (destino.equals("Kelvin")) {
                resultado = (valor + 459.67) / 1.8;
            } else {
                resultado = valor;
            }
        } else if (origen.equals("Kelvin")) {
            if (destino.equals("Celsius")) {
                resultado = valor - 273.15;
            } else if (destino.equals("Fahrenheit")) {
                resultado = valor * 1.8 - 459.67;
            } else {
                resultado = valor;
            }
        } else {
            resultado = valor;
        }

        return resultado;
    }
}
