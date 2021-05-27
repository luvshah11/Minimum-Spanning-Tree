package minimalTrees;

import java.math.BigDecimal;

public class MSTTest {
	
	BigDecimal expectedDecimal;
	BigDecimal trueDecimal;
	BigDecimal roundedDecimal;
	
	public boolean testKruskal(EdgeWeightedGraph graph, double expectedWeight){
		expectedDecimal = BigDecimal.valueOf(expectedWeight);
		KruskalsAlgorithm kruskals = new KruskalsAlgorithm(graph);
		trueDecimal = BigDecimal.valueOf(kruskals.weight());
		if(expectedDecimal.equals(trueDecimal)) {
			System.out.println("Error: weight is "  + roundedDecimal + ". Should be " + expectedWeight);
			return false;
		}
		System.out.println("Kruskal's test passed!");
    	return true;
    }
	
	public boolean testPrimms(EdgeWeightedGraph graph, double expectedWeight){
		expectedDecimal = BigDecimal.valueOf(expectedWeight);
		PrimsAlgorithm prims = new PrimsAlgorithm(graph);
		trueDecimal = BigDecimal.valueOf(prims.weight());
		if(expectedDecimal.equals(trueDecimal)) {	
			System.out.println("Error: weight is "+ prims.weight() + ". Should be " + expectedWeight);
			return false;
			
		}
		System.out.println("Primm's test passed!");
    	return true;
    }
}
