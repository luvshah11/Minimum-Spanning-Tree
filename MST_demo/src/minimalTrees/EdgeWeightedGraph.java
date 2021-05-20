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

public class EdgeWeightedGraph implements Graph<Integer> {

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
	public int numberofVertices() 
	{
		return vertexCount;
	}

	public int numberofEdges() {
		return totalEdges;
	}

	public void addEdge(Edge newEdge) 
	{
		int vertex1 = newEdge.either(), vertex2 = newEdge.other(vertex1);
		adj[vertex1].add(newEdge);
		adj[vertex2].add(newEdge);
		totalEdges++;
	}

	public Iterable<Edge> adj(int v)
	{ 
		return adj[v]; 
	}

	public Iterable<Edge> edges()
	{
		Collection<Edge> edges = new ArrayList<Edge>();
		for(int v = 0; v<vertexCount; v++) {
				
		}
		return new ArrayList<Edge>() ;
	}
	// See page 609.




}
