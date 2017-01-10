import java.util.List;
import java.util.ArrayList;

public class DFS {
	
	private boolean[] visited;
	private int[] fromVert;
	private int source;
	
	public DFS(Graph G, int s) {	
		this.source = s;
		this.visited = new boolean[G.V()];
		this.fromVert = new int[G.V()];
		
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		
		while (!stack.isEmpty()) {
			Integer top = stack.pop();
			for (Integer i : G.adj(top)) {
				if (!visited[i]) {
					visited[i] = true;
					fromVert[i] = top;
					stack.push(i);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return visited[v];
	}
	
	public Iterable<Integer> pathTo(int v) {
		if (!visited[v]) return new ArrayList<>();
		
		int count = 1;
		int from = v;
		while (from != source) {
			from = fromVert[from];
			count++;
		}
		
		List<Integer> ret = new ArrayList<>();
		
		from = v;
		int i = 0;
		ret.add(v);
		while (from != source) {
			i++;
			from = fromVert[from];
			ret.add(from);
		}
		return ret;
	}
	
	public static void main(String args[]) {
		Graph g = Support.getGraph();
		DFS d = new DFS(g, 0);
		
		for (Integer i : d.pathTo(3)) {
			System.out.println(i);
		}
		
		System.out.println("Hello DFS");
	}
}