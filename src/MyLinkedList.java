import java.util.*;

/**
 * ����ʵ�ֵ����Ա� 
 * @author King
 * @param <Item>
 */
public class MyLinkedList<Item> {
			
	private Node head;	//��������ͷ��
	
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
	
	/**
	 * ������β����������
	 * @param d
	 */
	public void addNode(Item d) {
		Node newNode = new Node(d);
		if(head == null) {
			head = newNode;
			return;
		}
		Node tmp = head;
		while(tmp.next != null) {
			tmp = tmp.next;
		}		
		tmp.next = newNode;     //tmpָ����β����newNode��ӽ�tmp.next
	}
	
	/**
	 * 
	 * @return ��㳤��
	 */
	public int length() {
		int length = 0;
		Node tmp = head;
		while(tmp != null) {
			length++;
			tmp = tmp.next;
		}
		return length;
	}
	
	/**
	 * 
	 * @param index ɾ����index�����
	 * @return
	 */
	public boolean deleteNode(int index) {
		if (index < 1 || index > length()) {
			return false;
		}
		if(index == 1) {       //���ж��ǲ���ɾ��ͷ�����
			head = head.next;
			return true;
		}
		int i = 2;
		Node preNode = head;
		while(preNode.next != null) {
			if(i == index) {
				preNode.next = preNode.next.next;
				return true;
			}
			preNode = preNode.next;
			i++;	
		}
		return true;
	}
	
	/**
	 * ˫��ѭ�������� ɾ���ظ�Ԫ��
	 */
	public void deleteDuplecate() {
		Node p = head;
		while(p != null) {
			Node q = p;
			while(q.next != null) {
				if(p.item == q.next.item) {
					q.next = q.next.next;
				}
				else
					q = q.next;
			}
			p = p.next;
		}
	}
	
	/**
	 * ��ͷ��β���������
	 */
	public void printList() {
		Node tmp = head;
		while(tmp != null) {
			System .out.println(tmp.item);
			tmp = tmp.next;
		}
	}
	
	/**
	 * ��β��ͷ���������
	 * @param x
	 */
	public void printListReversely(Node n) {
		if(n.next != null)
			printListReversely(n.next);
	
		System.out.println(n.item);
	}
	
	/**
	 * ��������Ƿ�Ϊ��
	 * @param head
	 */
	public boolean isLoop(Node head) {
		if(head == null) return false;
		Node fast = head;
		Node slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)
				return true;
		}
		return !(fast == null||fast.next == null);
	}
	
	/**
	 * �ҵ�������ڵ�
	 * @param head
	 * @return
	 */
	public Node findLoopPort(Node head) {
		Node slow = head,fast = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow)
				break;
		}
		if(fast == null||fast.next == null)
			return null;
		slow = head;
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	/**
	 * ��֪��ͷ���������ɾ��ָ�����
	 * @param n
	 * @return
	 */
	public boolean deleteNode(Node n) {
		if(n == null || n.next == null)
			return false;
		n.item = n.next .item;
		n.next = n.next.next;
		return true;
	}
	
	/**
	 * �ж������Ƿ��ཻ
	 * @param n1
	 * @param n2
	 * @return
	 */
	public boolean isIntersect(Node n1,Node n2) {
		if(n1 == null|| n2 == null)
			return false;
		while(n1.next != null)
			n1 = n1.next;
		while(n2.next != null)
			n2 = n2.next;
		return n1 == n2;
	}
	
	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<String>();
		
		list.addNode("x");list.addNode("x");list.addNode("x");
		list.addNode("y");list.addNode("x");list.addNode("y");
		list.addNode("z");list.addNode("z");
		
		list.printList();
		System .out.println("***********");
		list.deleteDuplecate();
		list.printList();
		System .out.println("***********");
		list.printListReversely(list.head);
	}
}
