import java.util.*;

/**
 * 链表实现栈
 * @author King
 * @param <Item>
 */
public class Stack<Item> implements Iterable<Item>{

	private Node first; //栈顶元素（最近添加的元素）
	private int N;      //元素数量
	
	
	/**定义结点的”内部类“
	 * 
	 * @author King
	 *
	 */
	private class Node {
		Item item;
		Node next;
		public Node(Item item) {
			this.item = item;
		}
	}

	public boolean isEmpty() { 
		return first == null; //或 N == 0
	} 	
	
	public int size() {	
		return N;
	}
	
	public void push(Item item) {
		//向栈顶即链表头部添加元素，保证栈顶为最新元素
		Node oldfirst = first;
		first = new Node(item);
		first.next = oldfirst;
		N++;
	}
	
	/**
	 * 取出栈顶元素（最新元素）并在栈中删除
	 * @return 栈顶元素
	 */
	public Item pop() {
		if(this.isEmpty())  //判断空栈
			return null;
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<Item> {
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
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
//		System .out.println("栈元素个数:" + s.size());
//		System .out.println("栈顶元素为:" + s.pop());
//		System .out.println("栈顶元素为:" + s.pop());
		Iterator it = s.iterator();
	}
}
