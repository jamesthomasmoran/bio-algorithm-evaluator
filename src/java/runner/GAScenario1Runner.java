package runner;

public class GAScenario1Runner extends GABaseRunner{
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
        GAScenario1Runner runner = new GAScenario1Runner();

        for(int i = 0; i < POP_SIZE_NUM_ITERATION_COMPARISON.length; i++)
        {
            runner.runGAAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE_NUM_ITERATION_COMPARISON[i][0], POP_SIZE_NUM_ITERATION_COMPARISON[i][1],
                    runner.mutator, runner.singlePointCrossover);

            runner.runGAAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE_NUM_ITERATION_COMPARISON[i][0], POP_SIZE_NUM_ITERATION_COMPARISON[i][1],
                    runner.mutator, runner.singlePointCrossover, runner.meanAlterer);

            runner.runGAAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE_NUM_ITERATION_COMPARISON[i][0], POP_SIZE_NUM_ITERATION_COMPARISON[i][1],
                    runner.mutator, runner.uniformCrossover);

            runner.runGAAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE_NUM_ITERATION_COMPARISON[i][0], POP_SIZE_NUM_ITERATION_COMPARISON[i][1],
                    runner.mutator, runner.uniformCrossover,
                    runner.meanAlterer);

            runner.runGAAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE_NUM_ITERATION_COMPARISON[i][0], POP_SIZE_NUM_ITERATION_COMPARISON[i][1],
                    runner.gaussianMutator, runner.singlePointCrossover);

            runner.runGAAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE_NUM_ITERATION_COMPARISON[i][0], POP_SIZE_NUM_ITERATION_COMPARISON[i][1],
                    runner.gaussianMutator, runner.singlePointCrossover, runner.meanAlterer);

            runner.runGAAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE_NUM_ITERATION_COMPARISON[i][0], POP_SIZE_NUM_ITERATION_COMPARISON[i][1],
                    runner.gaussianMutator, runner.uniformCrossover);

            runner.runGAAlgorithm(ITERATIONS, NUM_RUNS, POP_SIZE_NUM_ITERATION_COMPARISON[i][0], POP_SIZE_NUM_ITERATION_COMPARISON[i][1],
                    runner.gaussianMutator, runner.uniformCrossover, runner.meanAlterer);
        }
    }

}
