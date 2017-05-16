package polinomio;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class TestPolinomioRendimiento {

	private Polinomio polinomio;
	private int x = 3;

	private static String pathIn = "Preparacion de Prueba/Lote de Prueba/Entrada/";

	@Test
	public void testGrado5() throws IOException {
		this.polinomio = new Polinomio(pathIn + "01_PolinomioSimpleGrado5.in");
		long tIni = System.nanoTime();
		double resultado = this.polinomio.evaluarRecursiva(this.x);
		long tFin = System.nanoTime();
		long diff = tFin - tIni;
		assertEquals(-107, resultado, 0.0);
		System.out.println("Polinomio grado 5: " + diff);
	}

	@Test
	public void testGrado10() throws IOException {
		this.polinomio = new Polinomio(pathIn + "02_PolinomioSimpleGrado10.in");
		long tIni = System.nanoTime();
		double resultado = this.polinomio.evaluarRecursiva(this.x);
		long tFin = System.nanoTime();
		long diff = tFin - tIni;
		assertEquals(-44292.0, resultado, 0.0);
		System.out.println("Polinomio grado 10: " + diff);
	}

	@Test
	public void testGrado16() throws IOException {
		this.polinomio = new Polinomio(pathIn + "03_PolinomioSimpleGrado16.in");
		long tIni = System.nanoTime();
		double resultado = this.polinomio.evaluarRecursiva(this.x);
		long tFin = System.nanoTime();
		long diff = tFin - tIni;
		assertEquals(6.4570081E7, resultado, 0.0);
		System.out.println("Polinomio grado 16: " + diff);
	}

	@Test
	public void testGrado50() throws IOException {
		this.polinomio = new Polinomio(pathIn + "04_PolinomioSimpleGrado50.in");
		long tIni = System.nanoTime();
		double resultado = this.polinomio.evaluarRecursiva(this.x);
		long tFin = System.nanoTime();
		long diff = tFin - tIni;
		assertEquals(8.726617828130853E24, resultado, 0.0);
		System.out.println("Polinomio grado 50: " + diff);
	}

	@Test
	public void testGrado250() throws IOException {
		this.polinomio = new Polinomio(pathIn + "05_PolinomioSimpleGrado250.in");
		long tIni = System.nanoTime();
		double resultado = this.polinomio.evaluarRecursiva(this.x);
		long tFin = System.nanoTime();
		long diff = tFin - tIni;
		assertEquals(2.31791177072516E120, resultado, 0.0);
		System.out.println("Polinomio grado 250: " + diff);
	}
	
}
