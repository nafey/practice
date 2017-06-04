public class Trie {
	class Node {
		public Object val;
		public Node[] next;
		
		public Node(Object val) {
			this.val = val;
			this.next = new Node[Support.radix()];
		}
	}
	
	public Node head;
	
	public Trie() {
		this.head = new Node(null);
	}
	
	public void add(String key, Object val) {
		Node current = this.head;
		for (int i = 0; i < key.length(); i++) {
			int idx = Support.charVal(key.charAt(i));
			if (current.next[idx] == null) {
				current.next[idx] = new Node(null);
			}
				
			current = current.next[idx];
		}
		
		current.val = val;
	}

	public Object get(String key) {
		Node current = this.head;
		for (int i = 0; i < key.length(); i++) {
			int idx = Support.charVal(key.charAt(i));
			
			if (current.next[idx] == null) {
				return null;
			}

			current = current.next[idx];
		}
		
		return 	current.val;
	}
	
	public boolean contains(String key) {
		Node current = this.head;
		for (int i = 0; i < key.length(); i++) {
			int idx = Support.charVal(key.charAt(i));
			
			if (current.next[idx] == null) {
				return false;
			}

			current = current.next[idx];
		}
		
		if (current.val == null) return false;
		
		return true;
	}
	
	
	public static void main(String[] args) {
		Trie tr = new Trie();
		
		tr.add("abc", 14);		
		// Support.pL(tr.head.next[10].next[11].next);
		Support.s(tr.get("abc"));
		
		System.out.println("Hello World!");
	}
}
	