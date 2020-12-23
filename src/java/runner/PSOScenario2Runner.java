package runner;

public class PSOScenario2Runner extends PSOBaseRunner
{
	//Number of times we will change bestValues
	private static final int ITERATIONS = 5;
	// number of times each group of values is run by algorithm to generate average
	private static final int NUM_RUNS = 5;

	private static final int POP_SIZE = 1000;
	private static final int NUM_ITER = 1000;

	public static void main(final String[] args)
	{
		PSOScenario2Runner runner = new PSOScenario2Runner();

		runner.runPSOAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE, NUM_ITER);
	}
}
