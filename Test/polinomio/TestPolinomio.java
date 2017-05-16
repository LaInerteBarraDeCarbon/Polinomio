package polinomio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestPolinomio {

	private Polinomio polinomio;
	private int x = 5;
	private double esperado = 1.0987654321E10;

	@Before
	public void iniciar() {
		double[] vector = new double[this.x];
		for (int i = 0; i < this.x; i++) {
			vector[i] = this.x - i;
		}
		this.polinomio = new Polinomio(vector);
	}

	@Test
	public void testMultiplicacionSucesiva() {
		long tIni = System.nanoTime();
		double resultado = this.polinomio.evaluarMSucesivas(x);
		long tFin = System.nanoTime();
		long diff = tFin - tIni;
		//assertEquals(this.esperado, resultado, 0.0);
		System.out.println("Multiplicación sucesivas: " + diff);
	}

	@Test
	public void testRecursiva() {
		long tIni = System.nanoTime();
		double resultado = this.polinomio.evaluarRecursiva(x);
		long tFin = System.nanoTime();
		long diff = tFin - tIni;
		//assertEquals(this.esperado, resultado, 0.0);
		System.out.println("Recursiva: " + diff);
	}

	@Test
	public void testRecursivaPar() {
		long tIni = System.nanoTime();
		double resultado = this.polinomio.evaluarRecursivaPar(x);
		long tFin = System.nanoTime();
		long diff = tFin - tIni;
		//assertEquals(this.esperado, resultado, 0.0);
		System.out.println("Recursiva Par: " + diff);
	}

	@Test
	public void testDinamica() {
		long tIni = System.nanoTime();
		double resultado = this.polinomio.evaluarProgDinamica(x);
		long tFin = System.nanoTime();
		long diff = tFin - tIni;
		//assertEquals(this.esperado, resultado, 0.0);
		System.out.println("Dinámica: " + diff);
	}

	@Test
	public void testMejorada() {
		long tIni = System.nanoTime();
		double resultado = this.polinomio.evaluarMejorada(x);
		long tFin = System.nanoTime();
		long diff = tFin - tIni;
		//assertEquals(this.esperado, resultado, 0.0);
		System.out.println("Mejorada: " + diff);
	}

	@Test
	public void testPow() {
		long tIni = System.nanoTime();
		double resultado = this.polinomio.evaluarPow(x);
		long tFin = System.nanoTime();
		long diff = tFin - tIni;
		//assertEquals(this.esperado, resultado, 0.0);
		System.out.println("Pow: " + diff);
	}

	@Test
	public void testHorner() {
		long tIni = System.nanoTime();
		double resultado = this.polinomio.evaluarHorner(x);
		long tFin = System.nanoTime();
		long diff = tFin - tIni;
		//assertEquals(this.esperado, resultado, 0.0);
		System.out.println("Horner: " + diff);
	}
}
