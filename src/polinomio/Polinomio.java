package polinomio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Polinomio {
	private int grado;
	private double[] coeficientes;

	/**
	 * Construye un polinomio con grado cero. <br>
	 */
	public Polinomio() {
		coeficientes = new double[1];
		coeficientes[0] = 0;
		grado = 0;
	}

	/**
	 * Construye un polinomio desde un archivo. <br>
	 * 
	 * @param path
	 *            Direcci�n del archivo. <br>
	 * @throws IOException
	 */
	public Polinomio(String path) throws IOException {
		FileReader fr;
		BufferedReader bfInput = null;
		try {
			String linea;
			fr = new FileReader(new File(path));
			bfInput = new BufferedReader(fr);
			linea = bfInput.readLine();
			if (linea != null) {
				this.grado = Integer.parseInt(linea);
				this.coeficientes = new double[this.grado + 1];
				linea = bfInput.readLine();
				for (int i = 0; i < this.grado + 1; i++) {
					this.coeficientes[i] = Double.parseDouble(linea);
					linea = bfInput.readLine();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			bfInput.close();
		}
	}

	/**
	 * Construye un polinomio a partir de un vector. Si el vector no posee
	 * elementos crea un Polinomio por defecto, con grado cero.<br>
	 * 
	 * @param vector
	 *            Coeficientes del polinomio. <br>
	 */
	public Polinomio(double[] vector) {
		if (vector.length == 0) {
			coeficientes = new double[1];
			coeficientes[0] = 0;
			grado = 0;
		} else {
			coeficientes = new double[vector.length];
			grado = vector.length - 1;
			for (int i = 0; i < vector.length; i++) {
				coeficientes[i] = vector[i];
			}
		}
	}

	/**
	 * Resuelve un polinomio por multiplicaciones sucesivas. <br>
	 * 
	 * @param x
	 *            Valor de X. <br>
	 * @return Resultado del polinomio. <br>
	 */
	public double evaluarMSucesivas(double x) {
		double resultado = 0;
		double multi = 1;

		for (int i = 0; i <= grado; i++) {
			for (int j = 1; j <= grado - i; j++) {
				multi *= x;
			}
			resultado += coeficientes[i] * multi;
			multi = 1;// tiene que volver a ser 1 para calcular de nuevo la
						// potencia
		}
		return resultado;
	}

	/**
	 * Resuelve un polinomio con potencia recursiva. <br>
	 * 
	 * @param x
	 *            Valor de X. <br>
	 * @return Resultado del polinomio. <br>
	 */
	public double evaluarRecursiva(double x) {
		double resultado = 0;
		for (int i = 0; i <= this.grado; i++) {
			resultado += this.coeficientes[i] * potencia(x, this.grado - i);
		}
		return resultado;
	}

	/**
	 * Calcula la potencia. <br>
	 * 
	 * @param x
	 *            Valor de X. <br>
	 * @param n
	 *            Grado actual. <br>
	 * @return Potencia. <br>
	 */
	private double potencia(double x, int n) {
		if (n > 1)
			return x * potencia(x, n - 1);
		else if (n == 1)
			return x;
		else
			return 1;
	}

	/**
	 * Resuelve un polinomio con potencia recursiva. <br>
	 * Se fija el grado del polinomio si es par o impar. De ser par calcula la
	 * potencia usando (x*x,n/2), si es impar usa (x,n-1). <br>
	 * 
	 * @param x
	 *            Valor de X. <br>
	 * @return Resultado. <br>
	 */
	public double evaluarRecursivaPar(double x) {
		double resultado = 0;
		for (int i = 0; i <= this.grado; i++) {
			resultado += this.coeficientes[i] * potenciaDiferenciada(x, this.grado - i);
		}
		return resultado;
	}

	/**
	 * Calcula la potencia teniendo en cuenta si es par el grado. <br>
	 * 
	 * @param x
	 *            Valor de X. <br>
	 * @param n
	 *            Grado en el momento. <br>
	 * @return Potencia. <br>
	 */
	private double potenciaDiferenciada(double x, int n) {
		if (n > 1)
			if (n % 2 != 0)
				return x * potenciaDiferenciada(x, n - 1);
			else
				return potenciaDiferenciada(x * x, n / 2);
		else if (n == 1)
			return x;
		else
			return 1;
	}

	/**
	 * Resuelve un polinomio alamcenando las potencias de X ya calculadas. <br>
	 * 
	 * @param x
	 *            Valor de X. <br>
	 * @return Resultado. <br>
	 */
	public double evaluarProgDinamica(double x) {
		double resultados[] = new double[this.grado + 1];
		resultados[this.grado] = 1;
		double resul = this.coeficientes[this.grado];
		for (int i = this.grado - 1; i >= 0; i--) {
			resultados[i] = resultados[i + 1] * x;
			resul += this.coeficientes[i] * resultados[i];
		}
		return resul;
	}

	/**
	 * Resuelve un polinomio alamcenando las potencias de X ya calculadas de
	 * manera m�s eficiente. <br>
	 * 
	 * @param x
	 *            Valor de X. <br>
	 * @return Resultado. <br>
	 */
	public double evaluarMejorada(double x) {
		double multi = 1;
		double resultado = coeficientes[grado]; // guardo el termino
												// independiente
		for (int i = grado - 1; i >= 0; i--) {
			multi *= x;
			resultado += coeficientes[i] * multi; // se multiplica cada termino
													// con el grado
		}
		return resultado;
	}

	/**
	 * Resuelve un polinomio utilizando la funcion <i>pow</i> de la biblioteca
	 * Math. <br>
	 * 
	 * @param x
	 *            Valor de X. <br>
	 * @return Resultado. <br>
	 */
	public double evaluarPow(double x) {
		double resultado = 0;
		for (int i = 0; i <= this.grado; i++)
			resultado += this.coeficientes[i] * Math.pow(x, this.grado - i);
		return resultado;
	}

	/**
	 * Resuelve un polinomio aplicando el algoritmo de Horner de an�liis
	 * num�rico. <br>
	 * 
	 * @param x
	 *            Valor de X. <br>
	 * @return Resultado. <br>
	 */
	public double evaluarHorner(double x) {
		double resultado = this.coeficientes[0];
		for (int i = 1; i <= this.grado; i++) {
			resultado = this.coeficientes[i] + resultado * x;
		}
		return resultado;
	}

	@Override
	public String toString() {
		return "El polinomio es de grado " + grado + " con polinomio = " + Arrays.toString(coeficientes);
	}

}
