package coeficientes;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestPolinomio {

	private Polinomio polinomio;
	private int x = 10;
	private double esperado = 1.0987654321E10;

	@Before
	public void iniciar() {
		double[] vector = new double[this.x];
		for (int i = 0; i < this.x; i++) {
			vector[i] = this.x - i;
		}
		this.polinomio = new Polinomio(vector);
	}

	@Ignore
	public void testMultiplicacionSucesiva() {
		Calendar tIni = new GregorianCalendar();
		double resultado = this.polinomio.evaluarMSucesivas(x);
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		assertEquals(this.esperado, resultado, 0.0);
		System.out.println("--Multiplicación Sucesiva: \n" + this.polinomio + "\nEl valor " + this.x
				+ " da como resultado: " + resultado + "\nTiempo: " + diff);
	}

	@Ignore
	public void testRecursiva() {
		Calendar tIni = new GregorianCalendar();
		double resultado = this.polinomio.evaluarRecursiva(this.x);
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		assertEquals(this.esperado, resultado, 0.0);
		System.out.println("--Recursiva: \n" + this.polinomio + "\nEl valor " + this.x + " da como resultado: "
				+ resultado + "\nTiempo: " + diff);
	}

	@Ignore
	public void testRecursivaPar() {
		Calendar tIni = new GregorianCalendar();
		double resultado = this.polinomio.evaluarRecursivaPar(this.x);
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		assertEquals(this.esperado, resultado, 0.0);
		System.out.println("--Recursiva Par: \n" + this.polinomio + "\nEl valor " + this.x + " da como resultado: "
				+ resultado + "\nTiempo: " + diff);
	}

	@Test
	public void testDinamica() {
		Calendar tIni = new GregorianCalendar();
		double resultado = this.polinomio.evaluarProgDinamica(this.x);
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		assertEquals(this.esperado, resultado, 0.0);
		System.out.println("--Prog Dinámica: \n" + this.polinomio + "\nEl valor " + this.x + " da como resultado: "
				+ resultado + "\nTiempo: " + diff);
	}

	@Ignore
	public void testMejorada() {
		Calendar tIni = new GregorianCalendar();
		double resultado = this.polinomio.evaluarMejorada(this.x);
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		assertEquals(this.esperado, resultado, 0.0);
		System.out.println("--Mejorada: \n" + this.polinomio + "\nEl valor " + this.x + " da como resultado: "
				+ resultado + "\nTiempo: " + diff);
	}

	@Test
	public void testPow() {
		Calendar tIni = new GregorianCalendar();
		double resultado = this.polinomio.evaluarPow(this.x);
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		assertEquals(this.esperado, resultado, 0.0);
		System.out.println("--Pow: \n" + this.polinomio + "\nEl valor " + this.x + " da como resultado: " + resultado
				+ "\nTiempo: " + diff);
	}

	@Ignore
	public void testHorner() {
		Calendar tIni = new GregorianCalendar();
		double resultado = this.polinomio.evaluarHorner(this.x);
		Calendar tFin = new GregorianCalendar();
		long diff = tFin.getTimeInMillis() - tIni.getTimeInMillis();
		assertEquals(this.esperado, resultado, 0.0);
		System.out.println("--Horner: \n" + this.polinomio + "\nEl valor " + this.x + " da como resultado: " + resultado
				+ "\nTiempo: " + diff);
	}
}
