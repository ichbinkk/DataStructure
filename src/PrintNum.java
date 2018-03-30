import java.util.*;

public class PrintNum {	
	/**
	 * 按照要求排列组合打印出所有数字
	 */
	private int[] numbers = {1,2,2,3,4,5};
	private int n = numbers.length;
	//用来标记图中节点是否被遍历过
	private boolean[] visited = new boolean[n];
	//图的二维数组表示
	private int[][] graph = new int[n][n];
	//数字的组合
	private String combination = "";
	
	public Set<String> getAllCombinations() {
		Set<String> set = new HashSet<String>();
		//构造图                                                                                                                                                                                                                                                                                                                                                                                                           
		buildGraph();
		//分别从不同结点出发深度遍历图
		for(int i = 0;i < n;i++) {
			dfs(i,set);
		}
		return set;
	}
	
	/**
	 * 构造图的邻接矩阵
	 */
	private void buildGraph() {
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < n;j++) {
				if(i == j) {
					graph[i][j] = 0;
				} else {
					graph[i][j] = 1;
				}
			}	
		}
		//！！！确保在遍历时3与5是不可达的
		graph[3][5] = 0;
		graph[5][3] = 0;
	}
	
	/**
	 * 深度遍历图
	 * @param start
	 * @param set
	 */
	private void dfs(int start, Set<String> set) {
		visited[start] = true;
		combination += numbers[start];
		if(combination.length() == n) {
			if(combination.indexOf("4") != 2)
				set.add(combination);
		}
		for(int j = 0;j < n;j++) {
			if(graph[start][j] == 1 && visited[j] == false)
				dfs(j,set);			
		}
		combination = combination.substring(0,combination.length() - 1);
		visited[start] = false;
	}
	
	public static void main(String[] args) {
		PrintNum t = new PrintNum();
		Set<String> set = t.getAllCombinations();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String str = (String)it.next();
			System.out.println(str);	
		}
	}
}
