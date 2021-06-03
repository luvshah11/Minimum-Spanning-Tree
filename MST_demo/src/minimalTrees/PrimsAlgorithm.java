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
		edgeTo = new Edge[G.getNumberOfVerticies()];
		distTo = new double[G.getNumberOfVerticies()];
		marked = new boolean[G.getNumberOfVerticies()];
		for (int v = 0; v < G.getNumberOfVerticies(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		pq = new IndexMinPQ<Double>(G.getNumberOfVerticies()); //create a new minimum priority queue
		distTo[0] = 0.0; 
		pq.insert(0, 0.0); // Initialize pq with 0, weight 0.
		//initialize an empty spot of 0 for the minimum part of the priority queue
		
		while (!pq.isEmpty()) //while the minimum priority queue still has an edge stored in it
			visit(G, pq.delMin()); // Add closest vertex to tree.
	}
	private void visit(EdgeWeightedGraph G, int sourcevertex) { // Add source vertex to tree; update data structures.
		marked[sourcevertex] = true;
		for (Edge edge : G.adj(sourcevertex)) { //for every edge in the graph, starting from the source vertex
			int currVertex = edge.other(sourcevertex); //look at the vertex 
			if (marked[currVertex]) //if the vertex has been marked
				continue; // there is a cycle, this edge is ineligible.
			if (edge.weight() < distTo[currVertex]) { // Edge is new best (lowest weighted) connection from current tree to the next vertex.
				edgeTo[currVertex] = edge; //the edge connected to the current connected vertex in the MST is this edge
				distTo[currVertex] = edge.weight(); //the weight of the edge in the MST
				
				//checking for duplicates
				if (pq.contains(currVertex)) //if the priority queue contains this vertex
					pq.changeKey(currVertex, distTo[currVertex]); //change the value at this vertex
				else
					pq.insert(currVertex, distTo[currVertex]); //insert the value into the priority queue
			}
		}
	}

	public Iterable<Edge> edges()
	{ //retrieving the edges in the created MST
		Collection<Edge> mst = new ArrayList<Edge>();
		for (int v = 0; v < edgeTo.length; v++)

			mst.add(edgeTo[v]);
		return mst;
	}

	public String toString()
	{
		StringBuilder s = new StringBuilder();
	    //lambda for every edge, print its vertices and weight 
	    this.edges().forEach(e -> s.append("From vertex "+ e.other(e.either()) + ", to vertex " + e.either() + ", weighs: " + e.weight()+ "\n"));
	    
	    return s.toString();
	}
	public double weight()
	{
		double sum =0 ;
		for(int x = 0; x < edgeTo.length; x++)
		{
			if(edgeTo[x]!=null) {
			sum += edgeTo[x].weight();
			}
		}
		return sum;
	}
}
