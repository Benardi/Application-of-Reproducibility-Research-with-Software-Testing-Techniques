package br.edu.ufcg.splab.experiment_hierarchy.core.benchmarking;

import br.edu.ufcg.splab.experiment_hierarchy.core.datacollectors.DependentVariableCollector;

public interface InterfaceBenchmark extends DependentVariableCollector<Void> {
	public void startBenchmark();
	public void endBenchmark();
}
