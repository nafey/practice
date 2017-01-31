public class Union {
	private int[] u;
	
	public Union(int n) {
		u = new int[n];
		
		for (int i = 0; i < u.length; i++) {
			u[i] = i;
		}
	}
	
	public void union(int a, int b) {
		int remove_this = u[b];
		for (int i = 0; i < u.length; i++) {
			if (u[i] == remove_this) {
				u[i] = u[a];
			}
		}
	}
	
	public boolean connected(int a, int b) {
		return (u[a] == u[b]);
	}
	
	
	
	public static void main(String[] args) {
		Union u = new Union(7);

		u.union(1, 2);
		u.union(3, 4);
		u.union(2, 3);
		
		System.out.println(u.connected(1, 4));
	}
}