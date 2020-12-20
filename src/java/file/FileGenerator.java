package file;

import wrapper.GAParams;
import wrapper.PSOParams;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileGenerator
{
	private static final String GA_HEADERS = "popSize,NumIter,alterers,numSurvivors,tournamentSize,probMutation,probCrossover,meanProb,fitness,timeTaken";
	private static final String PSO_HEADERS = "numParticles,numIter,neighWeight,inertiaWeight,personalWeight,globalWeight,maxMinVelocity,fitness,timeTaken";

	private static final Map<String, String> ALTERER_CLASS_MAP = new HashMap<String, String>(){{
		put("Mutator", "mutator");
		put("GaussianMutator", "gaussianmutator");
		put("UniformCrossover", "uniformcrossover");
		put("SinglePointCrossover", "singlepointcrossover");
		put("MeanAlterer","meanalterer");
	}};


	public File generateFileWithGAHeaders(GAParams params, String changingParam)
	{
		return generateFile(GAFileNameGenerator(params, changingParam), GA_HEADERS);
	}

	public File generateFileWithPSOHeaders(PSOParams params, String changingParam)
	{
		return generateFile(PSOFileNameGenerator(params, changingParam), PSO_HEADERS);
	}

	private File generateFile(String filename, String headers){
		File file = new File(filename);
		file.getParentFile().mkdirs();
		if (!file.exists())
		{
			try
			{
				file.createNewFile();
				FileWriter fw = new FileWriter(file, true);

				//BufferedWriter writer give better performance
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(headers);
				bw.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return file;
	}

	private String GAFileNameGenerator(GAParams params, String changingParam){
		String alterers = createAltererString(params);
		return "output/ga/" + params.getPopSize() + "x" + params.getNumIter() + "/" + alterers + "/ga-" + params.getPopSize() + "x" + params.getNumIter() + alterers + "-" + changingParam + ".csv";
	}

	private String PSOFileNameGenerator(PSOParams params, String changingParam){
		return "output/pso/" + params.getNumParticles() + "x" + params.getNumIter() + "/pso-" + params.getNumIter() + "x" + params.getNumIter() + "-" + changingParam+ ".csv";
	}

	private String createAltererString(GAParams params){
		String alterers = "";
		for(int i = 0; i < params.getAlterers().length; i++){
			alterers += "-" + ALTERER_CLASS_MAP.get(params.getAlterers()[i].getClass().getSimpleName());
		}
		return alterers;
	}

}
