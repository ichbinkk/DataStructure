import java.util.Arrays;

/**
 * ʵ�ֻ��ڶѵ����ȶ���
 * @�ӡ�1����ʼ˳����
 */
public class MaxPQ<Key extends Comparable<Key>> {

	private Key[] pq;   //���ڶѵ���ȫ������
	private int N = 0;  //�洢��pq[1..N]�У�pq[0]û��ʹ��
	
	/**
	 * �������ȶ���
	 * @param maxN
	 */
	public MaxPQ(int maxN) {
		pq = (Key[]) new Comparable[maxN + 1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	public void insert(Key v) {
		pq[++N] = v;
		swim(N);
	}
	
	public Key delMax() {
		if(N == 0) return null;  //��ָֹ��Խ��
		Key max = pq[1];
		exch(1,N--);
		pq[N + 1] = null;
		sink(1);
		return max;
	}	

	private boolean less(int i, int j) {		
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}
	
	/**
	 * �������ϵĶ����򻯣��ϸ�����ʵ��
	 * @param a
	 * @param k
	 */
	private void swim(int k) {
		while(k > 1 && less(k/2,k)) {
			exch(k/2,k);
			k = k/2;
		}
	}
	
	/**
	 * �������µĶ����򻯣��³�����ʵ��
	 * @param a
	 * @param k
	 */
	private void sink(int k) {
		while(2*k <= N) {
			int j = 2*k;
			if(j < N && less(j,j+1)) j++;
			if(!less(k,j)) break;
			exch(k,j);
			k = j;
		}		
	}	
	
	@Override
	public String toString() {
		return "MaxPQ pq=" + Arrays.toString(pq) + ", N=" + N ;
	}

	public static void main(String[] args) {
		MaxPQ<Integer> p = new MaxPQ<>(5);
		p.insert(5);
		p.insert(4);
		p.insert(9);
		p.insert(8);
		p.insert(7);
		System.out.println(p);
		System.out.println(p.delMax());
		System.out.println(p.delMax());
		System.out.println(p.delMax());
		System.out.println(p.delMax());
		System.out.println(p.delMax());
		System.out.println(p.delMax());
		System.out.println(p.delMax());
	}

}
