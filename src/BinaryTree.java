import java.util.LinkedList;
import java.util.Queue;



public class BinaryTree {
	/**
	 * 定义树节点数据结构
	 * @author King
	 */
	private class Node {
		public int data;
		public Node left;
		public Node right;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	private Node root;
	public BinaryTree() {
		root = null;
	}
	
	/**
	 * 将数值输入构建二叉树
	 * @param data
	 */
	public void buildTree(int[] data) {
		for(int i = 0;i < data.length;i++) {
			insert(data[i]);
		}
	}
	
	/**
	 * 把data插入到二叉排序树中
	 * @param data
	 */
	public void insert(int data) {
		Node newNode = new Node(data);
		if(root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent;
		while(true)//寻找插入的位置
		{
			parent = current;
			if(data < current.data){
				current = current.left;
				if(current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if(current == null) {
					parent.right = newNode;
					return;
				}
			}
		}

	}
	
	/**
	 * 中序遍历方法递归实现
	 * @param localRoot
	 */
	public void inOrder(Node localRoot) {
		if(localRoot != null) {
			inOrder(localRoot.left);
			System.out.print(localRoot.data+" ");
			inOrder(localRoot.right);
		}
	}
	
	/**
	 * 先序遍历方法递归实现
	 * @param localRoot
	 */
	public void preOrder(Node localRoot) {
		if(localRoot != null) {
			System.out.print(localRoot.data+" ");
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}

	/**
	 * 后序遍历方法递归实现
	 * @param localRoot
	 */
	public void postOrder(Node localRoot) {
		if(localRoot != null) {					
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.print(localRoot.data+" ");
		}
	}
	
	/**
	 * 层序遍历方法“队列”实现
	 * @param localRoot
	 */
	public void layerTranverse(Node localRoot) {
		if(localRoot == null) 
			return;
		Queue<Node> q = new LinkedList<Node> ();
		q.add(localRoot);
		while(!q.isEmpty()){
			Node n = q.poll();
			System.out.print(n.data+" ");
			if(n.left != null) 
				q.add(n.left);
			if(n.right != null) 
				q.add(n.right);
		}
	}
	
	/**
	 * 二叉树的先序遍历和中序遍历得到后序遍历
	 * @param preOrder
	 * @param inOrder
	 */
	public void initTree(int[] preOrder,int[] inOrder) {
		this.root = this.initTree(preOrder, 0,preOrder.length-1,inOrder,0,inOrder.length-1);
	}
	
	/**
	 * 递归实现构建二叉排序树
	 * @param preOrder
	 * @param start1
	 * @param end1
	 * @param inOrder
	 * @param start2
	 * @param end2
	 * @return
	 */
	private Node initTree(int[] preOrder, int start1, int end1, int[] inOrder, int start2, int end2) {
		if(start1>end1||start2>end2)
			return null;
		int rootData = preOrder[start1];
		Node head = new Node(rootData);
		//找到根节点所在的位置
		int rootIndex = -1;
		for(int i = start2;i <= end2;i++) {
			if(inOrder[i] == rootData)
				rootIndex = i;
		}
		int offSet = rootIndex - start2-1;
		//递归构建左子树
		Node left = initTree(preOrder,start1+1,start1+1+offSet,inOrder,start2,start2+offSet);
		//递归构建右子树
		Node right = initTree(preOrder,start1+offSet+2,end1,inOrder,rootIndex+1,end2);
		head.left = left;
		head.right = right;
		return head;
	}

	public static void main(String[] args) {
		BinaryTree biTree = new BinaryTree();
		int[] data = {2,8,7,4,9,3,1,6,7,5};		
		biTree.buildTree(data);//构建一个树实例
		
		System.out.print("二叉树的中序遍历:");
		biTree.inOrder(biTree.root);
		System.out.println();
		System.out.print("二叉树的先序遍历:");
		biTree.preOrder(biTree.root);
		System.out.println();
		System.out.print("二叉树的后序遍历:");
		biTree.postOrder(biTree.root);
		System.out.println();
		System.out.print("二叉树的层序遍历:");
		biTree.layerTranverse(biTree.root);
		System.out.println();
		
		int[] preOrder = {1,2,4,8,9,5,10,3,6,7};
		int[] inOrder = {8,4,9,2,10,5,1,6,3,7};
		biTree.initTree(preOrder, inOrder);
		System.out.println("二叉树的先序遍历和中序遍历得到后序遍历");
		biTree.postOrder(biTree.root);
		
	}

}
