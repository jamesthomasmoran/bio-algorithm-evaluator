package helper;

import algorithm.GAAlgorithm;
import algorithm.PSOAlgorithm;
import file.DataFileWriter;
import io.jenetics.GaussianMutator;
import io.jenetics.MeanAlterer;
import io.jenetics.Mutator;
import io.jenetics.SinglePointCrossover;
import io.jenetics.UniformCrossover;
import wrapper.GABestParamSetter;
import wrapper.GABestParamSetterGroup;
import wrapper.GAParams;
import wrapper.PSOBestParamSetter;
import wrapper.PSOBestParamSetterGroup;
import wrapper.PSOParams;

import java.io.File;

public class LocalFitnessCalculator
{
	private static final String MUTATOR = "Mutator";
	private static final String GAUSSIAN_MUTATOR = "GaussianMutator";
	private static final String MEAN_ALTERER = "MeanAlterer";
	private static final String SINGLE_POINT_CROSSOVER = "SinglePointCrossover";
	private static final String UNIFORM_CROSSOVER = "UniformCrossover";

	public GAParams findLocalBest(double start, double max, double increment, File file, GAParams localBest, int numRuns, GABestParamSetter bestParamSetter){
		GAAlgorithm alg = new GAAlgorithm();
		GAParams local = new GAParams(localBest);
		DataFileWriter dataFileWriter = new DataFileWriter();

		for(double i = start; i <= max; i += increment){
			local = bestParamSetter.setBestValue(local, i);
			alg.setParams(local);

			GAParams average = averageFitnessCalculation(local, alg, numRuns);

			dataFileWriter.writeResultToFile(file, average);
			if(average.getFitness() < localBest.getFitness() || localBest.getFitness() < 0){
				localBest = new GAParams(average);
				localBest.setFitness(average.getFitness());
			}
		}
		return localBest;
	}

	private GAParams averageFitnessCalculation(GAParams params, GAAlgorithm alg, int numRuns){

		GAParams average = params;
		average.setFitness(0);
		for(int i = 0; i < numRuns; i++){
			GAParams lastRun = alg.run();
			average.setFitness(average.getFitness() + lastRun.getFitness());
			average.setTimeTaken(average.getTimeTaken() + lastRun.getTimeTaken());
		}
		average.setFitness(average.getFitness() / numRuns);
		average.setTimeTaken(average.getTimeTaken() / numRuns);
		return  average;
	}

	public GABestParamSetterGroup generateGAParamSetters(){

		GABestParamSetter meanProbSetter = (params, val) -> {
			params.setMeanProb(val.doubleValue());

			for(int i = 0; i < params.getAlterers().length; i++){
				if(params.getAlterers()[i].getClass().getSimpleName().equals(MEAN_ALTERER)){
					params.getAlterers()[i] = new MeanAlterer(val.doubleValue());
				}
			}
			return params;
		};

		GABestParamSetter probCrossoverSetter = (params, val) -> {
			params.setProbCrossover(val.doubleValue());

			for(int i = 0; i < params.getAlterers().length; i++){
				if(params.getAlterers()[i].getClass().getSimpleName().equals(UNIFORM_CROSSOVER)){
					params.getAlterers()[i] = new UniformCrossover(val.doubleValue());
				}
				else if(params.getAlterers()[i].getClass().getSimpleName().equals(SINGLE_POINT_CROSSOVER)){
					params.getAlterers()[i] = new SinglePointCrossover(val.doubleValue());
				}
			}
			return params;
		};

		GABestParamSetter probMutationSetter = (params, val) -> {
			params.setProbMutation(val.doubleValue());

			for(int i = 0; i < params.getAlterers().length; i++){
				if(params.getAlterers()[i].getClass().getSimpleName().equals(MUTATOR)){
					params.getAlterers()[i] = new Mutator(val.doubleValue());
				}
				else if(params.getAlterers()[i].getClass().getSimpleName().equals(GAUSSIAN_MUTATOR)){
					params.getAlterers()[i] = new GaussianMutator(val.doubleValue());
				}
			}
			return params;
		};

		GABestParamSetter numSurvivorsSetter = (params, i) -> {
			params.setNumSurvivors(i.intValue());
			return params;
		};

		GABestParamSetter tournamentSizeSetter = (params, i) -> {
			params.setTournamentSize(i.intValue());
			return params;
		};

		return new GABestParamSetterGroup(meanProbSetter, probCrossoverSetter, probMutationSetter, numSurvivorsSetter, tournamentSizeSetter);
	}

	public PSOParams findLocalBest(double start, double max, double increment, File file, PSOParams localBest, int numRuns, PSOBestParamSetter bestParamSetter){
		PSOAlgorithm alg = new PSOAlgorithm();
		PSOParams local = new PSOParams(localBest);
		DataFileWriter dataFileWriter = new DataFileWriter();

		for(double i = start; i <= max; i += increment){
			local = bestParamSetter.setBestValue(local, i);
			alg.setParams(local);

			PSOParams average = averageFitnessCalculation(local, alg, numRuns);

			dataFileWriter.writeResultToFile(file, average);
			if(average.getFitness() < localBest.getFitness() || localBest.getFitness() < 0){
				localBest = new PSOParams(average);
				localBest.setFitness(average.getFitness());
			}
		}
		return localBest;
	}

	private PSOParams averageFitnessCalculation(PSOParams params, PSOAlgorithm alg, int numRuns){

		PSOParams average = params;
		average.setFitness(0);
		for(int i = 0; i < numRuns; i++){
			PSOParams lastRun = alg.run();
			average.setFitness(average.getFitness() + lastRun.getFitness());
			average.setTimeTaken(average.getTimeTaken() + lastRun.getTimeTaken());
		}
		average.setFitness(average.getFitness() / numRuns);
		average.setTimeTaken(average.getTimeTaken() / numRuns);
		return  average;
	}

	public PSOBestParamSetterGroup generatePSOParamSetters(){

		PSOBestParamSetter neighWeightSetter = (params, val) -> {
			params.setNeighWeight(val.doubleValue());
			return params;
		};

		PSOBestParamSetter inertiaWeightSetter = (params, val) -> {
			params.setInertiaWeight(val.doubleValue());
			return params;
		};

		PSOBestParamSetter personalWeightSetter = (params, val) -> {
			params.setPersonalWeight(val.doubleValue());
			return params;
		};

		PSOBestParamSetter globalWeightSetter = (params, i) -> {
			params.setGlobalWeight(i.intValue());
			return params;
		};

		PSOBestParamSetter maxMinVelocitySetter = (params, i) -> {
			params.setMaxMinVelocity(i.intValue());
			return params;
		};
		return new PSOBestParamSetterGroup(neighWeightSetter, personalWeightSetter, inertiaWeightSetter,globalWeightSetter, maxMinVelocitySetter);
	}
}
