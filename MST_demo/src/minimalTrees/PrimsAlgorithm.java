package minimalTrees;

import java.util.ArrayList;
import java.util.Collection;

public class PrimsAlgorithm {

	private Edge[] edgeTo; // shortest edge from tree vertex
	private double[] distTo; // distTo[w] = edgeTo[w].weight()
	private boolean[] marked; // true if v on tree
	private IndexMinPQ<Double> pq; // eligible crossing edges

	public PrimsAlgorithm(EdgeWeightedGraph G)
	{
		edgeTo = new Edge[G.numberofVertices()];
		distTo = new double[G.numberofVertices()];
		marked = new boolean[G.numberofVertices()];
		for (int v = 0; v < G.numberofVertices(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		pq = new IndexMinPQ<Double>(G.numberofVertices());
		distTo[0] = 0.0;
		pq.insert(0, 0.0); // Initialize pq with 0, weight 0.
		while (!pq.isEmpty())
			visit(G, pq.delMin()); // Add closest vertex to tree.
	}

	private void visit(EdgeWeightedGraph G, int v) { // Add v to tree; update data structures.
		marked[v] = true;
		for (Edge e : G.adj(v)) {
			int w = e.other(v);
			if (marked[w])
				continue; // v-w is ineligible.
			if (e.weight() < distTo[w]) { // Edge e is new best connection from tree to w.
				edgeTo[w] = e;
				distTo[w] = e.weight();
				if (pq.contains(w))
					pq.changeKey(w, distTo[w]);
				else
					pq.insert(w, distTo[w]);
			}
		}
	}

	public Iterable<Edge> edges()
	{
		Collection<Edge> mst = new ArrayList<Edge>();
		for (int v = 1; v < edgeTo.length; v++)
			mst.add(edgeTo[v]);
		return mst;
	}

	public double weight()
	{
		return 0;
	}
}
