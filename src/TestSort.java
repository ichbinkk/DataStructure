
public class TestSort {
	
	/**
	 * 选择排序
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
			if(min != i)   //如果发现到更小值再进行交换，如果没发现到更小值就不交换
				exch(a,i,min);
		}
	}
		
	/**
	 * 插入排序
	 * @param a
	 */
	public static void insertSort(int[] a) {
		int n = a.length;
		for(int i = 1;i < n;i++) {
			//将a[i]插入到左边a[i-1] a[i-2]...之中
			for(int j = i;j > 0 && a[j] < a[j-1];j--) {
				exch(a,j,j - 1);
			}
		}
	}
	
	/**
	 * 冒泡排序
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
	 * 希尔排序       
	 * @“基于插入排序，先将数组分为多个子序列，分别进行插入排序，待“基本有序后”，最后对整体进行一次插入排序
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
	 * 原地归并的抽象方法，用于归并排序
	 * @param a
	 * @param lo
	 * @param mid
	 * @param hi
	 */	
	public static void merge(int[] a,int lo,int mid,int hi) {
		//将a[lo..mid]和a[mid+1..hi]归并
		int i = lo, j = mid + 1;
		
		int[] aux = new int[a.length];  //将a[lo..hi]复制到aux[lo..hi]
		for(int k = lo;k <= hi;k++) {			
			aux[k] = a[k];
		}
		
		for(int k = lo;k <= hi;k++) {	//归并回到a[lo..hi]		
			if(i > mid)                 a[k] = aux[j++];
			else if(j > hi)             a[k] = aux[i++];
			else if(aux[j] < aux[i])    a[k] = aux[j++];
			else                        a[k] = aux[i++];
		}
	}
	
	/**
	 * 归并排序
	 * @param a
	 * @param lo
	 * @param hi
	 */
	public static void mergeSort(int a[],int lo,int hi) {
		if(hi <= lo) return;
		int mid = lo + (hi -lo)/2;
		mergeSort(a,lo,mid);   //将左半边排序
		mergeSort(a,mid + 1,hi);   //将左半边排序
		merge(a,lo,mid,hi);
	}

	/**
	 * 快速排序的切分
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
	 * 快速排序
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
		
	//遍历打印出数组的数字
	public static void show(int[] a) {
		for(int i = 0;i < a.length;i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	//交换数组中两个数
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
