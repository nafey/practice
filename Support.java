public class Support {
	
	public class Stub {
		public void main(String[] args) {
			System.out.println("Hello World!");
		}
	}
	
	public static void printList(int[] u) {
		printList(u, u.length);
	}
	
	public static void printList(int[] u, int till) {
		for (int i = 0; i < till; i++) {
			System.out.print(u[i] + " ");
		}
		
		System.out.print("\n");	
	}
	
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
	
	public static Digraph getDigraph() {
		Digraph graph = new Digraph(13);
		
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
	
	public static Digraph getDAG() {
		Digraph graph = new Digraph(7);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 5);
		graph.addEdge(1, 4);
		graph.addEdge(3, 2);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(3, 6);
		graph.addEdge(5, 2);
		graph.addEdge(6, 0);
		graph.addEdge(6, 4);
		
		return graph;
	}
	
	public static EWG getEWG() {
		EWG e = new EWG(8);
		
		e.addEdge(new Edge(4, 5, 0.35));
		e.addEdge(new Edge(4, 7, 0.37));
		e.addEdge(new Edge(5, 7, 0.28));
		e.addEdge(new Edge(0, 7, 0.16));
		
		e.addEdge(new Edge(1, 5, 0.32));
		e.addEdge(new Edge(0, 4, 0.38));
		e.addEdge(new Edge(2, 3, 0.17));
		e.addEdge(new Edge(1, 7, 0.19));
		
		e.addEdge(new Edge(0, 2, 0.26));
		e.addEdge(new Edge(1, 2, 0.36));
		e.addEdge(new Edge(1, 3, 0.29));
		e.addEdge(new Edge(2, 7, 0.34));
		
		e.addEdge(new Edge(6, 2, 0.40));
		e.addEdge(new Edge(3, 6, 0.52));
		e.addEdge(new Edge(6, 0, 0.58));
		e.addEdge(new Edge(6, 4, 0.93));
		
		return e;
	}
	
	public static void main(String[] args) {
		System.out.println("Hello Support!");
	}
}