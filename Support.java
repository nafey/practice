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
	
	public static void main(String[] args) {
		System.out.println("Hello Support!");
	}
}