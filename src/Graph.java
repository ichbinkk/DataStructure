import java.util.*;

public class Graph {

	private int V;  //������
	private int E;  //����
	private Bag<Integer>[] adj;  //�ڽӱ�
	
	public Graph(int V) {   //�����ڽӱ������������ʼ��Ϊ�ա�ֻ�е㣬û�б�
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0;v < V;v++)
			adj[v] = new Bag<Integer>();
	}
	
	public Graph(Scanner in) {
		this(in.nextInt());  //��ȡV����ͼ��ʼ��
		this.E = in.nextInt();
		for(int i = 0;i < E;i++) {
			int v = in.nextInt();
			int w = in.nextInt();
			addEdge(v, w);
		}
	}
	
	public void addEdge(int v,int w) {
		adj[v].add(w);
		adj[w].add(v);
		//E++;
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

}
