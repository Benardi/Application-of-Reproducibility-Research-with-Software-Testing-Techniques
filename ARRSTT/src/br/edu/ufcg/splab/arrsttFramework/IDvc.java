package br.edu.ufcg.splab.arrsttFramework;

import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;

/*
 * Change														Author				Date
 * -------------------------------------------------------------------------------------------
 * Creation														Wesley Silva		2015-09-13
 * 
 */
/**
 * <b>Objective:</b> This interface represents a dependent variable collector,
 * being responsible for the collecting an experiment's dependent variable
 * and saving it in a StringBuffer.
 * <br>
 * <b>Description of use:</b> It is used in an ExperimentRunner so it can collect
 * the experiment's dependent variable.
 * 
 * @author Wesley
 *
 */
public interface IDvc {
	/**
	 * <b>Objective:</b> Add the dependent variable data collected from a tuple of
	 * ExecutableTreatments in a StringBuffer that will be returned.
	 * <br>
	 * <b>Example of use:</b> In an experiment that is going to check if merge sort is
	 * quicker than bubble sort for a certain list, a CombinationElement of ExecutableTratment with
	 * the merge sort and the list can be passed to this method so it will write the 
	 * execution time of the sort in a StringBuffer and return it.
	 * 
	 * @param treatment
	 * 			A tuple of ExecutableTreatments that is going to have a dependent variable
	 * 			collected.
	 * 
	 * @return The StringBuffer containing the dependent variable's data
	 */
	public StringBuffer collect(TestSuite t);
	
	public String getName();
}
