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

	private final int V; // number of vertices
	private int E; // number of edges
	private Collection<Edge>[] adj; // adjacency lists

	public EdgeWeightedGraph(Integer V) {
		this.V = V;
		this.E = 0;
		adj = (Collection<Edge>[]) new Collection[V];
		for (int v = 0; v < V; v++)
			adj[v] = new ArrayList<Edge>();
	}

	//public EdgeWeightedGraph(InputStream in);
	// See Exercise 4.3.9.
	public int V() 
	{
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(Edge e) 
	{
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}

	public Iterable<Edge> adj(int v)
	{ 
		return adj[v]; 
	}

	public Iterable<Edge> edges()
	{
		return new ArrayList<Edge>() ;
	}
	// See page 609.
	
	//impliment Graph methods
	@Override
	public int getNumberOfVerticies()
	{
		return 0;
	}
	@Override
	public int getNumberOfEdges()
	{
		return 0;
	}

	@Override
	public boolean addEdge(Integer from, Integer to) {
		return false;
	}

	@Override
	public boolean removeEdge(Integer from, Integer to) {
		return false;
	}

}
