import java.util.*;

/**
 * ����ʵ��ջ
 * @author King
 * @param <Item>
 */
public class Stack<Item> implements Iterable<Item>{

	private Node first; //ջ��Ԫ�أ������ӵ�Ԫ�أ�
	private int N;      //Ԫ������
	
	
	/**������ġ��ڲ��ࡰ
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
		return first == null; //�� N == 0
	} 	
	
	public int size() {	
		return N;
	}
	
	public void push(Item item) {
		//��ջ��������ͷ�����Ԫ�أ���֤ջ��Ϊ����Ԫ��
		Node oldfirst = first;
		first = new Node(item);
		first.next = oldfirst;
		N++;
	}
	
	/**
	 * ȡ��ջ��Ԫ�أ�����Ԫ�أ�����ջ��ɾ��
	 * @return ջ��Ԫ��
	 */
	public Item pop() {
		if(this.isEmpty())  //�жϿ�ջ
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
//		System .out.println("ջԪ�ظ���:" + s.size());
//		System .out.println("ջ��Ԫ��Ϊ:" + s.pop());
//		System .out.println("ջ��Ԫ��Ϊ:" + s.pop());
		Iterator it = s.iterator();
	}
}
