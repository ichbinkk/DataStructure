import java.util.Arrays;

public class ArrayTest {

	/**
	 * �����������֮�ͣ��������������ģ�
	 * @param arr
	 * @return ���ֵ����ӡ��ʼ���յ�λ������
	 */
	public static int maxSubArray(int[] arr) {
		int begin = 0,end = 0;
		int maxSum = Integer.MIN_VALUE;
		int nSum = 0; //�������������һλ�����ֵ
		for(int i =0;i < arr.length;i++) {
			if(nSum < 0) {
				nSum = arr[i];
				begin = i;
			} else {
				nSum += arr[i];
			}
			if(nSum > maxSum) {
				maxSum = nSum;
				end = i;
			}
		}
		System.out.println("begin=" + begin +",end="+end);
		return maxSum;
	}
/**************************end**********************************/	
	/**
	 * ��������������ӵ����ƶ����ֵ��������(����)
	 * @param a
	 * @param sum
	 */
	public static void findSum(int[] a,int sum) {
		Arrays.sort(a);
		int begin = 0;
		int end = a.length - 1;
		while(begin < end) {
			if(a[begin] + a[end] < sum)
				begin++;
			else if (a[begin] + a[end] > sum)
				end--;
			else {
				System.out.println(a[begin] +","+a[end]);
				begin++;
				end--;
			}
		}
	}
/**************************end**********************************/
	/**
	 * �������������е�һ��
	 * @param a
	 * @param begin
	 * @param end
	 */
	public static void reverse(int[] a,int begin,int end) {
		while(begin < end) {
			int temp = a[begin];
			a[begin] = a[end];
			a[end] = temp;
			begin++;
			end--;
		}
	}
	
	/**
	 * ��������kλ
	 * @param a
	 * @param k
	 */
	public static void leftShift_k(int[] a,int k) {
		int n = a.length;
		k = k % n;
		reverse(a,0,n-k-1);
		reverse(a,n-k,n-1);
		reverse(a,0,n-1);
	}	
/**************************end**********************************/
	/**
	 * �����������ظ�"�ظ���������"��Ԫ�أ�ȡ������
	 * @param a
	 * @return
	 */
	public static int findDup(int[] a) {
		int n = a.length;
		int result = Integer.MAX_VALUE;
		for(int i = 0;i < n;i++) {
			if(a[i] > 0) {
				a[a[i]] = -a[a[i]];
			} else {
				a[-a[i]] = -a[-a[i]];
			}
		}
		for(int i = 1;i < n;i++) {
			if(a[i] > 0)
				result =i;
			else
				a[i] = -a[i];
		}
		return result;
	}
/**************************end**********************************/
	/**
	 * �ݹ�����������
	 * @param a
	 * @param b
	 * @return
	 */
	private static int max(int a,int b) {
		return a > b ? a : b;
	}
	public static int  maxnum(int[] a,int begin) {
		if(begin == a.length - 1) 
			return a[begin];
		else
			return max(a[begin],maxnum(a,begin+1));
	}
/**************************end**********************************/
	/**
	 * ��̬�滮�������֮�����ֵ(��ȥ��������)
	 * @param a
	 * @return
	 */
	public static int getMax(int[] a) {
		if(a == null || a.length <= 1)
			return Integer.MIN_VALUE;
		int diff = 0;
		int max = a[0];
		for(int i =1;i < a.length;i++) {
			diff = max(diff,max - a[i]);
			max = max(max,a[i]);
		}
		return diff;
	}
	
/**************************end**********************************/
	public static void main(String[] args) {
	/*����maxSubArray()*/
//		int[] arr = {1,-2,4,8,-4,7,-1,-5};
//		System.out.println("max=" + maxSubArray(arr));
	/*����findSum()*/
//		int[] array = {1,7,17,2,6,3,14};
//		findSum(array,20);
	/*����leftShift_k(int[] a,int k)��*/
//		int array[] = {1,2,3,4,5,6,7,8};
//		leftShift_k(array, 2);
//		for(int i :array) {
//			System.out.print(i + " ");
//		}
	/*����findDup(int[] a)*/
//		int[] a = {4,2,1,3,4};
//		int missingNum = findDup(a);
//		System.out.print(missingNum);
	/*����maxnum(int[] a,int begin)*/
//		int[] a = {0,16,2,3,4,5,10,7,8,9};
//		System.out.print(maxnum(a,0));
	/*����getMax(int[] a)*/
		int[] a = {1,4,17,3,2,9};
		System.out.print(getMax(a));
	
	
	
	}
}
