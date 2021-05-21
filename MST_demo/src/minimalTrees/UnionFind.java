package minimalTrees;

public class UnionFind {
//	pg219 Sec. 1.5 S&W text
//	public class UF
//	UF(int N) 						initialize N edges with integer weights (0 to N-1)
//	void union(int p, int q) 		add connection between p and q
//	int find(int p) 				component identifier for p (0 to N-1)
//	boolean connected(int p, int q) return true if p and q are in the same component
//	int count() 					number of components

	//pg 228 Algorithm 1.5
	private int count;
	private int identifierArray[]; //array with vertexes being the position in the array 
									//and the parent subgraph being the value stored on that position 
	private int[] size; // size of component for roots (site indexed)
	UnionFind(int numberofVertices)
	{
		count = numberofVertices;
		identifierArray = new int[numberofVertices];
		for (int i = 0; i < numberofVertices; i++)
			identifierArray[i] = i;
		
		size = new int[numberofVertices];
		for (int i = 0; i < numberofVertices; i++) size[i] = 1;
	}
	void union(int vertex1, int vertex2) //union 2 roots on a graph together to have the same subgraph parent
	{
		int i = find(vertex1);
		int j = find(vertex2);
		if (i == j) return;
		
		// Make smaller root point to larger one.
		if (size[i] < size[j]) { identifierArray[i] = j; size[j] += size[i]; }
		else { identifierArray[j] = i; size[i] += size[j]; }
		count--;
	}
	//find the subgraph a vertex is in 
	int find(int vertex)
	{
		while (vertex != identifierArray[vertex]) {
			vertex = identifierArray[vertex];
		}
		return vertex;
	}
	boolean connected(int vertex1, int vertex2) //are these vertexes in the same subgraph?
	{
		return find(vertex1) == find(vertex2);
	}
	int count()
	{
		return count;
	}

}
