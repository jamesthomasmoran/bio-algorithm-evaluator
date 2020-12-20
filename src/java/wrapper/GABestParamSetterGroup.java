package wrapper;

public class GABestParamSetterGroup
{
	private GABestParamSetter meanProbSetter;
	private GABestParamSetter probCrossoverSetter;
	private GABestParamSetter probMutationSetter;
	private GABestParamSetter numSurvivorsSetter;
	private GABestParamSetter tournamentSizeSetter;

	public GABestParamSetterGroup(GABestParamSetter meanProbSetter, GABestParamSetter probCrossoverSetter,
			GABestParamSetter probMutationSetter, GABestParamSetter numSurvivorsSetter,
			GABestParamSetter tournamentSizeSetter)
	{
		this.meanProbSetter = meanProbSetter;
		this.probCrossoverSetter = probCrossoverSetter;
		this.probMutationSetter = probMutationSetter;
		this.numSurvivorsSetter = numSurvivorsSetter;
		this.tournamentSizeSetter = tournamentSizeSetter;
	}

	public GABestParamSetter getMeanProbSetter()
	{
		return meanProbSetter;
	}

	public GABestParamSetter getProbCrossoverSetter()
	{
		return probCrossoverSetter;
	}

	public GABestParamSetter getProbMutationSetter()
	{
		return probMutationSetter;
	}

	public GABestParamSetter getNumSurvivorsSetter()
	{
		return numSurvivorsSetter;
	}

	public GABestParamSetter getTournamentSizeSetter()
	{
		return tournamentSizeSetter;
	}
}
