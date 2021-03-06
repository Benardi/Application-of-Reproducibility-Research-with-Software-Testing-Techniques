/*
 * @(#)Tipo.java
 *
 * Revision:
 * Author                                         Date           
 * --------------------------------------------   ------------   
 *  Jeremias D. Serafim de Araujo                    14/11/2012    
 */

package br.edu.ufcg.splab.graph.core.edges;


public enum TransitionType {
	DEFAULT("default"),
	STEPS("steps"),
	CONDITIONS("conditions"),
	EXPECTED_RESULTS("expected_results");
	
	String str;
	
	private TransitionType(String str) {
		this.str = str;
	}

	public String getStrTipo() {
		return str;
	}

	public static TransitionType getInstance(String str) {
		for (TransitionType t : values()) {
			if (t.getStrTipo().equals(str.toLowerCase())) {
				return t;
			}
		}
		return null;
	}
}


