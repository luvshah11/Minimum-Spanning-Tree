

//import java.util.Collection;

public interface Graph<E> {
	/**
	 * @return the number of vertices in the graph
	 */
	int getNumberOfVerticies();

	/**
	 * @return the number of edges in the graph
	 */
	int getNumberOfEdges();

	/**
	 * Adds the specified undirected edge to the graph
	 * 
	 * @param from the start vertex
	 * @param to   the end vertex
	 * @return true if the vertex did not already exist
	 */
	boolean addEdge(E from, E to);

	/**
	 * Get all vertices adjacent to the specified vertex
	 * 
	 * @param to the specified vertex
	 * @return a Collection of all adjacent vertices
	 */
	//Collection<E> getAdjacent(E to);

	/**
	 * Removes the edge both from and to
	 * 
	 * @param from the start vertex
	 * @param to   the end vertex
	 * @return true if an edge was removed
	 */
	boolean removeEdge(E from, E to);

}
