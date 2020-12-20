package runner;

import file.FileGenerator;
import helper.LocalFitnessCalculator;
import io.jenetics.Alterer;
import io.jenetics.DoubleGene;
import io.jenetics.GaussianMutator;
import io.jenetics.MeanAlterer;
import io.jenetics.Mutator;
import io.jenetics.SinglePointCrossover;
import io.jenetics.UniformCrossover;
import wrapper.GABestParamSetter;
import wrapper.GABestParamSetterGroup;
import wrapper.GAFileGroup;
import wrapper.GAParams;

import javax.print.DocFlavor;
import java.io.File;

public abstract class GABaseRunner
{
	private static final int DEFAULT_NUM_SURVIVORS = 1;
	private static final int DEFAULT_TOURNAMENT_SIZE = 2;
	private static final double DEFAULT_PROB_MUTATION = 0.01;
	private static final double DEFAULT_PROB_CROSSOVER = 0.30;
	private static final double DEFAULT_MEAN_PROB = 0.5;
	private static final double DEFAULT_FITNESS = -1;


	protected GAParams bestParams = new GAParams();

	protected final Alterer mutator = new Mutator(bestParams.getProbMutation());
	protected final Alterer gaussianMutator = new GaussianMutator(bestParams.getProbMutation());
	protected final Alterer uniformCrossover = new UniformCrossover(bestParams.getProbCrossover());
	protected final Alterer singlePointCrossover = new SinglePointCrossover(bestParams.getProbCrossover());
	protected final Alterer meanAlterer = new MeanAlterer(bestParams.getMeanProb());

	protected void runGAAlgorithm(int iterations, int numRuns, int popSize, int numIters, Alterer... alterers){
		setBestParams(numIters, popSize, alterers);
		runGAAlgorithmIterations(iterations, numRuns);
	}

	private void runGAAlgorithmIterations(int iterations, int numRuns){
		GAFileGroup fileGroup = new GAFileGroup(bestParams);
		LocalFitnessCalculator localFitnessCalculator = new LocalFitnessCalculator();

		GABestParamSetterGroup bestParamSetterGroup = localFitnessCalculator.generateGAParamSetters();

		for(int i = 0; i < iterations; i++){
			bestValue(fileGroup.getProbCrossoverFile(), 0.01, 0, 1, bestParamSetterGroup.getProbCrossoverSetter(), localFitnessCalculator, numRuns);
			bestValue(fileGroup.getProbMutationFile(), 0.01, 0, 1, bestParamSetterGroup.getProbMutationSetter(), localFitnessCalculator, numRuns);
			bestValue(fileGroup.getNumSurvivorsFile(),1, 1,20, bestParamSetterGroup.getNumSurvivorsSetter(), localFitnessCalculator, numRuns);
			bestValue(fileGroup.getTournamentSizeFile(), 1, 2,20, bestParamSetterGroup.getTournamentSizeSetter(), localFitnessCalculator, numRuns);
			bestValue(fileGroup.getMeanProbFile(), 0.01, 0,1, bestParamSetterGroup.getMeanProbSetter(), localFitnessCalculator, numRuns);
			printBestParametersAndFitness(Integer.toString(i + 1));
		}
		printBestParametersAndFitness("final results");
	}

	private double bestValue(File file, double increment, double start, double max, GABestParamSetter bestParamSetter, LocalFitnessCalculator localFitnessCalculator, int numRuns){

		GAParams localBest = localFitnessCalculator.findLocalBest(start, max, increment, file, new GAParams(bestParams), numRuns, bestParamSetter);
		if(localBest.getFitness() < bestParams.getFitness() || bestParams.getFitness() < 0){

			bestParams = localBest;
		}

		return bestParams.getFitness();
	}

	private void printBestParametersAndFitness(String iteration){
		System.out.println(iteration);
		System.out.println("probMutation: " + bestParams.getProbMutation());
		System.out.println("probCrossover: " + bestParams.getProbCrossover());
		System.out.println("meanProb: " + bestParams.getMeanProb());
		System.out.println("numSurvivors: " + bestParams.getNumSurvivors());
		System.out.println("tournamentSize: " + bestParams.getTournamentSize());
		System.out.println("bestFitness: " + bestParams.getFitness());
		System.out.println();
	}

	private void setBestParams(int numIter, int popSize, Alterer<DoubleGene, Double>... alterers){
		this.bestParams = new GAParams(DEFAULT_NUM_SURVIVORS, DEFAULT_TOURNAMENT_SIZE, DEFAULT_PROB_MUTATION, DEFAULT_PROB_CROSSOVER, DEFAULT_FITNESS, numIter, popSize, DEFAULT_MEAN_PROB, alterers);
	}
}
