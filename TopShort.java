public class TopShort {
	private static final int MAX = 9999;
	
	private EWD graph;
	private int source;
	
	private double[] dist;
	private Dredge[] from;
	
	public TopShort(EWD g, int s) {
		this.graph = g;
		this.source = s;
		
		dist = new double[g.V()];
		
		for (int i = 0; i < dist.length; i++) {
			this.dist[i] = MAX;
		}
		
		this.dist[s] = 0;
		
		from = new Dredge[g.V()];
		
		Digraph dg = new Digraph(g.V());
		
		for (Dredge d : g.edges()) {
			dg.addEdge(d.from(), d.to());
		}
		
		Topology t = new Topology(dg);
		
		for (Integer i : t.getTopologicalSort()) {
			Integer top = i;
			double curr = dist[top];
			
			for (Dredge d : g.adj(top)) {
				if (curr + d.weight() < dist[d.to()]) {
					from[d.to()] = d;
					dist[d.to()] = curr + d.weight();
				}
			}
		}
	}
	
	public double distTo(int v) {
		return dist[v];
	}
	
	public Iterable<Integer> pathTo(int v) {
		Stack<Integer> stack = new Stack<>();
		
		int curr = v;
		stack.push(curr);
		
		while (curr != source) {
			curr = from[curr].from();
			stack.push(curr);
		}
		
		return stack;
	}
	
	public static void main(String[] args) {
		TopShort t = new TopShort(Support.getEWD(), 0);
		Support.printList(t.pathTo(6));
		
		System.out.println("Hello World!");
	}
}