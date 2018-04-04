
public class TestSort {
	
	/**
	 * ѡ������
	 * @param a
	 */
	public static void selectSort(int[] a) {		
		int n = a.length;
		for(int i = 0;i < n;i ++) {
			int min = i;
			for(int j = i + 1;j < n;j++ ) {
				if(a[j] < a[min]) {
					min = j;
				}				
			}
			if(min != i)   //������ֵ���Сֵ�ٽ��н��������û���ֵ���Сֵ�Ͳ�����
				exch(a,i,min);
		}
	}
		
	/**
	 * ��������
	 * @param a
	 */
	public static void insertSort(int[] a) {
		int n = a.length;
		for(int i = 1;i < n;i++) {
			//��a[i]���뵽���a[i-1] a[i-2]...֮��
			for(int j = i;j > 0 && a[j] < a[j-1];j--) {
				exch(a,j,j - 1);
			}
		}
	}
	
	/**
	 * ð������
	 * @param a
	 */
	public static void BubbleSort(int[] a) {
		int n = a.length;
		for(int i = 0;i < n;i++) {
			for(int j = i + 1;j < n;j++) {
				if(a[j] < a[i])
					exch(a,i,j);
			}
		}
	}
	
	/**
	 * ϣ������       
	 * @�����ڲ��������Ƚ������Ϊ��������У��ֱ���в������򣬴�����������󡱣������������һ�β�������
	 * @param a
	 */	 
	public static void shell(int[] a) {
		int n = a.length;
		int h = 1;
		while(h < n/3) {
			h = 3 * h + 1;
		}
		while(h >= 1) {
			for(int i = h; i < n;i++) {
				for(int j = i;j >= h && (a[j] < a[j - h]);j -= h) {
					exch(a,j,j - h);
				}
			}
			h = h / 3;
		}
	}
	
	/**
	 * ԭ�ع鲢�ĳ��󷽷������ڹ鲢����
	 * @param a
	 * @param lo
	 * @param mid
	 * @param hi
	 */	
	public static void merge(int[] a,int lo,int mid,int hi) {
		//��a[lo..mid]��a[mid+1..hi]�鲢
		int i = lo, j = mid + 1;
		
		int[] aux = new int[a.length];  //��a[lo..hi]���Ƶ�aux[lo..hi]
		for(int k = lo;k <= hi;k++) {			
			aux[k] = a[k];
		}
		
		for(int k = lo;k <= hi;k++) {	//�鲢�ص�a[lo..hi]		
			if(i > mid)                 a[k] = aux[j++];
			else if(j > hi)             a[k] = aux[i++];
			else if(aux[j] < aux[i])    a[k] = aux[j++];
			else                        a[k] = aux[i++];
		}
	}
	
	/**
	 * �鲢����
	 * @param a
	 * @param lo
	 * @param hi
	 */
	public static void mergeSort(int a[],int lo,int hi) {
		if(hi <= lo) return;
		int mid = lo + (hi -lo)/2;
		mergeSort(a,lo,mid);   //����������
		mergeSort(a,mid + 1,hi);   //����������
		merge(a,lo,mid,hi);
	}

	/**
	 * ����������з�
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	public static int partition(int[] a,int lo,int hi) {
		int i = lo,j = hi + 1;
		int v = a[lo];
		while(true) {
			while(a[++i] < v) if(i == hi) break;
			while(a[--j] > v) if(j == lo) break;
			if(i >= j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	
	/**
	 * ��������
	 * @param a
	 * @param lo
	 * @param hi
	 */
	public static void quickSort(int[] a,int lo,int hi) {
		if(hi <= lo) return;
		int j = partition(a, lo, hi);
		quickSort(a,lo,j-1);
		quickSort(a,j+1,hi);
	}
		
	//������ӡ�����������
	public static void show(int[] a) {
		for(int i = 0;i < a.length;i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	//����������������
	private static void exch(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void main(String[] args) {
		int a[] = {5,4,9,8,7,6,0,1,3,2};
		//selectSort(a);
		//insertSort(a);
		//BubbleSort(a);
		//shell(a);
		//mergeSort(a,0,a.length - 1);
		quickSort(a,0,a.length - 1);
		show(a);		
	}

}
