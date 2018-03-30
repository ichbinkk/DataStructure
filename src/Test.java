import java.util.Stack;

public class Test {
	
	/**
	 * 测试static作用
	 * @author King
	 */	
	public int a = 0;
	public static int b = 0; //多个对象共享b,只生成一次，占用一个内存
	public int c = 0;
	
	public void f() {
		this.a++;
		Test.b++;
		this.c++;
	}
	
	public static void main(String[] args) {
		Test t1 = new Test();
		t1.f();
		System.out.println(t1.a+" "+b+" "+t1.c);
		
		Test t2 = new Test();
		t2.f();
		System.out.println(t2.a+" "+b+" "+t2.c);
		
		Test t3 = new Test();
		t3.f();
		System.out.println(t3.a+" "+b+" "+t3.c);
	}
/**************************end**********************************/
	
}
