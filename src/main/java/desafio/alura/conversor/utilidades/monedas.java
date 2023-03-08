package desafio.alura.conversor.utilidades;

public enum monedas {
	//listado de tipos de monedas

	USD("USD"),
	EUR("EUR"),
	GBP("GBP"),
	JPY("JPY"),
	CAD("CAD"),
	AUD("AUD"),
	CHF("CHF"),
	NIO("NIO"),
	CNY("CNY");

	private final String codigo;
	monedas(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigo() {
		return codigo;
	}

}
