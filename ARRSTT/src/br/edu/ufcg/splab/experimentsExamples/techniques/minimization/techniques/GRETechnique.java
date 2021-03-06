package br.edu.ufcg.splab.experimentsExamples.techniques.minimization.techniques;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestCase;
import br.edu.ufcg.splab.arrsttFramework.util.testCollections.TestSuite;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.factories.MinimizationStructureFactory;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.requirements.TestRequirement;
import br.edu.ufcg.splab.experimentsExamples.techniques.minimization.structures.MinimizationStructure;
import br.edu.ufcg.splab.experimentsExamples.util.Randomizer;


public class GRETechnique implements InterfaceMinimizationTechnique {
	private MinimizationStructure structure;
	
	public GRETechnique(TestSuite originalTestSuite, List<TestRequirement> requirements) {
		TestSuite testSuite = new TestSuite(originalTestSuite);
		MinimizationStructureFactory factory = new MinimizationStructureFactory();
		this.structure = factory.createStructure(testSuite, requirements);
	}
	
	public TestSuite minimize() {
		TestSuite minimizedTestSuite = new TestSuite();
		
		
		while (!structure.isEmpty()) {
			TestCase tCase  = doEssentialRedundant();
			
			if (tCase == null) {
				tCase = doGreedy();
			}
			
			minimizedTestSuite.add(tCase);
		}
		
		return minimizedTestSuite;
	}
	
	private TestCase doEssentialRedundant() {
		Set<TestCase> tCases = structure.getTestCases();
		Set<TestCase> toBeRemoved = new HashSet<>();
		
		for(TestCase tc : tCases){
			for(TestCase tc2 : tCases){
				if(! tc.equals(tc2) && tc.containsAll(tc2)){
					toBeRemoved.add(tc2);
				}
			}
		}
		
		for(TestCase removed : toBeRemoved) {
			structure.removeTuples(removed);
		}
		
		return doEssential();
	}
	
	private TestCase doEssential() {
		Set<TestRequirement> reqs = structure.getTestRequirements();
		List<TestCase> essentialTestCases = new ArrayList<>();
		for(TestRequirement req : reqs){
			if(structure.getTestCases(req).size() == 1){
				essentialTestCases.addAll(structure.getTestCases(req));
			}
		}
		
		TestCase selected = null;
		
		if (!essentialTestCases.isEmpty()) {
			selected = Randomizer.getRandomTestCase(essentialTestCases);
			structure.removeAllTuples(structure.getTestRequirements(selected));
		}
		
		return selected;
	}
	
	private TestCase doGreedy() {
		int biggestSize = -1;
		Set<TestCase> tCases = structure.getTestCases();
		List<TestCase> biggestTestCases = new ArrayList<>();
		int currentSize;
		
		for(TestCase tc : tCases){
			currentSize = structure.getTestRequirements(tc).size();
			
			if(currentSize >= biggestSize){
				if(currentSize > biggestSize){
					biggestTestCases = new ArrayList<>();
					biggestSize = currentSize;
				}
				
				biggestTestCases.add(tc);
			}
		}
		
		TestCase selected = null;
		if (!biggestTestCases.isEmpty()) {
			selected = Randomizer.getRandomTestCase(biggestTestCases);
			
			structure.removeAllTuples(structure.getTestRequirements(selected));
		}
		
		return selected;
	}
	
	
}
