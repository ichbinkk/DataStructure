import java.util.*;

public class MyLinkedList<Item> {
			
	private Node head = null;	//保存链表头部
	
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
		
	public void printList() {
		Node tmp = head;
		while(tmp != null) {
			System .out.println(tmp.item);
			tmp = tmp.next;
		}
	}
	
	public static void main(String[] args) {
		MyLinkedList<String> list = new MyLinkedList<String>();
		list.addNode("x");
		list.addNode("x");list.addNode("x");
		list.addNode("y");list.addNode("x");list.addNode("y");
		list.addNode("z");
		list.addNode("z");
		list.printList();
		System .out.println("***********");
		list.deleteDuplecate();
		list.printList();
	}
}
