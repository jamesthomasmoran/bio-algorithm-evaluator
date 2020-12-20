package wrapper;

import io.jenetics.Alterer;
import io.jenetics.DoubleGene;

public class GAParams
{
    private int numSurvivors;
    private int tournamentSize;
    private double probMutation;
    private double probCrossover;
    private double fitness;
    private int numIter;
    private int popSize;
    private double meanProb;
    private Alterer<DoubleGene, Double>[] alterers;
    private long timeTaken;

    public GAParams(){

    }
    public GAParams(int numSurvivors, int tournamentSize, double probMutation, double probCrossover, double fitness, int numIter, int popSize, double meanProb, Alterer<DoubleGene, Double>... alterers)
     {

        this.numSurvivors = numSurvivors;
        this.tournamentSize = tournamentSize;
        this.probMutation = probMutation;
        this.probCrossover = probCrossover;
        this.fitness = fitness;
        this.meanProb = meanProb;
        this.numIter = numIter;
        this.popSize = popSize;
        this.alterers = alterers;
    }

    public GAParams(GAParams orig)
    {
        this.numSurvivors = orig.getNumSurvivors();
        this.tournamentSize = orig.getTournamentSize();
        this.probMutation = orig.getProbMutation();
        this.probCrossover = orig.getProbCrossover();
        this.fitness = -1;
        this.numIter = orig.getNumIter();
        this.popSize = orig.getPopSize();
        this.meanProb = orig.getMeanProb();
        this.alterers = orig.getAlterers();
    }

    public double getMeanProb() {
        return meanProb;
    }

    public void setMeanProb(double meanProb) {
        this.meanProb = meanProb;
    }

    public int getNumSurvivors() {
        return numSurvivors;
    }

    public void setNumSurvivors(int numSurvivors) {
        this.numSurvivors = numSurvivors;
    }

    public int getTournamentSize() {
        return tournamentSize;
    }

    public void setTournamentSize(int tournamentSize) {
        this.tournamentSize = tournamentSize;
    }

    public double getProbMutation() {
        return probMutation;
    }

    public void setProbMutation(double probMutation) {
        this.probMutation = probMutation;
    }

    public double getProbCrossover() {
        return probCrossover;
    }

    public void setProbCrossover(double probCrossover) {
        this.probCrossover = probCrossover;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public int getNumIter() {
        return numIter;
    }

    public int getPopSize() {
        return popSize;
    }

    public long getTimeTaken()
    {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken)
    {
        this.timeTaken = timeTaken;
    }

    public Alterer[] getAlterers()
    {
        return alterers;
    }

    public String getAlterersString(){
        String alterers = "";
        for(int i = 0; i < this.getAlterers().length; i++){
            alterers += "-" + this.getAlterers()[i].getClass().getSimpleName();
        }
        return alterers;
    }
}
