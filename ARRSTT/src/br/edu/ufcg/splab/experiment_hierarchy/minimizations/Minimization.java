package br.edu.ufcg.splab.experiment_hierarchy.minimizations;

import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.splab.experiment_hierarchy.minimizations.builders.RequirementBuilder;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.requirements.TestRequirement;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.structures.MinimizationStructure;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.techniques.EssentialTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.techniques.GreedyTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.techniques.Harrold;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.techniques.InterfaceMinimizationTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.minimizations.techniques.OneToOneRedundantEssentialTechnique;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestCase;
import br.edu.ufcg.splab.experiment_hierarchy.util.testcollections.TestSuite;

public class Minimization {
	private MinimizationStructure minimizationStructure;
	private List<InterfaceMinimizationTechnique> techniques;
	
	public Minimization(TestSuite testSuite, RequirementBuilder builder) {
		buildStructure(testSuite, builder.getRequirements());
		this.techniques = new ArrayList<InterfaceMinimizationTechnique>();
		this.techniques.add(new GreedyTechnique(minimizationStructure));
		this.techniques.add(new EssentialTechnique(minimizationStructure));
		this.techniques.add(new OneToOneRedundantEssentialTechnique(minimizationStructure));
		this.techniques.add(new Harrold(minimizationStructure));
	}
	
	private void buildStructure(TestSuite testSuite, List<TestRequirement> testRequirements) {
		for (TestCase tc : testSuite) {
			for (TestRequirement req : testRequirements) {
				if (req.cover(tc)) {
					minimizationStructure.insert(tc, req);
				}
			}
		}
	}
	
	public TestSuite minimizeG() {
		InterfaceMinimizationTechnique technique = techniques.get(0);
		TestSuite minimizedTestSuite = new TestSuite();
		
		while (!minimizationStructure.isEmpty()) {
			minimizedTestSuite.add(technique.minimize());
		}
		
		return minimizedTestSuite;
	}
	
	public TestSuite minimizeGE() {
		InterfaceMinimizationTechnique techniqueG = techniques.get(0);
		InterfaceMinimizationTechnique techniqueE = techniques.get(1);
		TestSuite minimizedTestSuite = new TestSuite();
		
		
		while (!minimizationStructure.isEmpty()) {
			TestCase tCase = techniqueE.minimize();
			
			if (tCase == null) {
				tCase = techniqueG.minimize();
			}
			
			minimizedTestSuite.add(tCase);
		}
		
		return minimizedTestSuite;
	}
	
	public TestSuite minimizeGRE() {
		InterfaceMinimizationTechnique techniqueG = techniques.get(0);
		InterfaceMinimizationTechnique techniqueRE = techniques.get(2);
		TestSuite minimizedTestSuite = new TestSuite();
		
		
		while (!minimizationStructure.isEmpty()) {
			TestCase tCase  = techniqueRE.minimize();
			
			if (tCase == null) {
				tCase = techniqueG.minimize();
			}
			
			minimizedTestSuite.add(tCase);
		}
		
		return minimizedTestSuite;
	}
	
	public TestSuite minimizeH() {
		InterfaceMinimizationTechnique techniqueH = techniques.get(3);
		
		TestSuite minimizationTestSuite = new TestSuite();
		
		while (!minimizationStructure.isEmpty()) {
			minimizationTestSuite.add(techniqueH.minimize());
		}
		
		return minimizationTestSuite;
	}
}
