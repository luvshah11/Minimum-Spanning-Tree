	package minimalTrees;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalsAlgorithm {
	private Queue<Edge> mst;
	private double weight;

	public KruskalsAlgorithm(EdgeWeightedGraph weightedGraph) {
		mst = new PriorityQueue<Edge>();
		PriorityQueue<Edge> mstQueue = new PriorityQueue<Edge>(weightedGraph.getNumberOfEdges(), new CompareEdges());
		for(Edge edge : weightedGraph.edges()) {
			mstQueue.add(edge);
		}
		UnionFind uf = new UnionFind(weightedGraph.getNumberOfVerticies());
		while (!mstQueue.isEmpty() && mst.size() < weightedGraph.getNumberOfVerticies() - 1) {
			Edge edge = mstQueue.poll(); // Get min weight edge on pq
			int vertex1 = edge.either(), vertex2 = edge.other(vertex1); // and whichever vertices matches the edge value
			if (uf.connected(vertex1, vertex2)) { //if they are in a cycle, ignore those edges
				continue; // Ignore ineligible edges.
			}
			uf.union(vertex1, vertex2); // Merge components.
			mst.add(edge); // Add edge to mst.
		}
		
		//set weight()
		this.mst.forEach(e -> { //lambda ( Parameter -> Expression) Example: Suppose I have a list of objects to print
			if(e != null)											//List<int> happyList
				weight += e.weight();								//happyList.forEach(for each element in the list -> perform some function)
			else													//its like a for loop, but nerdy-er
				weight = 0;});
	}

	public Iterable<Edge> edges() {
		//return the edges in the new minimum spanning tree created with the algorithm
		return mst;
	}

	public double weight() // See Exercise 4.3.31.
	{
		return weight; //see constructor for assignment
	}
	
	public String toString(){ 
	    StringBuilder s = new StringBuilder();
	    //lambda for every edge, print its vertices and weight 
	    for(Edge e: mst) {
	    	s.append("From vertex "+ e.other(e.either()) + ", to vertex " + e.either() + ", weighs: " + e.weight()+ "\n");
	    }
	    return s.toString();
	}


}

//https://www.geeksforgeeks.org/comparator-interface-java/
//need this for PriorityQueue to behave like MinPQ in the book
 class CompareEdges implements Comparator<Edge> {

	@Override
	public int compare(Edge edge1, Edge edge2) {
		return edge1.compareTo(edge2);
	}

}
