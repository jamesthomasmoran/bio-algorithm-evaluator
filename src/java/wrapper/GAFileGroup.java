package wrapper;

import file.FileGenerator;

import java.io.File;

public class GAFileGroup
{
	private static final String MEAN_PROB = "meanprob";
	private static final String PROB_CROSSOVER = "probcrossover";
	private static final String PROB_MUTATION = "probmutation";
	private static final String NUM_SURVIVORS = "numsurvivors";
	private static final String TOURNAMENT_SIZE = "tournamentsize";

	private File meanProbFile;
	private File probCrossoverFile;
	private File probMutationFile;
	private File numSurvivorsFile;
	private File tournamentSizeFile;

	public GAFileGroup(GAParams bestParams){
		FileGenerator fileGenerator = new FileGenerator();

		this.meanProbFile = fileGenerator.generateFileWithGAHeaders(bestParams, MEAN_PROB);
		this.probCrossoverFile = fileGenerator.generateFileWithGAHeaders(bestParams, PROB_CROSSOVER);
		this.probMutationFile = fileGenerator.generateFileWithGAHeaders(bestParams, PROB_MUTATION);
		this.numSurvivorsFile = fileGenerator.generateFileWithGAHeaders(bestParams, NUM_SURVIVORS);
		this.tournamentSizeFile = fileGenerator.generateFileWithGAHeaders(bestParams, TOURNAMENT_SIZE);
	}

	public File getMeanProbFile()
	{
		return meanProbFile;
	}

	public File getProbCrossoverFile()
	{
		return probCrossoverFile;
	}

	public File getProbMutationFile()
	{
		return probMutationFile;
	}

	public File getNumSurvivorsFile()
	{
		return numSurvivorsFile;
	}

	public File getTournamentSizeFile()
	{
		return tournamentSizeFile;
	}
}
