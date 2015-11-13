package br.edu.ufcg.splab.experiment_hierarchy.minimizations.techniques;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.structures.InterfaceMinimizationTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.util.Randomizer;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;

public class EssentialTechnique implements InterfaceMinimizationTechnique{
	
	private MinimizationStructure structure;
	
	public EssentialTechnique(MinimizationStructure structure){
		this.structure = structure;
	}
	
	@Override
	public TestCase minimize() {
		Set<TestRequirement> reqs = structure.getTestRequirements();
		List<TestCase> essentialTestCases = new ArrayList<>();
		for(TestRequirement req : reqs){
			if(structure.getTestCases(req).size() == 1){
				essentialTestCases.addAll(structure.getTestCases(req));
			}
		}
		
		TestCase selected = Randomizer.getRandomTestCase(essentialTestCases);
		structure.removeTuples(selected);	
		return selected;
	}
	
	protected MinimizationStructure getStructure(){
		return structure;
	}

}
