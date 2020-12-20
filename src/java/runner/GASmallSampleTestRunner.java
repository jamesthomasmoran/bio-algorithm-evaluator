package runner;

public class GASmallSampleTestRunner extends GABaseRunner
{
	//Number of times we will change bestValues
	private static final int ITERATIONS = 10;
	// number of times each group of values is run by algorithm to generate average
	private static final int NUM_RUNS = 10;

	private static final int POP_SIZE = 100;
	private static final int NUM_ITER = 100;

	public static void main(final String[] args)
	{
		GASmallSampleTestRunner runner = new GASmallSampleTestRunner();

		runner.runGAAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE, NUM_ITER,
				runner.mutator, runner.singlePointCrossover);

		runner.runGAAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE, NUM_ITER,
				runner.mutator, runner.singlePointCrossover, runner.meanAlterer);

		runner.runGAAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE, NUM_ITER,
				runner.mutator, runner.uniformCrossover);

		runner.runGAAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE, NUM_ITER,
				runner.mutator, runner.uniformCrossover, runner.meanAlterer);

		runner.runGAAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE, NUM_ITER,
				runner.gaussianMutator, runner.singlePointCrossover);

		runner.runGAAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE, NUM_ITER,
				runner.gaussianMutator, runner.singlePointCrossover, runner.meanAlterer);

		runner.runGAAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE, NUM_ITER,
				runner.gaussianMutator, runner.uniformCrossover);

		runner.runGAAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE, NUM_ITER,
				runner.gaussianMutator, runner.uniformCrossover, runner.meanAlterer);

	}
}
