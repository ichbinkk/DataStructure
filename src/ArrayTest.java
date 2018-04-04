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
	 * ��������������ӵ����ƶ����ֵ��������
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
	public static void main(String[] args) {
		//����maxSubArray()
//		int[] arr = {1,-2,4,8,-4,7,-1,-5};
//		System.out.println("max=" + maxSubArray(arr));
		//����findSum()
//		int[] array = {1,7,17,2,6,3,14};
//		findSum(array,20);
		//����leftShift_k(int[] a,int k)��
		int array[] = {1,2,3,4,5,6,7,8};
		leftShift_k(array, 2);
		for(int i :array) {
			System.out.print(i + " ");
		}
	}
}
