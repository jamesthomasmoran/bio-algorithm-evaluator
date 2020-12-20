package wrapper;

public class PSOParams
{
    private double neighWeight = 1.0;
    private double inertiaWeight = 1.0;
    private double personalWeight = 1.0;
    private double globalWeight = 1.0;
    private double maxMinVelocity = 0.1;
    private double fitness = -1;
    private  int numParticles = 1000;
    private int numIter = 1000;
    private long timeTaken;

    public PSOParams(){}


    public PSOParams(double neighWeight, double inertiaWeight, double personalWeight, double globalWeight, double maxMinVelocity, double fitness, int numParticles, int numIter) {
        this.neighWeight = neighWeight;
        this.inertiaWeight = inertiaWeight;
        this.personalWeight = personalWeight;
        this.globalWeight = globalWeight;
        this.fitness = fitness;
        this.maxMinVelocity = maxMinVelocity;
        this.numIter = numIter;
        this.numParticles = numParticles;
    }

    public PSOParams(PSOParams orig) {
        this.neighWeight = orig.getNeighWeight();
        this.inertiaWeight = orig.getInertiaWeight();
        this.personalWeight = orig.getPersonalWeight();
        this.globalWeight = orig.getGlobalWeight();
        this.maxMinVelocity = orig.getMaxMinVelocity();
        this.fitness = -1;
        this.numIter = orig.getNumIter();
        this.numParticles = orig.getNumParticles();
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public int getNumParticles() {
        return numParticles;
    }

    public void setNumParticles(int numParticles) {
        this.numIter = numParticles;
    }

    public int getNumIter() {
        return numIter;
    }

    public void setNumIter(int numIter) {
        this.numIter = numIter;
    }

    public double getNeighWeight() {
        return neighWeight;
    }

    public void setNeighWeight(double neighWeight) {
        this.neighWeight = neighWeight;
    }

    public double getInertiaWeight() {
        return inertiaWeight;
    }

    public void setInertiaWeight(double inertiaWeight) {
        this.inertiaWeight = inertiaWeight;
    }

    public double getPersonalWeight() {
        return personalWeight;
    }

    public void setPersonalWeight(double personalWeight) {
        this.personalWeight = personalWeight;
    }

    public double getGlobalWeight() {
        return globalWeight;
    }

    public void setGlobalWeight(double globalWeight) {
        this.globalWeight = globalWeight;
    }

    public double getMaxMinVelocity() {
        return maxMinVelocity;
    }

    public void setMaxMinVelocity(double maxMinVelocity) {
        this.maxMinVelocity = maxMinVelocity;
    }

    public long getTimeTaken()
    {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken)
    {
        this.timeTaken = timeTaken;
    }
}
