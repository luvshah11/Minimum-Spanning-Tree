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

public class Edge {
	private final int v;//one vertex
	private final int w; // the other vertex
	private final double weight; // edge weight
	public Edge(int v, int w, double weight)
	{
	this.v = v;
	this.w = w;
	this.weight = weight;
	}
	public double weight()
	{ return weight; }
	public int either()
	{ return v; }
	public int other(int vertex)
	{
	if (vertex == v) return w;
	else if (vertex == w) return v;
	else throw new RuntimeException("Inconsistent edge");
	}
	public int compareTo(Edge that)
	{
	if (this.weight() < that.weight()) return -1;
	else if (this.weight() > that.weight()) return +1;
	else return 0;
	}
	public String toString()
	{ return String.format("%d-%d %.2f", v, w, weight); }

}
