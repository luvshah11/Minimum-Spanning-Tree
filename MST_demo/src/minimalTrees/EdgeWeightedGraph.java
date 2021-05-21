package minimalTrees;
//EdgeWeightedGraph
//-------------------------------------------------------
//+EdgeWeightedGraph(int V) 	create an empty V-vertex graph
//+EdgeWeightedGraph(In in) read graph from input stream
//+ V():int number of vertices
//+ E():int number of edge
//+addEdge(Edge e): void add edge e to this graph
//+adj(int v):Iterable<Edge>  edges incident to v
//+ edges():Iterable<Edge> all of this graph’s edges
//+toString():String string representation

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;


public class EdgeWeightedGraph{
	
	private final int vertexCount; // number of vertices
	private int totalEdges; // number of edges

	private Collection<Edge>[] adj; // adjacency lists

	public EdgeWeightedGraph(Integer totalVertices) {
		this.vertexCount = totalVertices;
		this.totalEdges = 0;
		adj = (Collection<Edge>[]) new Collection[totalVertices];
		for (int vertex = 0; vertex < totalVertices; vertex++)
			adj[vertex] = new ArrayList<Edge>();
	}

//	public EdgeWeightedGraph(InputStream in)
//	{
//		
//	}
	// See Exercise 4.3.9.
	public int getNumberOfVerticies() 
	{
		return vertexCount;
	}

	public int getNumberOfEdges() {
		return totalEdges;
	}

	public void addEdge(Edge newEdge) 
	{
		//each edge needs 2 verticies 
		int vertex1 = newEdge.either(), vertex2 = newEdge.other(vertex1);
		adj[vertex1].add(newEdge);
		adj[vertex2].add(newEdge);
		totalEdges++;
	}

	public Iterable<Edge> adj(int vertex) //returns adjacency matrix of connected edges at this vertex
	{ 
		return adj[vertex]; 
	}
	//return the iterable collection of edges on the edgeweightedgraph
	public Iterable<Edge> edges()
	{
		Collection<Edge> edges = new ArrayList<Edge>(); //create new arraylist of edges
		for(int currentVertex = 0; currentVertex<vertexCount; currentVertex++) { //for every vertex that exists on the edgeweighted graph
			for(Edge edge : adj[currentVertex]) { // iterate through every vertex in that edges adjacency list
				if(edge.other(currentVertex)>currentVertex) { //see other(v) comment in Edge.java, we need to get the other vertex for the edge being looked at. 
					edges.add(edge); //add the other edge connected to that current vertex
				}
			}
		}
		return edges(); //return edge collection
	}

	// See page 609.
	
	//Implement Graph methods
	
	//citation https://algs4.cs.princeton.edu/43mst/EdgeWeightedGraph.java.html
	public String toString(){ 
	    StringBuilder s = new StringBuilder();
	    s.append(this.getNumberOfVerticies()+ " " + this.getNumberOfEdges() + "\n");
	    for (int v = 0; v < this.V(); v++)
	    {
	        s.append(v + " : ");
	        for (Edge e: this.adj(v)) 
	        {
	            s.append(e.toString() + " ");
	        }
	        s.append("\n");
	    }
	    return s.toString();
	}

}
