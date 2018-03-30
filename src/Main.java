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
//        Object[] obj = staff.toArray();//先讲set集合转为Object对象数组（向上转型）  
//        int nums[] = new int[obj.length];  
//        for (int i = 0; i < obj.length; i++) {  
//            nums[i] = (Integer) obj[i];//将Object对象数组转为整型数组（强制向下转型）  
//            System.out.print(nums[i] + " ");  
//        }  
//        
//        // 查找对数
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
	 * 将set集合转为整型int数组的方法  
	 * @param allSet
	 * @return
	 */
    private static int[] SetToInt(Set<Integer> allSet) {  
        // 先将set集合转为Integer型数组  
        Integer[] temp = allSet.toArray(new Integer[] {});//关键语句  
  
        // 再将Integer型数组转为int型数组  
        int[] intArray = new int[temp.length];  
        for (int i = 0; i < temp.length; i++) {  
            intArray[i] = temp[i].intValue();  
        }  
        return intArray;  
    }
/******************************************************滴滴2018春季测试**end************************************************************/
    
    /**
     * 数对问题
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
     * 牛牛找工作
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
	 * 网易春季实习生招聘问答题
	 */
//    1、Vector、ArrayList都是以类似数组的形式存储在内存中，LinkedList则以链表的形式进行存储。
//
//    2、List中的元素有序、允许有重复的元素，Set中的元素无序、不允许有重复元素。
//
//    3、Vector线程同步，ArrayList、LinkedList线程不同步。
//
//    4、LinkedList适合指定位置插入、删除操作，不适合查找；ArrayList、Vector适合查找，不适合指定位置的插入、删除操作。
//
//    5、ArrayList在元素填满容器时会自动扩充容器大小的50%，而Vector则是100%，因此ArrayList更节省空间。
//    
//    同步: 就是我调用一个功能，该功能没有结束前，我死等结果。
//    2. 异步: 就是我调用一个功能，不需要知道该功能结果，该功能有结果后通知我（回调通知）
//    3. 阻塞: 就是调用我（函数），我（函数）没有接收完数据或者没有得到结果之前，我不会返回。
//    4. 非阻塞: 就是调用我（函数），我（函数）立即返回，通过select通知调用者
//    同步IO和异步IO的区别就在于：数据拷贝的时候进程是否阻塞！
//    阻塞IO和非阻塞IO的区别就在于：应用程序的调用是否立即返回！
/*************************************************网易2018春季测试**end************************************************************/
 
}
