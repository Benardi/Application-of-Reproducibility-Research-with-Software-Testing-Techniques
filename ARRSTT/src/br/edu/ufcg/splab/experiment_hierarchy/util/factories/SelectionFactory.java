package br.edu.ufcg.splab.experiment_hierarchy.util.factories;

import br.edu.ufcg.splab.experiment_hierarchy.selections.BiggestTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.BySimilaritySelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.InterfaceTestCaseSelector;
import br.edu.ufcg.splab.experiment_hierarchy.selections.RandomizedTestCaseSelection;
import br.edu.ufcg.splab.experiment_hierarchy.util.enums.SelectionType;

/**
 * Objective: his class covers all necessary procedure involved in the process
 * of generating a selector.
 * 
 * Description of use: Receives a type of selection and returns a selector of
 * the respective type.
 */
public class SelectionFactory {
	/**
	 * Objective: Generating a selector whose type of selection is the same as
	 * the provided one.
	 * 
	 * Description of use: The generated selection can be used in the building
	 * of a selection as in the Experiment Factory class.
	 * 
	 * @param type
	 *            The desired type of selection
	 * @return A selector of the desired type.
	 */
	public InterfaceTestCaseSelector createTreatment(SelectionType type) {
		if (type == SelectionType.BIGGEST) {
			return createBiggestSelector();
		} else if (type == SelectionType.RANDOMIZED) {
			return createRandomizedSelector();
		} else {
			return createSimilaritySelector();
		}
	}

	/**
	 * 
	 * @return A biggest test case selector
	 */
	public InterfaceTestCaseSelector createBiggestSelector() {
		return new BiggestTestCaseSelector();
	}

	/**
	 * 
	 * @return A randomized selector.
	 */
	public InterfaceTestCaseSelector createRandomizedSelector() {
		return new RandomizedTestCaseSelection();
	}

	/**
	 * 
	 * @return a similarity selector.
	 */
	public InterfaceTestCaseSelector createSimilaritySelector() {
		return new BySimilaritySelector();
	}
}