

public class StringTest {
	
	/**
	 * <1> 实现含空格的字符串反转 
	 * how are you -> you are how
	 * @param cArr
	 * @param front
	 * @param end
	 */	
	
	/**
	 * 反转任意字符串从front到end的函数
	 * @param cArr
	 * @param front
	 * @param end
	 */
	public void swap(char[] cArr,int front,int end) {
		while(front < end) {
			char tmp = cArr[end];
			cArr[end] = cArr[front];
			cArr[front] = tmp;			
			front++;
			end--;
		}
	}
	
	/**
	 * 先对整个字符串进行反转，再反转每个单词
	 * @param s
	 * @return
	 */
	public String swapWords(String s) {
		char[] cArr = s.toCharArray();
		//对整个字符串进行反转
		swap(cArr,0,cArr.length-1);
		int begin = 0;
		//对单个单词进行反转
		for(int i = 1;i < cArr.length;i++) {
			if(cArr[i] == ' ') {
				swap(cArr,begin,i - 1);
				begin = i + 1;
			}			
		}
		swap(cArr,begin,cArr.length - 1);
		return new String(cArr);
	}
/**************************end**********************************/	
	/**
	 * <2>判断两个字符串是否由相同的字符组成 
	 * 方法1：排序法 （不做讨论）
	 * 方法2：额外申请256大小的数组记录各个字符出现的次数
	 * @param s1
	 * @param s2
	 */
	
	/**
	 * 方法2：额外申请256大小的数组记录各个字符出现的次数
	 * @param s1
	 * @param s2
	 */
	public static void compare(String s1,String s2) {
		byte[] b1 = s1.getBytes();
		byte[] b2 = s2.getBytes();
		int[] bCount = new int[256];
		for(int i = 0;i < 256;i++) {
			bCount[i] = 0;
		}
		for(int i =0;i < b1.length;i++) 
			bCount[b1[i] - '0']++;
		for(int i =0;i < b2.length;i++) 
			bCount[b2[i] - '0']--;
		for(int i =0;i < 256;i++)
			if(bCount[i] != 0) {
				System.out.println("not equal");
				return;
			}
		System.out.println("equal");
	}
/**************************end**********************************/	
	/**
	 * <3>删除字符串中重复的字符
	 * @param str
	 * @return
	 */
	public static String removeDuplicate(String str) {
		char[] c = str.toCharArray();
		int len = c.length;
		int[] flags = new int[8];
		int i;
		for(i = 0;i < 8;i++)
			flags[i] = 0;
		for(i = 0;i < len;i++) {
			int index = (int)c[i]/32;
			int shift = (int)c[i]%32;
			if((flags[index]&(1<<shift))!= 0)
				c[i] = '\0';
		flags[index]|= (1<<shift);
		}
		int l= 0;
		for( i = 0;i < len;i++) {
			if(c[i] != '\0')
				c[l++] = c[i];
		}
		return new String(c,0,l);
	}

/**************************end**********************************/	
	/**
	 * <4>统计一行字符中有多少个单词 (可能有多个空格连在一起)
	 * @param s
	 * @return
	 */
	public static int wordCount(String s) {
		boolean flag = false;//标记前面是否有单词
		int count = 0;
		for(int i = 0;i < s.length();i++) {
			if(s.charAt(i)==' ') {
				flag = false;
			}else if (!flag) {
				flag = true;
				count++;
			}			
		}
		return count;
	}
	
	public static void main(String[] args) {
//		//<1>
//		String str = "how are you";
//		System.out.println(new StringTest().swapWords(str));
//		//<2>
//		String s1 = "aaaabbc";
//		String s2 = "abcbaaa";
//		compare(s1,s2);
//		//<3>
//		System.out.println(removeDuplicate(s1));
		//<4>
		String s ="i am hehao";
		System.out.println(wordCount(s));
	}

}
