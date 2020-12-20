package file;

import wrapper.GAParams;
import wrapper.PSOParams;

public class DataExtraction
{
	public String printGAResults(GAParams params){

		return "\n" + params.getPopSize() + "," + params.getNumIter() + "," + params.getAlterersString() + "," + params.getNumSurvivors() +
				"," + params.getTournamentSize() + "," + params.getProbMutation() + "," + params.getProbCrossover() +
				"," + params.getMeanProb() + "," + params.getFitness() + "," + params.getTimeTaken();
	}

	public String printPSOResults(PSOParams params){

		System.out.println(params.getTimeTaken());
		return "\n" + params.getNumIter() + "," + params.getNumIter() + "," + params.getNeighWeight() +
				"," + params.getInertiaWeight() + "," + params.getPersonalWeight() +","+params.getGlobalWeight() + "," +
				params.getMaxMinVelocity() + "," + params.getFitness() + "," + params.getTimeTaken();

	}
}
