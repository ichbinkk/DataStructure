import java.util.*;

/**
 * 链表实现的线性表 
 * @author King
 * @param <Item>
 */
public class MyLinkedList<Item> {
			
	private Node head;	//保存链表头部
	
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
	
	/**
	 * 向链表尾部插入数据
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
		tmp.next = newNode;     //tmp指向链尾，将newNode添加进tmp.next
	}
	
	/**
	 * 
	 * @return 结点长度
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
	 * @param index 删除第index个结点
	 * @return
	 */
	public boolean deleteNode(int index) {
		if (index < 1 || index > length()) {
			return false;
		}
		if(index == 1) {       //先判定是不是删除头部结点
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
	 * 双重循环遍历， 删除重复元素
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
	 * 从头到尾输出单链表
	 */
	public void printList() {
		Node tmp = head;
		while(tmp != null) {
			System .out.println(tmp.item);
			tmp = tmp.next;
		}
	}
	
	/**
	 * 从尾到头输出单链表
	 * @param x
	 */
	public void printListReversely(Node n) {
		if(n.next != null)
			printListReversely(n.next);
	
		System.out.println(n.item);
	}
	
	/**
	 * 检测链表是否为环
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
	 * 找到环的入口点
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
	 * 不知道头结点的情况下删除指定结点
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
	 * 判断链表是否相交
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
