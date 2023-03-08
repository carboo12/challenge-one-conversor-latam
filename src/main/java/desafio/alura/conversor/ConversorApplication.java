package desafio.alura.conversor;

import desafio.alura.conversor.utilidades.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.swing.*;
import java.io.IOException;


@SpringBootApplication
public class ConversorApplication {

	public static void main(String[] args) throws IOException {
		ConvertirImplem implem = new ConvertirImplem();
		String mensaje = "";
		int respuesta = 0;
		JLabel label = new JLabel("=>");
		ConvertirImplem convertirImplem = new ConvertirImplem();
		ConversorTemperatura conversorTemperatura = new ConversorTemperatura();
		identificadorDeHora hora = new identificadorDeHora();
		mensaje = hora.obtenerSaludoSegunHora();
		JOptionPane.showMessageDialog(null, mensaje + " BIENVENIDO A ESTA APP", "APLICACION DE CONVERCION",
				JOptionPane.INFORMATION_MESSAGE);
		do {
			JPanel panel = new JPanel();
			String[] opciones = {"Convertir monedas", "Convertir temperaturas"};
			JComboBox<String> cboOpciones = new JComboBox<>(opciones);
			panel.add(cboOpciones);
			int opcion = JOptionPane.showConfirmDialog(null, panel, "¿Qué tipo de conversión deseas realizar?",
					JOptionPane.OK_CANCEL_OPTION);
			if (opcion == JOptionPane.OK_OPTION) {
				if (cboOpciones.getSelectedItem().equals("Convertir monedas")) {
					String amountString = JOptionPane.showInputDialog(null,
							"Ingrese la cantidad de dinero a convertir:", "Conversor de Moneda",
							JOptionPane.QUESTION_MESSAGE);
					JPanel panel2 = new JPanel();
					double amount = Double.parseDouble(amountString);
					JComboBox<monedas> cboMonedaOrigen = new JComboBox<>(monedas.values());
					panel2.add(cboMonedaOrigen);
					panel2.add(label);
					JComboBox<monedas> cboMonedaDestino = new JComboBox<>(monedas.values());
					panel2.add(cboMonedaDestino);
					int resultado = JOptionPane.showConfirmDialog(null, panel2, "Introduce los datos de la conversión",
							JOptionPane.OK_CANCEL_OPTION);
					if (resultado == JOptionPane.OK_OPTION) {
						monedas fromCurrency = (monedas) cboMonedaOrigen.getSelectedItem();
						monedas toCurrency = (monedas) cboMonedaDestino.getSelectedItem();
						double convertedAmount = implem.callApi(amount, fromCurrency, toCurrency);
						JOptionPane.showMessageDialog(null,
								String.format("%,.2f %s = %,.2f %s", amount, fromCurrency, convertedAmount, toCurrency),
								"Conversor de Moneda", JOptionPane.INFORMATION_MESSAGE);
					}
				} else if (cboOpciones.getSelectedItem().equals("Convertir temperaturas")) {
					String amountString = JOptionPane.showInputDialog(null,
							"Ingrese la cantidad de temperatura a convertir:", "Conversor de Temperatura",
							JOptionPane.QUESTION_MESSAGE);
					double amount = Double.parseDouble(amountString);
					JComboBox<TiposTemperaturas> cboTemperaturaOrigen = new JComboBox<>(TiposTemperaturas.values());
					panel.add(cboTemperaturaOrigen);
					JComboBox<TiposTemperaturas> cboTemperaturaDestino = new JComboBox<>(TiposTemperaturas.values());
					panel.add(cboTemperaturaDestino);
					int resultado = JOptionPane.showConfirmDialog(null, panel, "Introduce los datos de la conversión",
							JOptionPane.OK_CANCEL_OPTION);
					if (resultado == JOptionPane.OK_OPTION) {
						TiposTemperaturas fromTemperature = (TiposTemperaturas) cboTemperaturaOrigen.getSelectedItem();
						TiposTemperaturas toTemperature = (TiposTemperaturas) cboTemperaturaDestino.getSelectedItem();
						double convertedTemp = conversorTemperatura.convertirTemperatura(amount, fromTemperature,
								toTemperature);
						JOptionPane.showMessageDialog(null,
								String.format("%,.2f %s = %,.2f %s", amount,
										fromTemperature, convertedTemp, toTemperature),
								"Conversor de Temperatura", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "¡Hasta pronto!", "APLICACION DE CONVERCION",
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
			respuesta = JOptionPane.showConfirmDialog(null, "¿Desea realizar otra conversión?", "Continuar",
					JOptionPane.YES_NO_OPTION);
		}while (respuesta == JOptionPane.YES_OPTION);
		JOptionPane.showMessageDialog(null, "¡Adiós!");
	}
}
