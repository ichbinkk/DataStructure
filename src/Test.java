
import java.util.HashMap;
import java.util.Scanner;

public class Test {
	
	/**
	 * 测试static作用
	 * @author King
	 */	
//	public int a = 0;
//	public static int b = 0; //多个对象共享b,只生成一次，占用一个内存
//	public int c = 0;
//	
//	public void f() {
//		this.a++;
//		Test.b++;
//		this.c++;
//	}
//	
//	public static void main(String[] args) {
//		Test t1 = new Test();
//		t1.f();
//		System.out.println(t1.a+" "+b+" "+t1.c);
//		
//		Test t2 = new Test();
//		t2.f();
//		System.out.println(t2.a+" "+b+" "+t2.c);
//		
//		Test t3 = new Test();
//		t3.f();
//		System.out.println(t3.a+" "+b+" "+t3.c);
//	}
/**************************end**********************************/
	
	/**
	 * 选择最高分
	 * @param args
	 */
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
//		int max = 0,maxNum = 0,num;
//		String temp = in.nextLine();
//		String[] ss = temp.trim().split(" ");
//		for(int i = 0;i < ss.length;i++) {
//			num = Integer.parseInt(ss[i]);		
//			if(!m.containsKey(num))
//				m.put(num, 1);
//			else 
//				m.put(num, m.get(num)+1);
//			if(max < m.get(num)) {
//				max = m.get(num);
//				maxNum = num;
//			}
//		}
//		System.out.println(max*maxNum);
//	}
/**************************end**********************************/
	
	public static void main(String[] args) {
		int a = 8;
		System.out.println(Integer.bitCount(a));
	}
}
