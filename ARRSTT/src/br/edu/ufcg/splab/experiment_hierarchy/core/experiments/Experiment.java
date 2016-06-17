package br.edu.ufcg.splab.experiment_hierarchy.core.experiments;

import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceRunner;
import br.edu.ufcg.splab.experiment_hierarchy.core.api.InterfaceSetup;
import br.edu.ufcg.splab.experiment_hierarchy.util.ExperimentData;
/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-13
 * 
 */
/**
 * <b>Objective:</b> This class receives an experiment's setup and
 * runner to execute it.
 */
public class Experiment {
	private InterfaceSetup setup;
	private InterfaceRunner runner;
	
	/**
	 * Experiment's constructor.
	 * @param setup
	 * 			The experiment set up.
	 * @param runner
	 * 			The experiment runner.
	 */
	public Experiment(InterfaceSetup setup, InterfaceRunner runner) {
		this.setup = setup;
		this.runner = runner;
	}
	
	/**
	 * <b>Objective:</b> Get the set up and runner to execute
	 * the experiment.
	 * 
	 */
	public List<ExperimentData> execute() {
		return runner.runExperiment(setup.getArtifacts());
	}
}
