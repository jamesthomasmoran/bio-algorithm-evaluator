package runner;

public class PSOSmallSampleTestRunner extends PSOBaseRunner
{
	//Number of times we will change bestValues
	private static final int ITERATIONS = 20;
	// number of times each group of values is run by algorithm to generate average
	private static final int NUM_RUNS = 10;

	private static final int POP_SIZE = 10;
	private static final int NUM_ITER = 10;

	public static void main(final String[] args)
	{
		PSOSmallSampleTestRunner runner = new PSOSmallSampleTestRunner();

		runner.runPSOAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE, NUM_ITER);
	}

}
