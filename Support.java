public class Support {
	public static Graph getGraph() {
		Graph graph = new Graph(10);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(0, 6);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(7, 9);
		
		return graph;
	}
	
	public static Graph getDigraph() {
		Graph graph = new Digraph(13);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 5);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 2);
		graph.addEdge(3, 5);
		graph.addEdge(4, 2);
		graph.addEdge(4, 3);
		graph.addEdge(5, 4);
		graph.addEdge(6, 0);
		graph.addEdge(6, 4);
		graph.addEdge(6, 8);
		graph.addEdge(6, 9);
		graph.addEdge(7, 6);
		graph.addEdge(7, 9);
		graph.addEdge(8, 6);
		graph.addEdge(9, 10);
		graph.addEdge(9, 11);
		graph.addEdge(10, 12);
		graph.addEdge(11, 4);
		graph.addEdge(11, 12);
		graph.addEdge(12, 9);
		
		return graph;
	}
	
	public static void main(String[] args) {
		System.out.println("Hello Support!");
	}
}