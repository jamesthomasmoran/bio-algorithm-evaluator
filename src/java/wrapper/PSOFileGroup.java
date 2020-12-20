package wrapper;

import file.FileGenerator;

import java.io.File;

public class PSOFileGroup
{
	private static final String NEIGH_WEIGHT = "neighweight";
	private static final String INERTIA_WEIGHT = "inertiaweight";
	private static final String PERSONAL_WEIGHT = "personalweight";
	private static final String GLOBAL_WEIGHT = "globalweight";
	private static final String MAX_MIN_VELOCITY = "maxminvelocity";

	private File neighWeightFile;
	private File inertiaWeightFile;
	private File personalWeightFile;
	private File globalWeightFile;
	private File maxMinVelocityFile;

	public PSOFileGroup(PSOParams bestParams){
		FileGenerator fileGenerator = new FileGenerator();

		this.neighWeightFile = fileGenerator.generateFileWithPSOHeaders(bestParams, NEIGH_WEIGHT);
		this.inertiaWeightFile = fileGenerator.generateFileWithPSOHeaders(bestParams, INERTIA_WEIGHT);
		this.personalWeightFile = fileGenerator.generateFileWithPSOHeaders(bestParams, PERSONAL_WEIGHT);
		this.globalWeightFile = fileGenerator.generateFileWithPSOHeaders(bestParams, GLOBAL_WEIGHT);
		this.maxMinVelocityFile = fileGenerator.generateFileWithPSOHeaders(bestParams, MAX_MIN_VELOCITY);
	}

	public File getNeighWeightFile()
	{
		return neighWeightFile;
	}

	public File getInertiaWeightFile()
	{
		return inertiaWeightFile;
	}

	public File getPersonalWeightFile()
	{
		return personalWeightFile;
	}

	public File getGlobalWeightFile()
	{
		return globalWeightFile;
	}

	public File getMaxMinVelocityFile()
	{
		return maxMinVelocityFile;
	}
}
