package polinomio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BinomioDeNewton {

	private int valorA;
	private int valorB;
	private int valorN;

	/**
	 * Crea un Binomio de Newton. Formato: (ax+b)^n <br>
	 * 
	 * @param valorA
	 *            Valor de A. <br>
	 * @param valorB
	 *            Valor de B. <br>
	 * @param valorN
	 *            Valor de N. <br>
	 */
	public BinomioDeNewton(final int valorA, final int valorB, final int valorN) {
		this.valorA = valorA;
		this.valorB = valorB;
		this.valorN = valorN;
	}

	public BinomioDeNewton(final String path) throws IOException {
		FileReader fr;
		BufferedReader bfInput = null;
		try {
			String linea;
			fr = new FileReader(new File(path));
			bfInput = new BufferedReader(fr);
			linea = bfInput.readLine();
			if (linea != null) {
				this.valorA = Integer.parseInt(linea);
				linea = bfInput.readLine();
				this.valorB = Integer.parseInt(linea);
				linea = bfInput.readLine();
				this.valorN = Integer.parseInt(linea);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			bfInput.close();
		}
	}

	/**
	 * 
	 * @param k
	 * @return Coeficiente de K. <br>
	 */
	public double coeficienteK(int k) {
		return 0.0;
	}

	/**
	 * Resuelve un Binomio de Newton en un polinomio. <br>
	 * 
	 * @param grado
	 *            Grado del polinomio. <br>
	 * @return Polinomio. <br>
	 */
	public Polinomio coeficientesPolinomio() {
		double[] vector = new double[this.valorN];
		double[][] matriz = new double[this.valorN + 1][this.valorN + 1];
		for (int i = 0; i <= this.valorN; i++) {
			matriz[i][0] = 1;
			matriz[i][i] = 1;
			for (int j = 1; j < i; j++) {
				matriz[i][j] = matriz[i - 1][j - 1] + matriz[i - 1][j];
			}
		}
		int j = this.valorN;
		int i = 0;
		while (j >= 0) {
			matriz[this.valorN][i] *= Math.pow(this.valorA, j) * Math.pow(this.valorB, i);
			i++;
			j--;
		}
		vector = matriz[this.valorN];
		return new Polinomio(vector);
	}

}
