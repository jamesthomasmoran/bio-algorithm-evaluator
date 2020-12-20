package wrapper;

public class PSOBestParamSetterGroup
{
	private PSOBestParamSetter neighWeightSetter;
	private PSOBestParamSetter personalWeightSetter;
	private PSOBestParamSetter inertiaWeightSetter;
	private PSOBestParamSetter globalWeightSetter;
	private PSOBestParamSetter minMaxVelocitySetter;

	public PSOBestParamSetterGroup(PSOBestParamSetter neighWeightSetter, PSOBestParamSetter personalWeightSetter,
			PSOBestParamSetter inertiaWeightSetter, PSOBestParamSetter globalWeightSetter,
			PSOBestParamSetter minMaxVelocitySetter)
	{
		this.neighWeightSetter = neighWeightSetter;
		this.personalWeightSetter = personalWeightSetter;
		this.inertiaWeightSetter = inertiaWeightSetter;
		this.globalWeightSetter = globalWeightSetter;
		this.minMaxVelocitySetter = minMaxVelocitySetter;
	}

	public PSOBestParamSetter getNeighWeightSetter()
	{
		return neighWeightSetter;
	}

	public PSOBestParamSetter getPersonalWeightSetter()
	{
		return personalWeightSetter;
	}

	public PSOBestParamSetter getInertiaWeightSetter()
	{
		return inertiaWeightSetter;
	}

	public PSOBestParamSetter getGlobalWeightSetter()
	{
		return globalWeightSetter;
	}

	public PSOBestParamSetter getMinMaxVelocitySetter()
	{
		return minMaxVelocitySetter;
	}
}
