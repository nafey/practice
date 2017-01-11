import java.util.List;
import java.util.ArrayList;

public class BFS {
	
	private boolean[] visited;
	private int[] fromVert;
	private int source;
	
	public BFS(Graph G, int s) {	
		this.source = s;
		this.visited = new boolean[G.V()];
		this.fromVert = new int[G.V()];
		
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(s);
		
		while (!queue.isEmpty()) {
			Integer top = queue.dequeue();
			for (Integer i : G.adj(top)) {
				if (!visited[i]) {
					visited[i] = true;
					fromVert[i] = top;
					queue.enqueue(i);
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
		BFS d = new BFS(g, 0);
		
		for (Integer i : d.pathTo(2)) {
			System.out.println(i);
		}
		
		System.out.println("Hello BFS");
	}
}