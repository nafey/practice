public class Queue<T> {
	public Node<T> head;
	public Node<T> tail;
	
	public boolean isEmpty() {
		return ((head == null) && (tail == null));
	}
	
	public void enqueue(T val) {
		Node n = new Node<>(val);
		if (this.isEmpty()) {
			tail = head = n;
		} else {
			tail.next = n;
			tail = n;
		}
	}
	
	public T dequeue() {
		T ret = this.head.val;
		head = head.next;
		
		if (head == null) tail = null;
		
		return ret;
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(5);
		queue.enqueue(51);
		queue.enqueue(15);
		
		
		
		while (!queue.isEmpty()) {
			System.out.println(queue.dequeue());
		}
		System.out.println("Hello Queue!");
	}
}