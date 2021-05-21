	package minimalTrees;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalsAlgorithm {
	private Queue<Edge> mst;

	public KruskalsAlgorithm(EdgeWeightedGraph weightedGraph) {
		mst = new PriorityQueue<Edge>();
		PriorityQueue<Edge> mstQueue = new PriorityQueue<Edge>(weightedGraph.getNumberOfEdges(), new CompareEdges());
		UnionFind uf = new UnionFind(weightedGraph.getNumberOfVerticies());
		while (!mstQueue.isEmpty() && mst.size() < weightedGraph.getNumberOfVerticies() - 1) {
			Edge edge = mstQueue.poll(); // Get min weight edge on pq
			
			int vertex1 = edge.either(), vertex2 = edge.other(vertex1); // and whichever vertice matches the edge value
			
			if (uf.connected(vertex1, vertex2)) { //if they are in a cycle, ignore those edges
				continue; // Ignore ineligible edges.
			}
			uf.union(vertex1, vertex2); // Merge components.
			mst.add(edge); // Add edge to mst.
		}
	}

	public Iterable<Edge> edges() {
		//return the edges in the new minimum spanning tree created with the algorithm, NOT the original weighed edge graph.
		return mst;
	}

	public double weight(PriorityQueue<Edge> mst){
		double totalWeight = 0; //initialize weight value
		Iterator<Edge> weightIterator = mst.iterator(); //create iterator to iterate through MST array
			while(weightIterator.hasNext()) { //iterator loop
				totalWeight = totalWeight + weightIterator.next().weight(); //for every edge in the MST, add the weight() value of that edge to the total
			}
		return totalWeight; //return total weight
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
