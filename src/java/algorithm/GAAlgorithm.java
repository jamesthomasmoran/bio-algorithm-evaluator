package algorithm;

import java.util.Arrays;

import static io.jenetics.engine.EvolutionResult.toBestPhenotype;

import helper.GAFitnessFunction;
import io.jenetics.DoubleGene;
import io.jenetics.TournamentSelector;
import io.jenetics.EliteSelector;
import io.jenetics.Optimize;
import io.jenetics.Phenotype;
import io.jenetics.engine.Codecs;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionStatistics;
import io.jenetics.stat.DoubleMomentStatistics;
import io.jenetics.util.DoubleRange;
import wrapper.GAParams;

public class GAAlgorithm
{
	private GAParams params;


	private static final double R = 5.12;
	private static final int N = 10;

	public void setParams(GAParams params){
		this.params = params;
	}

	public GAParams run() {

		GAParams output = new GAParams(params);

		final long startTime = System.nanoTime();

		final Engine<DoubleGene, Double> engine = Engine
			.builder(
					GAFitnessFunction::evaluate,
				// Codec for 'x' vector.
				Codecs.ofVector(DoubleRange.of(-R, R), N))
			.populationSize(params.getPopSize())
			.optimize(Optimize.MINIMUM)
			.survivorsSize(params.getNumSurvivors())
			.survivorsSelector(new EliteSelector<>(params.getNumSurvivors()))
			.offspringSelector(new TournamentSelector<>(params.getTournamentSize()))
			.alterers(
					params.getAlterers()[0], Arrays.copyOfRange(params.getAlterers(), 1, params.getAlterers().length)
			)
			.build();

		final EvolutionStatistics<Double, DoubleMomentStatistics>
			statistics = EvolutionStatistics.ofNumber();

		final Phenotype<DoubleGene, Double> best = engine.stream()
			.limit(params.getNumIter())
			.peek(statistics)
			.collect(toBestPhenotype());

		final long endTime = System.nanoTime();

		output.setTimeTaken(Math.abs(endTime - startTime) / 1000000);

		output.setFitness(best.getFitness());

		return output;
	}
}
