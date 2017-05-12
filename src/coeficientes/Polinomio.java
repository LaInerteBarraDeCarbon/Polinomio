package coeficientes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Polinomio {
	private int grado;
	private double[] coeficientes;

	// Constuctor por defecto.
	public Polinomio() {
		coeficientes = new double[0];
		coeficientes[0] = 0;
		grado = 0;
	}

	// Constructor a partir de un vector
	public Polinomio(String arg) {
		Scanner sc = null;
		try {
			sc = new Scanner(new File(arg));
			this.grado = sc.nextInt();
			this.coeficientes = new double[grado + 1]; // por el termino independiente
			for (int i = 0; i < grado + 1; i++) {
				coeficientes[i] = sc.nextDouble();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		sc.close();
	}

	double evaluarMSucesivas(double x) {

	}

	double evaluarRecursiva(double x) {
		double resultado = 0;
		for(int i = 0; i <= this.grado; i++){
			resultado += this.coeficientes[i] * potencia(x, this.grado-i);
		}
		return resultado;
	}
	
	double potencia(double x, int n){
		if(n > 1)
			return x * potencia(x, n-1);
		else
			if(n == 1)
				return x;
			else
				return 1;
	}

	double evaluarRecursivaPar(double x) {

	}

	double evaluarProgDinamica(double x) {

	}

	double evaluarMejorada(double x) {

	}

	double evaluarPow(double x) {

	}

	double evaluarHorner(double x) {

	}
}
