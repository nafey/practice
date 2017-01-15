import java.util.List;
import java.util.ArrayList;

public class BFS {
	
	private boolean[] visited;
	private int[] fromVert;
	private int[] distance;
	private int source;
	
	public BFS(Graph G, int s) {	
		this.source = s;
		this.visited = new boolean[G.V()];
		this.fromVert = new int[G.V()];
		this.distance = new int[G.V()];
		
		for (int i = 0; i < this.distance.length; i++) {
			this.distance[i] = -1;
		}
		
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(s);
		
		this.distance[s] = 0;
		
		while (!queue.isEmpty()) {
			Integer top = queue.dequeue();
			for (Integer i : G.adj(top)) {
				if (!visited[i]) {
					visited[i] = true;
					fromVert[i] = top;
					this.distance[i] = this.distance[top] + 1;
					queue.enqueue(i);
				}
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return visited[v];
	}
	
	public int distance(int v) {
		return this.distance[v];
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
		Graph g = Support.getDigraph();
		BFS d = new BFS(g, 0);
		
		for (Integer i : d.pathTo(2)) {
			System.out.println(i);
		}
		
		System.out.println(d.distance(2));
	}
}