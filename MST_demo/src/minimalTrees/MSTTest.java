package minimalTrees;

public class MSTTest {
	public boolean testKruskal(EdgeWeightedGraph graph, double expectedWeight){
		KruskalsAlgorithm kruskals = new KruskalsAlgorithm(graph);
		if(kruskals.weight()!=expectedWeight) {
			System.out.println("Error: weight is "+ kruskals.weight() + ". Should be " + expectedWeight);
			return false;
		}
		System.out.println("Kruskal's test passed!");
    	return true;
    }
	public boolean testPrimms(EdgeWeightedGraph graph, double expectedWeight){
		PrimsAlgorithm prims = new PrimsAlgorithm(graph);
		if(prims.weight()!=expectedWeight) {
			System.out.println("Error: weight is "+ prims.weight() + ". Should be " + expectedWeight);
			return false;
		}
		System.out.println("Primm's test passed!");
    	return true;
    }
}
