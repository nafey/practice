public class Heap {
	private static final int MAX_SIZE = 100;
	private int tail;
	private int[] vals; 
	
	public Heap() {
		this.vals = new int[MAX_SIZE];
		this.tail = 1;

		
	}
	
	void printHeap() {
		Support.printList(this.vals, this.tail);
	}
	
	private int getParent(int i) {
		return i / 2;
	}
	
	private int getChild1(int i) {
		int ret = i * 2;
		if (ret < MAX_SIZE && ret <= tail) {
			return ret;
		} else {
			return -1;
		}
	}
	
	private int getChild2(int i) {
		int ret = i * 2 + 1;
		if (ret < MAX_SIZE && ret <= tail) {
			return ret;
		} else {
			return -1;
		}
	}
	
	private void add(int val) {
		this.vals[tail] = val;
		this.swim(tail);
		tail++;
	}
	
	private int max() {
		if (tail == 1) return 0;
		int ret = this.vals[1];
		
		this.vals[1] = this.vals[tail - 1];
		tail = tail - 1;
		
		this.sink(1);
		
		return ret;
	}
		
		
	
	private void sink(int i) {
		if (i > MAX_SIZE || i >= tail) return;
		
		int c1 = this.getChild1(i);
		int c2 = this.getChild2(i);
		
		if (c1 == -1 || c2 == -1) {
			return;
		}
		
		if (this.vals[i] < this.vals[c1] || this.vals[i] < this.vals[c2]){
			int c;
			if (this.vals[c1] > this.vals[c2]) {
				c = c1;
			} else {
				c = c2;
			}
			
			int temp = this.vals[i];
			vals[i] = this.vals[c];
			this.vals[c] = temp;
			
			this.sink(c);
		}
	}
	
	private void swim(int i) {
		if (i <= 1) return;
		
		if (vals[i] > vals[getParent(i)]) {
			int temp = vals[i];
			vals[i] = vals[getParent(i)];
			vals[getParent(i)] = temp;
		}
		
		swim(getParent(i));
	}
	
	public static void main(String[] args) {
		Heap h = new Heap();
		
		h.add(2);
		h.add(3);
		h.add(1);
		h.add(4);
		h.add(5);
		h.add(6);
		
		h.printHeap();
		
		System.out.println("The max is " + h.max());
		h.printHeap();
		
		System.out.println("The max is " + h.max());
		h.printHeap();
		
		System.out.println("The max is " + h.max());
		h.printHeap();
		
		System.out.println("The max is " + h.max());
		h.printHeap();
		
		System.out.println("The max is " + h.max());
		h.printHeap();
		
		System.out.println("The max is " + h.max());
		h.printHeap();
		
		System.out.println("Hello World!");
	}
}