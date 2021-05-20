package minimalTrees;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalsAlgorithm {
	private Queue<Edge> mst;

	public KruskalsAlgorithm(EdgeWeightedGraph G) {
		mst = new PriorityQueue<Edge>();
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(G.getNumberOfEdges(), new CompareEdges());
		UnionFind uf = new UnionFind(G.V());
		while (!pq.isEmpty() && mst.size() < G.V() - 1) {
			Edge e = pq.poll(); // Get min weight edge on pq
			int v = e.either(), w = e.other(v); // and its vertices.
			if (uf.connected(v, w))
				continue; // Ignore ineligible edges.
			uf.union(v, w); // Merge components.
			mst.add(e); // Add edge to mst.
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	// public double weight() // See Exercise 4.3.31.

}

//https://www.geeksforgeeks.org/comparator-interface-java/
//need this for PriorityQueue to behave like MinPQ in the book
 class CompareEdges implements Comparator<Edge> {

	@Override
	public int compare(Edge o1, Edge o2) {
		return o1.compareTo(o2);
	}

}
