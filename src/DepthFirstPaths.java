import java.io.File;
import java.util.Scanner;

/**
 * dfs，解决寻找单点路径问题
 * @author King
 */
public class DepthFirstPaths {

	private boolean[] marked;  
	private int[] edgeTo;  //从起点到一个顶点的已知路径上的最后一个顶点
	private final int s;   //起点
	
	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		dfs(G,s);
	}
	
	private void dfs(Graph G,int v) {
		marked[v] = true;
		for(int w:G.adj(v)) {
			if(!marked[w]) {
				edgeTo[w] = v;
				dfs(G,w);
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
		DepthFirstPaths search = new DepthFirstPaths(G,s);
		
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
