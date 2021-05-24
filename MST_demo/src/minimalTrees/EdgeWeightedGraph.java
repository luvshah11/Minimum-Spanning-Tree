package minimalTrees;
//EdgeWeightedGraph
//-------------------------------------------------------
//+EdgeWeightedGraph(int V) 	create an empty V-vertex graph
//+EdgeWeightedGraph(In in) read graph from input stream
//+ V():int number of vertices
//+ E():int number of edge
//+addEdge(Edge e): void add edge e to this graph
//+adj(int v):Iterable<Edge>  edges incident to v
//+ edges():Iterable<Edge> all of this graph�s edges
//+toString():String string representation

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Collections;
import java.util.TreeSet;
import java.io.InputStreamReader;
import java.util.stream.Collectors;


public class EdgeWeightedGraph{
	private final int vertexCount; // number of vertices
	private int totalEdges; // number of edges
	private double totalWeight;
	private Collection<Edge>[] adj; // adjacency lists
	private Set<Edge> edgeSet = new TreeSet<>(); // treeset to make no duplicate edges	
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
		 this.vertexCount = Integer.parseInt(lines[0]);
		 this.totalEdges = Integer.parseInt(lines[1]);
		 adj = new ArrayList[this.vertexCount];
			for (int v = 0; v < this.vertexCount; v++)
				adj[v] = new ArrayList<Edge>();
		 
		 
		 for(int i = 2; i < lines.length; i++) {
			 String cols[] = lines[i].split(" ");
			 int v1 = Integer.parseInt(cols[0]);
			 int v2 = Integer.parseInt(cols[1]);
			 double w  = Double.parseDouble(cols[2]);
			 Edge tmp = new Edge(v1, v2, w);
			 adj[v1].add(tmp);
			 adj[v2].add(tmp);
			 totalEdges++;		 
		 }
	}

	public int getNumberOfVerticies() 
	{
		return vertexCount;
	}

	public int getNumberOfEdges() {
		return totalEdges/2;
	}

	public void addEdge(Edge newEdge) 
	{
		//each edge needs 2 verticies 
		int vertex1 = newEdge.either(), vertex2 = newEdge.other(vertex1);
		adj[vertex1].add(newEdge);
		adj[vertex2].add(newEdge);
		totalWeight = totalWeight + newEdge.weight();
		totalEdges++;
	}

	public Iterable<Edge> adj(int vertex) //returns adjacency matrix of connected edges at this vertex
	{ 
		return adj[vertex]; 
	}
	
	//get the weight of the enitre edgeweighted graph
	public double getWeight() {
		return totalWeight;
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
	    StringBuilder edgeWString = new StringBuilder();
	    edgeWString.append("Number of verticies:" + this.getNumberOfVerticies()+ " " + "Number of edges:" + this.getNumberOfEdges() + "\n");
	    for (int vertex = 0; vertex < this.getNumberOfVerticies(); vertex++)
	    {
	        edgeWString.append("Edge " + vertex + " : ");
	        for (Edge edge: this.adj(vertex)) 
	        {
	            edgeWString.append(edge.toString() + " ");
	        }
	        edgeWString.append("\n");
	    }
	    return edgeWString.toString();

	}

}
