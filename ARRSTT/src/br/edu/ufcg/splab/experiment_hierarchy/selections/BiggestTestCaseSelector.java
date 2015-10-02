package br.edu.ufcg.splab.experiment_hierarchy.selections;

import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

/**
 * Objective: Generate a sub set that is generated by members of a bigger set
 * using as parameter its dimension.
 * 
 * Description of use: In the Experiment Factory this class is used in the
 * process of building a selection.
 *
 */
public class BiggestTestCaseSelector implements InterfaceTestCaseSelector {

	public BiggestTestCaseSelector() {

	}

	/**
	 * Objective: Calculate the dimension of the smaller test suite.
	 * 
	 * Description of use: This method is used on the select method to help
	 * build the new test suite.
	 *
	 * @param testSuite
	 *            the test suite whose section will be separated
	 * @param percentage
	 *            the percentage desired from the test suite
	 * @return how many will be chosen.
	 */
	private int getQuantity(TestSuite testSuite, double percentage) {
		return (int) Math.ceil(testSuite.size() * percentage);
	}

	@Override
	public TestSuite select(TestSuite testSuite, Double percentage) {
		TestSuite result = new TestSuite();
		int quantity = getQuantity(testSuite, percentage);
		for (int i = 0; i < quantity; i++) {
			addBiggestTestCase(result, testSuite);
		}
		return result;
	}

	/**
	 * Objective: Add to one test suite the biggest test cas from another test
	 * suite.
	 * 
	 * Description of use: This method is used on the select method to help
	 * build the new test suite.
	 * 
	 * @param result
	 *            the test suite that hold the biggest test cases.
	 * 
	 * @param testSuite
	 *            the test suite from where the biggest will be chosen.
	 */
	private void addBiggestTestCase(TestSuite result, TestSuite testSuite) {
		int maxSize = -1;
		int maxIndex = -1;
		for (int i = 0; i < testSuite.size(); i++) {
			if (!result.contains(testSuite.get(i))) {
				if (testSuite.get(i).size() > maxSize) {
					maxSize = testSuite.get(i).size();
					maxIndex = i;
				}
			}
		}
		result.add(new TestCase(testSuite.get(maxIndex)));

	}

}