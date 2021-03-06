package br.edu.ufcg.splab.experimentsExamples.techniques.minimization.builders;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestCase;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.requirements.ARRSTTTestRequirement;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.requirements.TestRequirement;
import br.edu.ufcg.splab.graph.core.InterfaceEdge;

public class APCoverage implements RequirementBuilder {
	private TestSuite testSuite;
	
	public APCoverage(TestSuite testSuite) {
		this.testSuite = testSuite;
	}

	@Override
	public List<TestRequirement> getRequirements() {
		List<TestRequirement> requirements = new ArrayList<TestRequirement>();
		
		for (TestCase testCase : testSuite) {
			for (int i = 0; i < testCase.size() - 1; i++) {
				List<InterfaceEdge> edges = new ArrayList<InterfaceEdge>();
				edges.add(testCase.get(i));
				edges.add(testCase.get(i + 1));
				requirements.add(new ARRSTTTestRequirement(edges));
			}
		}
		
		return requirements;
	}
	
	
}
