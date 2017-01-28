public class Strong {
	private int[] scc;
	
	//Implementation of the strong components
	public Strong(Digraph g) {
		Digraph grev = g.getReverse();
		Topology t = new Topology(grev);
		
		Integer[] rev = new Integer[grev.V()];
		int c = 0;
		for (Integer i : t.getTopologicalSort()) {
			rev[c] = i;
			c++;
		}
		
		this.scc = new int[grev.V()];
		
		for (int i = 0; i < scc.length; i++) {
			// marks unvisited
			scc[i] = -1; 
		}
		
		int val = 0;
		for (int i = 0; i < scc.length; i++) {
			if (scc[rev[i]] == -1) {
				this.markSCC(g, rev[i], scc, val);
				val++;
			}
		}
		
		System.out.println(g.connected(0, 1));
		
		System.out.println("-------------------");
		
		for (int i = 0; i < scc.length; i++) {
			System.out.println("Vertex " + i + " is in " + scc[i] + " SCC");
		}
	}
	
	private void markSCC(Digraph g, int source, int[] scc, int val){
		scc[source] = val;
		for (Integer i : g.adj(source)){
			if (scc[i] == -1) {
				markSCC(g, i, scc, val);
			}
		}
	}
	
	public static void main(String[] args) {
		Strong s = new Strong(Support.getDigraph());
		System.out.println("Hello World!");
	}
}