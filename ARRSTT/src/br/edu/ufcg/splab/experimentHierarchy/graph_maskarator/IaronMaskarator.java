package br.edu.ufcg.splab.experimentHierarchy.graph_maskarator;

import br.edu.ufcg.splab.graph.core.InterfaceEdge;
import br.edu.ufcg.splab.graph.core.InterfaceGraph;

/*
 * This class gets the list of trasitions and selects which trasitions are
 * going to be marked by fixing a distance between the marked trasitions.
 * eg: if a graph has 6 trasitions and it is going to have 2 errors, the 3rd
 * and 6th trasitions are going to be marked.
 * eg: if a graph has 10 trasitions and it is going to have 3 errors, the 3rd,
 * 6th and the 9th is going to be marked.
 */
public class IaronMaskarator implements GraphMaskaratorInterface{

	@Override
	public InterfaceGraph maskarate(InterfaceGraph toBeMasked, double percentage) {
		int errorQuantity = (int) Math.ceil(toBeMasked.getEdges().size() * percentage);
		return maskarate(toBeMasked, errorQuantity);
	}
	
	
	
	/*I thought about using a toBeMasked's clone, but to do that I think I would have
	 *to exchange InterfaceGraph by AbstractGraph. So, what should I do? Use clone, or
	 *keep it this way and change it's return to void?
	 */
	//I think a while would fit this better, but I don't know how to do it.
	@Override
	public InterfaceGraph maskarate(InterfaceGraph toBeMasked, int errorQuantity) {
		int errorPosition = toBeMasked.getEdges().size() / errorQuantity ;
		int count = 1;
		for(InterfaceEdge edge : toBeMasked.getEdges()){
			if(count == errorPosition){
				edge.setLabel("ERROR");
				errorQuantity--;
				if(errorQuantity == 0){
					return toBeMasked;
				}
			} else {
				count++;
			}	
		}
		return null;
	}

}