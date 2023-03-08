package desafio.alura.conversor.utilidades;

public class ConversorTemperatura {

    public double convertirTemperatura(double cantidad, TiposTemperaturas fromTemperature, TiposTemperaturas toTemperature) {
        double temperaturaConvertida = 0.0;
        switch (fromTemperature) {
            case CELSIUS:
                if (toTemperature == TiposTemperaturas.FAHRENHEIT) {
                    temperaturaConvertida = (cantidad * 1.8) + 32;
                }
                break;
            case FAHRENHEIT:
                if (toTemperature == TiposTemperaturas.CELSIUS) {
                    temperaturaConvertida = (cantidad - 32) / 1.8;
                }
                break;
        }
        return temperaturaConvertida;
    }



}
