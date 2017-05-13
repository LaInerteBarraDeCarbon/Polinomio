package polinomio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBinomioDeNewton {

	private BinomioDeNewton binomio;

	@Before
	public void iniciar() {
		binomio = new BinomioDeNewton(3, 2, 2);
	}

	@Test
	public void testResolverPolinomio() {
		Polinomio polinomio = binomio.coeficientesPolinomio();
		System.out.println(polinomio);
	}
}
