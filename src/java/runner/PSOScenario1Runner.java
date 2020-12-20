package runner;

public class PSOScenario1Runner extends PSOBaseRunner{
	//Number of times we will change bestValues
	private static final int ITERATIONS = 20;
	// number of times each group of values is run by algorithm to generate average
	private static final int NUM_RUNS = 10;

	private static final int[][] POP_SIZE_NUM_ITERATION_COMPARISON = {
			{25, 400},
			{100, 100},
			{250, 40},
			{1000, 10},
			{2500, 4},
			{10000, 1},
			{2000, 5},
			{400, 25},
			{40, 250}
	};
	public static void main(final String[] args)
	{
		PSOScenario1Runner runner = new PSOScenario1Runner();

		for(int i = 0; i < POP_SIZE_NUM_ITERATION_COMPARISON.length; i++)
		{
			runner.runPSOAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE_NUM_ITERATION_COMPARISON[i][0],
					POP_SIZE_NUM_ITERATION_COMPARISON[i][1]);
		}
	}

}
