import java.util.*;

public class PrintNum {	
	/**
	 * ����Ҫ��������ϴ�ӡ����������
	 */
	private int[] numbers = {1,2,2,3,4,5};
	private int n = numbers.length;
	//�������ͼ�нڵ��Ƿ񱻱�����
	private boolean[] visited = new boolean[n];
	//ͼ�Ķ�ά�����ʾ
	private int[][] graph = new int[n][n];
	//���ֵ����
	private String combination = "";
	
	public Set<String> getAllCombinations() {
		Set<String> set = new HashSet<String>();
		//����ͼ                                                                                                                                                                                                                                                                                                                                                                                                           
		buildGraph();
		//�ֱ�Ӳ�ͬ��������ȱ���ͼ
		for(int i = 0;i < n;i++) {
			dfs(i,set);
		}
		return set;
	}
	
	/**
	 * ����ͼ���ڽӾ���
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
		//������ȷ���ڱ���ʱ3��5�ǲ��ɴ��
		graph[3][5] = 0;
		graph[5][3] = 0;
	}
	
	/**
	 * ��ȱ���ͼ
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
