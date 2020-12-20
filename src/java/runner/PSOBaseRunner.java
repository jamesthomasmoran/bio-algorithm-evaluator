package runner;

import helper.LocalFitnessCalculator;
import wrapper.PSOBestParamSetter;
import wrapper.PSOBestParamSetterGroup;
import wrapper.PSOFileGroup;
import wrapper.PSOParams;

import java.io.File;

public class PSOBaseRunner
{
	private static final double DEFAULT_NEIGH_WEIGHT = 1.0;
	private static final double DEFAULT_INERTIA_WEIGHT = 1.0;
	private static final double DEFAULT_PERSONAL_WEIGHT = 1.0;
	private static final double DEFAULT_GLOBAL_WEIGHT = 1.0;
	private static final double DEFAULT_MAX_MIN_VELOCITY = 0.01;
	private static final double DEFAULT_FITNESS = -1.0;


	protected PSOParams bestParams = new PSOParams();


	protected void runPSOAlgorithm(int iterations, int numRuns, int popSize, int numIters){
		setBestParams(numIters, popSize);
		runPSOAlgorithmIterations(iterations, numRuns);
	}

	private void runPSOAlgorithmIterations(int iterations, int numRuns){
		PSOFileGroup fileGroup = new PSOFileGroup(bestParams);
		LocalFitnessCalculator localFitnessCalculator = new LocalFitnessCalculator();

		PSOBestParamSetterGroup bestParamSetterGroup = localFitnessCalculator.generatePSOParamSetters();

		for(int i = 0; i < iterations; i++){
			bestValue(fileGroup.getPersonalWeightFile(), 0.01, 0, 3, bestParamSetterGroup.getPersonalWeightSetter(), localFitnessCalculator, numRuns);
			bestValue(fileGroup.getInertiaWeightFile(), 0.01, 0, 3, bestParamSetterGroup.getInertiaWeightSetter(), localFitnessCalculator, numRuns);
			bestValue(fileGroup.getNeighWeightFile(),0.01, 0,3, bestParamSetterGroup.getNeighWeightSetter(), localFitnessCalculator, numRuns);
			bestValue(fileGroup.getGlobalWeightFile(), 0.01, 0.0,3, bestParamSetterGroup.getGlobalWeightSetter(), localFitnessCalculator, numRuns);
			bestValue(fileGroup.getMaxMinVelocityFile(), 0.01, 0.01,2, bestParamSetterGroup.getMinMaxVelocitySetter(), localFitnessCalculator, numRuns);
			printBestParametersAndFitness(Integer.toString(i + 1));
		}
		printBestParametersAndFitness("final results");
	}

	private double bestValue(File file, double increment, double start, double max, PSOBestParamSetter bestParamSetter, LocalFitnessCalculator localFitnessCalculator, int numRuns){

		PSOParams localBest = localFitnessCalculator.findLocalBest(start, max, increment, file, new PSOParams(bestParams), numRuns, bestParamSetter);
		if(localBest.getFitness() < bestParams.getFitness() || bestParams.getFitness() < 0){

			bestParams = localBest;
		}

		return bestParams.getFitness();
	}

	private void printBestParametersAndFitness(String iteration){
		System.out.println(iteration);
		System.out.println("neighWeight: " + bestParams.getNeighWeight());
		System.out.println("inertiaWeight: " + bestParams.getInertiaWeight());
		System.out.println("personalWeight: " + bestParams.getPersonalWeight());
		System.out.println("globalWeight: " + bestParams.getGlobalWeight());
		System.out.println("maxMinVelocity: " + bestParams.getMaxMinVelocity());
		System.out.println("bestFitness: " + bestParams.getFitness());
		System.out.println();
	}

	private void setBestParams(int numIter, int popSize){
		this.bestParams = new PSOParams(DEFAULT_NEIGH_WEIGHT, DEFAULT_INERTIA_WEIGHT, DEFAULT_PERSONAL_WEIGHT, DEFAULT_GLOBAL_WEIGHT, DEFAULT_MAX_MIN_VELOCITY, DEFAULT_FITNESS, popSize, numIter);
	}
}
