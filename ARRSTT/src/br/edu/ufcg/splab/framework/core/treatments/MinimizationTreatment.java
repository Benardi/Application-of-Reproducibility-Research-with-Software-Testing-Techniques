package br.edu.ufcg.splab.framework.core.treatments;

import br.edu.ufcg.splab.framework.core.api.ExecutableTreatment;
import br.edu.ufcg.splab.framework.techniques.minimization.techniques.InterfaceMinimizationTechnique;
import br.edu.ufcg.splab.util.testcollections.TestSuite;

//WORK IN PROGRESS
/*
* Change														Author				Date
* -------------------------------------------------------------------------------------------
* Documentation												Benardi Nunes		2016-07-12
* 
*/
/**
 * <b>Objective:</b> This class represents an ARRSTT experiment's executable
 * treatment that is capable of selecting an amount of test cases in a test
 * suite while maintaining its representativeness, hence creating a new
 * TestSuite with the chosen test cases. <br>
 * <b>Description of use:</b> Receives a minimization algorithm capable of
 * returning a new test suite with the chosen test cases.
 *
 */
public class MinimizationTreatment implements ExecutableTreatment {
	private InterfaceMinimizationTechnique technique;
	/**
	 * MinimizationTreatment's constructor
	 * 
	 * @param technique
	 * 				The minimization technique
	 */
	public MinimizationTreatment(InterfaceMinimizationTechnique technique) {
		this.technique = technique;
	}
	/**
	 * b>Objective:</b> This method is responsible for using the minimization
	 * algorithm. <br>
	 */
	@Override
	public TestSuite execute() {
		return technique.minimize();
	}

	@Override
	public String toString() {
		return technique.toString();
	}
}
