public class BellFord {
	private static final int MAX = 9999;
	
	private EWD graph;
	private int source;
	
	private double[] dist;
	private Dredge[] from;
	
	public BellFord(EWD g, int s) {
		this.graph = g;
		this.source = s;
		
		dist = new double[g.V()];
		
		for (int i = 0; i < dist.length; i++) {
			this.dist[i] = MAX;
		}
		
		this.dist[s] = 0;
		
		from = new Dredge[g.V()];
		
		Queue<Integer> q = new Queue<>();
		q.enqueue(s);
		
		while (!q.isEmpty()) {
			boolean[] repeatFlag = new boolean[graph.V()];
			
			Queue<Integer> worker = new Queue<>();
			while (!q.isEmpty()) {
				worker.enqueue(q.dequeue());
			}
			
			while (!worker.isEmpty()) {
				Integer top = worker.dequeue();
				double curr = dist[top];
				
				for (Dredge d : graph.adj(top)) {
					if (curr + d.weight() < dist[d.to()]) {
						from[d.to()] = d;
						dist[d.to()] = curr + d.weight();
						
						if (!repeatFlag[d.to()]) {
							q.enqueue(d.to());
							repeatFlag[d.to()] = true;
						}
					}
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
		BellFord dj = new BellFord(Support.getEWD(), 0);
		Support.printList(dj.pathTo(6));
		
		
		System.out.println("Hello World!");
	}
}