package minimalTrees;
//edge object

//---------------
//-double weight 
//-int v1, 
//-int v2
//---------------
//+weight():double
//+either():int returns either of this edge's vertices
//+other() :int returns the other vertex
//+compareTo(Edge that): int return the # of differences
//+toString(): String 	print a string representation

public class Edge implements Comparable<Edge> {
	private final int vertex1;// one vertex
	private final int vertex2; // the other vertex
	private final double weight; // edge weight

	public Edge(int vertex1, int vertex2, double weight) {
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
		this.weight = weight;
	}

	public double weight() {
		return weight;
	}

	public int either() {
		return vertex1;
	}

	public int other(int vertex) { //takes in a vertex and checks if it is equal to vertex 1, since we want to get the other vertex return vertex 2. if its vertex 2 return vertex1. 
		if (vertex == vertex1)
			return vertex2;
		else if (vertex == vertex2)
			return vertex1;
		else
			throw new RuntimeException("Inconsistent edge");
	}

	public int compareTo(Edge otherEdge) {
		if (this.weight() < otherEdge.weight())
			return -1;
		else if (this.weight() > otherEdge.weight())
			return +1;
		else
			return 0;
	}

	public String toString() {
		return String.format("%d-%d %.2f", vertex1, vertex2, weight);
	}

}
