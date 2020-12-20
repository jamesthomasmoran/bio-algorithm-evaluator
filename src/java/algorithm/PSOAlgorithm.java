package algorithm;

import net.sourceforge.jswarm_pso.Neighborhood1D;
import net.sourceforge.jswarm_pso.Swarm;
import helper.PSOFitnessFunction;
import helper.MyParticle;
import wrapper.PSOParams;

public class PSOAlgorithm
{
	private static double R = 5.12;

	private PSOParams params;

    public void setParams(PSOParams params){
        this.params = params;
    }

	public PSOParams run() {

    	PSOParams output = new PSOParams(params);

        long startTime = System.nanoTime();
		// Create a swarm (using 'src.java.helper.MyParticle' as sample particle
		// and 'src.java.helper.MyFitnessFunction' as finess function)
		Swarm swarm = new Swarm(params.getNumParticles()
			, new MyParticle()
			, new PSOFitnessFunction());
		// Set position (and velocity) constraints. 
		// i.e.: where to look for solutions

		// Use neighborhood
		Neighborhood1D neigh = new Neighborhood1D(params.getNumParticles() / 10, true);
		swarm.setNeighborhood(neigh);
		swarm.setNeighborhoodIncrement(params.getNeighWeight());

		// Set weights of velocity update formula
		swarm.setInertia(params.getInertiaWeight()); // Previous velocity weight
                swarm.setParticleIncrement(params.getPersonalWeight()); // Personal best weight
                swarm.setGlobalIncrement(params.getGlobalWeight()); // Global best weight

		// Set limits to velocity value
		swarm.setMaxMinVelocity(params.getMaxMinVelocity());

		// Set max and min positions
		swarm.setMaxPosition(+R);
		swarm.setMinPosition(-R);

		// Optimize a few times
		for( int i = 0; i < params.getNumIter(); i++ ) {
			swarm.evolve();
			//System.out.println(swarm.toStringStats());
		}
        long endTime = System.nanoTime();

		output.setTimeTaken(Math.abs(endTime - startTime)/ 1000000);

		output.setFitness(swarm.getBestFitness());
		System.out.println(output.getTimeTaken());
		return output;
	}
}
