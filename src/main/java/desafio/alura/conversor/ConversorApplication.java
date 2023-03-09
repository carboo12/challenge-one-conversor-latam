package desafio.alura.conversor;

import desafio.alura.conversor.utilidades.*;
import desafio.alura.conversor.vista.ConversorMain;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.swing.*;
import java.io.IOException;


@SpringBootApplication
public class ConversorApplication {

	public static void main(String[] args) throws IOException {
		ConversorMain conversorMain = new ConversorMain();
		conversorMain.MenuConversor();
	}
}
