package runner;

public class GAScenario2Runner extends GABaseRunner{
	//Number of times we will change bestValues
	private static final int ITERATIONS = 5;
	// number of times each group of values is run by algorithm to generate average
	private static final int NUM_RUNS = 5;

	private static final int POP_SIZE = 1000;
	private static final int NUM_ITER = 1000;

	public static void main(final String[] args)
	{
		GAScenario2Runner runner = new GAScenario2Runner();

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
