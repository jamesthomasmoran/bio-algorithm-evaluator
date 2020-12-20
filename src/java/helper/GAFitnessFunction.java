package helper;

import static java.lang.Math.PI;
import static java.lang.Math.cos;

public class GAFitnessFunction
{
	private static final double A = 10;
	private static final double R = 5.12;
	private static final int N = 10;

	public static double evaluate(final double[] x) {
		double value = A*N;
		for (int i = 0; i < N; ++i) {
			value += x[i]*x[i] - A*cos(2.0*PI*x[i]);
		}

		return value;
	}
}
