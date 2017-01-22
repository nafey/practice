public class Topology {
	
	private boolean[] vis;
	
	private Stack<Integer> ret;
	
	private void dfs(Graph g, int source, boolean[] visited) {
		visited[source] = true;
		for (Integer i : g.adj(source)) {
			if (!visited[i]) {
				dfs(g, i, visited);
			}			
		}
		System.out.println(source);
	}
	
	public Topology(Digraph G) {	
		this.vis = new boolean[G.V()];
		this.ret = new Stack<Integer>();
		
		for (int i = 0; i < G.V(); i++) {
			if (!this.vis[i]) {
				dfs(G, i, this.vis);
			}
		}
	}
	
	public Iterable<Integer> getTopologicalSort(){
		return ret;
	}
	
	public static void main(String[] args) {
		Topology t = new Topology(Support.getDAG());
		
		for (Integer i : t.getTopologicalSort()) {
			System.out.println(i);
		}
		
	}
}