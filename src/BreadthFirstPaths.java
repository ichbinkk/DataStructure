import java.io.File;
import java.util.Scanner;

/**
 * 广度优先搜索（bfs),寻找最短路径
 * @author King
 */
public class BreadthFirstPaths {

	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public BreadthFirstPaths(Graph G,int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G,s);
	}
	
	private void bfs(Graph G, int s) {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		marked[s] = true;
		queue.enqueue(s);
		while(!queue.isEmpty()) {
			int v = queue.dequeue();
			for(int w: G.adj(v) ) {
				if(!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					queue.enqueue(w);
				}
			}
		}		
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x = v;x != s;x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("tinyCG.txt"));  //读取文件流
		Graph G = new Graph(in);
		int s = 0;
		BreadthFirstPaths search = new BreadthFirstPaths(G,s);
		
		for(int v = 0;v < G.V();v++) {
			System.out.print(s + " to " + v + ":");
			if(search.hasPathTo(v)) {
				for(int x :search.pathTo(v)) {
					if(x == s) System.out.print(x);
					else       System.out.print("-" + x);
				}
			}
			System.out.println();
		}
	}

}
