package desafio.alura.conversor.utilidades;

import java.util.Calendar;

public class identificadorDeHora {
	String saludo;
	 // Obtener la hora actual del sistema
    int horaActual = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    public  String obtenerSaludoSegunHora() {    
    	
    	if (horaActual >= 5 && horaActual < 12) {
            saludo = "Buenos días";
        } else if (horaActual >= 12 && horaActual < 20) {
            saludo = "Buenas tardes";
        } else {
            saludo = "Buenas noches";
        }
        return saludo;    	
    }

}
