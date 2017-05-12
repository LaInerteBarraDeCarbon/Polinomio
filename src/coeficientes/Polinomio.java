package coeficientes;

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
	public Polinomio(double[] vector) {
		// Si el vector no tiene elementos el usar este constructor equivaldrá a
		// utilizar el constructor por defecto.
		if (vector.length == 0) {
			coeficientes = new double[0];
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

	double evaluarMSucesivas(double x) {

	}

	double evaluarRecursiva(double x) {
		double resultado = 0;
		for(int i = 0; i <= this.grado; i++){
			resultado += this.coeficientes[i] * potencia(x, this.grado-i);
		}
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
