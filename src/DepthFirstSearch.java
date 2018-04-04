import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 深度优先搜索算法
 * @author King
 */
public class DepthFirstSearch {

	private boolean[] marked;
	private int count;
	
	public DepthFirstSearch(Graph G,int s) {
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	
	private void dfs(Graph G,int v) {
		marked[v] = true;
		count++;
		for(int w:G.adj(v))
			if(!marked[w]) dfs(G,w);
	}
	
	public boolean marked(int w) {
		return marked[w];
	}
	
	public int count() {
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(new File("tinyCG.txt"));  //读取文件流
		Graph G = new Graph(in);		
		DepthFirstSearch d = new DepthFirstSearch(G,0);
		System.out.println(Arrays.toString(d.marked));
	}

}
