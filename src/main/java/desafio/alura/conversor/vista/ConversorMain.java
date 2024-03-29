package desafio.alura.conversor.vista;

import desafio.alura.conversor.enums.TiposTemperaturas;
import desafio.alura.conversor.enums.monedas;
import desafio.alura.conversor.utilidades.*;

import javax.swing.*;
import java.io.IOException;

public class ConversorMain {

    //Este es el meto que nos desplega el menu para realizar las converciones de las monedas y temperatures
    public void MenuConversor() throws IOException {
        ConvertirMonedasImplem implem = new ConvertirMonedasImplem();
        String mensaje = "";
        int respuesta = 0;
        JLabel label = new JLabel("=>");
        ConvertirMonedasImplem convertirMonedasImplem = new ConvertirMonedasImplem();
        ConversorTemperaturaImp conversorTemperaturaImp = new ConversorTemperaturaImp();
        identificadorDeHora hora = new identificadorDeHora();
        mensaje = hora.obtenerSaludoSegunHora();
        JOptionPane.showMessageDialog(null, mensaje + " BIENVENIDO A ESTA APP", "APLICACION DE CONVERCION",
                JOptionPane.INFORMATION_MESSAGE);
        //qui use un ciclo Do-While para que al final de cada operacion me pregunto se deseo seguir
        do {
            JPanel panel = new JPanel();
            //aqui defino opciones como mi lista para despues integrarla al comboBox
            //de la misma manera para toddos los demas comboBox
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
                    //aqui tuve que definir dos panel por que se repetia las listas y daben un especi de error
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
                        double convertedTemp = conversorTemperaturaImp.convertirTemperatura(amount, fromTemperature,
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
        //aqui cierra el ciclo si la respues es no de lo contrario seguira preguntando
        JOptionPane.showMessageDialog(null, "¡Adiós!");
    }

}
