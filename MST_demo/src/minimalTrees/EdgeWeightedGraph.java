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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class EdgeWeightedGraph implements Graph<Integer> {

	private int V; // number of vertices
	private int E; // number of edges
	private Collection<Edge>[] adj; // adjacency lists

	public EdgeWeightedGraph(Integer V) {
		this.V = V;
		this.E = 0;
		adj = new ArrayList[V];
		for (int v = 0; v < V; v++)
			adj[v] = new ArrayList<Edge>();
	}

	
    /*
     *  INPUT FORMAT:
     *  <num_of_verts>
     *  <num_of_edges>
     *  <vert1> <vert2> <weight>
     *  <vert1> <vert2> <weight>
     *  <vert1> <vert2> <weight>
     *  ...
     * 
     */
	public EdgeWeightedGraph(InputStream in) throws IOException
	{
		


		 // https://stackoverflow.com/questions/309424/how-do-i-read-convert-an-inputstream-into-a-string-in-java
		 String result = new BufferedReader(new InputStreamReader(in))
				   .lines().collect(Collectors.joining("\n"));
		 
		
		 String lines[] = result.split("\n");
		 this.V = Integer.parseInt(lines[0]);
		 this.E= Integer.parseInt(lines[1]);
		 adj = new ArrayList[V];
			for (int v = 0; v < V; v++)
				adj[v] = new ArrayList<Edge>();
		 
		 
		 for(int i = 2; i < lines.length; i++) {
			 String cols[] = lines[i].split(" ");
			 int v1 = Integer.parseInt(cols[0]);
			 int v2 = Integer.parseInt(cols[1]);
			 int w  = Integer.parseInt(cols[2]);
			 Edge tmp = new Edge(v1, v2, w);
			 adj[v1].add(tmp);
			 adj[v2].add(tmp);
			 E++;
			 
		 }
		
		
	}
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
	
	//Implement Graph methods
	@Override
	public int getNumberOfVerticies()
	{
		return this.V;
	}
	@Override
	public int getNumberOfEdges()
	{
		return this.E;
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
