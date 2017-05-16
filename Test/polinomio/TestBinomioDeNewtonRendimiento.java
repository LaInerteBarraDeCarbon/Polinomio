package polinomio;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class TestBinomioDeNewtonRendimiento {

	private BinomioDeNewton binomio;
	private int x = 3;

	private static String pathIn = "Preparacion de Prueba/Lote de Prueba/Entrada/";

	@Test
	public void testGrado5() throws IOException {
		this.binomio = new BinomioDeNewton(pathIn + "06_BinomioNewtonExp2.in");
		long tIni = System.nanoTime();
		double resultado = this.binomio.coeficienteK(x);
		long tFin = System.nanoTime();
		long diff = tFin - tIni;
		assertEquals(-107, resultado, 0.0);
		System.out.println("Binomio exponente 2: " + diff);
	}
}