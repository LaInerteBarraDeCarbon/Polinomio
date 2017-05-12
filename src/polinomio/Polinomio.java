package polinomio;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Polinomio {
	private int grado;
	private double[] coeficientes;
	
	public Polinomio(String arg) throws FileNotFoundException{
		Scanner sc= new Scanner (new File(arg));
		this.grado= sc.nextInt();
		this.coeficientes= new double[grado+1]; // por el termino independiente
		for(int i=0; i<= grado; i++ ){
			this.coeficientes[i]= sc.nextDouble();
		}
		sc.close();
	} 
	
	double evaluarMSucesivas(double x){
	     	double resultado = 0;
			double multi = 1;
			
			for(int i=0; i<=grado; i++)
			{ 
				for(int j=1; j<=grado-i; j++)
				{
					multi*=x;
				}
				resultado+= coeficientes[i] * multi; 
				multi=1;// tiene que volver a ser 1 para calcular de nuevo la potencia
			}
			
			return resultado;
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
	double evaluarRecursivaPar (double x){
		
	}
	
	double evaluarProgDinamica (double x){
		double multi=1;
		double resultado = coeficientes[grado]; //guardo el termino independiente 
		
		for(int i=grado-1; i>=0; i--)
		{
			multi*=x;
			resultado+= coeficientes[i] * multi; // se multiplica cada termino con el grado		}	
		return resultado;
	}
		
	}
	
	double evaluarMejorada (double x){
		
	}
	
	double evaluarPow (double x){
		
	}
	
	double evaluarHorner (double x){
		
	}
}
