import java.util.*;

public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        int res = 0;
//        Set<Integer> staff = new HashSet<>();
//        for(int i = 0;i < n;i++) {
//        	staff.add(in.nextInt()) ;
//        }
//        
//        Object[] obj = staff.toArray();//�Ƚ�set����תΪObject�������飨����ת�ͣ�  
//        int nums[] = new int[obj.length];  
//        for (int i = 0; i < obj.length; i++) {  
//            nums[i] = (Integer) obj[i];//��Object��������תΪ�������飨ǿ������ת�ͣ�  
//            System.out.print(nums[i] + " ");  
//        }  
//        
//        // ���Ҷ���
//        for(int i = 0;i < nums.length;i++) {
//            for(int j = 0;j < nums.length;j++) {
//                if(nums[i]-nums[j] == k){
//                	res++;
//                }
//            }
//        } 
//        System.out.println("\n"+res);        
//    }
    
	/**
	 * ��set����תΪ����int����ķ���  
	 * @param allSet
	 * @return
	 */
    private static int[] SetToInt(Set<Integer> allSet) {  
        // �Ƚ�set����תΪInteger������  
        Integer[] temp = allSet.toArray(new Integer[] {});//�ؼ����  
  
        // �ٽ�Integer������תΪint������  
        int[] intArray = new int[temp.length];  
        for (int i = 0; i < temp.length; i++) {  
            intArray[i] = temp[i].intValue();  
        }  
        return intArray;  
    }
/******************************************************�ε�2018��������**end************************************************************/
    
    /**
     * ��������
     * @param args
     */
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int count = 0;
//
//        
//        for(int x = 1;x <= n;x++) {
//        	for(int y = 1;y <= n;y++) {
//	             if ((x % y) >= k ) {
//	                count++;
//	            } 
//        	}
//        }
//        
//        System.out.println(count);
//    }
    
    /**
     * ţţ�ҹ���
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();int M = sc.nextInt();
        int[][] work = new int[N][2];
        for(int i = 0;i < N;i++) {
            for(int j = 0;j < N;j++) {
                work[i][j] = sc.nextInt();
            }
        }
        int[] A = new int[M];
        for(int i = 0;i < N;i++) {
            A[i] = sc.nextInt();
        }       
    }
	
    /**
	 * ���״���ʵϰ����Ƹ�ʴ���
	 */
//    1��Vector��ArrayList�����������������ʽ�洢���ڴ��У�LinkedList�����������ʽ���д洢��
//
//    2��List�е�Ԫ�������������ظ���Ԫ�أ�Set�е�Ԫ�����򡢲��������ظ�Ԫ�ء�
//
//    3��Vector�߳�ͬ����ArrayList��LinkedList�̲߳�ͬ����
//
//    4��LinkedList�ʺ�ָ��λ�ò��롢ɾ�����������ʺϲ��ң�ArrayList��Vector�ʺϲ��ң����ʺ�ָ��λ�õĲ��롢ɾ��������
//
//    5��ArrayList��Ԫ����������ʱ���Զ�����������С��50%����Vector����100%�����ArrayList����ʡ�ռ䡣
//    
//    ͬ��: �����ҵ���һ�����ܣ��ù���û�н���ǰ�������Ƚ����
//    2. �첽: �����ҵ���һ�����ܣ�����Ҫ֪���ù��ܽ�����ù����н����֪ͨ�ң��ص�֪ͨ��
//    3. ����: ���ǵ����ң����������ң�������û�н��������ݻ���û�еõ����֮ǰ���Ҳ��᷵�ء�
//    4. ������: ���ǵ����ң����������ң��������������أ�ͨ��select֪ͨ������
//    ͬ��IO���첽IO����������ڣ����ݿ�����ʱ������Ƿ�������
//    ����IO�ͷ�����IO����������ڣ�Ӧ�ó���ĵ����Ƿ��������أ�
/*************************************************����2018��������**end************************************************************/
 
}
