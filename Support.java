public class Support {
	
	public class Stub {
		public void main(String[] args) {
			System.out.println("Hello World!");
		}
	}
	
	public static void s(Object s) {
		System.out.println(String.valueOf(s));
	}
	
	public static void pL(Object[] u) {
		for (int i = 0; i < u.length; i++) {
			System.out.println(u[i]);
		}
	}
	
	public static void pL(String[] u) {
		for (int i = 0; i < u.length; i++) {
			System.out.println(u[i]);
		}
	}
	
	public static void pL(Iterable<Integer> u) {
		for (Integer i : u) {
			System.out.print(i + " ");
		}
		
		System.out.print("\n");
	}
	
	public static void pL(int[] u) {
		pL(u, u.length);
	}
	
	public static int radix() {
		return 36;
	}
	
	public static int charVal(char c) {
		if (Character.isDigit(c)) {
			return Character.getNumericValue(c);
		} else {
			if (c < 97 || c > 122) {
				return -1;
			} else {
				return c - 87;
			}
		}
	}

	
	public static void pL(int[] u, int till) {
		for (int i = 0; i < till; i++) {
			System.out.print(u[i] + " ");
		}
		
		System.out.print("\n");	
	}
	
	public static void pL(Object[] u, int till) {
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
	
	public static EWD getEWD() {
		EWD e = new EWD(8);
		
		e.addEdge(new Dredge(0, 1, 5.0));
		e.addEdge(new Dredge(0, 4, 9.0));
		e.addEdge(new Dredge(0, 7, 8.0));
		e.addEdge(new Dredge(1, 2, 12.0));
		              
		e.addEdge(new Dredge(1, 3, 15.0));
		e.addEdge(new Dredge(1, 7, 4.0));
		e.addEdge(new Dredge(2, 3, 3.0));
		e.addEdge(new Dredge(2, 6, 11.0));
		              
		e.addEdge(new Dredge(3, 6, 9.0));
		e.addEdge(new Dredge(4, 5, 4.0));
		e.addEdge(new Dredge(4, 6, 20.0));
		e.addEdge(new Dredge(4, 7, 5.0));
		              
		e.addEdge(new Dredge(5, 2, 1.0));
		e.addEdge(new Dredge(5, 6, 13.0));
		e.addEdge(new Dredge(7, 5, 6.0));
		e.addEdge(new Dredge(7, 2, 7.0));
		
		return e;
	}
	
	public static void main(String[] args) {
		System.out.println("Hello Support!");
	}
}