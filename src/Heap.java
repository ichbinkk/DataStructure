import java.util.*;

public class Heap <Key extends Comparable<Key>>{	
	
	/**
	 * ������
	 * 1.������
	 * 2.�����Ѷ�Ԫ�������һ��Ԫ�ص�λ�ã�����������
	 * @�ӡ�0����ʼ˳����
	 * @param a
	 */
	public static void heapSort(Comparable[] a) {
		int N = a.length;
		for(int k = (N-1)/2;k >= 0;k--)
			sink(a,k,N - 1);
		while(N > 0) {
			exch(a,0,(N--)-1);
			sink(a,0,N - 1);
		}
	}
	
	
	public static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	/**
	 * �������µĶ����򻯣��³�����ʵ��
	 * @param a
	 * @param k
	 */
	private static void sink(Comparable[] a,int k,int N) {
		while(2*k <= N) {
			int j = 2*k;
			if(j < N && less(a,j,j+1)) j++;
			if(!less(a,k,j)) break;
			exch(a,k,j);
			k = j;
		}		
	}	
	
	private static boolean less(Comparable[] a,int i, int j) {		
		return a[i].compareTo(a[j]) < 0;
	}
	
	public static void main(String[] args) {
		String[] num = {"S","O","R","T","S"};
		//Heap<Integer> h = new Heap<>();
		heapSort(num);
		System.out.println(Arrays.toString(num));
	}
}
