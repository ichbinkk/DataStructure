import java.util.*;

public class Graph {

	private int V;  //顶点数
	private int E;  //边数
	private Bag<Integer>[] adj;  //邻接表
	
	public Graph(int V) {   //创建邻接表，将所有链表初始化为空。只有点，没有边
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0;v < V;v++)
			adj[v] = new Bag<Integer>();
	}
	
	public Graph(Scanner in) {
		this(in.nextInt());  //读取V并将图初始化
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
