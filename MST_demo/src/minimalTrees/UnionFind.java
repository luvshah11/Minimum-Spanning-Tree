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
	private int id[];
	private int[] sz; // size of component for roots (site indexed)
	UnionFind(int N)
	{
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
		
		sz = new int[N];
		for (int i = 0; i < N; i++) sz[i] = 1;
	}
	void union(int p, int q)
	{
		int i = find(p);
		int j = find(q);
		if (i == j) return;
		
		// Make smaller root point to larger one.
		if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
		else { id[j] = i; sz[i] += sz[j]; }
		count--;
	}
	int find(int p)
	{
		while (p != id[p]) p = id[p];
		return p;
	}
	boolean connected(int p, int q)
	{
		return find(p) == find(q);
	}
	int count()
	{
		return count;
	}

}
