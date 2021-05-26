package minimalTrees;

import java.math.BigDecimal;

public class MSTTest {
	
	BigDecimal expectedDecimal;
	BigDecimal trueDecimal;
	
	public boolean testKruskal(EdgeWeightedGraph graph, double expectedWeight){
		expectedDecimal = BigDecimal.valueOf(expectedWeight);
		KruskalsAlgorithm kruskals = new KruskalsAlgorithm(graph);
		trueDecimal = BigDecimal.valueOf(kruskals.weight());
		if(expectedDecimal == trueDecimal) {
			System.out.println("Error: weight is "+ kruskals.weight() + ". Should be " + expectedWeight);
			return false;
		}
		System.out.println("Kruskal's test passed!");
    	return true;
    }
	public boolean testPrimms(EdgeWeightedGraph graph, double expectedWeight){
		expectedDecimal = BigDecimal.valueOf(expectedWeight);
		PrimsAlgorithm prims = new PrimsAlgorithm(graph);
		trueDecimal = BigDecimal.valueOf(prims.weight());
		if(expectedDecimal == trueDecimal) {	
			System.out.println("Error: weight is "+ prims.weight() + ". Should be " + expectedWeight);
			return false;
			
		}
		System.out.println("Primm's test passed!");
    	return true;
    }
}
