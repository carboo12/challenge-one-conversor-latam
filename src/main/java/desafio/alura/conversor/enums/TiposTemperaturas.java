package desafio.alura.conversor.enums;

public enum TiposTemperaturas {

    //lista de tipos de temperaturas (las mas utiles XD)

    CELSIUS("CELSIUS"),
    FAHRENHEIT("FAHRENHEIT");

    private final String tipo;

    TiposTemperaturas(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }



}
