import java.util.Iterator;


/**
 * 链表实现队列
 * @author King
 *
 */
public class MyQueue<Item> implements Iterable<Item>{

	private class Node {
		Item item;
		Node next;
		public Node(Item item) {
			this.item = item;
		}
	}
	
	private Node first;
	private Node last;
	private int N;
	
	public boolean isEmpty() { 
		return first == null; //或 N == 0
	} 	
	
	public int size() {	
		return N;
	}
	
	public void enqueue(Item item) {
		Node oldlast = last;
		last = new Node(item);
		last.next = null;
		if(isEmpty()) first = last;
		else oldlast.next = last;
		N++;
	}
	
	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		if(isEmpty()) last = null;
		N--;
		return item;
	}
	

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new MyQueueIterator();
	}
	
	private class MyQueueIterator implements Iterator<Item> {
		private Node current = first;
		public boolean hasNext() {
			return current != null;
		}
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		public void remove() {
			// TODO Auto-generated method stub
		}		
	}
	
	public static void main(String[] args) {
		MyQueue<String> q = new MyQueue<String>();
		q.enqueue("F");
		q.enqueue("B");
		q.enqueue("I");
		q.enqueue("D");
		System.out.println(q.size());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}


}
