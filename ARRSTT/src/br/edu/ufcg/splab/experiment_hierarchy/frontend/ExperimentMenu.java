package br.edu.ufcg.splab.experiment_hierarchy.frontend;

import java.util.Scanner;
/* Change		Author		Date
 * Creation		Iaron		2015-09-29
 */
public class ExperimentMenu {
	private static Scanner scan = new Scanner(System.in);
	private static ARRSTTFacade facade = new ARRSTFacade();
	
	public static void main(String[] args) {
		System.out.println("Welcome to the experiment menu!");
		experimentSelection();
		System.out.println("Now, pick the treatments.");
		if(experimentNumber == 0){
			selectSearch();
			selectLoopCoverage();
			selectGenerationDVC();
		} else if (experimentNumber == 1){
			selectSelection();
			selectSelectionPercentage();
			selectMaskPercentage();
			selectSelectionDVC();
		}
		

	}
	
	private static void experimentSelection(){
		boolean haventSelected = true;
		int experimentNumber = -1;
		while(haventSelected){
			System.out.println("We have two experiments available at the moment.\n"
					+ "Write the number of the desired experiment (1 - Generation 2 - Selection)");
		
			experimentNumber = scan.nextInt();
			if(experimentNumber < 1 || experimentNumber > 2){
				System.out.println("Please, select a valid experiment");
			} else {
				haventSelected = false;
			}
		}
		facade.selectExperiment(experimentNumber);;		
	}
	
	private static void selectSearch(){
		boolean haventSelected = true;
		String output;
		String[] results;
		while(haventSelected){
			System.out.println("Now, select which treatments you want for generation:");
			System.out.println("1 - DFS 2 - BFS");
			System.out.println("Output exemple: 1 2 1");
			output = scan.nextLine();
			results = output.split(" ");
			
			if(results.length == 0){
				System.out.println("Please, input valid numbers");
			}else {
				for(int i = 0; i < results.length; i++){
					facade.addGenerationAlgorithm(result[i]);
				}
				haventSelected = false;
			}
		}
	}
	
	private static void selectSelection(){
		boolean haventSelected = true;
		String output;
		String[] results;
		while(haventSelected){
			System.out.println("Now, select which treatments you want for selection:");
			System.out.println("1 - Random 2 - Biggest 3 - Similarity");
			System.out.println("Output exemple: 1 2 3 2");
			output = scan.nextLine();
			results = output.split(" ");
			
			if(results.length == 0){
				System.out.println("Please, input valid numbers");
			}else {
				for(int i = 0; i < results.length; i++){
					facade.addSelectionAlgorithm(result[i]);
				}
				haventSelected = false;
			}
		}
	}
	
	private static void selectLoopCoverage(){
		boolean haventSelected = true;
		String output;
		String[] results;
		while(haventSelected){
			System.out.println("Now, select which loop coverages you want:");
			System.out.println("Output exemple: 0 1 2 3 4 5 6");
			output = scan.nextLine();
			results = output.split(" ");
			
			if(results.length == 0){
				System.out.println("Please, input valid numbers");
			}else {
				for(int i = 0; i < results.length; i++){
					facade.addLoopCoverages(result[i]);
				}
				haventSelected = false;
			}
		}
	}
	
	private static void selectSelectionPercentage(){
		boolean haventSelected = true;
		double percentage = -1;
		while(haventSelected){
			System.out.println("Now, select the selection's percentage");
			System.out.println("Output exemple: 0.4");
			percentage = scan.nextDouble();
			if(percentage < 0.0 || percentage > 1.0){
				System.out.println("Please, input a valid number");
			} else {
				facade.addSelectPercentage();
				haventSelected = false;
			}
		}
	}
	
	private static void selectMaskPercentage(){
		boolean haventSelected = true;
		double percentage = -1;
		while(haventSelected){
			System.out.println("Now, select the mask's percentage");
			System.out.println("Output exemple: 0.7");
			percentage = scan.nextDouble();
			if(percentage < 0.0 || percentage > 1.0){
				System.out.println("Please, input a valid number");
			} else {
				facade.addMaskPercentage();
				haventSelected = false;
			}
		}
	}
	
	private static void selectGenerationDVC(){
		boolean haventSelected = true;
		String output;
		String[] results;
		while(haventSelected){
			System.out.println("Now, select which dependent variables you want:");
			System.out.println("1 - Time 2 - Size");
			System.out.println("Output exemple: 1 2");
			output = scan.nextLine();
			results = output.split(" ");
			
			if(results.length == 0){
				System.out.println("Please, input valid numbers");
			}else {
				for(int i = 0; i < results.length; i++){
					facade.addGenerationDVCs(result[i]);
				}
				haventSelected = false;
			}
		}
	}
	
	private static void selectSelectionDVC(){
		boolean haventSelected = true;
		String output;
		String[] results;
		while(haventSelected){
			System.out.println("Now, select which dependent variables you want:");
			System.out.println("1 - Time 2 - Size 3 - Defects 4 - Defective trasitions 5 - Failures");
			System.out.println("Output exemple: 1 2 3 4 5");
			output = scan.nextLine();
			results = output.split(" ");
			
			if(results.length == 0){
				System.out.println("Please, input valid numbers");
			}else {
				for(int i = 0; i < results.length; i++){
					facade.addSelectionDVCs(result[i]);
				}
				haventSelected = false;
			}
		}
	}
	
	

}
